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

import pe.com.mamachas.entity.PromocionEntity;
import pe.com.mamachas.service.PromocionService;

@RestController
@RequestMapping("/api/promocion")
public class PromocionRestController {

    @Autowired
    private PromocionService service;

    
    @GetMapping
    public List<PromocionEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public List<PromocionEntity> findAllCustom() {
        return service.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<PromocionEntity> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public PromocionEntity add(@RequestBody PromocionEntity p) {
        return service.add(p);
    }

    @PutMapping("/{id}")
    public PromocionEntity update(@PathVariable int id, @RequestBody PromocionEntity p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public PromocionEntity delete(@PathVariable int id) {
        return service.delete(id);
    }

}
