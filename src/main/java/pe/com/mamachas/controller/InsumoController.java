package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.dto.InsumoDTO;
import pe.com.mamachas.service.InsumoService;
import pe.com.mamachas.service.TipoInsumoService;

@Controller
public class InsumoController {

    @Autowired
    private InsumoService servicio;

    @Autowired
    private TipoInsumoService tipoInsumoServicio;

    @GetMapping("/insumo/listar")
    public String MostrarListarInsumo(Model model) {
        model.addAttribute("insumos", servicio.findAllCustom());
        return "insumo/listar_insumo";
    }

    @GetMapping("/insumo/registro")
    public String MostrarRegistroInsumo(Model model) {
        model.addAttribute("tipoinsumos", tipoInsumoServicio.findAllCustom());
        return "insumo/registrar_insumo";
    }

    @GetMapping("/insumo/actualizar/{id}")
    public String MostrarActualizarInsumo(@PathVariable Long id, Model model) {
        model.addAttribute("tipoinsumos", tipoInsumoServicio.findAllCustom());
        model.addAttribute("insumos", servicio.findById(id));
        return "insumo/actualizar_insumo";
    }

    @GetMapping("/insumo/eliminar/{id}")
    public String EliminarInsumo(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/insumo/listar";
    }

    @GetMapping("/insumo/habilitar")
    public String MostrarHabilitarInsumo(Model model) {
        model.addAttribute("insumos", servicio.findAll());
        return "insumo/habilitar_insumo";
    }

    @GetMapping("/insumo/habilitar/{id}")
    public String HabilitarInsumo(@PathVariable Long id, Model model) {
        servicio.enable(id);
        return "redirect:/insumo/habilitar";
    }

    @GetMapping("/insumo/deshabilitar/{id}")
    public String DeshabilitarInsumo(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/insumo/habilitar";
    }

    @ModelAttribute("insumo")
    public InsumoDTO ModeloInsumo() {
        return new InsumoDTO();
    }
    @PostMapping("/insumo/registrar")
    public String RegistrarInsumo(@ModelAttribute("tipoinsumo") InsumoDTO i) {
        servicio.add(i);
        return "redirect:/insumo/listar";
    }

    @PostMapping("/insumo/actualizar/{id}")
    public String ActualizarInsumo(@PathVariable Long id, @ModelAttribute("tipoinsumo") InsumoDTO i) {
        servicio.update(i, id);
        return "redirect:/insumo/listar";
    }

}
