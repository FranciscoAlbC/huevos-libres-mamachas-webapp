package pe.com.mamachas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.mamachas.entity.DetalleVentaEntity;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Integer> {

    @Query("SELECT d FROM DetalleVentaEntity d WHERE d.estado = true")
    List<DetalleVentaEntity> findAllCustom();
}
