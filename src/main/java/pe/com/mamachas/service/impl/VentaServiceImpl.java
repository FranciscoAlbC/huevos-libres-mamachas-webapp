package pe.com.mamachas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import pe.com.mamachas.entity.VentaEntity;
import pe.com.mamachas.repository.VentaRepository;
import pe.com.mamachas.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService{

    @Autowired
    private VentaRepository repo;

    @Override
    public List<VentaEntity> findAll() {
       return repo.findAll();
    }

    @Override
    public List<VentaEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public Optional<VentaEntity> findById(int id) {
       return repo.findById(id);
    }

    @Override
    public VentaEntity add(VentaEntity v) {
       return repo.save(v);
    }

    @Override
    public VentaEntity update(int id, VentaEntity v) {
        repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Ve nta con código " + id + " no encontrada."));
        v.setCodigo(id);
        return repo.save(v);
    }

    @Override
    public VentaEntity delete(int id) {
        VentaEntity dbVenta = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Ve nta con código " + id + " no encontrada."));
        dbVenta.setEstado(false);
        return repo.save(dbVenta);
    }

}
