package pe.com.mamachas.service;

import pe.com.mamachas.dto.OrdenCompraDTO;
import java.util.List;

public interface OrdenCompraService {

    List<OrdenCompraDTO> findAll();
    List<OrdenCompraDTO> findAllCustom();
    OrdenCompraDTO findById(Long id);
    OrdenCompraDTO add(OrdenCompraDTO oc);
    OrdenCompraDTO update(OrdenCompraDTO oc, Long id);
    OrdenCompraDTO delete(Long id);
    OrdenCompraDTO enable(Long id);
}
