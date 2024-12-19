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
import pe.com.mamachas.dto.PagoDTO;
import pe.com.mamachas.service.PagoService;

@RestController
@RequestMapping("/pago")
public class PagoRestController {

    @Autowired
    private PagoService servicio;

    @GetMapping
    public List<PagoDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<PagoDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public PagoDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public PagoDTO add(@RequestBody PagoDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public PagoDTO update(@PathVariable long id, @RequestBody PagoDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("/{id}")
    public PagoDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public PagoDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }        
}
