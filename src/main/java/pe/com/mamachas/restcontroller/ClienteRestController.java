package pe.com.lasmamachas.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.lasmamachas.dto.ClienteDTO;
import pe.com.lasmamachas.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    private ClienteService servicio;

    @GetMapping
    public List<ClienteDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ClienteDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ClienteDTO add(@RequestBody ClienteDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public ClienteDTO update(@PathVariable long id, @RequestBody ClienteDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("/{id}")
    public ClienteDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public ClienteDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}