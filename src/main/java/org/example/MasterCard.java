package org.example;

public class MasterCard implements FormaDePago {
    @Override
    public float aplicarDescuento(float precioComida, float precioBebida) {
        return (precioComida + precioBebida) - (precioComida * 0.02f);
    }
}
