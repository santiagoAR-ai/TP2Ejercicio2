package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tarjeta {
    private BigDecimal saldo;
    private String Nombre;
    private FormaDePago formaDePago;

    public Tarjeta(String Nombre, BigDecimal saldo, FormaDePago formaDePago) {
        if (Nombre.isBlank()) {
            throw new RuntimeException("Error");
        }
        if (formaDePago == null) {
            throw new RuntimeException("Error");
        }
        this.Nombre = Nombre;
        this.saldo = saldo;
        this.formaDePago = formaDePago;
    }

    public void pagar(float precioComida, float precioBebida,Propina propina) {
        float precio = formaDePago.aplicarDescuento(precioComida, precioBebida);
        BigDecimal importeTotal = BigDecimal.valueOf(precio * (1 + propina.porcentaje()))
                .setScale(2, RoundingMode.HALF_UP);
        saldo = saldo.subtract(importeTotal).setScale(2, RoundingMode.HALF_UP);
    }


    public BigDecimal getSaldo(){
        return saldo;
    }
}
