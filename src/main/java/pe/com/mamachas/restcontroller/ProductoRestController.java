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

import pe.com.mamachas.entity.ProductoEntity;
import pe.com.mamachas.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<ProductoEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public List<ProductoEntity> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<ProductoEntity> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity p) {
        return service.add(p);
    }

    @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable int id, @RequestBody ProductoEntity p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public ProductoEntity delete(@PathVariable int id) {
        return service.delete(id);
    }
}
