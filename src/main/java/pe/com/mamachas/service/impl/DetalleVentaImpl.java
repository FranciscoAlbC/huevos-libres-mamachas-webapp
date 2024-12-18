package pe.com.mamachas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import pe.com.mamachas.entity.DetalleVentaEntity;
import pe.com.mamachas.repository.DetalleVentaRepository;
import pe.com.mamachas.service.DetalleVentaService;

@Service
public class DetalleVentaImpl implements DetalleVentaService{

    @Autowired
    private DetalleVentaRepository repo;

    @Override
    public List<DetalleVentaEntity> findAll() {
       return repo.findAll();
    }

    @Override
    public List<DetalleVentaEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public Optional<DetalleVentaEntity> findById(int id) {
       return repo.findById(id);    
    }

    @Override
    public DetalleVentaEntity add(DetalleVentaEntity d) {
        return repo.save(d);
    }

    @Override
    public DetalleVentaEntity update(int id, DetalleVentaEntity d) {
       repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Detalle con código " + id + " no encontrado."));
       d.setCodigo(id);

       return repo.save(d);
    }

    @Override
    public DetalleVentaEntity delete(int id) {
       DetalleVentaEntity dbDetalle = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Detalle con código " + id + " no encontrado."));

       dbDetalle.setEstado(false);

       return repo.save(dbDetalle);
    }
}
