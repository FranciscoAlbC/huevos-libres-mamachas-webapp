package pe.com.mamachas.service;

import pe.com.mamachas.dto.InsumoDTO;
import pe.com.mamachas.dto.PedidoProductoDTO;
import pe.com.mamachas.dto.PedidoProductoIdDTO;

import java.util.List;

public interface PedidoProductoService {

    List<PedidoProductoDTO> findAll();
    List<PedidoProductoDTO> findAllCustom();
    PedidoProductoDTO findById(PedidoProductoIdDTO id);
    PedidoProductoDTO add(PedidoProductoDTO pp);
    PedidoProductoDTO update(PedidoProductoDTO pp, PedidoProductoIdDTO id);
    PedidoProductoDTO delete(PedidoProductoIdDTO id);
    PedidoProductoDTO enable(PedidoProductoIdDTO id);
}
