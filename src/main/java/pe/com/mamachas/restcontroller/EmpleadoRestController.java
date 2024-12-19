package pe.com.mamachas.restcontroller;

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
import pe.com.mamachas.dto.EmpleadoDTO;
import pe.com.mamachas.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {
    @Autowired
    private EmpleadoService servicio;

    @GetMapping
    public List<EmpleadoDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<EmpleadoDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public EmpleadoDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public EmpleadoDTO add(@RequestBody EmpleadoDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public EmpleadoDTO update(@PathVariable long id, @RequestBody EmpleadoDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("/{id}")
    public EmpleadoDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public EmpleadoDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }    
}
