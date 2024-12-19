package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.dto.TipoInsumoDTO;
import pe.com.mamachas.service.TipoInsumoService;

@Controller
public class TipoInsumoController {

    @Autowired
    private TipoInsumoService servicio;

    @GetMapping("/tipoinsumo/listar")
    public String MostrarListarTipoInsumo(Model model) {
        model.addAttribute("tipoinsumos", servicio.findAllCustom());
        return "tipoinsumo/listar_tipoinsumo";
    }

    @GetMapping("/tipoinsumo/registro")
    public String MostrarRegistroTipoInsumo() {
        return "tipoinsumo/registrar_tipoinsumo";
    }

    @GetMapping("/tipoinsumo/actualizar/{id}")
    public String MostrarActualizarTipoInsumo(@PathVariable Long id, Model model) {
        model.addAttribute("tipoinsumos", servicio.findById(id));
        return "tipoinsumo/actualizar_tipoinsumo";
    }

    @GetMapping("/tipoinsumo/eliminar/{id}")
    public String EliminarTipoInsumo(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/tipoinsumo/listar";
    }

    @GetMapping("/tipoinsumo/habilitar")
    public String MostrarHabilitarTipoInsumo(Model model) {
        model.addAttribute("tipoinsumos", servicio.findAll());
        return "tipoinsumo/habilitar_tipoinsumo";
    }

    @GetMapping("/tipoinsumo/habilitar/{id}")
    public String HabilitarTipoInsumo(@PathVariable Long id, Model model) {
        servicio.enable(id);
        return "redirect:/tipoinsumo/habilitar";
    }

    @GetMapping("/tipoinsumo/deshabilitar/{id}")
    public String DeshabilitarTipoInsumo(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/tipoinsumo/habilitar";
    }

    @ModelAttribute("tipoinsumo")
    public TipoInsumoDTO ModeloTipoInsumo() {
        return new TipoInsumoDTO();
    }
    @PostMapping("/tipoinsumo/registrar")
    public String RegistrarTipoInsumo(@ModelAttribute("tipoinsumo") TipoInsumoDTO ti) {
        servicio.add(ti);
        return "redirect:/tipoinsumo/listar";
    }

    @PostMapping("/tipoinsumo/actualizar/{id}")
    public String ActualizarTipoInsumo(@PathVariable Long id, @ModelAttribute("tipoinsumo") TipoInsumoDTO ti) {
        servicio.update(ti, id);
        return "redirect:/tipoinsumo/listar";
    }

}

