package pe.com.mamachas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mamachas.dto.InsumoDTO;
import pe.com.mamachas.entity.InsumoEntity;
import pe.com.mamachas.service.InsumoService;

import java.util.List;

@RestController
@RequestMapping("/insumo")
public class InsumoRestController {

    @Autowired
    private InsumoService servicio;

    @GetMapping
    public List<InsumoDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<InsumoDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public InsumoDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public InsumoDTO add(@RequestBody InsumoDTO i) {
        return servicio.add(i);
    }

    @PutMapping("/{id}")
    public InsumoEntity update(@PathVariable long id, @RequestBody InsumoEntity i){
        return servicio.update(i);
    }
//    @PutMapping("/{id}")
//    public InsumoDTO update(@PathVariable long id, @RequestBody InsumoDTO i){
//        return servicio.update(i, id);
//    }

    @DeleteMapping("/{id}")
    public InsumoDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public InsumoDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
