package com.mycompany.model;

import java.util.Objects;

public final class Conversion {
    private final String base_code;
    private final String target_code;
    private String fecha;
    private final Double conversion_rate;
    private Double cantidadBase;
    private final Double conversion_result;

    public Conversion(String base_code,
                      String target_code,
                      String fecha,
                      Double conversion_rate,
                      Double cantidadBase,
                      Double conversion_result) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.fecha = fecha;
        this.conversion_rate = conversion_rate;
        this.cantidadBase = cantidadBase;
        this.conversion_result = conversion_result;
    }

    public String base_code() {
        return base_code;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCantidadBase(Double cantidadBase) {
        this.cantidadBase = cantidadBase;
    }

    public String target_code() {
        return target_code;
    }

    public String fecha() {
        return fecha;
    }

    public Double conversion_rate() {
        return conversion_rate;
    }

    public Double cantidadBase() {
        return cantidadBase;
    }

    public Double conversion_result() {
        return conversion_result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Conversion) obj;
        return Objects.equals(this.base_code, that.base_code) &&
                Objects.equals(this.target_code, that.target_code) &&
                Objects.equals(this.fecha, that.fecha) &&
                Objects.equals(this.conversion_rate, that.conversion_rate) &&
                Objects.equals(this.cantidadBase, that.cantidadBase) &&
                Objects.equals(this.conversion_result, that.conversion_result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base_code, target_code, fecha, conversion_rate, cantidadBase, conversion_result);
    }

    @Override
    public String toString() {
        return "Conversion[" +
                "base_code=" + base_code + ", " +
                "target_code=" + target_code + ", " +
                "fecha=" + fecha + ", " +
                "conversion_rate=" + conversion_rate + ", " +
                "cantidadBase=" + cantidadBase + ", " +
                "conversion_result=" + conversion_result + ']';
    }

}
