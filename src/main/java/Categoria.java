package main.java;

public class Categoria {

    private static int pointer = 1;
    private int id;
    private String name;

    // constructores
    public Categoria(String name) {
        this.id = pointer++;
        this.name = name;
    }

    // metodos
    public void createCat() {
        if (name != null) {
            System.out.println("Categoria creada correctamente");

        } else {
            System.out.println("Error, debe de agregar un nombre");
        }
    }

    // getters y setters
    public static int getPointer() {
        return pointer;
    }

    public static void setPointer(int pointer) {
        Categoria.pointer = pointer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
