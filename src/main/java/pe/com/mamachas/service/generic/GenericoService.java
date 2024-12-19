package pe.com.mamachas.service.generic;

import java.util.List;

public interface GenericoService<T> {

    List<T> findAll();

    List<T> findAllCustom();

    T findById(Long id);

    T findByName(String nombre);

    T add(T t);

    T update(T t, Long id);

    T delete(Long ig);

    T enable(Long id);
}
