package pe.com.lasmamachas.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.lasmamachas.dto.EmpleadoDTO;
import pe.com.lasmamachas.entity.EmpleadoEntity;
import pe.com.lasmamachas.repository.EmpleadoRepository;
import pe.com.lasmamachas.service.EmpleadoService;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<EmpleadoDTO> findAll() {
        List<EmpleadoEntity> lista = repositorio.findAll();
        return lista.stream()
                .map(e -> mapper.map(e, EmpleadoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoDTO> findAllCustom() {
        List<EmpleadoEntity> lista = repositorio.findAllCustom();
        return lista.stream()
                .map(e -> mapper.map(e, EmpleadoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO findById(Long id) {
        EmpleadoEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO findByName(String nombre) {
        EmpleadoEntity lista = repositorio.findByName(nombre);
        return mapper.map(lista, EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO add(EmpleadoDTO e) {
        EmpleadoEntity empleado = mapper.map(e, EmpleadoEntity.class);
        return mapper.map(repositorio.save(empleado), EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO update(EmpleadoDTO e, Long id) {
        EmpleadoEntity empleado = repositorio.findById(id).get();
        mapper.map(e, empleado);
        return mapper.map(repositorio.save(empleado), EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO delete(Long id) {
        EmpleadoEntity empleado = repositorio.findById(id).get();
        empleado.setEstado(false);
        return mapper.map(repositorio.save(empleado), EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO enable(Long id) {
        EmpleadoEntity empleado = repositorio.findById(id).get();
        empleado.setEstado(true);
        return mapper.map(repositorio.save(empleado), EmpleadoDTO.class);
    }


}
