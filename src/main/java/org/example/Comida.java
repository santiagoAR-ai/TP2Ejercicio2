package org.example;

public class Comida {
    private String nombre;
    private int precio;

    public Comida(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
/*
    public String getComida() {
        return "Comida " + nombre + "Precio " + precio;
    }
*/
    public int getPrecio() {
        return precio;
    }
}
