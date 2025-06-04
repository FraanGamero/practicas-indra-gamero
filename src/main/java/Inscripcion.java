package main.java;

public class Inscripcion {

    private static int pointer = 1;
    private int id;
    private int idUser;
    private int idEvent;

    // Constructor
    public Inscripcion(int idUser, int idEvent) {
        this.id = pointer++;
        this.idUser = idUser;
        this.idEvent = idEvent;
    }

    // metodo
    public void addInscripction() {
        if (idUser == 0) {
            System.out.println("error");
        } else {
            System.out.println("Datos introducidos");
        }
    }

    // Getters y Setters
    public static int getPointer() {
        return pointer;
    }

    public static void setPointer(int pointer) {
        Inscripcion.pointer = pointer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    @Override
    public String toString() {
        return "Inscripcion [id=" + id + ", idUser=" + idUser + ", idEvent=" + idEvent + "]";
    }
}
