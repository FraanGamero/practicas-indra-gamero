import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InscripcionTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testConstructorAndGetters() {
        Inscripcion ins = new Inscripcion(5, 10);
        assertEquals(1, ins.getId(), "El ID debe inicializarse a 1");
        assertEquals(5, ins.getIdUser(), "El idUser debe inicializarse correctamente");
        assertEquals(10, ins.getIdEvent(), "El idEvent debe inicializarse correctamente");
        assertEquals(2, Inscripcion.getPointer(), "El puntero debe incrementarse tras crear una inscripción");

        Inscripcion ins2 = new Inscripcion(7, 14);
        assertEquals(2, ins2.getId(), "El ID debe inicializarse a 2 para la segunda instancia");
        assertEquals(3, Inscripcion.getPointer(), "El puntero debe incrementarse nuevamente tras crear una segunda inscripción");
    }

    @Test
    public void testAddInscripctionWithValidUser() {
        Inscripcion ins = new Inscripcion(3, 8);
        ins.addInscripction();
        String output = outContent.toString().trim();
        assertEquals("Datos introducidos", output, "addInscripction debe imprimir éxito cuando idUser es distinto de cero");
    }

    @Test
    public void testAddInscripctionWithZeroUser() {
        Inscripcion ins = new Inscripcion(0, 8);
        ins.addInscripction();
        String output = outContent.toString().trim();
        assertEquals("error", output, "addInscripction debe imprimir error cuando idUser es cero");
    }

    @Test
    public void testSettersAndGetters() {
        Inscripcion ins = new Inscripcion(1, 2);
        // Test setId
        ins.setId(100);
        assertEquals(100, ins.getId(), "setId debe actualizar el ID");

        // Test setIdUser y getIdUser
        ins.setIdUser(50);
        assertEquals(50, ins.getIdUser(), "setIdUser debe actualizar idUser");

        // Test setIdEvent y getIdEvent
        ins.setIdEvent(75);
        assertEquals(75, ins.getIdEvent(), "setIdEvent debe actualizar idEvent");

        // Test setPointer y getPointer estáticos
        Inscripcion.setPointer(20);
        assertEquals(20, Inscripcion.getPointer(), "setPointer debe actualizar el puntero estático");
    }

    @Test
    public void testToString() {
        Inscripcion ins = new Inscripcion(4, 9);
        // id será 1 dado que el puntero se reinicia
        String expected = "Inscripcion [id=1, idUser=4, idEvent=9]";
        assertEquals(expected, ins.toString(), "toString debe devolver la representación de cadena correcta");
    }
}
