package pe.com.mamachas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mamachas.entity.DetalleOrdenCompraEntity;

import java.util.List;

public interface DetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompraEntity, Long> {

    @Query("select dc from DetalleOrdenCompraEntity dc where dc.estado = true")
    List<DetalleOrdenCompraEntity> findAllCustom();
}
