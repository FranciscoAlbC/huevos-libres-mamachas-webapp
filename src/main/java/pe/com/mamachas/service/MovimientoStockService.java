package pe.com.mamachas.service;

import pe.com.mamachas.dto.MovimientoStockDTO;
import pe.com.mamachas.entity.MovimientoStockEntity;

import java.util.List;

public interface MovimientoStockService {

    List<MovimientoStockDTO> findAll();
    List<MovimientoStockDTO> findAllCustom();
    MovimientoStockDTO findById(Long id);
    MovimientoStockDTO add(MovimientoStockDTO ms);

    MovimientoStockEntity update(MovimientoStockEntity ms);
//    MovimientoStockDTO update(MovimientoStockDTO ms, Long id);

    MovimientoStockDTO delete(Long id);
    MovimientoStockDTO enable(Long id);
}
