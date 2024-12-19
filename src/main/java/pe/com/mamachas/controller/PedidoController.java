package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.dto.PedidoDTO;
import pe.com.mamachas.service.PedidoService;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService servicio;

    @GetMapping("/pedido/listar")
    public String MostrarListraPedido(Model modelo) {
        modelo.addAttribute("pedidos", servicio.findAllCustom());
        return "pedido/listar_pedido";
    }

    @GetMapping("/pedido/registro")
    public String MostrarRegistroPedido(Model modelo) {
        return "pedido/registrar_pedido";
    }

    @GetMapping("/pedido/actualiza/{id}")
    public String MostrarActualizaPedido(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("pedido", servicio.findById(id));
        return "pedido/actualizar_pedido";
    }

    @GetMapping("/pedido/eliminar/{id}")
    public String EliminarPedido(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/pedido/listar";
    }

    //modelo para trsportar datos para las acciones
    @ModelAttribute("pedido")
    public PedidoDTO ModeloPedido() {
        return new PedidoDTO();
    }

    @GetMapping("/pedido/habilita")
    public String MostrarHabilitarPedido(Model modelo) {
        modelo.addAttribute("pedidos", servicio.findAll());
        return "pedido/habilitar_pedido";
    }

    @GetMapping("/pedido/habilitar/{id}")
    public String HabilitarPedido(@PathVariable Long id,
            Model modelo) {
        servicio.enable(id);
        return "redirect:/pedido/habilita";
    }

    @GetMapping("/pedido/deshabilitar/{id}")
    public String DeshabilitarPedido(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/pedido/habilita";
    }

    //accion
    @PostMapping("/pedido/registrar")
    public String RegistrarPedido(@ModelAttribute("pedido") PedidoDTO p) {
        servicio.add(p);
        return "redirect:/pedido/listar";
    }

    @PostMapping("/pedido/actualizar/{id}")
    public String ActualizarPedido(@PathVariable Long id,
            @ModelAttribute("pedido") PedidoDTO p) {
        servicio.update(p, id);
        return "redirect:/pedido/listar";
    }
    
    
}
