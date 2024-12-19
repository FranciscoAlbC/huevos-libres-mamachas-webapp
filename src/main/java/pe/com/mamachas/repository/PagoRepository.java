package pe.com.lasmamachas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.lasmamachas.entity.PagoEntity;
import pe.com.lasmamachas.repository.generic.GenericoRepository;

@Repository
public interface PagoRepository extends GenericoRepository<PagoEntity, Long>{
    @Query("select pa from PagoEntity pa where pa.estado=true")
    List<PagoEntity> findAllCustom();
}
