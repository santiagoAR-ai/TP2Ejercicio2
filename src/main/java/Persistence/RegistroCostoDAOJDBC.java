package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegistroCostoDAOJDBC implements RegistroCosto{
    @Override
    public void registrar(LocalDate fecha, float costo) {
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO inscripcion(fecha,costo)" + "VALUES (?,?)");
            statement.setDate(1, java.sql.Date.valueOf(fecha));
            statement.setFloat(2, costo);
            int cantidad = statement.executeUpdate();

            if (cantidad == 0) {
                throw new RuntimeException("No fue posible realizar la carga");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error");
        } finally {
            ConnectionManager.disconnect();
        }
    }

}
