package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.mamachas.entity.VentaEntity;
import pe.com.mamachas.service.VentaService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/venta")
public class VentaController {

    private static final Logger logger = LoggerFactory.getLogger(VentaController.class);
    @Autowired
    private VentaService vService;

    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, true));
    }

    
    @GetMapping("/lista")
    public String listar(Model model) {
        List<VentaEntity> ventas = vService.findAll();
        
        model.addAttribute("ventas", ventas);
        return "venta/lista";
    }

    @GetMapping("/registrar")
    public String mostrarFormRegistro(Model model) {
        model.addAttribute("venta", new VentaEntity());
        return "venta/registrar"; 
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute VentaEntity venta) {
        vService.add(venta);
        return "redirect:/venta/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormEditar(@PathVariable int id, Model model) {
        Optional<VentaEntity> venta = vService.findById(id);
        if (venta.isPresent()) {
            model.addAttribute("venta", venta.get());
            return "venta/editar";  
        } else {
            return "redirect:/venta/lista"; 
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute VentaEntity venta) {
        vService.update(id, venta);
        return "redirect:/venta/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String delete(@PathVariable int id) {
        vService.delete(id);
        return "redirect:/venta/lista"; 
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable int id, Model model) {
        Optional<VentaEntity> venta = vService.findById(id);
        if (venta.isPresent()) {
            model.addAttribute("venta", venta.get());
            return "venta/detalle";
        }else 
        {
            return "redirect:/venta/lista";
        }
    }
}
