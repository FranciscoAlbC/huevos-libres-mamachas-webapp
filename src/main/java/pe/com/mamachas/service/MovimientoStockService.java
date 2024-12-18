package pe.com.mamachas.service;

import pe.com.mamachas.dto.MovimientoStockDTO;
import java.util.List;

public interface MovimientoStockService {

    List<MovimientoStockDTO> findAll();
    List<MovimientoStockDTO> findAllCustom();
    MovimientoStockDTO findById(Long id);
    MovimientoStockDTO add(MovimientoStockDTO ms);
    MovimientoStockDTO update(MovimientoStockDTO ms, Long id);
    MovimientoStockDTO delete(Long id);
    MovimientoStockDTO enable(Long id);
}
