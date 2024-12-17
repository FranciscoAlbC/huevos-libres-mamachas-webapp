package pe.com.mamachas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/promocion")
    public String mostrarPromocion() {
        return "promocion/lista"; 
    }
}
