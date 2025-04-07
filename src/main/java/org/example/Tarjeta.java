package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tarjeta {
    private float saldo;
    private String Nombre;
    private FormaDePago formaDePago;
    private String correo;

    public Tarjeta(String Nombre, float saldo, FormaDePago formaDePago, String correo) {
        if (Nombre.isBlank()) {
            throw new RuntimeException("Error");
        }
        if (formaDePago == null) {
            throw new RuntimeException("Error");
        }
        this.Nombre = Nombre;
        this.saldo = saldo;
        this.formaDePago = formaDePago;
        this.correo=correo;
    }

    public void pagar(float importeTotal) {
        this.saldo-= importeTotal;
    }


    public float getSaldo(){
        return saldo;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public String getCorreo() {
        return correo;
    }
}
