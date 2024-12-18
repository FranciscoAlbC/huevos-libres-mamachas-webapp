package pe.com.mamachas.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.dto.OrdenCompraDTO;
import pe.com.mamachas.dto.TipoInsumoDTO;
import pe.com.mamachas.entity.OrdenCompraEntity;
import pe.com.mamachas.entity.TipoInsumoEntity;
import pe.com.mamachas.repository.OrdenCompraRepository;
import pe.com.mamachas.service.OrdenCompraService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<OrdenCompraDTO> findAll() {
        List<OrdenCompraEntity> lista = repositorio.findAll();
        return lista.stream().map(oc -> mapper.map(oc, OrdenCompraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<OrdenCompraDTO> findAllCustom() {
        List<OrdenCompraEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(oc -> mapper.map(oc, OrdenCompraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OrdenCompraDTO findById(Long id) {
        OrdenCompraEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, OrdenCompraDTO.class);
    }

    @Override
    public OrdenCompraDTO add(OrdenCompraDTO oc) {
        OrdenCompraEntity ordenCompra = mapper.map(oc, OrdenCompraEntity.class);
        return mapper.map(repositorio.save(ordenCompra), OrdenCompraDTO.class);
    }

    @Override
    public OrdenCompraEntity update(OrdenCompraEntity oc) {
        OrdenCompraEntity objoc = repositorio.getById(oc.getCodigo());
        BeanUtils.copyProperties(oc, objoc);
        return repositorio.save(objoc);
    }

    @Override
    public OrdenCompraDTO delete(Long id) {
        OrdenCompraEntity ordenCompra = repositorio.findById(id).get();
        ordenCompra.setEstado(false);
        return mapper.map(repositorio.save(ordenCompra), OrdenCompraDTO.class);
    }

    @Override
    public OrdenCompraDTO enable(Long id) {
        OrdenCompraEntity ordenCompra = repositorio.findById(id).get();
        ordenCompra.setEstado(true);
        return mapper.map(repositorio.save(ordenCompra), OrdenCompraDTO.class);
    }
}
