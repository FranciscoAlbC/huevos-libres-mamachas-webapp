package pe.com.lasmamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import pe.com.lasmamachas.dto.ComprobanteDTO;
import pe.com.lasmamachas.dto.PagoDTO;
import pe.com.lasmamachas.service.ComprobanteService;
import pe.com.lasmamachas.service.PagoService;

@Controller
public class PagoController {
    
    @Autowired
    private PagoService servicio;
    
    @Autowired
    private ComprobanteService serviciocomprobante;

    @GetMapping("/pago/listar")
    public String MostrarListraPago(Model modelo) {
        modelo.addAttribute("pagos", servicio.findAllCustom());
        return "pago/listar_pago";
    }

    @GetMapping("/pago/registro")
    public String MostrarRegistroPago(Model modelo) {
        modelo.addAttribute("comprobante", servicio.findAllCustom());
        return "pago/registrar_pago";
    }

    @GetMapping("/pago/actualiza/{id}")
    public String MostrarActualizaPago(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("comprobante", servicio.findAllCustom());
        modelo.addAttribute("pago", servicio.findById(id));
        return "pago/actualizar_pago";
    }

    @GetMapping("/pago/eliminar/{id}")
    public String EliminarPago(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/pago/listar";
    }

    //modelo para trsportar datos para las acciones
    @ModelAttribute("pago")
    public PagoDTO ModeloPago() {
        return new PagoDTO();
    }

    @GetMapping("/pago/habilita")
    public String MostrarHabilitarPago(Model modelo) {
        modelo.addAttribute("pagos", servicio.findAll());
        return "pago/habilitar_pago";
    }

    @GetMapping("/pago/habilitar/{id}")
    public String HabilitarPago(@PathVariable Long id,
            Model modelo) {
        servicio.enable(id);
        return "redirect:/pago/habilitar";
    }

    @GetMapping("/pago/deshabilitar/{id}")
    public String DeshabilitarPago(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/pago/habilitar";
    }

    //accion
    @PostMapping("/pago/registrar")
    public String Registrarpago(@ModelAttribute("pago") PagoDTO pa) {
        servicio.add(pa);
        return "redirect:/pago/listar";
    }

    @PostMapping("/pago/actualizar/{id}")
    public String Actualizarpago(@PathVariable Long id,
            @ModelAttribute("pago") PagoDTO pa) {
        ComprobanteDTO comprobante = serviciocomprobante.findById(pa.getComprobante().getCodigo());
        pa.setComprobante(comprobante);
        servicio.update(pa, id);
        return "redirect:/pago/listar";
    }    
}
