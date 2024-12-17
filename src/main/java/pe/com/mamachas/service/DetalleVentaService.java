package pe.com.mamachas.service;

import java.util.List;
import java.util.Optional;
import pe.com.mamachas.entity.DetalleVentaEntity;

public interface DetalleVentaService {
    
    List<DetalleVentaEntity> findAll();

    List<DetalleVentaEntity> findAllCustom();

    Optional<DetalleVentaEntity> findById(int id);

    DetalleVentaEntity add(DetalleVentaEntity d);

    DetalleVentaEntity update(int id, DetalleVentaEntity d);

    DetalleVentaEntity delete(int id);
}
