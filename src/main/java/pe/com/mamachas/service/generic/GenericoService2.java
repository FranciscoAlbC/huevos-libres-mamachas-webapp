package pe.com.lasmamachas.service.generic;

import java.util.List;


public interface GenericoService2<T> {
    
    List<T> findAll();

    List<T> findAllCustom();

    T findById(Long id);

    T add(T t);

    T update(T t, Long id);

    T delete(Long ig);

    T enable(Long id);
}
