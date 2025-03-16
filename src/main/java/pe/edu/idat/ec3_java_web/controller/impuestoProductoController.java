package pe.edu.idat.ec3_java_web.controller;

// ALONSO ZAMBRANO

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.idat.ec3_java_web.model.bonificacionPagosModel;
import pe.edu.idat.ec3_java_web.model.impuestoProductoModel;

@Controller
public class impuestoProductoController {

    @GetMapping("/impuestoProducto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("impuestomodel", new impuestoProductoModel());
        return "impuestoProducto";
    }

    @PostMapping("/calcularimpuesto")
    public String calcularImpuesto(@ModelAttribute impuestoProductoModel imp, Model model) {
        double precio = imp.getPrecioBase();
        String categoria = imp.getCategoria();
        double impuesto = 0;

        if (categoria.equals("1")) { // Electronica
            impuesto = precio * 0.15;
        } else if (categoria.equals("2")) { // Alimenntos
            impuesto = precio * 0.05;
        } else if (categoria.equals("3")) { // Ropa
            impuesto = precio * 0.08;
        } else if (categoria.equals("4")) { // Muebles
            impuesto = precio * 0.10;
        }

        double precioFinal = precio + impuesto;

        model.addAttribute("impuestomodel", imp);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("resultado", "Precio Base: S/. " + precio + ", Impuesto: S/. " + impuesto + ", Precio Final: S/. " + precioFinal);
        model.addAttribute("estilodiagnostico", "alert-success");

        return "impuestoProducto";
    }
}
