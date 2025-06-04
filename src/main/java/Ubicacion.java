package main.java;

public class Ubicacion {

    private static int pointer = 1;
    private int id;
    private String direction;
    private String type;

    // Constructor
    public Ubicacion(String direction, String type) {
        this.id = pointer++;
        this.direction = direction;
        this.type = type;
    }

    // Metodos
    public void createUbicacion() {
        if (direction != null && type != null) {
            System.out.println("Ubicación creada correctamente");
        } else {
            System.out.println("Error, debe agregar dirección y type");
        }
    }

    // Getters y Setters
    public static int getPointer() {
        return pointer;
    }

    public static void setPointer(int pointer) {
        Ubicacion.pointer = pointer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ubicacion [id=" + id + ", direction=" + direction + ", type=" + type + "]";
    }
}
