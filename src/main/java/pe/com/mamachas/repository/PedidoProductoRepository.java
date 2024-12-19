package pe.com.mamachas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mamachas.entity.PedidoProductoEntity;

import java.util.List;

public interface PedidoProductoRepository extends JpaRepository<PedidoProductoEntity, Long> {

    @Query("select p from PedidoProductoEntity p where p.estado = true")
    List<PedidoProductoEntity> findAllCustom();
}
