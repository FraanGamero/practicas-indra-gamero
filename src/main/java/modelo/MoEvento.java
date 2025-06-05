package modelo;

public class MoEvento {

	private static int pointer = 1;
	private int id;
	private String nombreEvento;
	private String fechaEvento;
	private String lugarEvento;
	private int duracionEvento;
	private int idCategoria;
	private int idUbicacion;
	private int idOrganizador;


//	constructores
	public MoEvento() {

		// TODO Auto-generated constructor stub
	}


	public MoEvento(String nombreEvento, String fechaEvento, String lugarEvento, int duracionEvento,
			int idCategoria, int idUbicacion, int idOrganizador) {
		this.id = pointer++;
		this.nombreEvento = nombreEvento;
		this.fechaEvento = fechaEvento;
		this.lugarEvento = lugarEvento;
		this.duracionEvento = duracionEvento;
		this.idCategoria = idCategoria;
		this.idUbicacion = idUbicacion;
		this.idOrganizador = idOrganizador;
	}
	
//	getters y setters

	public static int getPointer() {
		return pointer;
	}

	public static void setPointer(int pointer) {
		MoEvento.pointer = pointer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getLugarEvento() {
		return lugarEvento;
	}

	public void setLugarEvento(String lugarEvento) {
		this.lugarEvento = lugarEvento;
	}

	public int getDuracionEvento() {
		return duracionEvento;
	}

	public void setDuracionEvento(int duracionEvento) {
		this.duracionEvento = duracionEvento;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public int getIdOrganizador() {
		return idOrganizador;
	}

	public void setIdOrganizador(int idOrganizador) {
		this.idOrganizador = idOrganizador;
	}

}
