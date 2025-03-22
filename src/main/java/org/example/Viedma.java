package org.example;

public class Viedma implements FormaDePago {
    @Override
    public float aplicarDescuento(float precioComida, float precioBebida) {
        return (precioComida + precioBebida);
    }
}
