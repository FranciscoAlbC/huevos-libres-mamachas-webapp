package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.dto.MovimientoStockDTO;
import pe.com.mamachas.service.DetalleOrdenCompraService;
import pe.com.mamachas.service.InsumoService;
import pe.com.mamachas.service.MovimientoStockService;

@Controller
public class MovimientoStockController {

    @Autowired
    private MovimientoStockService servicio;

    @Autowired
    private InsumoService insumoService;

    @Autowired
    private DetalleOrdenCompraService detalleOrdenCompraService;

    @GetMapping("/movimientostock/listar")
    public String MostrarDetalleMovStock(Model model) {
        model.addAttribute("movimientostocks", servicio.findAllCustom());
        return "movimientostock/listar_movimientostock";
    }

    @GetMapping("/movimientostock/registro")
    public String MostrarRegistroMovStock(Model model) {
        model.addAttribute("insumos", insumoService.findAllCustom());
        model.addAttribute("detalleordencompras", detalleOrdenCompraService.findAllCustom());
        return "movimientostock/registrar_movimientostock";
    }

    @GetMapping("/movimientostock/actualizar/{id}")
    public String MostrarActualizarMovStock(@PathVariable Long id, Model model) {
        model.addAttribute("insumos", insumoService.findAllCustom());
        model.addAttribute("detalleordencompras", detalleOrdenCompraService.findAllCustom());
        model.addAttribute("movimientostocks", servicio.findById(id));
        return "movimientostock/actualizar_movimientostock";
    }

    @GetMapping("/movimientostock/eliminar/{id}")
    public String EliminarMovStock(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/movimientostock/listar";
    }

    @GetMapping("/movimientostock/habilitar")
    public String MostrarHabilitarMovStock(Model model) {
        model.addAttribute("movimientostocks", servicio.findAll());
        return "movimientostock/habilitar_movimientostock";
    }

    @GetMapping("/movimientostock/habilitar/{id}")
    public String HabilitarMovStock(@PathVariable Long id, Model model) {
        servicio.enable(id);
        return "redirect:/movimientostock/habilitar";
    }

    @GetMapping("/movimientostock/deshabilitar/{id}")
    public String DeshabilitarMovStock(@PathVariable Long id, Model model) {
        servicio.delete(id);
        return "redirect:/movimientostock/habilitar";
    }

    @ModelAttribute("movimientostock")
    public MovimientoStockDTO ModeloMovStock() {
        return new MovimientoStockDTO();
    }
    @PostMapping("/movimientostock/registrar")

    public String RegistrarMovStock(@ModelAttribute("movimientostock") MovimientoStockDTO ms) {
        servicio.add(ms);
        return "redirect:/movimientostock/listar";
    }

    @PostMapping("/movimientostock/actualizar/{id}")
    public String ActualizarMovStock(@PathVariable Long id, @ModelAttribute("movimientostock") MovimientoStockDTO ms) {
        servicio.update(ms, id);
        return "redirect:/movimientostock/listar";
    }
}
