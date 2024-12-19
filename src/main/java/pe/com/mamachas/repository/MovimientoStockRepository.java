package pe.com.mamachas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mamachas.entity.MovimientoStockEntity;

import java.util.List;

public interface MovimientoStockRepository extends JpaRepository<MovimientoStockEntity, Long> {

    @Query("select ms from MovimientoStockEntity ms where ms.estado = true")
    List<MovimientoStockEntity> findAllCustom();

}
