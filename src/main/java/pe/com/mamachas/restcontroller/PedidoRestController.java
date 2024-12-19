package pe.com.mamachas.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.mamachas.dto.PedidoDTO;
import pe.com.mamachas.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoRestController {
    @Autowired
    private PedidoService servicio;

    @GetMapping
    public List<PedidoDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<PedidoDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public PedidoDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public PedidoDTO add(@RequestBody PedidoDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public PedidoDTO update(@PathVariable long id, @RequestBody PedidoDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("/{id}")
    public PedidoDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public PedidoDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }    
}
