package modelo;

public class MoUbicacion {

	private static int pointer = 1;
	private int id;
	private String direccion;
	private String tipo;

	// constructor
	public MoUbicacion() {

		// TODO Auto-generated constructor stub
	}

	public MoUbicacion(String direccion, String tipo) {
	
		this.id = pointer++;
		this.direccion = direccion;
		this.tipo = tipo;
	}

//	getteres y setters
	public static int getPointer() {
		return pointer;
	}

	public static void setPointer(int pointer) {
		MoUbicacion.pointer = pointer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
