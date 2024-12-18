package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.dto.DetalleOrdenCompraDTO;
import pe.com.mamachas.dto.PedidoProductoDTO;
import pe.com.mamachas.dto.PedidoProductoIdDTO;
import pe.com.mamachas.entity.PedidoProductoId;
import pe.com.mamachas.service.PedidoProductoService;

@Controller
public class PedidoProductoController {

    @Autowired
    private PedidoProductoService servicio;

//Todo agregar servicios
//    @Autowired
//    private PedidoService serviciopedido;
//    @Autowired
//    private ProductoService servicioproducto;


    @GetMapping("/pedidoproducto/listar")
    public String MostrarPedidoProducto(Model model) {
        model.addAttribute("pedidoproductos", servicio.findAllCustom());
        return "pedidoproducto/listar_pedidoproducto";
    }

    @GetMapping("/pedidoproducto/registro")
    public String MostrarRegistroPedidoProducto(Model model) {
        //TODO agregar modelos de pedido y producto
        // model.addAttribute("pedidos", serviciopedido.findAllCustom());
        // model.addAttribute("productos", servicioproductos.findAllCustom());
        return "pedidoproducto/registrar_pedidoproducto";
    }

    @GetMapping("/pedidoproducto/actualizar/{idPedido}/{idProducto}")
    public String MostrarActualizarPedidoProducto(@PathVariable Integer idPedido, @PathVariable Integer idProducto, Model model) {
        PedidoProductoIdDTO id = new  PedidoProductoIdDTO(idPedido, idProducto);
        //TODO agregar modelos de pedido y producto
        // model.addAttribute("pedidos", serviciopedido.findAllCustom());
        //  model.addAttribute("productos", servicioproductos.findAllCustom());
        model.addAttribute("pedidoproducto", servicio.findById(id));
        return "pedidoproducto/actualizar_pedidoproducto";
    }

    @GetMapping("/pedidoproducto/eliminar/{idPedido}/{idProducto}")
    public String EliminarPedidoProducto(@PathVariable Integer idPedido, @PathVariable Integer idProducto) {
        PedidoProductoIdDTO id = new  PedidoProductoIdDTO(idPedido, idProducto);
        servicio.delete(id);
        return "redirect:/pedidoproducto/listar";
    }

    @GetMapping("/pedidoproducto/habilitar")
    public String MostrarHabilitarPedidoProducto(Model model) {
        model.addAttribute("pedidoproductos", servicio.findAll());
        return "pedidoproducto/habilitar_pedidoproducto";
    }

    @GetMapping("/pedidoproducto/habilitar/{idPedido}/{idProducto}")
    public String HabilitarPedidoProducto(@PathVariable Integer idPedido, @PathVariable Integer idProducto) {
        PedidoProductoIdDTO id = new  PedidoProductoIdDTO(idPedido, idProducto);
        servicio.enable(id);
        return "redirect:/pedidoproducto/habilitar";
    }

    @GetMapping("/pedidoproducto/deshabilitar/{idPedido}/{idProducto}")
    public String DeshabilitarPedidoProducto(@PathVariable Integer idPedido, @PathVariable Integer idProducto) {
        PedidoProductoIdDTO id = new  PedidoProductoIdDTO(idPedido, idProducto);
        servicio.delete(id);
        return "redirect:/pedidoproducto/habilitar";
    }

    @ModelAttribute("pedidoproducto")
    public PedidoProductoDTO ModeloPedidoProducto() {
        return new PedidoProductoDTO();
    }

    @PostMapping("/pedidoproducto/registrar")
    public String RegistrarPedidoProducto(@ModelAttribute("pedidoproducto") PedidoProductoDTO pp) {
        servicio.add(pp);
        return "redirect:/pedidoproducto/listar";
    }

    @PostMapping("/pedidoproducto/actualizar/{idPedido}/{idProducto}")
    public String ActualizarPedidoProducto(@PathVariable Integer idPedido, @PathVariable Integer idProducto, @ModelAttribute("tipoinsumo") PedidoProductoDTO pp) {
        PedidoProductoIdDTO id = new  PedidoProductoIdDTO(idPedido, idProducto);
        servicio.update(pp, id);
        return "redirect:/pedidoproducto/listar";
    }
}
