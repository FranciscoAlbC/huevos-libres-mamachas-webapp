package pe.com.mamachas.service;

import java.util.List;
import java.util.Optional;

import pe.com.mamachas.entity.PromocionEntity;

public interface PromocionService {
    List<PromocionEntity> findAll();

    List<PromocionEntity> findAllCustom();

    Optional<PromocionEntity> findById(int id);

    PromocionEntity add(PromocionEntity p);

    PromocionEntity update(int id, PromocionEntity p);

    PromocionEntity delete(int id);
}
