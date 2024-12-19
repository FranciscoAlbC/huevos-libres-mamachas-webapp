package pe.com.mamachas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.mamachas.dto.MovimientoStockDTO;
import pe.com.mamachas.entity.MovimientoStockEntity;
import pe.com.mamachas.service.MovimientoStockService;

import java.util.List;

@RestController
@RequestMapping("/movimientoStock")
public class MovimientoStockRestController {

    @Autowired
    private MovimientoStockService servicio;

    @GetMapping
    public List<MovimientoStockDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<MovimientoStockDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public MovimientoStockDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public MovimientoStockDTO add(@RequestBody MovimientoStockDTO ms) {
        return servicio.add(ms);
    }


    @PutMapping("/{id}")
    public MovimientoStockEntity update(@PathVariable long id, @RequestBody MovimientoStockEntity ms){
        return servicio.update(ms);
    }

//    @PutMapping("/{id}")
//    public MovimientoStockDTO update(@PathVariable long id, @RequestBody MovimientoStockDTO ms){
//        return servicio.update(ms, id);
//    }

    @DeleteMapping("/{id}")
    public MovimientoStockDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public MovimientoStockDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }

}
