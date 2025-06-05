package Controlador;

import java.util.Scanner;

import modelo.MoCategorias;
import modelo.MoEvento;
import modelo.MoInscripcion;
import modelo.MoOrganizador;
import modelo.MoUbicacion;
import modelo.MoUsuario;
import modelo.Modelo;
import vista.VMenu;

public class Controlador {

	Modelo datos;
	VMenu vista;
	static Scanner sc = new Scanner(System.in);
	boolean sigue = false;

	public Controlador() {
		datos = new Modelo();
		vista = new VMenu();

		do {

			vista.generarMenu();

			int key = escribirNumero();

			switch (key) {
			case 0:
				sigue = true;
				break;
			case 1:
				registrarUsuario();
				break;
			case 2:
				registrarOrganizador();
				break;
			case 3:
				registrarEvento();
				break;

			case 4:
				registrarUbicacion();
				break;

			case 5:
				registrarCategoria();
				break;
			case 6:
				registrarInscripccion();
				break;
			case 7:
				mostrarOrganizadores();
				break;
			case 8:
				mostrarUsuarios();
				break;
			case 9:
				mostrarEventos();
				break;
			case 10:
				mostrarUbicaciones();
				break;
			case 11:
				mostrarIscripciones();
				break;
			case 12:
				mostrarCategorias();
				break;

			default:
				escribir("Error");
				break;
			}

		} while (!sigue);

	}

//	creamos los metodos correspondientes para registrar

	public void registrarUsuario() {
		escribir("Introduzca el nombre del Usuario:");
		String nombre = escribirLine();
		escribirLine();// depuramos

		String correo;
		boolean sigue;

		do {
			escribir("Introduzca el correo:");
			correo = escribirLine();
			// asumimos que es válido hasta comprobar
			sigue = true;

			for (MoUsuario usuario : datos.getDatosUsuario()) {
				if (usuario.getEmailUsuario().equalsIgnoreCase(correo)) {
					escribir("Correo ya existe, escriba otro.");
					sigue = false;

				}
			}
		} while (!sigue);

		escribir("Introduce contraseña:");
		String contra = escribirLine();

		// Suponiendo que tienes método para guardar
		datos.crearUsuario(nombre, correo, contra);
		escribir("Usuario registrado correctamente.");
	}

	public void registrarOrganizador() {

		escribir("Introduzca el nombre del organizador");
		String nombre = escribirLine();
		escribirLine();// depuramos

		escribir("Introduzca tlf");
		String tlf = escribirLine();

		String correo;
		boolean sigue;

		do {
			escribir("Introduzca el correo:");
			correo = escribirLine();
			// asumimos que es válido hasta comprobar
			sigue = true;

			for (MoUsuario usuario : datos.getDatosUsuario()) {
				if (usuario.getEmailUsuario().equalsIgnoreCase(correo)) {
					escribir("Correo ya existe, escriba otro.");
					sigue = false;

				}
			}
		} while (!sigue);

//		añadimos los datos
		datos.crearOrganizador(nombre, tlf, correo);
	}

	public void registrarEvento() {

		if (datos.getDatosCategoria().isEmpty() || datos.getDatosUbicacion().isEmpty()
				|| datos.getDatosOrganizador().isEmpty()) {
			escribir("Lo siento, debe de haber al menos un evento y un usuario registrado");
		} else {

			escribir("Introduzca el nombre del evento:");
			String nombre = escribirLine();
			escribirLine();// depuramos

			escribir("Introduzca el nombre del fecha:");
			String fecha = escribirLine();
			escribirLine();// depuramos

			escribir("Introduzca el nombre del lugar:");
			String lugar = escribirLine();
			escribirLine();// depuramos

			escribir("Introduzca la duracion (horas):");
			int duracion = escribirNumero();

			int idCategoria, idUbicacion, idOrganizador;

			boolean sigue = true;
			do {
				mostrarCategorias();

				escribir("Introduzca el ID del usuario:");
				idCategoria = escribirNumero();

				for (MoCategorias cat : datos.getDatosCategoria()) {
					if (cat.getId() == idCategoria) {
						sigue = !sigue;
					} else {
						escribir("Error, no existe el numero");
					}
				}

			} while (sigue);

			do {
				mostrarUbicaciones();

				escribir("Introduzca el ID de la ubicacion:");
				idUbicacion = escribirNumero();

				for (MoUbicacion ubi : datos.getDatosUbicacion()) {
					if (ubi.getId() == idUbicacion) {
						sigue = !sigue;
					} else {
						escribir("Error, no existe el numero introducido");
					}
				}

			} while (sigue);

			do {
				mostrarOrganizadores();

				escribir("Introduzca el ID del organizador:");
				idOrganizador = escribirNumero();

				for (MoOrganizador org : datos.getDatosOrganizador()) {
					if (org.getId() == idOrganizador) {
						sigue = !sigue;
					} else {
						escribir("Error, no existe el numero introducido");
					}
				}

			} while (sigue);
		}

	}

