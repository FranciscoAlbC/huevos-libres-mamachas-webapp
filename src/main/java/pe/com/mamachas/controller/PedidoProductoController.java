package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.entity.PedidoProductoEntity;
import pe.com.mamachas.service.PedidoProductoService;
import pe.com.mamachas.service.PedidoService;
import pe.com.mamachas.service.ProductoService;

import java.util.List;

@Controller
public class PedidoProductoController {

    @Autowired
    private PedidoProductoService servicio;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PedidoService pedidoservice;


    @GetMapping("/pedidoproducto/listar")
    public String MostrarListarPedidoProducto(Model model) {
        List<PedidoProductoEntity> pedidoproductos = servicio.findAllCustom();
        model.addAttribute("pedidoproductos",pedidoproductos);
        model.addAttribute("productos", productoService.findAll());
        return "pedidoproducto/listar_pedidoproducto";
    }

    @GetMapping("/pedidoproducto/registro")
    public String MostrarRegistroPedidoProducto(Model model) {
        model.addAttribute("productos", productoService.findAllCustom());
        model.addAttribute("pedidos", pedidoservice.findAllCustom());
        return "pedidoproducto/registrar_pedidoproducto";
    }

    @GetMapping("/pedidoproducto/actualizar/{id}")
    public String MostrarActualizarPedidoProducto(@PathVariable long id, Model model) {
        model.addAttribute("productos", productoService.findAllCustom());
        model.addAttribute("pedidos", pedidoservice.findAllCustom());
        model.addAttribute("pedidoproductos", servicio.findById(id));
        return "pedidoproducto/actualizar_pedidoproducto";
    }

    @GetMapping("/pedidoproducto/eliminar/{id}")
    public String EliminarPedidoProducto(@PathVariable long id) {
        PedidoProductoEntity objpedpro = new PedidoProductoEntity();
        objpedpro.setCodigo(id);
        servicio.delete(objpedpro);
        return "redirect:/pedidoproducto/listar";
    }

    @GetMapping("/pedidoproducto/habilitar")
    public String MostrarHabilitarPedidoProducto(Model model) {
        model.addAttribute("productos", productoService.findAllCustom());
        model.addAttribute("pedidos", pedidoservice.findAllCustom());
        model.addAttribute("pedidoproductos", servicio.findAll());
        return "pedidoproducto/habilitar_pedidoproducto";
    }

    @GetMapping("/pedidoproducto/habilitar/{id}")
    public String HabilitarPedidoProducto(@PathVariable long id) {
        PedidoProductoEntity objpedpro = new PedidoProductoEntity();
        objpedpro.setCodigo(id);
        servicio.enable(objpedpro);
        return "redirect:/pedidoproducto/habilitar";
    }

    @GetMapping("/pedidoproducto/deshabilitar/{id}")
    public String DeshabilitarPedidoProducto(@PathVariable long id) {
        PedidoProductoEntity objpedpro = new PedidoProductoEntity();
        objpedpro.setCodigo(id);
        servicio.delete(objpedpro);
        return "redirect:/pedidoproducto/habilitar";
    }

    @ModelAttribute("pedidoproducto")
    public PedidoProductoEntity ModeloPedidoProducto() {
        return new PedidoProductoEntity();
    }

    @PostMapping("/pedidoproducto/registrar")
    public String RegistrarPedidoProducto(@ModelAttribute("pedidoproducto") PedidoProductoEntity p) {
        servicio.add(p);
        return "redirect:/pedidoproducto/listar";
    }


    @PostMapping("/pedidoproducto/actualizar/{id}")
    public String ActualizarPedidoProducto(@PathVariable long id, @ModelAttribute("tipoinsumo") PedidoProductoEntity p) {
        servicio.update(p);
        return "redirect:/pedidoproducto/listar";
    }
}

