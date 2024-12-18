package pe.com.mamachas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.mamachas.entity.ProveedorEntity;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Integer> {
    
    @Query("select p from ProveedorEntity p where p.estado = true")
    List<ProveedorEntity> findAllCustom();
}
