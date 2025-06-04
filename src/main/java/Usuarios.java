package main.java;

public class Usuarios {

    private static int pointer = 1;
    private int id;
    private String name;
    private String email;
    private String pass;

    // constructores
    public Usuarios(String name, String email, String pass) {
        this.id = pointer++;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    // metodos
    public void signInUser() {
        if (name == null || pass == null || email == null) {

            System.out.println("Error, todos los campos tienen que estar completos");
        } else {

            System.out.println("datos agregados correctamente");
        }
    }

    // getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
