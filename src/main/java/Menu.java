package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import javax.xml.stream.events.StartDocument;

// clase principal con la cual controlaremos eventos, usuarios y organizadores
public class Menu {
    private static ArrayList<Organizadores> organizadores;
    private static ArrayList<Usuarios> usuarios;
    private static ArrayList<Evento> events;
    private static ArrayList<Categoria> categorias;
    private static ArrayList<Ubicacion> ubicaciones;
    private static ArrayList<Inscripcion> inscripciones;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        organizadores = new ArrayList<>();
        usuarios = new ArrayList<>();
        events = new ArrayList<>();
        categorias = new ArrayList<>();
        ubicaciones = new ArrayList<>();
        inscripciones = new ArrayList<>();

        boolean again = true;

        System.out.println("Bienvenido a nuestros Eventos!\n");

        do {
            System.out.println("\nQue desea hacer: ");

            System.out.println("1 - Registrar un Usuario");
            System.out.println("2 - Registrar un Organizador");
            System.out.println("3 - Registrar un Evento");
            System.out.println("4 - Registrar Ubicacion");
            System.out.println("5 - Registrar Categoria");
            System.out.println("6 - Registrar Inscripcion");
            System.out.println("7 - Mostrar todos los organizadores");
            System.out.println("8 - Mostrar todos los usuarios");
            System.out.println("9 - Mostrar todos los eventos");
            System.out.println("10 - Mostrar todos los ubicaciones");
            System.out.println("11 - Mostrar todos las inscripciones");
            System.out.println("0 - salir\n");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 0:
                    again = false;
                    break;

                case 1:

                    System.out.print("Nombre del usuario: ");
                    String userName = sc.next();

                    System.out.print("email: ");
                    String userEmail = sc.next();

                    System.out.print("contraseña: ");
                    String userPass = sc.next();

                    Usuarios user = new Usuarios(userName, userEmail, userPass);

                    // organizador = new Organizadores(name, tlf, email);

                    usuarios.add(user);
                    user.signInUser();

                    System.out.println("Usuario registrado correctamente.");
                    break;
                case 2:

                    System.out.print("Nombre del organizador: ");
                    String orgName = sc.next();

                    System.out.print("Teléfono: ");
                    String orgTlf = sc.next();

                    System.out.print("Email: ");
                    String orgEmail = sc.next();

                    Organizadores organizador = new Organizadores(orgName, orgTlf, orgEmail);

                    organizadores.add(organizador);
                    organizador.signInOrganizador();

                    System.out.println("Organizador registrado correctamente.");
                    break;

                case 3:

                    if (organizadores.isEmpty() || categorias.isEmpty() || ubicaciones.isEmpty()) {
                        // comprobamos que haya datos
                        System.out.println("Error, primero debe haber al menos 1 categoria, ubicacion y organizador");

                    } else {

                        System.out.print("Introduzca nombre del evento: ");
                        String eventName = sc.nextLine();

                        System.out.print("Introduzca fecha del evento (dd/MM/yyyy): ");
                        String eventDate = sc.nextLine();

                        System.out.print("Introduzca lugar del evento: ");
                        String place = sc.nextLine();

                        System.out.print("Introduzca duración del evento (en horas): ");
                        String duration = sc.nextLine();

                        System.out.print("Introduzca ID de la categoría: ");
                        int idCat = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Introduzca ID de la ubicación: ");
                        int idLoc = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Introduzca ID del organizador: ");
                        int idOrg = sc.nextInt();
                        sc.nextLine();

                        Evento addEvent = new Evento(eventName, eventDate, place, duration, idCat, idLoc, idOrg);

                        addEvent.addNewEvent();
                        events.add(addEvent);
                    }

                    break;

                case 4:

                    System.out.print("Introduzca dirección de la ubicación: ");
                    String direction = sc.nextLine();

                    System.out.print("Introduzca tipo de ubicación (Presencial/Virtual): ");
                    String type = sc.nextLine();

                    Ubicacion nuevaUbicacion = new Ubicacion(direction, type);
                    ubicaciones.add(nuevaUbicacion);
                    nuevaUbicacion.createUbicacion();
                    System.out.println("Ubicación registrada correctamente.");
                    break;

                case 5:

                    System.out.print("Introduzca nombre de la categoría: ");
                    String catName = sc.nextLine();

                    Categoria nuevaCategoria = new Categoria(catName);
                    categorias.add(nuevaCategoria);
                    nuevaCategoria.createCat();
                    System.out.println("Categoría registrada correctamente.");
                    break;

                case 6:

                    if (usuarios.isEmpty() || events.isEmpty()) {
                        System.out.println("Error, debe haber al menos un Usuario y un Evento");

                    } else {
                        System.out.println("Usuarios disponibles:");
                        for (Usuarios u : usuarios) {
                            System.out.println("  ID=" + u.getId() + " - " + u.getName());
                        }

                        System.out.print("Introduzca ID del usuario: ");
                        int usuarioInscripcion = sc.nextInt();
                        sc.nextLine();

                        for (Evento e : events) {
                            System.out.println(" ID=" + e.getId() + " - " + e.getName());
                        }

                        System.out.print("Introduzca ID del evento: ");
                        int eventoInscripcion = sc.nextInt();
                        sc.nextLine();

                        Inscripcion usuarioEventoInscripcion = new Inscripcion(usuarioInscripcion,
                                eventoInscripcion);

                        inscripciones.add(usuarioEventoInscripcion);
                        usuarioEventoInscripcion.addInscripction();

                    }

                    break;
                case 7:

                    for (Organizadores org : organizadores) {
                        System.out.println(org);
                    }
                    break;

                case 8:

                    for (Usuarios us : usuarios) {
                        System.out.println(us);
                    }
                    break;
                case 9:

                    for (Evento ev : events) {
                        System.out.println(ev);
                    }
                    break;
                case 10:

                    for (Ubicacion ub : ubicaciones) {
                        System.out.println(ub);
                    }
                    break;
                case 11:

                for (Inscripcion ins : inscripciones) {
                System.out.println(ins);
                }
                break;

                default:
                    System.out.println("Error");
                    break;
            }
        } while (again);
    }
}