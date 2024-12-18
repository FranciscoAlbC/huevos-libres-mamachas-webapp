package pe.com.lasmamachas.service;

import pe.com.lasmamachas.dto.EmpleadoDTO;
import pe.com.lasmamachas.service.generic.GenericoService;

public interface EmpleadoService extends GenericoService<EmpleadoDTO> {
    
    EmpleadoDTO login(String usuario, String clave);
    
}
