package modelo;

public class MoUsuario {

	private static int pointer = 1;
	private int id;
	private String nombreUsuario;
	private String emailUsuario;
	private String contrasenaUsuario;

//	Constructores
	public MoUsuario() {

		// TODO Auto-generated constructor stub
	}

	public MoUsuario(String nombreUsuario, String emailUsuario, String contrasenaUsuario) {
		
		this.id = pointer++;
		this.nombreUsuario = nombreUsuario;
		this.emailUsuario = emailUsuario;
		this.contrasenaUsuario = contrasenaUsuario;
	}
	
//	Getteres y setters

	public static int getPointer() {
		return pointer;
	}

	public static void setPointer(int pointer) {
		MoUsuario.pointer = pointer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getContrasenaUsuario() {
		return contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}

}
