package pe.com.mamachas.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.dto.MovimientoStockDTO;
import pe.com.mamachas.dto.TipoInsumoDTO;
import pe.com.mamachas.entity.MovimientoStockEntity;
import pe.com.mamachas.entity.TipoInsumoEntity;
import pe.com.mamachas.repository.MovimientoStockRepository;
import pe.com.mamachas.service.MovimientoStockService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimientoStockServiceImpl implements MovimientoStockService {

    @Autowired
    private MovimientoStockRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<MovimientoStockDTO> findAll() {
        List<MovimientoStockEntity> lista = repositorio.findAll();
        return lista.stream().map(ms -> mapper.map(ms, MovimientoStockDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<MovimientoStockDTO> findAllCustom() {
        List<MovimientoStockEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(ms -> mapper.map(ms, MovimientoStockDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MovimientoStockDTO findById(Long id) {
        MovimientoStockEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, MovimientoStockDTO.class);
    }

    @Override
    public MovimientoStockDTO add(MovimientoStockDTO ms) {
        MovimientoStockEntity movStock = mapper.map(ms, MovimientoStockEntity.class);
        return mapper.map(repositorio.save(movStock), MovimientoStockDTO.class);
    }

    @Override
    public MovimientoStockDTO update(MovimientoStockDTO ms, Long id) {
        MovimientoStockEntity movStock = repositorio.findById(id).get();
        mapper.map(ms, movStock);
        return mapper.map(repositorio.save(movStock), MovimientoStockDTO.class);
    }

    @Override
    public MovimientoStockDTO delete(Long id) {
        MovimientoStockEntity movStock = repositorio.findById(id).get();
        movStock.setEstado(false);
        return mapper.map(repositorio.save(movStock), MovimientoStockDTO.class);
    }

    @Override
    public MovimientoStockDTO enable(Long id) {
        MovimientoStockEntity movStock = repositorio.findById(id).get();
        movStock.setEstado(true);
        return mapper.map(repositorio.save(movStock), MovimientoStockDTO.class);
    }
}