	public void registrarUbicacion() {

		escribir("Introduzca la direccion de la ubicacion");
		String direccion = escribirLine();
		escribirLine();// depuramos

		escribir("Introduzca el tipo de via");
		String tipo = escribirLine();

		datos.crearUbicacion(direccion, tipo);

	}

	public void registrarCategoria() {

		escribir("Introduzca nombre de categoria");
		String NombreCat = escribirLine();

		escribirLine();

		datos.crearCategoria(NombreCat);
	}

	public void registrarInscripccion() {

		int idUsuario, idEvento;

		if (datos.getDatosUsuario().isEmpty() || datos.getDatosEvento().isEmpty()) {
			escribir("Lo siento, debe de haber al menos un evento y un usuario registrado");
		} else {
			boolean sigue = true;
			do {
				mostrarUsuarios();

				escribir("Introduzca el ID del usuario:");
				idUsuario = escribirNumero();

				for (MoUsuario usu : datos.getDatosUsuario()) {
					if (usu.getId() == idUsuario) {
						sigue = !sigue;
					} else {
						escribir("Error, no existe el numero");
					}
				}

			} while (sigue);

			do {
				mostrarEventos();

				escribir("Introduzca el ID del evento:");
				idEvento = escribirNumero();

				for (MoEvento eve : datos.getDatosEvento()) {
					if (eve.getId() == idEvento) {
						sigue = !sigue;
					} else {
						escribir("Error, no existe el numero introducido");
					}
				}

			} while (sigue);

			datos.crearInscripcion(idUsuario, idEvento);

		}

	}

//	creamos los metodos para mostrar los datos

	public void mostrarUsuarios() {

		escribir("Estos son los usuarios registrados: :");

		for (MoUsuario usu : datos.getDatosUsuario()) {
			escribir("Id: " + usu.getId() + " - Nombre: " + usu.getNombreUsuario() + " - Email: "
					+ usu.getEmailUsuario());
		}

	}

	public void mostrarOrganizadores() {
		escribir("Estos son los organizadores registrados:");
		for (MoOrganizador org : datos.getDatosOrganizador()) {
			escribir("ID: " + org.getId() + " | Nombre: " + org.getNombreOrganizador());
		}
	}

	public void mostrarEventos() {
		escribir("Estos son los eventos registrados: ");

		for (MoEvento eve : datos.getDatosEvento()) {
			escribir("Id: " + eve.getId() + " - Nombre: " + eve.getNombreEvento() + " - Fecha: " + eve.getFechaEvento()
					+ " - Lugar: " + eve.getLugarEvento() + " - Duración: " + eve.getDuracionEvento() + "h");
		}

	}

	public void mostrarUbicaciones() {

		escribir("Ubicaciones disponibles:");
		for (MoUbicacion ubi : datos.getDatosUbicacion()) {
			escribir("ID: " + ubi.getId() + " | Nombre: " + ubi.getDireccion());
		}
	}

	public void mostrarIscripciones() {

		escribir("Inscripciones registradas: ");
		for (MoInscripcion ins : datos.getDatosInscripcion()) {
			escribir("Id: " + ins.getId() + " - Usuario: " + ins.getIdUsuario() + " - Evento: " + ins.getIdEvento());
		}
	}

	public void mostrarCategorias() {
		escribir("categorias disponibles:");
		for (MoCategorias cat : datos.getDatosCategoria()) {
			escribir("ID: " + cat.getId() + " | Nombre: " + cat.getNombreCat());
		}

	}

//	metodos simples para dejarlo mas estructurado y estetito
	public void escribir(String texto) {
		System.out.println(texto);
	}

	public int escribirNumero() {
		return sc.nextInt();
	}

	public String escribirLine() {
//		sc.nextLine();
		return sc.nextLine();
	}
}
