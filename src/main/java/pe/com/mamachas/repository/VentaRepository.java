package pe.com.mamachas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.mamachas.entity.VentaEntity;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Integer> {

    @Query("select v from VentaEntity v where v.estado = true")
    List<VentaEntity> findAllCustom();
}
