package wlind.levano.eduardo.pruebas.API.models;

public class E2Equipo {

    private String _id;
    private String nombre;
    private Integer numero;
    private String jugadores;
    private String administradores;
    private String locacion;
    private boolean completo;
    private String equipoImagen;

    public E2Equipo() {

    }

    public E2Equipo(String _id, String nombre, Integer numero, String jugadores, String administradores, String locacion, boolean completo, String equipoImagen) {
        this._id = _id;
        this.nombre = nombre;
        this.numero = numero;
        this.jugadores = jugadores;
        this.administradores = administradores;
        this.locacion = locacion;
        this.completo = completo;
        this.equipoImagen = equipoImagen;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getJugadores() {
        return jugadores;
    }

    public void setJugadores(String jugadores) {
        this.jugadores = jugadores;
    }

    public String getAdministradores() {
        return administradores;
    }

    public void setAdministradores(String administradores) {
        this.administradores = administradores;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public String getEquipoImagen() {
        return equipoImagen;
    }

    public void setEquipoImagen(String equipoImagen) {
        this.equipoImagen = equipoImagen;
    }
}
