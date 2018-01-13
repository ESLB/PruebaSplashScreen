package wlind.levano.eduardo.pruebas.API.models;

public class J2Jugador {

    private String nombre;
    private Integer edad;
    private String email;

    public J2Jugador() {
    }

    public J2Jugador(String nombre, Integer edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



