package pe.com.mamachas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mamachas.entity.InsumoEntity;

import java.util.List;

public interface InsumoRepository extends JpaRepository<InsumoEntity, Long> {

    @Query("select i from InsumoEntity i where i.estado = true")
    List<InsumoEntity> findAllCustom();

}
