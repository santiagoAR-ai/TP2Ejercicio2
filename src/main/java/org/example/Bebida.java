package org.example;

public class Bebida {
    private String nombre;
    private int precio;

    public Bebida(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
/*
    public String getBebida() {
        return "Bebida " + nombre + "Precio " + precio;
    }
*/
    public int getPrecio() {
        return precio;
    }
}
