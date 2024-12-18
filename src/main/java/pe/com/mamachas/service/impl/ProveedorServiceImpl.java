package pe.com.mamachas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import pe.com.mamachas.entity.ProveedorEntity;
import pe.com.mamachas.repository.ProveedorRepository;
import pe.com.mamachas.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository repo;

    @Override
    public List<ProveedorEntity> findAll() {
       return repo.findAll();
    }

    @Override
    public List<ProveedorEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public Optional<ProveedorEntity> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public ProveedorEntity add(ProveedorEntity p) {
        return repo.save(p) ;
    }

    @Override
    public ProveedorEntity update(int id, ProveedorEntity p) {
        repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Proveedor con código " + id + " no encontrado."));
        p.setCodigo(id);
        return repo.save(p);
    }

    @Override
    public ProveedorEntity delete(int id) {
       ProveedorEntity dbProveedor = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Proveedor con código " + id + " no encontrado."));
       dbProveedor.setEstado(false);
       return repo.save(dbProveedor);
    }

}
