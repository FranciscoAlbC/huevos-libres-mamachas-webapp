package pe.com.mamachas.service;

import pe.com.mamachas.dto.TipoInsumoDTO;

import java.util.List;

public interface TipoInsumoService {

    List<TipoInsumoDTO> findAll();
    List<TipoInsumoDTO> findAllCustom();
    TipoInsumoDTO findById(Long id);
    TipoInsumoDTO add(TipoInsumoDTO ti);
    TipoInsumoDTO update(TipoInsumoDTO ti, Long id);
    TipoInsumoDTO delete(Long id);
    TipoInsumoDTO enable(Long id);
}
