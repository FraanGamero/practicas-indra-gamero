package modelo;

public class MoCategorias {

	private static int pointer = 1;
	private int id;
	private String NombreCat;

	// constructores

	public MoCategorias() {
		// TODO Auto-generated constructor stub
	}

	public MoCategorias(String nombreCat) {
		this.id = pointer++;
		NombreCat = nombreCat;
	}

	// asignamos responsabilidades especificas
	public boolean esNombreValido() {
		return NombreCat != null && NombreCat.length() >= 3;
	}

	// getters y setters
	public static int getPointer() {
		return pointer;
	}

	public static void setPointer(int pointer) {
		MoCategorias.pointer = pointer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCat() {
		return NombreCat;
	}

	public void setNombreCat(String nombreCat) {
		NombreCat = nombreCat;
	}

}
