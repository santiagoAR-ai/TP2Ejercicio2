import Persistence.RegistroCosto;
import org.example.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestRestaurante {
    @Test
    public void test01() {
        List<Comida> menuComidas = new ArrayList<>();
        List<Bebida> menuBebidas = new ArrayList<>();
        FormaDePago visa = new Visa();
        cargarMenu(menuComidas, menuBebidas);
        var registroDisco= new RegistroDiscoFake();
        var serviceFake= new ServiceFake();
        Restaurante restaurante = new Restaurante(menuBebidas, menuComidas,registroDisco,
                serviceFake);
        Tarjeta tarjeta = new Tarjeta("Visa", 5000,
                visa,"santiagoabdala270@gmail.com");
        Propina propina= Propina.MEDIO;
        restaurante.cobrar(tarjeta, menuComidas.get(0), menuBebidas.get(0),propina);
        assertEquals(2955.45,tarjeta.getSaldo(),0.01f);
        assertEquals("santiagoabdala270@gmail.com - Pago : 2044.55",
                serviceFake.mail());
    }

    @Test
    public void test02() {
        List<Comida> menuComidas = new ArrayList<>();
        List<Bebida> menuBebidas = new ArrayList<>();
        FormaDePago masterCard = new MasterCard();
        cargarMenu(menuComidas, menuBebidas);
        var registroCostoDBFake= new RegistroCostoDBFake();
        var registroDisco= new RegistroDiscoFake();
        var serviceFake= new ServiceFake();
        Restaurante restaurante = new Restaurante(menuBebidas, menuComidas,
                registroDisco,serviceFake);
        Tarjeta tarjeta = new Tarjeta("Mastercard", 5000, masterCard,
                "santiagoabdala270@gmail.com");
        Propina propina= Propina.BAJO ;
        restaurante.cobrar(tarjeta,menuComidas.get(1),menuBebidas.get(1),propina);
        assertEquals(3494.48,tarjeta.getSaldo(),0.01f);
        assertEquals("santiagoabdala270@gmail.com - Pago : 1505.52",
                serviceFake.mail());
    }

    @Test
    public void test03() {
        List<Comida> menuComidas = new ArrayList<>();
        List<Bebida> menuBebidas = new ArrayList<>();
        FormaDePago comarcaPlus = new ComarcaPlus();
        cargarMenu(menuComidas, menuBebidas);var registroCostoDBFake= new RegistroCostoDBFake();
        var registroDisco= new RegistroDiscoFake();
        var serviceFake= new ServiceFake();
        Restaurante restaurante = new Restaurante(menuBebidas, menuComidas,
                registroDisco,serviceFake);
        Tarjeta tarjeta = new Tarjeta("Comarca Plus", 5000, comarcaPlus,"santiagoabdala270@gmail.com");
        Propina propina= Propina.BAJO;
        restaurante.cobrar(tarjeta,menuComidas.get(2),menuBebidas.get(2),propina);
        assertEquals(2750.90,tarjeta.getSaldo(),0.01f);
        assertEquals("santiagoabdala270@gmail.com - Pago : 2249.1",
                serviceFake.mail());
    }

    @Test
    public void test04() {
        List<Comida> menuComidas = new ArrayList<>();
        List<Bebida> menuBebidas = new ArrayList<>();
        FormaDePago viedma = new Viedma();
        cargarMenu(menuComidas, menuBebidas);var registroCostoDBFake= new RegistroCostoDBFake();
        var registroDisco= new RegistroDiscoFake();
        var serviceFake= new ServiceFake();
        Restaurante restaurante = new Restaurante(menuBebidas, menuComidas,
                registroDisco,serviceFake);
        Tarjeta tarjeta = new Tarjeta("Viedma", 5000, viedma,"santiagoabdala270@gmail.com");
        Propina propina= Propina.ALTO;
        restaurante.cobrar(tarjeta,menuComidas.get(3),menuBebidas.get(3),propina);
        assertEquals(2532.50,tarjeta.getSaldo(),0.01f);
        assertEquals("santiagoabdala270@gmail.com - Pago : 2467.5",
                serviceFake.mail());
    }

    public void cargarMenu(List<Comida> menuComidas, List<Bebida> menuBebidas) {
        Comida comida1 = new Comida("Milanesa", 1500);
        Comida comida2 = new Comida("Hamburguesa", 1200);
        Comida comida3 = new Comida("Pizza", 1800);
        Comida comida4 = new Comida("Bife", 2000);
        Bebida bebida1 = new Bebida("Coca-Cola", 500);
        Bebida bebida2 = new Bebida("Agua", 300);
        Bebida bebida3 = new Bebida("Jugo de naranja", 450);
        Bebida bebida4 = new Bebida("Fanta", 350);
        menuComidas.add(comida1);
        menuComidas.add(comida2);
        menuComidas.add(comida3);
        menuComidas.add(comida4);
        menuBebidas.add(bebida1);
        menuBebidas.add(bebida2);
        menuBebidas.add(bebida3);
        menuBebidas.add(bebida4);
    }
}
