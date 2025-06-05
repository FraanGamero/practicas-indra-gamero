package modelo;

import java.util.ArrayList;

public class Modelo {

	private ArrayList<MoCategorias> datosCategoria;
	private ArrayList<MoEvento> datosEvento;
	private ArrayList<MoInscripcion> datosInscripcion;
	private ArrayList<MoOrganizador> datosOrganizador;
	private ArrayList<MoUbicacion> datosUbicacion;
	private ArrayList<MoUsuario> datosUsuario;

//	constructores
	public Modelo() {

		datosCategoria = new ArrayList<MoCategorias>();
		datosEvento = new ArrayList<MoEvento>();
		datosInscripcion = new ArrayList<MoInscripcion>();
		datosOrganizador = new ArrayList<MoOrganizador>();
		datosUbicacion = new ArrayList<MoUbicacion>();
		datosUsuario = new ArrayList<MoUsuario>();

		// TODO Auto-generated constructor stub
	}

	public Modelo(ArrayList<MoCategorias> datosCategoria, ArrayList<MoEvento> datosEvento,
			ArrayList<MoInscripcion> datosInscripcion, ArrayList<MoOrganizador> datosOrganizador,
			ArrayList<MoUbicacion> datosUbicacion, ArrayList<MoUsuario> datosUsuario) {

		this.datosCategoria = datosCategoria;
		this.datosEvento = datosEvento;
		this.datosInscripcion = datosInscripcion;
		this.datosOrganizador = datosOrganizador;
		this.datosUbicacion = datosUbicacion;
		this.datosUsuario = datosUsuario;
	}

//	creamos los metodos para crear Categorias,Usuario etc

	public void crearCategoria(String nombre) {
		this.datosCategoria.add(new MoCategorias(nombre));
	}

	public void crearEvento(String nombre, String fecha, String lugar, int duracion, int idCategoria, int idUbicacion,
			int idOrganizador) {
		this.datosEvento.add(new MoEvento(nombre, fecha, lugar, duracion, idCategoria, idUbicacion, idOrganizador));
	}

	public void crearInscripcion(int idUsuario, int idEvento) {
		this.datosInscripcion.add(new MoInscripcion(idUsuario, idEvento));
	}

	public void crearOrganizador(String nombre, String tlf, String email) {
		this.datosOrganizador.add(new MoOrganizador(nombre, tlf, email));
	}

	public void crearUbicacion(String direccion, String tipo) {
		this.datosUbicacion.add(new MoUbicacion(direccion, tipo));

	}

	public void crearUsuario(String nombre, String email, String contrasena) {
		this.datosUsuario.add(new MoUsuario(nombre, email, contrasena));
	}

//	getteres y Setters

	public ArrayList<MoCategorias> getDatosCategoria() {
		return datosCategoria;
	}

	public void setDatosCategoria(ArrayList<MoCategorias> datosCategoria) {
		this.datosCategoria = datosCategoria;
	}

	public ArrayList<MoEvento> getDatosEvento() {
		return datosEvento;
	}

	public void setDatosEvento(ArrayList<MoEvento> datosEvento) {
		this.datosEvento = datosEvento;
	}

	public ArrayList<MoInscripcion> getDatosInscripcion() {
		return datosInscripcion;
	}

	public void setDatosInscripcion(ArrayList<MoInscripcion> datosInscripcion) {
		this.datosInscripcion = datosInscripcion;
	}

	public ArrayList<MoOrganizador> getDatosOrganizador() {
		return datosOrganizador;
	}

	public void setDatosOrganizador(ArrayList<MoOrganizador> datosOrganizador) {
		this.datosOrganizador = datosOrganizador;
	}

	public ArrayList<MoUbicacion> getDatosUbicacion() {
		return datosUbicacion;
	}

	public void setDatosUbicacion(ArrayList<MoUbicacion> datosUbicacion) {
		this.datosUbicacion = datosUbicacion;
	}

	public ArrayList<MoUsuario> getDatosUsuario() {
		return datosUsuario;
	}

	public void setDatosUsuario(ArrayList<MoUsuario> datosUsuario) {
		this.datosUsuario = datosUsuario;
	}

}
