package pe.com.mamachas.service;

import pe.com.mamachas.entity.PedidoProductoEntity;

import java.util.List;

public interface PedidoProductoService {

    public List<PedidoProductoEntity> findAll();
    public List<PedidoProductoEntity> findAllCustom();
    public PedidoProductoEntity findById(long id);
    public PedidoProductoEntity add(PedidoProductoEntity p);
    public PedidoProductoEntity update(PedidoProductoEntity p);
    public PedidoProductoEntity delete(PedidoProductoEntity p);
    public PedidoProductoEntity enable(PedidoProductoEntity p);
}
