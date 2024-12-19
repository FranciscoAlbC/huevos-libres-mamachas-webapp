package pe.com.mamachas .repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.mamachas.entity.PagoEntity;
import pe.com.mamachas.repository.generic.GenericoRepository;

@Repository
public interface PagoRepository extends GenericoRepository<PagoEntity, Long> {
    @Query("select pa from PagoEntity pa where pa.estado=true")
    List<PagoEntity> findAllCustom();
}
