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
        return "bonificacionPagos";
    }

    @PostMapping("/calcularPagos")
    public String calcularPagos(@ModelAttribute("pagosmodel") bonificacionPagosModel pg, Model model){
        Double montoCo = pg.getMontoCompra();
        Integer diasPa = pg.getDiasPago();
        Double desctPa;
        Double total;
        String diagnostico = "";
        String estiloDiagnostico = "alert-primary";

        if (diasPa < 7){
            desctPa = 0.1;
            total = montoCo * desctPa;
            diagnostico = "El monto total a pagar es: " + total;

        }else if (diasPa < 15){
            desctPa = 0.05;
            total = montoCo * desctPa;
            diagnostico = "El monto total a pagar es: " + total;

        } else {
            total = montoCo;
            diagnostico = "El monto total a pagar es: " + total;

        }

        model.addAttribute("resultado", " " + diagnostico);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilodiagnostico", estiloDiagnostico);
        return "bonificacionPagos";

    }

}
