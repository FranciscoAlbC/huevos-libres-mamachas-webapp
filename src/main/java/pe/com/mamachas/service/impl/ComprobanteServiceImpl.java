package pe.com.mamachas.service.impl;


import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.dto.ComprobanteDTO;
import pe.com.mamachas.entity.ComprobanteEntity;
import pe.com.mamachas.repository.ComprobanteRepository;
import pe.com.mamachas.service.ComprobanteService;

@Service
public class ComprobanteServiceImpl implements ComprobanteService {

    @Autowired
    private ComprobanteRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<ComprobanteDTO> findAll() {
        List<ComprobanteEntity> lista = repositorio.findAll();
        return lista.stream()
                .map(co -> mapper.map(co, ComprobanteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ComprobanteDTO> findAllCustom() {
        List<ComprobanteEntity> lista = repositorio.findAllCustom();
        return lista.stream()
                .map(co -> mapper.map(co, ComprobanteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ComprobanteDTO findById(Long id) {
        ComprobanteEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, ComprobanteDTO.class);
    }

    @Override
    public ComprobanteDTO add(ComprobanteDTO co) {
        ComprobanteEntity Comprobante = mapper.map(co, ComprobanteEntity.class);
        return mapper.map(repositorio.save(Comprobante), ComprobanteDTO.class);
    }

    @Override
    public ComprobanteDTO update(ComprobanteDTO co, Long id) {
        ComprobanteEntity Comprobante = repositorio.findById(id).get();
        mapper.map(co, Comprobante);
        return mapper.map(repositorio.save(Comprobante), ComprobanteDTO.class);
    }

    @Override
    public ComprobanteDTO delete(Long id) {
        ComprobanteEntity Comprobante = repositorio.findById(id).get();
        Comprobante.setEstado(false);
        return mapper.map(repositorio.save(Comprobante), ComprobanteDTO.class);
    }

    @Override
    public ComprobanteDTO enable(Long id) {
        ComprobanteEntity Comprobante = repositorio.findById(id).get();
        Comprobante.setEstado(true);
        return mapper.map(repositorio.save(Comprobante), ComprobanteDTO.class);
    }    

}
