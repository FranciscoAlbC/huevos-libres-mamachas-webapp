package pe.com.mamachas.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.stereotype.Repository;

import pe.com.mamachas.entity.PromocionEntity;

import java.util.List;

@Repository
public interface PromocionRepository extends JpaRepository<PromocionEntity, Integer>{

    @Query("select p from PromocionEntity p where p.estado = 'Activa'")
    List<PromocionEntity> findAllCustom();
} 