package pe.com.mamachas.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import pe.com.mamachas.entity.ProveedorEntity;
import pe.com.mamachas.service.ProveedorService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Date;



@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    
    @Autowired
    private ProveedorService prodService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        List<ProveedorEntity> proveedores = prodService.findAll();
        model.addAttribute("proveedores", proveedores);
        return "proveedor/lista"; 
    }


    @GetMapping("/registrar")
    public String mostrarFormRegistro(Model model) {
        model.addAttribute("proveedores", new ProveedorEntity());
        return "proveedor/registrar"; 
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute ProveedorEntity proveedor) {
        prodService.add(proveedor);
        return "redirect:/proveedor/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormEditar(@PathVariable int id, Model model) {
        Optional<ProveedorEntity> proveedor = prodService.findById(id);
        if (proveedor.isPresent()) {
            model.addAttribute("proveedor", proveedor.get());
            return "proveedor/editar";  
        } else {
            return "redirect:/proveedor/lista"; 
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute ProveedorEntity proveedor) {
        prodService.update(id, proveedor);
        return "redirect:/proveedor/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String deleteproveedor(@PathVariable int id) {
        prodService.delete(id);
        return "redirect:/proveedor/lista"; 
    }
}
