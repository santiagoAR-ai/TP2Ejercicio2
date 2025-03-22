package org.example;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Bebida> menuBebidas = new ArrayList<>();
    private List<Comida> menuComidas = new ArrayList<>();
    public Restaurante(List<Bebida> menuBebidas, List<Comida> menuComidas) {
        this.menuBebidas = menuBebidas;
        this.menuComidas = menuComidas;
    }

    public void cobrar(Tarjeta tarjeta, Comida comida, Bebida bebida,Propina propina) {
        tarjeta.pagar(comida.getPrecio(), bebida.getPrecio(), propina);
    }

    /*
    public void mostrarMenu() {
        for (int i = 0; i < menuBebidas.size(); i++) {
            System.out.println(menuBebidas.get(i).getBebida());
        }
        for (int i = 0; i < menuComidas.size(); i++) {
            System.out.println(menuComidas.get(i).getComida());
        }
    }
*/

}