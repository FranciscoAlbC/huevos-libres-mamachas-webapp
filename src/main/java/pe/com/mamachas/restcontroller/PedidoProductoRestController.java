package pe.com.mamachas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mamachas.dto.PedidoProductoDTO;
import pe.com.mamachas.dto.PedidoProductoIdDTO;
import pe.com.mamachas.entity.PedidoProductoEntity;
import pe.com.mamachas.entity.PedidoProductoId;
import pe.com.mamachas.service.PedidoProductoService;

import java.util.List;

@RestController
@RequestMapping("/pedidoProducto")
public class PedidoProductoRestController {

    @Autowired
    private PedidoProductoService servicio;

    @GetMapping
    public List<PedidoProductoDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<PedidoProductoDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{idPedido}/{idProducto}")
    public PedidoProductoDTO findById(@PathVariable Integer idPedido, @PathVariable Integer idProducto) {
        PedidoProductoIdDTO id = new PedidoProductoIdDTO(idPedido, idProducto);
        return servicio.findById(id);
    }

    @PostMapping
    public PedidoProductoDTO add(@RequestBody PedidoProductoDTO pp) {
        return servicio.add(pp);
    }

    @PutMapping("/{idPedido}/{idProducto}")
    public PedidoProductoEntity update(@PathVariable Integer idPedido, @PathVariable Integer idProducto, @RequestBody PedidoProductoEntity pp){
        PedidoProductoId id = new PedidoProductoId(idPedido, idProducto);
        pp.setCodigo(id);
        return servicio.update(pp);
    }
//    @PutMapping("/{idPedido}/{idProducto}")
//    public PedidoProductoDTO update(@PathVariable Integer idPedido, @PathVariable Integer idProducto, @RequestBody PedidoProductoDTO pp){
//        PedidoProductoIdDTO id = new PedidoProductoIdDTO(idPedido, idProducto);
//        return servicio.update(pp, id);
//    }

    @DeleteMapping("/{idPedido}/{idProducto}")
    public PedidoProductoDTO delete(@PathVariable Integer idPedido, @PathVariable Integer idProducto) {
        PedidoProductoIdDTO id = new PedidoProductoIdDTO(idPedido, idProducto);
        return servicio.delete(id);
    }

    @PutMapping("/enable/{idPedido}/{idProducto}")
    public PedidoProductoDTO enable(@PathVariable Integer idPedido, @PathVariable Integer idProducto) {
        PedidoProductoIdDTO id = new PedidoProductoIdDTO(idPedido, idProducto);
        return servicio.enable(id);
    }
}
