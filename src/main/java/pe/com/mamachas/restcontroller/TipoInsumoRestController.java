package pe.com.mamachas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mamachas.dto.TipoInsumoDTO;
import pe.com.mamachas.service.TipoInsumoService;

import java.util.List;

@RestController
@RequestMapping("/tipoInsumo")
public class TipoInsumoRestController {

    @Autowired
    private TipoInsumoService servicio;

    @GetMapping
    public List<TipoInsumoDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<TipoInsumoDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public TipoInsumoDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public TipoInsumoDTO add(@RequestBody TipoInsumoDTO ti) {
        return servicio.add(ti);
    }

    @PutMapping("/{id}")
    public TipoInsumoDTO update(@PathVariable long id, @RequestBody TipoInsumoDTO ti){
        return servicio.update(ti, id);
    }

    @DeleteMapping("/{id}")
    public TipoInsumoDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public TipoInsumoDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
