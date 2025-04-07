package Persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class EnDiscoRegistroCosto implements RegistroCosto{
    private String ruta;

    public EnDiscoRegistroCosto(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void registrar(LocalDate fecha, float costo) {
        String registro = fecha.toString() + "||" + costo;
        try {
            Files.write((Paths.get(this.ruta)),
                    registro.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir", e);
        }
    }
}
