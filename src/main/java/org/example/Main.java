package org.example;

import Persistence.RegistroCosto;
import Persistence.RegistroCostoDAOJDBC;
import Persistence.ServiceMail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Comida> menuComidas = new ArrayList<>();
        List<Bebida> menuBebidas = new ArrayList<>();
        Comida comida = new Comida("Milanesa", 1500);
        Bebida bebida = new Bebida("Coca-Cola", 500);
        FormaDePago visa = new Visa();
        menuComidas.add(comida);
        menuBebidas.add(bebida);
        var registroCosto= new RegistroCostoDAOJDBC();
        var servicioEmail= new ServiceMail("05b1cdffe5297b","2e74a25c291adf",
                "true","true",
                "sandbox.smtp.mailtrap.io","587");
        Tarjeta tarjeta = new Tarjeta("Visa", 5000,
                visa,"santiagoabdala270@gmail.com");
        Propina propina= Propina.MEDIO;
        Restaurante restaurante = new Restaurante(menuBebidas, menuComidas,registroCosto,servicioEmail);
        restaurante.cobrar(tarjeta, menuComidas.get(0), menuBebidas.get(0),propina);

    }


}
