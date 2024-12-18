package pe.com.mamachas.service;

import java.util.List;
import java.util.Optional;
import pe.com.mamachas.entity.VentaEntity;

public interface VentaService {
    List<VentaEntity> findAll();

    List<VentaEntity> findAllCustom();

    Optional<VentaEntity> findById(int id);

    VentaEntity add(VentaEntity v);

    VentaEntity update(int id, VentaEntity v);

    VentaEntity delete(int id);
}
