package pe.com.mamachas.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.dto.PedidoDTO;
import pe.com.mamachas.entity.PedidoEntity;
import pe.com.mamachas.repository.PedidoRepository;
import pe.com.mamachas.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<PedidoDTO> findAll() {
        List<PedidoEntity> lista = repositorio.findAll();
        return lista.stream()
                .map(p -> mapper.map(p, PedidoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoDTO> findAllCustom() {
        List<PedidoEntity> lista = repositorio.findAllCustom();
        return lista.stream()
                .map(p -> mapper.map(p, PedidoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO findById(Long id) {
        PedidoEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, PedidoDTO.class);
    }

    @Override
    public PedidoDTO add(PedidoDTO p) {
        PedidoEntity Pedido = mapper.map(p, PedidoEntity.class);
        return mapper.map(repositorio.save(Pedido), PedidoDTO.class);
    }

    @Override
    public PedidoDTO update(PedidoDTO p, Long id) {
        PedidoEntity Pedido = repositorio.findById(id).get();
        mapper.map(p, Pedido);
        return mapper.map(repositorio.save(Pedido), PedidoDTO.class);
    }

    @Override
    public PedidoDTO delete(Long id) {
        PedidoEntity Pedido = repositorio.findById(id).get();
        Pedido.setEstado(false);
        return mapper.map(repositorio.save(Pedido), PedidoDTO.class);
    }

    @Override
    public PedidoDTO enable(Long id) {
        PedidoEntity Pedido = repositorio.findById(id).get();
        Pedido.setEstado(true);
        return mapper.map(repositorio.save(Pedido), PedidoDTO.class);
    }    
}
