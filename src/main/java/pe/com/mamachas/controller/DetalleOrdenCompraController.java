package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.dto.DetalleOrdenCompraDTO;
import pe.com.mamachas.dto.OrdenCompraDTO;
import pe.com.mamachas.entity.DetalleOrdenCompraEntity;
import pe.com.mamachas.service.DetalleOrdenCompraService;
import pe.com.mamachas.service.OrdenCompraService;

@Controller
public class DetalleOrdenCompraController {

    @Autowired
    private DetalleOrdenCompraService servicio;

    @Autowired
    private OrdenCompraService servicioOrdenCompra;

    @GetMapping("/detalleordencompra/listar")
    public String MostrarDetalleOrdenCompra(Model model) {
        model.addAttribute("detalleordencompras", servicio.findAllCustom());
        return "detalleordencompra/listar_detalleordencompra";
    }

    @GetMapping("/detalleordencompra/registro")
    public String MostrarRegistroDetalleOrdenCompra(Model model) {
        model.addAttribute("ordencompras", servicioOrdenCompra.findAllCustom());
        return "detalleordencompra/registrar_detalleordencompra";
    }

    @GetMapping("/detalleordencompra/actualizar/{id}")
    public String MostrarActualizarDetalleOrdenCompra(@PathVariable Long id, Model model) {
        model.addAttribute("ordencompras", servicioOrdenCompra.findAllCustom());
        model.addAttribute("detalleordencompras", servicio.findById(id));
        return "detalleordencompra/actualizar_detalleordencompra";
    }

    @GetMapping("/detalleordencompra/eliminar/{id}")
    public String EliminarDetalleOrdenCompra(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/detalleordencompra/listar";
    }

    @GetMapping("/detalleordencompra/habilitar")
    public String MostrarHabilitarDetalleOrdenCompra(Model model) {
        model.addAttribute("detalleordencompras", servicio.findAll());
        return "detalleordencompra/habilitar_detalleordencompra";
    }

    @GetMapping("/detalleordencompra/habilitar/{id}")
    public String HabilitarDetalleOrdenCompra(@PathVariable Long id, Model model) {
        servicio.enable(id);
        return "redirect:/detalleordencompra/habilitar";
    }

    @GetMapping("/detalleordencompra/deshabilitar/{id}")
    public String DeshabilitarDetalleOrdenCompra(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/detalleordencompra/habilitar";
    }

    @ModelAttribute("detalleordencompra")
    public DetalleOrdenCompraDTO ModeloDetalleOrdenCompra() {
        return new DetalleOrdenCompraDTO();
    }

    @PostMapping("/detalleordencompra/registrar")
    public String RegistrarDetalleOrdenCompra(@ModelAttribute("detalleordencompra") DetalleOrdenCompraDTO doc) {
        servicio.add(doc);
        return "redirect:/detalleordencompra/listar";
    }

    @PostMapping("/detalleordencompra/actualizar/{id}")
    public String ActualizarDetalleOrdenCompra(@PathVariable Long id, @ModelAttribute("tipoinsumo") DetalleOrdenCompraEntity doc) {
        servicio.update(doc);
        return "redirect:/detalleordencompra/listar";
    }

//    @PostMapping("/detalleordencompra/actualizar/{id}")
//    public String ActualizarDetalleOrdenCompra(@PathVariable Long id, @ModelAttribute("tipoinsumo") DetalleOrdenCompraDTO doc) {
//        OrdenCompraDTO oc = servicioOrdenCompra.findById(doc.getOrdenCompra().getCodigo());
//        doc.setOrdenCompra(oc);
//        servicio.update(doc, id);
//        return "redirect:/detalleordencompra/listar";
//    }
}
