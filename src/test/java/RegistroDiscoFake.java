import Persistence.RegistroCosto;

import java.time.LocalDate;

public class RegistroDiscoFake implements RegistroCosto {
    private String content;

    public boolean startWith(String start) {
        return this.content.startsWith(start);
    }
    @Override
    public void registrar(LocalDate fecha, float costo) {
        this.content= fecha.toString() + "||" + costo;
    }
}
