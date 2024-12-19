package pe.com.mamachas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.mamachas.dto.ClienteDTO;
import pe.com.mamachas.service.ClienteService;

@Controller
public class ClienteController {

  @Autowired
    private ClienteService servicio;

    @GetMapping("/cliente/listar")
    public String MostrarListraCliente(Model modelo) {
        modelo.addAttribute("clientes", servicio.findAllCustom());
        return "cliente/listar_cliente";
    }

    @GetMapping("/cliente/registro")
    public String MostrarRegistroCliente(Model modelo) {
        return "cliente/registrar_cliente";
    }

    @GetMapping("/cliente/actualiza/{id}")
    public String MostrarActualizaCliente(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("cliente", servicio.findById(id));
        return "cliente/actualizar_cliente";
    }

    @GetMapping("/cliente/eliminar/{id}")
    public String EliminarCliente(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/cliente/listar";
    }

    //modelo para trsportar datos para las acciones
    @ModelAttribute("cliente")
    public ClienteDTO ModeloCliente() {
        return new ClienteDTO();
    }

    @GetMapping("/cliente/habilita")
    public String MostrarHabilitarCliente(Model modelo) {
        modelo.addAttribute("clientes", servicio.findAll());
        return "cliente/habilitar_cliente";
    }

    @GetMapping("/cliente/habilitar/{id}")
    public String HabilitarCliente(@PathVariable Long id,
            Model modelo) {
        servicio.enable(id);
        return "redirect:/cliente/habilita";
    }

    @GetMapping("/cliente/deshabilitar/{id}")
    public String DeshabilitarCliente(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/cliente/habilita";
    }

    //accion
    @PostMapping("/cliente/registrar")
    public String RegistrarCliente(@ModelAttribute("cliente") ClienteDTO c) {
        servicio.add(c);
        return "redirect:/cliente/listar";
    }

    @PostMapping("/cliente/actualizar/{id}")
    public String ActualizarCliente(@PathVariable Long id,
            @ModelAttribute("cliente") ClienteDTO c) {
        servicio.update(c, id);
        return "redirect:/cliente/listar";
    }
}
