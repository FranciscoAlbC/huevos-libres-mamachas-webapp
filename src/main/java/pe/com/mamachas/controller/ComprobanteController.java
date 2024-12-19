package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.dto.ClienteDTO;
import pe.com.mamachas.dto.ComprobanteDTO;
import pe.com.mamachas.dto.PedidoDTO;
import pe.com.mamachas.service.ClienteService;
import pe.com.mamachas.service.ComprobanteService;
import pe.com.mamachas.service.PedidoService;

@Controller
public class ComprobanteController {

    @Autowired
    private ComprobanteService servicio;
    
    @Autowired
    private PedidoService serviciopedido;
    
    @Autowired
    private ClienteService serviciocliente;
    

    @GetMapping("/comprobante/listar")
    public String MostrarListraComprobante(Model modelo) {
        modelo.addAttribute("comprobantes", servicio.findAllCustom());
        return "comprobante/listar_comprobante";
    }

    @GetMapping("/comprobante/registro")
    public String MostrarRegistroComprobante(Model modelo) {
        modelo.addAttribute("pedidos", serviciopedido.findAllCustom());
        modelo.addAttribute("clientes", serviciocliente.findAllCustom());
        return "comprobante/registrar_comprobante";
    }

    @GetMapping("/comprobante/actualiza/{id}")
    public String MostrarActualizaComprobante(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("pedidos", serviciopedido.findAllCustom());
        modelo.addAttribute("clientes", serviciocliente.findAllCustom());
        modelo.addAttribute("comprobante", servicio.findById(id));
        
        return "comprobante/actualizar_comprobante";
    }

    @GetMapping("/comprobante/eliminar/{id}")
    public String EliminarComprobante(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/comprobante/listar";
    }

    //modelo para trsportar datos para las acciones
    @ModelAttribute("comprobante")
    public ComprobanteDTO ModeloComprobante() {
        return new ComprobanteDTO();
    }

    @GetMapping("/comprobante/habilita")
    public String MostrarHabilitarComprobante(Model modelo) {
        modelo.addAttribute("comprobantes", servicio.findAll());
        return "comprobante/habilitar_comprobante";
    }

    @GetMapping("/comprobante/habilitar/{id}")
    public String HabilitarComprobante(@PathVariable Long id,
            Model modelo) {
        servicio.enable(id);
        return "redirect:/comprobante/habilita";
    }

    @GetMapping("/comprobante/deshabilitar/{id}")
    public String DeshabilitarComprobante(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/comprobante/habilita";
    }

    //accion
    @PostMapping("/comprobante/registrar")
    public String RegistrarComprobante(@ModelAttribute("comprobante") ComprobanteDTO co) {
        servicio.add(co);
        return "redirect:/comprobante/listar";
    }

    @PostMapping("/comprobante/actualizar/{id}")
    public String ActualizarComprobante(@PathVariable Long id,
            @ModelAttribute("comprobante") ComprobanteDTO co) {
        
        PedidoDTO pedido = serviciopedido.findById(co.getPedido().getCodigo());
        ClienteDTO cliente = serviciocliente.findById(co.getCliente().getCodigo());
        co.setPedido(pedido);
        co.setCliente(cliente);
        
        servicio.update(co, id);
        return "redirect:/comprobante/listar";
    }
    
}
