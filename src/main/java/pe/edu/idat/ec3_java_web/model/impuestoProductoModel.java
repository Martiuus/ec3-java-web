package pe.edu.idat.ec3_java_web.model;

// ALONSO ZAMBRANO

public class impuestoProductoModel {
    private double precioBase;
    private String categoria;
    private double impuestoCalculado;
    private double precioFinal;

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getImpuestoCalculado() {
        return impuestoCalculado;
    }

    public void setImpuestoCalculado(double impuestoCalculado) {
        this.impuestoCalculado = impuestoCalculado;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}

