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

import pe.com.mamachas.entity.ProveedorEntity;
import pe.com.mamachas.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorRestController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<ProveedorEntity> findAll() {
        return proveedorService.findAll();
    }

    @GetMapping("/custom")
    public List<ProveedorEntity> findAllCustom() {
        return proveedorService.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<ProveedorEntity> findById(@PathVariable int id) {
        return proveedorService.findById(id);
    }

    @PostMapping
    public ProveedorEntity add(@RequestBody ProveedorEntity proveedor) {
        return proveedorService.add(proveedor);
    }

    @PutMapping("/{id}")
    public ProveedorEntity update(@PathVariable int id, @RequestBody ProveedorEntity proveedor) {
        return proveedorService.update(id, proveedor);
    }

    @DeleteMapping("/{id}")
    public ProveedorEntity delete(@PathVariable int id) {
        return proveedorService.delete(id);
    }
}
