package main.java;

public class Organizadores {

    private static int pointer = 1;
    private int id;
    private String name;
    private String tlf;
    private String email;

    // constructores

    // metodos

    public void signInOrganizador() {
        if (name == null || tlf == null || email == null) {

            System.out.println("Error, todos los campos tienen que estar completos");
        } else {

            System.out.println("datos agregados correctamente");
        }
    }

    public Organizadores(String name, String tlf, String email) {
        this.id = pointer++;
        this.name = name;
        this.tlf = tlf;
        this.email = email;
    }

    // getters y setters

    public Organizadores() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Organizadores [id=" + id + ", name=" + name + ", tlf=" + tlf + ", email=" + email + "]";
    }

}
