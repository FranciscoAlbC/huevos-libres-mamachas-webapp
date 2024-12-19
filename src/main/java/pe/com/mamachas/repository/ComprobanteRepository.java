package pe.com.mamachas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.mamachas.entity.ComprobanteEntity;
import pe.com.mamachas.repository.generic.GenericoRepository;

@Repository
public interface ComprobanteRepository extends GenericoRepository<ComprobanteEntity, Long> {
    @Query("select co from ComprobanteEntity co where co.estado=true")
    List<ComprobanteEntity> findAllCustom();
}
