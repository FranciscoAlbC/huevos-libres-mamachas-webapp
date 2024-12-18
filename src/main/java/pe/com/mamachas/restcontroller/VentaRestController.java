package pe.com.mamachas.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.com.mamachas.entity.VentaEntity;
import pe.com.mamachas.service.VentaService;

@RestController
@RequestMapping("/api/venta")
public class VentaRestController {

    @Autowired
    private VentaService service;

    @GetMapping
    public List<VentaEntity> findAll() {
        return service.findAll();
    }
    @GetMapping("/custom")
    public List<VentaEntity> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<VentaEntity> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public VentaEntity add(@RequestBody VentaEntity v) {
        return service.add(v);
    }
    @PutMapping("/{id}")
    public VentaEntity update(@PathVariable int id, @RequestBody VentaEntity v) {
        return service.update(id, v);
    }
    @DeleteMapping("/{id}")
    public VentaEntity delete(@PathVariable int id) {
        return service.delete(id);
    }

}
