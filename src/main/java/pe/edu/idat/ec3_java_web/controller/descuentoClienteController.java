package pe.edu.idat.ec3_java_web.controller;

// AARON PINEDA

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.ec3_java_web.model.descuentoClienteModel;

@Controller
public class descuentoClienteController {

    @GetMapping("/descuentoCliente")
    public String formularioDescuentoCliente(Model model){
        model.addAttribute("descuentomodel", new descuentoClienteModel());
        model.addAttribute("visualizaralerta", false);
        return "descuentoCliente";
    }

    @PostMapping("/calcularDescuento")
    public String calcularDescuento(@ModelAttribute("descuentomodel") descuentoClienteModel d, Model model){

        Double montoCo = d.getMonto();
        int aniosAn = d.getAnios();
        Double descuento = 0.0;
        Double totalPagar = 0.0;

        if (aniosAn < 1){
            descuento = montoCo * 0.02;
            totalPagar = montoCo - descuento;

        } else if (aniosAn < 3) {
            descuento = montoCo * 0.05;
            totalPagar = montoCo - descuento;
            
        } else if (aniosAn < 5) {
            descuento = montoCo * 0.08;
            totalPagar = montoCo - descuento;
            
        } else if (aniosAn > 5) {
            descuento = montoCo * 0.12;
            totalPagar = montoCo - descuento;

        }


        model.addAttribute("resultado", "Felicidades, recibes un descuento de S/ " + descuento +
                "<br>El total a pagar es: S/ " + totalPagar);

        model.addAttribute("visualizaralerta", true);

        return "descuentoCliente";
    }



}
