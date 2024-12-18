package pe.com.mamachas.service;

import java.util.List;
import java.util.Optional;

import pe.com.mamachas.entity.ProveedorEntity;


public interface ProveedorService {
List<ProveedorEntity> findAll();

    List<ProveedorEntity> findAllCustom();

    Optional<ProveedorEntity> findById(int id);

    ProveedorEntity add(ProveedorEntity p);

    ProveedorEntity update(int id, ProveedorEntity p);

    ProveedorEntity delete(int id);
}
