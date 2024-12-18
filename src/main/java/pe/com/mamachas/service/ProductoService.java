package pe.com.mamachas.service;

import java.util.List;
import java.util.Optional;

import pe.com.mamachas.entity.ProductoEntity;

public interface ProductoService {
    List<ProductoEntity> findAll();

    List<ProductoEntity> findAllCustom();

    Optional<ProductoEntity> findById(int id);

    ProductoEntity add(ProductoEntity p);

    ProductoEntity update(int id, ProductoEntity p);

    ProductoEntity delete(int id);
}
