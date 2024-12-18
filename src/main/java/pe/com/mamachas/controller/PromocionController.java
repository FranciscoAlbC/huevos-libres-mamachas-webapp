package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pe.com.mamachas.entity.PromocionEntity;
import pe.com.mamachas.service.PromocionService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Controller
@RequestMapping("/promocion")
public class PromocionController {

    @Autowired
    private PromocionService promoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        List<PromocionEntity> promociones = promoService.findAll();
        model.addAttribute("promociones", promociones);
        return "promocion/lista"; 
    }


    @GetMapping("/registrar")
    public String mostrarFormRegistro(Model model) {
        model.addAttribute("promociones", new PromocionEntity());
        return "promocion/registrar"; 
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute PromocionEntity promocion) {
        promoService.add(promocion);
        return "redirect:/promocion/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormEditar(@PathVariable int id, Model model) {
        Optional<PromocionEntity> promocion = promoService.findById(id);
        if (promocion.isPresent()) {
            model.addAttribute("promocion", promocion.get());
            return "promocion/editar";  
        } else {
            return "redirect:/promocion/lista"; 
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute PromocionEntity promocion) {
        promoService.update(id, promocion);
        return "redirect:/promocion/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String deletePromocion(@PathVariable int id) {
        promoService.delete(id);
        return "redirect:/promocion/lista"; 
    }


    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable int id, Model model) {
        Optional<PromocionEntity> promocion = promoService.findById(id);
        if (promocion.isPresent()) {
            model.addAttribute("promocion", promocion.get());
            return "promocion/detalle";
        }else 
        {
            return "redirect:/promocion/lista";
        }
    }
}
