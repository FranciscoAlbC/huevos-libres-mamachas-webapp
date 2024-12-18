package pe.com.mamachas.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.dto.PedidoProductoDTO;
import pe.com.mamachas.dto.PedidoProductoIdDTO;
import pe.com.mamachas.entity.PedidoProductoEntity;
import pe.com.mamachas.entity.PedidoProductoId;
import pe.com.mamachas.repository.PedidoProductoRepository;
import pe.com.mamachas.service.PedidoProductoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoProductoServiceImpl implements PedidoProductoService {

    @Autowired
    private PedidoProductoRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<PedidoProductoDTO> findAll() {
        List<PedidoProductoEntity> lista = repositorio.findAll();
        return lista.stream().map(pp -> mapper.map(pp, PedidoProductoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PedidoProductoDTO> findAllCustom() {
        List<PedidoProductoEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(pp -> mapper.map(pp, PedidoProductoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PedidoProductoDTO findById(PedidoProductoIdDTO id) {
        PedidoProductoId codigo = new PedidoProductoId(id.getIdPedido(), id.getIdProducto());
        PedidoProductoEntity pedidoProducto = repositorio.findById(codigo).get();
        return mapper.map(pedidoProducto, PedidoProductoDTO.class);
    }

    @Override
    public PedidoProductoDTO add(PedidoProductoDTO pp) {
        PedidoProductoEntity pedidoProducto = mapper.map(pp, PedidoProductoEntity.class);
        return mapper.map(repositorio.save(pedidoProducto), PedidoProductoDTO.class);
    }

    @Override
    public PedidoProductoDTO update(PedidoProductoDTO pp, PedidoProductoIdDTO id) {
        PedidoProductoId codigo = new PedidoProductoId(id.getIdPedido(), id.getIdProducto());
        PedidoProductoEntity pedidoProducto = repositorio.findById(codigo).get();
        mapper.map(pp, pedidoProducto);
        PedidoProductoEntity pedidoProductoActualizar = repositorio.save(pedidoProducto);
        return mapper.map(pedidoProductoActualizar, PedidoProductoDTO.class);
    }

    @Override
    public PedidoProductoDTO delete(PedidoProductoIdDTO id) {
        PedidoProductoId codigo = new PedidoProductoId(id.getIdPedido(), id.getIdProducto());
        PedidoProductoEntity pedidoProducto = repositorio.findById(codigo).get();
        pedidoProducto.setEstado(false);
        PedidoProductoEntity savedEntity = repositorio.save(pedidoProducto);
        return mapper.map(savedEntity, PedidoProductoDTO.class);
    }

    @Override
    public PedidoProductoDTO enable(PedidoProductoIdDTO id) {
        PedidoProductoId codigo = new PedidoProductoId(id.getIdPedido(), id.getIdProducto());
        PedidoProductoEntity pedidoProducto = repositorio.findById(codigo).get();
        pedidoProducto.setEstado(true);
        PedidoProductoEntity savedEntity = repositorio.save(pedidoProducto);
        return mapper.map(savedEntity, PedidoProductoDTO.class);
    }
}
