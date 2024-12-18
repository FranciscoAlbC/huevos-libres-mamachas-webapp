package pe.com.mamachas.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.dto.TipoInsumoDTO;
import pe.com.mamachas.entity.TipoInsumoEntity;
import pe.com.mamachas.repository.TipoInsumoRepository;
import pe.com.mamachas.service.TipoInsumoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoInsumoServiceImpl implements TipoInsumoService {

    @Autowired
    private TipoInsumoRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<TipoInsumoDTO> findAll() {
        List<TipoInsumoEntity> lista = repositorio.findAll();
        return lista.stream().map(ti -> mapper.map(ti, TipoInsumoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TipoInsumoDTO> findAllCustom() {
        List<TipoInsumoEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(ti -> mapper.map(ti, TipoInsumoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TipoInsumoDTO findById(Long id) {
        TipoInsumoEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, TipoInsumoDTO.class);
    }

    @Override
    public TipoInsumoDTO add(TipoInsumoDTO ti) {
        TipoInsumoEntity tipoInsumo = mapper.map(ti, TipoInsumoEntity.class);
        return mapper.map(repositorio.save(tipoInsumo), TipoInsumoDTO.class);
    }

    @Override
    public TipoInsumoDTO update(TipoInsumoDTO ti, Long id) {
        TipoInsumoEntity tipoInsumo = repositorio.findById(id).get();
        mapper.map(ti, tipoInsumo);
        return mapper.map(repositorio.save(tipoInsumo), TipoInsumoDTO.class);
    }

    @Override
    public TipoInsumoDTO delete(Long id) {
        TipoInsumoEntity tipoInsumo = repositorio.findById(id).get();
        tipoInsumo.setEstado(false);
        return mapper.map(repositorio.save(tipoInsumo), TipoInsumoDTO.class);
    }

    @Override
    public TipoInsumoDTO enable(Long id) {
        TipoInsumoEntity tipoInsumo = repositorio.findById(id).get();
        tipoInsumo.setEstado(true);
        return mapper.map(repositorio.save(tipoInsumo), TipoInsumoDTO.class);
    }
}
