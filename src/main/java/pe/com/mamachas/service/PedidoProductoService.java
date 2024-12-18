package pe.com.mamachas.service;

import pe.com.mamachas.dto.InsumoDTO;
import pe.com.mamachas.dto.PedidoProductoDTO;
import pe.com.mamachas.dto.PedidoProductoIdDTO;
import pe.com.mamachas.entity.PedidoProductoEntity;

import java.util.List;

public interface PedidoProductoService {

    List<PedidoProductoDTO> findAll();
    List<PedidoProductoDTO> findAllCustom();
    PedidoProductoDTO findById(PedidoProductoIdDTO id);
    PedidoProductoDTO add(PedidoProductoDTO pp);


    PedidoProductoEntity update(PedidoProductoEntity pp);
//    PedidoProductoDTO update(PedidoProductoDTO pp, PedidoProductoIdDTO id);

    PedidoProductoDTO delete(PedidoProductoIdDTO id);
    PedidoProductoDTO enable(PedidoProductoIdDTO id);
}
