package pe.com.mamachas.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.dto.InsumoDTO;
import pe.com.mamachas.entity.InsumoEntity;
import pe.com.mamachas.repository.InsumoRepository;
import pe.com.mamachas.service.InsumoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsumoServiceImpl implements InsumoService {

    @Autowired
    private InsumoRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<InsumoDTO> findAll() {
        List<InsumoEntity> lista = repositorio.findAll();
        return lista.stream().map(i -> mapper.map(i, InsumoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<InsumoDTO> findAllCustom() {
        List<InsumoEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(i -> mapper.map(i, InsumoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public InsumoDTO findById(Long id) {
        InsumoEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, InsumoDTO.class);
    }

    @Override
    public InsumoDTO add(InsumoDTO i) {
        InsumoEntity insumo = mapper.map(i, InsumoEntity.class);
        return mapper.map(repositorio.save(insumo), InsumoDTO.class);
    }

    @Override
    public InsumoDTO update(InsumoDTO i, Long id) {
        InsumoEntity insumo = repositorio.findById(id).get();
        mapper.map(i, insumo);
        return mapper.map(repositorio.save(insumo), InsumoDTO.class);
    }

    @Override
    public InsumoDTO delete(Long id) {
        InsumoEntity insumo = repositorio.findById(id).get();
        insumo.setEstado(false);
        return mapper.map(repositorio.save(insumo), InsumoDTO.class);
    }

    @Override
    public InsumoDTO enable(Long id) {
        InsumoEntity insumo = repositorio.findById(id).get();
        insumo.setEstado(true);
        return mapper.map(repositorio.save(insumo), InsumoDTO.class);
    }
}
