package pe.edu.idat.ec3_java_web.controller;

// AARON PINEDA


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.ec3_java_web.model.comisionVendedoresModel;

@Controller
public class comisionVendedoresController {

    @GetMapping("/comisionVendedores")
    public String formularioComision(Model model){
        model.addAttribute("comisionmodel", new comisionVendedoresModel());
        model.addAttribute("visualizaralerta", false);
        return "comisionVendedores";
    }

    @PostMapping("/calcularventas")
    public String calcularVentas(@ModelAttribute("comisionmodel") comisionVendedoresModel c, Model model){
        Double ventasTotales = c.getVentasMensuales();
        Double comision = 0.0;

        if (ventasTotales < 1000){
            comision = ventasTotales * 0.03;
            c.setComision(Double.valueOf(String.format("%.2f", comision)));
        } else if (ventasTotales < 5000) {
            comision = ventasTotales * 0.05;
            c.setComision(Double.valueOf(String.format("%.2f", comision)));
        } else if (ventasTotales < 10000) {
            comision = ventasTotales * 0.07;
            c.setComision(Double.valueOf(String.format("%.2f", comision)));
        }else {
            comision = ventasTotales * 0.1;
            c.setComision(Double.valueOf(String.format("%.2f", comision)));
        }

        model.addAttribute("resultado", String.format("%.2f",comision));
        model.addAttribute("visualizaralerta", true);
        return "comisionVendedores";

    }
}
