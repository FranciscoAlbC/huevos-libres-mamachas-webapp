package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import pe.com.mamachas.entity.ProductoEntity;
import pe.com.mamachas.service.ProductoService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Controller
@RequestMapping("/producto")
public class ProductoController {


    @Autowired
    private ProductoService prodService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        List<ProductoEntity> productos = prodService.findAll();
        model.addAttribute("productos", productos);
        return "producto/lista"; 
    }


    @GetMapping("/registrar")
    public String mostrarFormRegistro(Model model) {
        model.addAttribute("productos", new ProductoEntity());
        return "producto/registrar"; 
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute ProductoEntity producto) {
        prodService.add(producto);
        return "redirect:/producto/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormEditar(@PathVariable int id, Model model) {
        Optional<ProductoEntity> producto = prodService.findById(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "producto/editar";  
        } else {
            return "redirect:/producto/lista"; 
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute ProductoEntity producto) {
        prodService.update(id, producto);
        return "redirect:/producto/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String deleteproducto(@PathVariable int id) {
        prodService.delete(id);
        return "redirect:/producto/lista"; 
    }
}


