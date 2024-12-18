package pe.com.mamachas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import pe.com.mamachas.entity.PromocionEntity;
import pe.com.mamachas.repository.PromocionRepository;
import pe.com.mamachas.service.PromocionService;

@Service
public class PromocionServiceImpl implements PromocionService{

    @Autowired
    private PromocionRepository repo;


    @Override
    public List<PromocionEntity> findAll() {
       return repo.findAll();
    }

    @Override
    public List<PromocionEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public Optional<PromocionEntity> findById(int id) {
      return repo.findById( id);
    }

    @Override
    public PromocionEntity add(PromocionEntity p) {
        return repo.save(p);
    }

    @Override
    public PromocionEntity update(int id, PromocionEntity p){
    
        repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Promoción con código " + id + " no encontrada."));
        p.setCodigo(id);
        return repo.save(p);
    }


    //cambiar estado
    @Override
    public PromocionEntity delete(int id) {
        
        PromocionEntity dbPromocion = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Promoción con código " + id + " no encontrada."));

        dbPromocion.setEstado("Inactiva");
         return repo.save(dbPromocion);
    }


}
