package org.example;

public class Visa implements FormaDePago {
    @Override
    public float aplicarDescuento(float precioComida, float precioBebida) {
        return (precioComida + precioBebida) - (precioBebida * 0.03f);
    }
}
