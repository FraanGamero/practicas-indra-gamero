
import modelo.Modelo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModeloTest {

    private Modelo modelo;

    @BeforeEach
    public void setUp() {
        modelo = new Modelo();
    }

    @Test
    public void testCrearCategoria() {
        modelo.crearCategoria("Deportes");
        assertEquals(1, modelo.getDatosCategoria().size());
        assertEquals("Deportes", modelo.getDatosCategoria().get(0).getNombreCat());
    }

    @Test
    public void testCrearEvento() {
        modelo.crearEvento("Concierto", "2025-06-10", "Auditorio", 90, 1, 1, 1);
        assertEquals(1, modelo.getDatosEvento().size());
        assertEquals("Concierto", modelo.getDatosEvento().get(0).getNombreEvento());
    }

    @Test
    public void testCrearInscripcion() {
        modelo.crearInscripcion(0, 0);
        assertEquals(1, modelo.getDatosInscripcion().size());
        assertEquals(0, modelo.getDatosInscripcion().get(0).getIdUsuario());
    }

    @Test
    public void testCrearOrganizador() {
        modelo.crearOrganizador("Organizador 1", "123456789", "org1@email.com");
        assertEquals(1, modelo.getDatosOrganizador().size());
        assertEquals("Organizador 1", modelo.getDatosOrganizador().get(0).getNombreOrganizador());
    }

    @Test
    public void testCrearUbicacion() {
        modelo.crearUbicacion("Calle Falsa 123", "Interior");
        assertEquals(1, modelo.getDatosUbicacion().size());
        assertEquals("Calle Falsa 123", modelo.getDatosUbicacion().get(0).getDireccion());
    }

    @Test
    public void testCrearUsuario() {
        modelo.crearUsuario("Ana", "ana@email.com", "1234");
        assertEquals(1, modelo.getDatosUsuario().size());
        assertEquals("Ana", modelo.getDatosUsuario().get(0).getNombreUsuario());
    }
}
