package pe.com.mamachas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mamachas.dto.DetalleOrdenCompraDTO;
import pe.com.mamachas.service.DetalleOrdenCompraService;

import java.util.List;

@RestController
@RequestMapping("/detalleOrdenCompra")
public class DetalleOrdenCompraRestController {
    @Autowired
    private DetalleOrdenCompraService servicio;

    @GetMapping
    public List<DetalleOrdenCompraDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<DetalleOrdenCompraDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public DetalleOrdenCompraDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public DetalleOrdenCompraDTO add(@RequestBody DetalleOrdenCompraDTO doc) {
        return servicio.add(doc);
    }

    @PutMapping("/{id}")
    public DetalleOrdenCompraDTO update(@PathVariable long id, @RequestBody DetalleOrdenCompraDTO doc){
        return servicio.update(doc, id);
    }

    @DeleteMapping("/{id}")
    public DetalleOrdenCompraDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public DetalleOrdenCompraDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
