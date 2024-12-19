package pe.com.mamachas.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.mamachas.dto.ClienteDTO;
import pe.com.mamachas.entity.ClienteEntity;
import pe.com.mamachas.repository.ClienteRepository;
import pe.com.mamachas.service.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService {

      @Autowired
    private ClienteRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteEntity> lista = repositorio.findAll();
        return lista.stream()
                .map(c -> mapper.map(c, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteDTO> findAllCustom() {
        List<ClienteEntity> lista = repositorio.findAllCustom();
        return lista.stream()
                .map(c -> mapper.map(c, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Long id) {
        ClienteEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, ClienteDTO.class);
    }

    @Override
    public ClienteDTO findByName(String nombre) {
        ClienteEntity lista = repositorio.findByName(nombre);
        return mapper.map(lista, ClienteDTO.class);
    }

    @Override
    public ClienteDTO add(ClienteDTO c) {
        ClienteEntity cliente = mapper.map(c, ClienteEntity.class);
        return mapper.map(repositorio.save(cliente), ClienteDTO.class);
    }

    @Override
    public ClienteDTO update(ClienteDTO c, Long id) {
        ClienteEntity cliente = repositorio.findById(id).get();
        mapper.map(c, cliente);
        return mapper.map(repositorio.save(cliente), ClienteDTO.class);
    }

    @Override
    public ClienteDTO delete(Long id) {
        ClienteEntity cliente = repositorio.findById(id).get();
        cliente.setEstado(false);
        return mapper.map(repositorio.save(cliente), ClienteDTO.class);
    }

    @Override
    public ClienteDTO enable(Long id) {
        ClienteEntity cliente = repositorio.findById(id).get();
        cliente.setEstado(true);
        return mapper.map(repositorio.save(cliente), ClienteDTO.class);
    }

}
