package pe.com.mamachas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mamachas.entity.PedidoProductoEntity;
import pe.com.mamachas.service.PedidoProductoService;

import java.util.List;

@RestController
@RequestMapping("/pedidoProducto")
public class PedidoProductoRestController {

    @Autowired
    private PedidoProductoService servicio;

    @GetMapping
    public List<PedidoProductoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<PedidoProductoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public PedidoProductoEntity findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public PedidoProductoEntity add(@RequestBody PedidoProductoEntity p) {
        return servicio.add(p);
    }

    @PutMapping("/{id}")
    public PedidoProductoEntity update(@PathVariable long id, @RequestBody PedidoProductoEntity p){
    p.setCodigo(id);
    return servicio.update(p);
    }


    @DeleteMapping("/{id}")
    public PedidoProductoEntity delete(@PathVariable long id) {
        PedidoProductoEntity pedpro = new PedidoProductoEntity();
        pedpro.setEstado(false);
        return servicio.delete(PedidoProductoEntity.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public PedidoProductoEntity enable(@PathVariable long id) {
        PedidoProductoEntity pedpro = new PedidoProductoEntity();
        pedpro.setEstado(true);
        return servicio.delete(PedidoProductoEntity.builder().codigo(id).build());
    }
}
