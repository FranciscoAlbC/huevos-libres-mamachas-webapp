package pe.com.lasmamachas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.lasmamachas.entity.ClienteEntity;
import pe.com.lasmamachas.repository.generic.GenericoRepository;

@Repository
public interface ClienteRepository extends GenericoRepository<ClienteEntity, Long>{
    
    //mostramos todos los clientes habilitados
    @Query("select c from ClienteEntity c where c.estado=true")
    List<ClienteEntity> findAllCustom();
    
    //buscar por nombre
    @Query("select c from ClienteEntity c where LOWER(c.nomCliente) like LOWER(CONCAT('%', :nombre,'%'))")
    ClienteEntity findByName(@Param("nombre") String nombre);
}
