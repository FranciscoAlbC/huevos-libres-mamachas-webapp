package pe.com.lasmamachas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.lasmamachas.entity.PedidoEntity;
import pe.com.lasmamachas.repository.generic.GenericoRepository;

@Repository
public interface PedidoRepository extends GenericoRepository<PedidoEntity, Long>{
    
    @Query("select p from PedidoEntity p where p.estado=true")
    List<PedidoEntity> findAllCustom();
    
}
