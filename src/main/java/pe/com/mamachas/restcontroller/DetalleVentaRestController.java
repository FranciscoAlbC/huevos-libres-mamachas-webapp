package pe.com.mamachas.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.mamachas.entity.DetalleVentaEntity;
import pe.com.mamachas.service.DetalleVentaService;

@RestController
@RequestMapping("/api/detalleventa")
public class DetalleVentaRestController {


    @Autowired
    private DetalleVentaService service;

  @GetMapping
    public List<DetalleVentaEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public List<DetalleVentaEntity> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<DetalleVentaEntity> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public DetalleVentaEntity add(@RequestBody DetalleVentaEntity v) {
        return service.add(v);
    }

    @PutMapping("/{id}")
    public DetalleVentaEntity update(@PathVariable int id, @RequestBody DetalleVentaEntity v) {
        return service.update(id, v);
    }

    @DeleteMapping("/{id}")
    public DetalleVentaEntity delete(@PathVariable int id) {
        return service.delete(id);
    }
    
}
