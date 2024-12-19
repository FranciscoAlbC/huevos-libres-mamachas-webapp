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
import pe.com.mamachas.dto.ComprobanteDTO;
import pe.com.mamachas.service.ComprobanteService;

@RestController
@RequestMapping("/comprobante")
public class ComprobanteRestController {


    @Autowired
    private ComprobanteService servicio;

    @GetMapping
    public List<ComprobanteDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ComprobanteDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ComprobanteDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ComprobanteDTO add(@RequestBody ComprobanteDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public ComprobanteDTO update(@PathVariable long id, @RequestBody ComprobanteDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("/{id}")
    public ComprobanteDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public ComprobanteDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }    
}
