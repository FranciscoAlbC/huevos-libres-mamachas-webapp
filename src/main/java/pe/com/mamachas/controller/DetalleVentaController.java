package pe.com.mamachas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.mamachas.entity.DetalleVentaEntity;
import pe.com.mamachas.entity.ProductoEntity;
import pe.com.mamachas.service.DetalleVentaService;
/* import org.slf4j.Logger;
import org.slf4j.LoggerFactory; */

@Controller
@RequestMapping("/detalleventa")
public class DetalleVentaController {

    @Autowired
    DetalleVentaService dtService;

    /* private static final Logger logger = LoggerFactory.getLogger(DetalleVentaController.class); */


    @GetMapping("/lista")
    public String listar(Model model) {
        List<DetalleVentaEntity> detalleVentas = dtService.findAll();
        
       /*  if (!detalleVentas.isEmpty()) {
            logger.info("primer elemento: {}", detalleVentas.get(0));
        } else {
            logger.warn("no trajo datos.");
        } */

        model.addAttribute("detalleVentas", detalleVentas);
        return "detalleventa/lista";
    }

    @GetMapping("/registrar")
    public String mostrarFormRegistro(Model model) {
        model.addAttribute("detalleVentas", new DetalleVentaEntity());
        return "detalleventa/registrar"; 
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute DetalleVentaEntity detalleventa) {
        dtService.add(detalleventa);
        return "redirect:/detalleventa/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormEditar(@PathVariable int id, Model model) {
        Optional<DetalleVentaEntity> detalleventa = dtService.findById(id);
        if (detalleventa.isPresent()) {
            model.addAttribute("detalleventa", detalleventa.get());
            return "detalleventa/editar";  
        } else {
            return "redirect:/detalleventa/lista"; 
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute DetalleVentaEntity detalleventa) {
        dtService.update(id, detalleventa);
        return "redirect:/detalleventa/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String delete(@PathVariable int id) {
        dtService.delete(id);
        return "redirect:/detalleventa/lista"; 
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable int id, Model model) {
        Optional<DetalleVentaEntity> detalleventa = dtService.findById(id);
        if (detalleventa.isPresent()) {
            model.addAttribute("detalleventa", detalleventa.get());
            return "detalleventa/detalle";
        }else 
        {
            return "redirect:/detalleventa/lista";
        }
    }

}