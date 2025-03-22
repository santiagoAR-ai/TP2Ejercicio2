package org.example;

public class ComarcaPlus implements FormaDePago {
    @Override
    public float aplicarDescuento(float precioComida, float precioBebida) {
        return (precioComida + precioBebida) - ((precioComida + precioBebida) * 0.02f);
    }
}
