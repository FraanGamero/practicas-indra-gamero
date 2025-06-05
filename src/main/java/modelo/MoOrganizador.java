package modelo;

public class MoOrganizador {

	private static int pointer = 1;
	private int id;
	private String nombreOrganizador;
	private String tlfOrganizador;
	private String emailOrganizador;

//    Constructores
	public MoOrganizador() {

		// TODO Auto-generated constructor stub
	}



public MoOrganizador(String nombreOrganizador, String tlfOrganizador, String emailOrganizador) {

	this.id = pointer++;
	this.nombreOrganizador = nombreOrganizador;
	this.tlfOrganizador = tlfOrganizador;
	this.emailOrganizador = emailOrganizador;
}



//	getters y setters
	public static int getPointer() {
		return pointer;
	}

	public static void setPointer(int pointer) {
		MoOrganizador.pointer = pointer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreOrganizador() {
		return nombreOrganizador;
	}

	public void setNombreOrganizador(String nombreOrganizador) {
		this.nombreOrganizador = nombreOrganizador;
	}

	public String getTlfOrganizador() {
		return tlfOrganizador;
	}

	public void setTlfOrganizador(String tlfOrganizador) {
		this.tlfOrganizador = tlfOrganizador;
	}

	public String getEmailOrganizador() {
		return emailOrganizador;
	}

	public void setEmailOrganizador(String emailOrganizador) {
		this.emailOrganizador = emailOrganizador;
	}

}
