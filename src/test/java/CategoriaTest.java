import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Categoria;

class CategoriaTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;


    @Test
    void testConstructorAutoIncrementaIdYAsignaNombre() {
        // Asumo que pointer vuelve a 1 antes de cada prueba
        Categoria primera = new Categoria("Conferencia");
        Categoria segunda = new Categoria("Concierto");

        assertEquals(1, primera.getId(), "El primer ID debe ser 1");
        assertEquals("Conferencia", primera.getName(), "El nombre debe conservarse");

        assertEquals(2, segunda.getId(), "El segundo ID debe ser 2");
        assertEquals("Concierto", segunda.getName(), "El nombre debe conservarse");
    }

    @Test
    void testGettersYSetters() {
        Categoria cat = new Categoria("Taller");
        assertEquals("Taller", cat.getName());

        cat.setName("Seminario");
        assertEquals("Seminario", cat.getName(), "El setter debe actualizar el nombre");

        cat.setId(42);
        assertEquals(42, cat.getId(), "El setter debe actualizar el ID");
    }

    @Test
    void testCreateCatConNombreValidoImprimeMensajeCorrecto() {
        Categoria cat = new Categoria("Exposición");
        cat.createCat();
        assertTrue(outContent.toString().contains("Categoria creada correctamente"));
    }

    @Test
    void testCreateCatConNombreNullImprimeError() {
        Categoria cat = new Categoria("Temporal");
        cat.setName(null);
        outContent.reset();
        cat.createCat();
        assertTrue(outContent.toString().contains("Error, debe de agregar un nombre"));
    }
}
