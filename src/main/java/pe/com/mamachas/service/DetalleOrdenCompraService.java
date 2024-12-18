package pe.com.mamachas.service;

import pe.com.mamachas.dto.DetalleOrdenCompraDTO;

import java.util.List;

public interface DetalleOrdenCompraService {

    List<DetalleOrdenCompraDTO> findAll();
    List<DetalleOrdenCompraDTO> findAllCustom();
    DetalleOrdenCompraDTO findById(Long id);
    DetalleOrdenCompraDTO add(DetalleOrdenCompraDTO doc);
    DetalleOrdenCompraDTO update(DetalleOrdenCompraDTO doc, Long id);
    DetalleOrdenCompraDTO delete(Long id);
    DetalleOrdenCompraDTO enable(Long id);
}
