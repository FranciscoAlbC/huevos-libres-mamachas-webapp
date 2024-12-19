package pe.com.mamachas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.mamachas.entity.TipoInsumoEntity;

import java.util.List;

public interface TipoInsumoRepository extends JpaRepository<TipoInsumoEntity, Long> {

    @Query("select ti from TipoInsumoEntity ti where ti.estado = true")
    List<TipoInsumoEntity> findAllCustom();

}
