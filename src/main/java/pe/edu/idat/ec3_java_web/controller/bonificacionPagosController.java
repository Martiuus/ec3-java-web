package pe.edu.idat.ec3_java_web.controller;

// ALONSO ZAMBRANO

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.ec3_java_web.model.bonificacionPagosModel;


@Controller
public class bonificacionPagosController {

    @GetMapping("/bonificacionPagos")
    public String formularioBonificacionPagos(Model model){
        model.addAttribute("pagosmodel", new bonificacionPagosModel());
        model.addAttribute("visualizaralerta", false);
        model.addAttribute("visualizaralerta2", false);
        return "bonificacionPagos";
    }

    @PostMapping("/calcularPagos")
    public String calcularPagos(@ModelAttribute("pagosmodel") bonificacionPagosModel pg, Model model){
        Double montoCo = pg.getMontoCompra();
        Integer diasPa = pg.getDiasPago();
        Double desctPa;
        Double subtotal;
        Double total;
        String diagnosticoSub = "";
        String diagnosticoTot = "";
        String estiloDiagnostico = "alert-primary";
        String estiloDiagnostico2 = "alert-primary";

        if (diasPa < 7){
            desctPa = 0.1;
            subtotal = montoCo * desctPa;
            total = montoCo - subtotal;
            diagnosticoSub = "Tienes un descuento del 10%: " + "S/."+ subtotal;
            diagnosticoTot = "Y el monto total a pagar es: " + "S/."+ total;

        }else if (diasPa < 15){
            desctPa = 0.05;
            subtotal = montoCo * desctPa;
            total = montoCo - subtotal;
            diagnosticoSub = "Tienes un descuento del 5%: " + "S/."+ subtotal;
            diagnosticoTot = "Y el monto total a pagar es: " + "S/."+ total;

        } if (diasPa >= 15) {
            total = montoCo;
            diagnosticoSub = "No tienes descuento y el monto total a pagar es: " + "S/."+ total;
            diagnosticoTot = "";
            model.addAttribute("visualizaralerta2", false);
        } else {
            model.addAttribute("visualizaralerta2", true);
        }

        model.addAttribute("resultado", " " + diagnosticoSub);
        model.addAttribute("resultado2", " " + diagnosticoTot);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilodiagnostico", estiloDiagnostico);
        model.addAttribute("estilodiagnostico2", estiloDiagnostico2);
        return "bonificacionPagos";

    }

}
