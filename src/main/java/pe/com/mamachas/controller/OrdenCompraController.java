package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.dto.OrdenCompraDTO;
import pe.com.mamachas.entity.OrdenCompraEntity;
import pe.com.mamachas.service.OrdenCompraService;
import pe.com.mamachas.service.ProveedorService;

@Controller
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService servicio;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/ordencompra/listar")
    public String MostrarOrdenCompra(Model model) {
        model.addAttribute("ordencompras", servicio.findAllCustom());
        return "ordencompra/listar_ordencompra";
    }

    @GetMapping("/ordencompra/registro")
    public String MostrarRegistroOrdenCompra(Model model) {
        model.addAttribute("proveedores", proveedorService.findAllCustom());
        return "ordencompra/registrar_ordencompra";
    }

    @GetMapping("/ordencompra/actualizar/{id}")
    public String MostrarActualizarOrdenCompra(@PathVariable Long id, Model model) {
        model.addAttribute("proveedores", proveedorService.findAllCustom());
        model.addAttribute("ordencompras", servicio.findById(id));
        return "ordencompra/actualizar_ordencompra";
    }

    @GetMapping("/ordencompra/eliminar/{id}")
    public String EliminarOrdenCompra(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/ordencompra/listar";
    }

    @GetMapping("/ordencompra/habilitar")
    public String MostrarHabilitarOrdenCompra(Model model) {
        model.addAttribute("ordencompras", servicio.findAll());
        return "ordencompra/habilitar_ordencompra";
    }

    @GetMapping("/ordencompra/habilitar/{id}")
    public String HabilitarOrdenCompra(@PathVariable Long id, Model model) {
        servicio.enable(id);
        return "redirect:/ordencompra/habilitar";
    }

    @GetMapping("/ordencompra/deshabilitar/{id}")
    public String DeshabilitarOrdenCompra(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/ordencompra/habilitar";
    }

    @ModelAttribute("ordencompra")
    public OrdenCompraDTO ModeloOrdenCompra() {
        return new OrdenCompraDTO();
    }

    @ModelAttribute("ordencompraEnt")
    public OrdenCompraEntity ModeloOrdenCompraEnt() {
        return new OrdenCompraEntity();
    }


    @PostMapping("/ordencompra/registrar")
    public String RegistrarOrdenCompra(@ModelAttribute("ordencompra") OrdenCompraDTO oc) {
        servicio.add(oc);
        return "redirect:/ordencompra/listar";
    }

    @PostMapping("/ordencompra/actualizar/{id}")
    public String ActualizarOrdenCompra(@PathVariable Long id, @ModelAttribute("ordencompraEnt") OrdenCompraEntity oc) {
        servicio.update(oc);
        return "redirect:/ordencompra/listar";
    }
}
