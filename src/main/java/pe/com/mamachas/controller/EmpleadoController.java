package pe.com.lasmamachas.controller;

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

    @ModelAttribute("empleado")
    public EmpleadoDTO ModeloEmpleado() {
        return new EmpleadoDTO();
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
