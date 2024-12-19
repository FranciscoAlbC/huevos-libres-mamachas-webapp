package pe.com.lasmamachas.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.lasmamachas.dto.PagoDTO;
import pe.com.lasmamachas.entity.PagoEntity;
import pe.com.lasmamachas.repository.PagoRepository;
import pe.com.lasmamachas.service.PagoService;

@Service
public class PagoServiceImpl implements PagoService{
    
    @Autowired
    private PagoRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<PagoDTO> findAll() {
        List<PagoEntity> lista = repositorio.findAll();
        return lista.stream()
                .map(e -> mapper.map(e, PagoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PagoDTO> findAllCustom() {
        List<PagoEntity> lista = repositorio.findAllCustom();
        return lista.stream()
                .map(e -> mapper.map(e, PagoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PagoDTO findById(Long id) {
        PagoEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, PagoDTO.class);
    }

    @Override
    public PagoDTO add(PagoDTO e) {
        PagoEntity Pago = mapper.map(e, PagoEntity.class);
        return mapper.map(repositorio.save(Pago), PagoDTO.class);
    }

    @Override
    public PagoDTO update(PagoDTO e, Long id) {
        PagoEntity Pago = repositorio.findById(id).get();
        mapper.map(e, Pago);
        return mapper.map(repositorio.save(Pago), PagoDTO.class);
    }

    @Override
    public PagoDTO delete(Long id) {
        PagoEntity Pago = repositorio.findById(id).get();
        Pago.setEstado(false);
        return mapper.map(repositorio.save(Pago), PagoDTO.class);
    }

    @Override
    public PagoDTO enable(Long id) {
        PagoEntity Pago = repositorio.findById(id).get();
        Pago.setEstado(true);
        return mapper.map(repositorio.save(Pago), PagoDTO.class);
    }    
}
