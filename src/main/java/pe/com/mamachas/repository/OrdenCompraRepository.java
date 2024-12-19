package pe.com.mamachas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mamachas.entity.OrdenCompraEntity;

import java.util.List;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraEntity, Long> {

    @Query("select oc from OrdenCompraEntity oc where oc.estado = true")
    List<OrdenCompraEntity> findAllCustom();

}
