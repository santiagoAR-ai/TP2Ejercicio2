package org.example;

import Persistence.IMailService;
import Persistence.RegistroCosto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Bebida> menuBebidas = new ArrayList<>();
    private List<Comida> menuComidas = new ArrayList<>();
    private RegistroCosto enMemoria;
    private IMailService mailService;
    public Restaurante(List<Bebida> menuBebidas, List<Comida> menuComidas,
                       RegistroCosto enMemoria, IMailService mailService) {
        this.menuBebidas = menuBebidas;
        this.menuComidas = menuComidas;
        this.enMemoria=enMemoria;
        this.mailService=mailService;
    }

    public void cobrar(Tarjeta tarjeta, Comida comida, Bebida bebida,Propina propina) {
        float importeTotal= calcularImporte(tarjeta, comida, bebida, propina);
        tarjeta.pagar(importeTotal);
        this.enMemoria.registrar(LocalDate.now(), importeTotal);
        this.mailService.enviarCorreo(tarjeta.getCorreo(), "Pago ", String.valueOf(importeTotal));
    }

    private float calcularImporte(Tarjeta tarjeta, Comida comida, Bebida bebida,Propina propina){
        float coste = tarjeta.getFormaDePago().aplicarDescuento(comida.getPrecio(), bebida.getPrecio());
        float porcentajePropina= coste * propina.porcentaje();
        return coste + porcentajePropina;
    }


}