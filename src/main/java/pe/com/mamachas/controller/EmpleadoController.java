package pe.com.lasmamachas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.lasmamachas.dto.EmpleadoDTO;
import pe.com.lasmamachas.service.EmpleadoService;


@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService servicio;


    @GetMapping("/empleado/listar")
    public String MostrarListraEmpleado(Model modelo) {
        modelo.addAttribute("empleados", servicio.findAllCustom());
        return "empleado/listar_empleado";
    }

    @GetMapping("/empleado/registro")
    public String MostrarRegistroEmpleado(Model modelo) {
        return "empleado/registrar_empleado";
    }

    @GetMapping("/empleado/actualiza/{id}")
    public String MostrarActualizaEmpleado(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("empleado", servicio.findById(id));
        return "empleado/actualizar_empleado";
    }

    @GetMapping("/empleado/eliminar/{id}")
    public String EliminarEmpleado(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/empleado/listar";
    }

    //modelo para trsportar datos para las acciones
    @ModelAttribute("empleado")
    public EmpleadoDTO ModeloEmpleado() {
        return new EmpleadoDTO();
    }

    @GetMapping("/empleado/habilita")
    public String MostrarHabilitarEmpleado(Model modelo) {
        modelo.addAttribute("empleados", servicio.findAll());
        return "empleado/habilitar_empleado";
    }

    @GetMapping("/empleado/habilitar/{id}")
    public String HabilitarEmpleado(@PathVariable Long id,
            Model modelo) {
        servicio.enable(id);
        return "redirect:/empleado/habilita";
    }

    @GetMapping("/empleado/deshabilitar/{id}")
    public String DeshabilitarEmpleado(@PathVariable Long id,
            Model modelo) {
        servicio.delete(id);
        return "redirect:/empleado/habilita";
    }

    //accion
    @PostMapping("/empleado/registrar")
    public String RegistrarEmpleado(@ModelAttribute("empleado") EmpleadoDTO e) {
        servicio.add(e);
        return "redirect:/empleado/listar";
    }

    @PostMapping("/empleado/actualizar/{id}")
    public String Actualizarempleado(@PathVariable Long id,
            @ModelAttribute("empleado") EmpleadoDTO e) {
        servicio.update(e, id);
        return "redirect:/empleado/listar";
    }
/*
    //acciones
    @PostMapping("/login")
    public String EmpleadoLogin(@ModelAttribute("empleado") EmpleadoDTO e, Model modelo) {
        EmpleadoDTO objempleado = servicio.login(e.getUsuario(),e.getClave());
        if (objempleado != null) {
            return "redirect:/menuprincipal";
        } else {
            return "index";
        }
    }*/
}
