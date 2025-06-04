import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventoTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testConstructorAndGetters() {
        Evento ev = new Evento("EventoTest", "2025-06-04", "Madrid", "2h", 1, 1, 1);
        assertEquals(1, ev.getId(), "El ID debe inicializarse a 1");
        assertEquals("EventoTest", ev.getName(), "El nombre debe inicializarse correctamente");
        assertEquals("2025-06-04", ev.getDate(), "La fecha debe inicializarse correctamente");
        assertEquals("Madrid", ev.getPlace(), "El lugar debe inicializarse correctamente");
        assertEquals("2h", ev.getDuration(), "La duración debe inicializarse correctamente");
        assertEquals(1, ev.getIdCat(), "El idCat debe inicializarse correctamente");
        assertEquals(1, ev.getIdLoc(), "El idLoc debe inicializarse correctamente");
        assertEquals(1, ev.getIdOrg(), "El idOrg debe inicializarse correctamente");
        assertEquals(2, Evento.getPointer(), "El puntero debe incrementarse tras crear un evento");

        Evento ev2 = new Evento("OtroEvento", "2025-07-01", "Barcelona", "3h", 2, 2, 2);
        assertEquals(2, ev2.getId(), "El ID debe inicializarse a 2 para la segunda instancia");
        assertEquals(3, Evento.getPointer(), "El puntero debe incrementarse nuevamente tras crear un segundo evento");
    }

    @Test
    public void testAddNewEventWithAllData() {
        Evento ev = new Evento("ValidEvent", "2025-06-05", "Valencia", "1h", 1, 1, 1);
        ev.addNewEvent();
        String output = outContent.toString().trim();
        assertEquals("Datos introducidos correctamente.", output,
                "addNewEvent debe imprimir éxito cuando todos los datos requeridos están presentes");
    }

    @Test
    public void testAddNewEventWithMissingName() {
        Evento ev = new Evento(null, "2025-06-05", "Valencia", "1h", 1, 1, 1);
        ev.addNewEvent();
        String output = outContent.toString().trim();
        assertEquals("Error: faltan datos obligatorios.", output,
                "addNewEvent debe imprimir error cuando el nombre es nulo");
    }

    @Test
    public void testAddNewEventWithMissingDate() {
        Evento ev = new Evento("EventName", null, "Valencia", "1h", 1, 1, 1);
        ev.addNewEvent();
        String output = outContent.toString().trim();
        assertEquals("Error: faltan datos obligatorios.", output,
                "addNewEvent debe imprimir error cuando la fecha es nula");
    }

    @Test
    public void testAddNewEventWithMissingDuration() {
        Evento ev = new Evento("EventName", "2025-06-06", "Valencia", null, 1, 1, 1);
        ev.addNewEvent();
        String output = outContent.toString().trim();
        assertEquals("Error: faltan datos obligatorios.", output,
                "addNewEvent debe imprimir error cuando la duración es nula");
    }

    @Test
    public void testAddNewEventWithZeroIds() {
        // Test con idCat = 0
        Evento evCatZero = new Evento("EventName", "2025-06-07", "Valencia", "2h", 0, 1, 1);
        evCatZero.addNewEvent();
        String outputCatZero = outContent.toString().trim();
        assertEquals("Error: faltan datos obligatorios.", outputCatZero,
                "addNewEvent debe imprimir error cuando idCat es cero");
        outContent.reset();

        // Test con idLoc = 0
        Evento evLocZero = new Evento("EventName", "2025-06-07", "Valencia", "2h", 1, 0, 1);
        evLocZero.addNewEvent();
        String outputLocZero = outContent.toString().trim();
        assertEquals("Error: faltan datos obligatorios.", outputLocZero,
                "addNewEvent debe imprimir error cuando idLoc es cero");
        outContent.reset();

        // Test con idOrg = 0
        Evento evOrgZero = new Evento("EventName", "2025-06-07", "Valencia", "2h", 1, 1, 0);
        evOrgZero.addNewEvent();
        String outputOrgZero = outContent.toString().trim();
        assertEquals("Error: faltan datos obligatorios.", outputOrgZero,
                "addNewEvent debe imprimir error cuando idOrg es cero");
    }

    @Test
    public void testToString() {
        Evento ev = new Evento("TestString", "2025-06-08", "Sevilla", "4h", 3, 3, 3);
        String expected = "Evento [id=1, name=TestString, date=2025-06-08, place=Sevilla, duration=4h, idCat=3, idLoc=3, idOrg=3]";
        assertEquals(expected, ev.toString(), "toString debe devolver la representación de cadena correcta");
    }
}
