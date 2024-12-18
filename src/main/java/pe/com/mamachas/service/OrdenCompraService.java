package pe.com.mamachas.service;

import pe.com.mamachas.dto.OrdenCompraDTO;
import pe.com.mamachas.entity.OrdenCompraEntity;

import java.util.List;

public interface OrdenCompraService {

    List<OrdenCompraDTO> findAll();
    List<OrdenCompraDTO> findAllCustom();
    OrdenCompraDTO findById(Long id);
    OrdenCompraDTO add(OrdenCompraDTO oc);
    OrdenCompraEntity update(OrdenCompraEntity oc);
    OrdenCompraDTO delete(Long id);
    OrdenCompraDTO enable(Long id);
}
