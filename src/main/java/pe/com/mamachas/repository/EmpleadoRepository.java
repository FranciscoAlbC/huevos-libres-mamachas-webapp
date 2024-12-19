package pe.com.mamachas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.mamachas.entity.EmpleadoEntity;
import pe.com.mamachas.repository.generic.GenericoRepository;

@Repository
public interface EmpleadoRepository extends GenericoRepository<EmpleadoEntity, Long> {

    @Query("select e from EmpleadoEntity e where e.estado=true")
    List<EmpleadoEntity> findAllCustom();

    @Query("select e from EmpleadoEntity e where LOWER(e.nomEmpleado) like LOWER(CONCAT('%', :nombre,'%'))")
    EmpleadoEntity findByName(@Param("nombre") String nombre);

}
