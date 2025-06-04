package main.java;

import java.util.*;

public class Evento {

    private static int pointer = 1;
    private int id;
    private String name;
    private String date;
    private String place;
    private String duration;
    private int idCat;
    private int idLoc;
    private int idOrg;

    // Constructor
    public Evento(String name, String date, String place, String duration,
            int idCat, int idLoc, int idOrg) {
        this.id = pointer++;
        this.name = name;
        this.date = date;
        this.place = place;
        this.duration = duration;
        this.idCat = idCat;
        this.idLoc = idLoc;
        this.idOrg = idOrg;

    }

    // Metodos
    public void addNewEvent() {
        if (name == null || date == null || duration == null ||
                idCat == 0 || idLoc == 0 || idOrg == 0) {
            System.out.println("Error: faltan datos obligatorios.");
        } else {
            System.out.println("Datos introducidos correctamente.");
        }
    }

    // Getters y Setters
    public static int getPointer() {
        return pointer;
    }

    public static void setPointer(int pointer) {
        Evento.pointer = pointer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getDuration() {
        return duration;
    }

    public int getIdCat() {
        return idCat;
    }

    public int getIdLoc() {
        return idLoc;
    }

    public int getIdOrg() {
        return idOrg;
    }

    @Override
    public String toString() {
        return "Evento [id=" + id + ", name=" + name + ", date=" + date +
                ", place=" + place + ", duration=" + duration +
                ", idCat=" + idCat + ", idLoc=" + idLoc + ", idOrg=" + idOrg + "]";
    }
}
