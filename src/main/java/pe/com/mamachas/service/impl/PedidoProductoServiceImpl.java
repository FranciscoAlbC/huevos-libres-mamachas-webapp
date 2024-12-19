package pe.com.mamachas.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.entity.PedidoProductoEntity;
import pe.com.mamachas.repository.PedidoProductoRepository;
import pe.com.mamachas.service.PedidoProductoService;

import java.util.List;

@Service
public class PedidoProductoServiceImpl implements PedidoProductoService {

    @Autowired
    private PedidoProductoRepository repositorio;

    @Override
    public List<PedidoProductoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<PedidoProductoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public PedidoProductoEntity findById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public PedidoProductoEntity add(PedidoProductoEntity p) {
        return repositorio.save(p);
    }

    @Override
    public PedidoProductoEntity update(PedidoProductoEntity p) {
        PedidoProductoEntity pedpro = new PedidoProductoEntity();
        BeanUtils.copyProperties(p, pedpro);
        return repositorio.save(pedpro);
    }

    @Override
    public PedidoProductoEntity delete(PedidoProductoEntity p) {
        PedidoProductoEntity pedpro = repositorio.findById(p.getCodigo()).get();
        pedpro.setEstado(false);
        return repositorio.save(pedpro);
    }

    @Override
    public PedidoProductoEntity enable(PedidoProductoEntity p) {
        PedidoProductoEntity pedpro = repositorio.findById(p.getCodigo()).get();
        pedpro.setEstado(true);
        return repositorio.save(pedpro);
    }
}
