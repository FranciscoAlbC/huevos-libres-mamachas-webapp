package pe.com.lasmamachas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.lasmamachas.entity.EmpleadoEntity;
import pe.com.lasmamachas.repository.generic.GenericoRepository;

@Repository
public interface EmpleadoRepository extends GenericoRepository<EmpleadoEntity, Long> {

    @Query("select e from EmpleadoEntity e where e.estado=true")
    List<EmpleadoEntity> findAllCustom();

    @Query("select e from EmpleadoEntity e where LOWER(e.nombre) like LOWER(CONCAT('%', :nombre,'%'))")
    EmpleadoEntity findByName(@Param("nombre") String nombre);

    @Query("select e from EmpleadoEntity e where e.usuario= :usuario and e.clave= :clave")
    EmpleadoEntity login(@Param("usuario") String usuario, @Param("clave") String clave);
}
