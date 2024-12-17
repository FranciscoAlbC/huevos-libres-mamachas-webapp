package pe.com.mamachas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.mamachas.entity.ProductoEntity;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    @Query("select p from ProductoEntity p where p.estado = true")
    List<ProductoEntity> findAllCustom();
}
