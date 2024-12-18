package pe.com.mamachas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mamachas.entity.PedidoProductoEntity;
import pe.com.mamachas.entity.PedidoProductoId;

import java.util.List;

public interface PedidoProductoRepository extends JpaRepository<PedidoProductoEntity, PedidoProductoId> {

    @Query("select pp from PedidoProductoEntity pp where pp.estado = true")
    List<PedidoProductoEntity> findAllCustom();
}
