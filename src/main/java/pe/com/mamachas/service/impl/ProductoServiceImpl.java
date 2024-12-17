package pe.com.mamachas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import pe.com.mamachas.entity.ProductoEntity;
import pe.com.mamachas.repository.ProductoRepository;
import pe.com.mamachas.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repo;

    @Override
    public List<ProductoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ProductoEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public Optional<ProductoEntity> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public ProductoEntity add(ProductoEntity p) {
        return repo.save(p);
    }

    @Override
    public ProductoEntity update(int id, ProductoEntity p) {
       repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Producto con código " + id + " no encontrado."));
       p.setCodigo(id);
       return repo.save(p);
    }

    @Override
    public ProductoEntity delete(int id) {
        ProductoEntity dbProducto = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Producto con código " + id + " no encontrado."));

        dbProducto.setEstado(false);
         return repo.save(dbProducto);
    }

}
