import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRestaurante {
    @Test
    public void test01() {
        List<Comida> menuComidas = new ArrayList<>();
        List<Bebida> menuBebidas = new ArrayList<>();
        FormaDePago visa = new Visa();
        cargarMenu(menuComidas, menuBebidas);
        Restaurante restaurante = new Restaurante(menuBebidas, menuComidas);
        Tarjeta tarjeta1 = new Tarjeta("Visa", 5000, visa);
        restaurante.cobrar(tarjeta1, menuComidas.get(0), menuBebidas.get(0));

    }

    @Test
    public void test02() {
        List<Comida> menuComidas = new ArrayList<>();
        List<Bebida> menuBebidas = new ArrayList<>();
        FormaDePago MasterCard = new MasterCard();
        cargarMenu(menuComidas, menuBebidas);
        Restaurante restaurante = new Restaurante(menuBebidas, menuComidas);
        Tarjeta tarjeta2 = new Tarjeta("Mastercard", 5000, MasterCard);


    }

    @Test
    public void test03() {
        List<Comida> menuComidas = new ArrayList<>();
        List<Bebida> menuBebidas = new ArrayList<>();
        FormaDePago comarcaPlus = new ComarcaPlus();
        cargarMenu(menuComidas, menuBebidas);
        Restaurante restaurante = new Restaurante(menuBebidas, menuComidas);
        Tarjeta tarjeta3 = new Tarjeta("Viedma", 5000, comarcaPlus);
    }

    @Test
    public void test04() {
        List<Comida> menuComidas = new ArrayList<>();
        List<Bebida> menuBebidas = new ArrayList<>();
        FormaDePago viedma = new Viedma();
        cargarMenu(menuComidas, menuBebidas);
        Restaurante restaurante = new Restaurante(menuBebidas, menuComidas);
        Tarjeta tarjeta4 = new Tarjeta("Comarca Plus", 5000, viedma);

    }

    public void cargarMenu(List<Comida> menuComidas, List<Bebida> menuBebidas) {
        Comida comida1 = new Comida("Milanesa", 1500);
        Comida comida2 = new Comida("Hamburguesa", 1200);
        Comida comida3 = new Comida("Pizza", 1800);
        Bebida bebida1 = new Bebida("Coca-Cola", 500);
        Bebida bebida2 = new Bebida("Agua", 300);
        Bebida bebida3 = new Bebida("Jugo de naranja", 450);
        menuComidas.add(comida1);
        menuComidas.add(comida2);
        menuComidas.add(comida3);
        menuBebidas.add(bebida1);
        menuBebidas.add(bebida2);
        menuBebidas.add(bebida3);
    }
}
