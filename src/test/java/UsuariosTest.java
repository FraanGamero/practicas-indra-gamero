import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuariosTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testConstructorAndGetters() {
        Usuarios user = new Usuarios("Juan", "juan@example.com", "1234");
        assertEquals("Juan", user.getName());
        assertEquals("juan@example.com", user.getEmail());
        assertEquals("1234", user.getPass());
    }

    @Test
    public void testSignInUserSuccess() {
        Usuarios user = new Usuarios("Ana", "ana@example.com", "pass123");
        user.signInUser();
        String output = outContent.toString().trim();
        assertEquals("datos agregados correctamente", output);
    }

    @Test
    public void testSignInUserMissingFields() {
        Usuarios user = new Usuarios(null, null, null);
        user.signInUser();
        String output = outContent.toString().trim();
        assertEquals("Error, todos los campos tienen que estar completos", output);
    }

    @Test
    public void testSetters() {
        Usuarios user = new Usuarios("A", "a@a.com", "p");
        user.setName("Mario");
        user.setEmail("mario@example.com");
        user.setPass("securepass");
        user.setId(10);

        assertEquals("Mario", user.getName());
        assertEquals("mario@example.com", user.getEmail());
        assertEquals("securepass", user.getPass());
        assertEquals(10, user.getId());
    }
}
