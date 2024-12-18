package pe.com.mamachas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mamachas.dto.OrdenCompraDTO;
import pe.com.mamachas.entity.OrdenCompraEntity;
import pe.com.mamachas.service.OrdenCompraService;


import java.util.List;

@RestController
@RequestMapping("/ordenCompra")
public class OrdenCompraRestController {

    @Autowired
    private OrdenCompraService servicio;

    @GetMapping
    public List<OrdenCompraDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<OrdenCompraDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public OrdenCompraDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public OrdenCompraDTO add(@RequestBody OrdenCompraDTO oc) {
        return servicio.add(oc);
    }

    @PutMapping("/{id}")
    public OrdenCompraEntity update(@PathVariable long id, @RequestBody OrdenCompraEntity oc){
        return servicio.update(oc);
    }

    @DeleteMapping("/{id}")
    public OrdenCompraDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public OrdenCompraDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}

