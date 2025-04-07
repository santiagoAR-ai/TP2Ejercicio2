import Persistence.ConnectionManager;
import Persistence.RegistroCosto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RegistroCostoDBFake  {
    @Test
    public void testConnection() {
        Connection connection = null;
        connection = ConnectionManager.getConnection();
        assertNotNull(connection, "La conexión debería ser válida y no nula.");
    }
}
