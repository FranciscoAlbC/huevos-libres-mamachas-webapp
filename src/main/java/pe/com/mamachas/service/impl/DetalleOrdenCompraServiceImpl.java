package pe.com.mamachas.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.dto.DetalleOrdenCompraDTO;
import pe.com.mamachas.dto.TipoInsumoDTO;
import pe.com.mamachas.entity.DetalleOrdenCompraEntity;
import pe.com.mamachas.entity.OrdenCompraEntity;
import pe.com.mamachas.entity.TipoInsumoEntity;
import pe.com.mamachas.repository.DetalleOrdenCompraRepository;
import pe.com.mamachas.repository.OrdenCompraRepository;
import pe.com.mamachas.service.DetalleOrdenCompraService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleOrdenCompraServiceImpl implements DetalleOrdenCompraService {

    @Autowired
    private DetalleOrdenCompraRepository repositorio;

    @Autowired
    private OrdenCompraRepository ocrepositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<DetalleOrdenCompraDTO> findAll() {
        List<DetalleOrdenCompraEntity> lista = repositorio.findAll();
        return lista.stream().map(doc -> mapper.map(doc, DetalleOrdenCompraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<DetalleOrdenCompraDTO> findAllCustom() {
        List<DetalleOrdenCompraEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(doc -> mapper.map(doc, DetalleOrdenCompraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DetalleOrdenCompraDTO findById(Long id) {
        DetalleOrdenCompraEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, DetalleOrdenCompraDTO.class);
    }

    @Override
    public DetalleOrdenCompraDTO add(DetalleOrdenCompraDTO doc) {
        DetalleOrdenCompraEntity detalleOrdenCompra = mapper.map(doc, DetalleOrdenCompraEntity.class);
        OrdenCompraEntity ordenCompra = ocrepositorio.findById(doc.getOrdenCompra().getCodigo()).get();
        detalleOrdenCompra.setOrdenCompra(ordenCompra);
        mapper.map(doc, detalleOrdenCompra);
        return mapper.map(repositorio.save(detalleOrdenCompra), DetalleOrdenCompraDTO.class);
    }

    @Override
    public DetalleOrdenCompraEntity update(DetalleOrdenCompraEntity doc) {
        DetalleOrdenCompraEntity detalleOrdenCompra = repositorio.getById(doc.getCodigo());
        BeanUtils.copyProperties(doc, detalleOrdenCompra);
        return repositorio.save(detalleOrdenCompra);
    }

//    @Override
//    public DetalleOrdenCompraDTO update(DetalleOrdenCompraDTO doc, Long id) {
//        DetalleOrdenCompraEntity detalleOrdenCompra = repositorio.findById(id).get();
//        mapper.map(doc, detalleOrdenCompra);
//        return mapper.map(repositorio.save(detalleOrdenCompra), DetalleOrdenCompraDTO.class);
//    }

    @Override
    public DetalleOrdenCompraDTO delete(Long id) {
        DetalleOrdenCompraEntity detalleOrdenCompra = repositorio.findById(id).get();
        detalleOrdenCompra.setEstado(false);
        return mapper.map(repositorio.save(detalleOrdenCompra), DetalleOrdenCompraDTO.class);
    }

    @Override
    public DetalleOrdenCompraDTO enable(Long id) {
        DetalleOrdenCompraEntity detalleOrdenCompra = repositorio.findById(id).get();
        detalleOrdenCompra.setEstado(true);
        return mapper.map(repositorio.save(detalleOrdenCompra), DetalleOrdenCompraDTO.class);
    }
}
