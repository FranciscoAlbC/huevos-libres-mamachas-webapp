package pe.com.mamachas.service;

import pe.com.mamachas.dto.InsumoDTO;
import java.util.List;

public interface InsumoService {

    List<InsumoDTO> findAll();
    List<InsumoDTO> findAllCustom();
    InsumoDTO findById(Long id);
    InsumoDTO add(InsumoDTO i);
    InsumoDTO update(InsumoDTO i, Long id);
    InsumoDTO delete(Long id);
    InsumoDTO enable(Long id);
}
