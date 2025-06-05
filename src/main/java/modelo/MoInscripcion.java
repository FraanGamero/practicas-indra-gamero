package modelo;

public class MoInscripcion {

	
    private static int pointer = 1;
    private int id;
    private int idUsuario;
    private int idEvento;
    
    
//    Constructores
	public MoInscripcion() {
		
		// TODO Auto-generated constructor stub
	}


	public MoInscripcion(int idUsuario, int idEvento) {
		
		this.id = pointer++;
		this.idUsuario = idUsuario;
		this.idEvento = idEvento;
	}

// getters y setters

	public static int getPointer() {
		return pointer;
	}


	public static void setPointer(int pointer) {
		MoInscripcion.pointer = pointer;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
    
	
	
    
    
	
}
