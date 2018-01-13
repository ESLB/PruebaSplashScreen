package wlind.levano.eduardo.pruebas.API.models;

//jugador , equipoSolicitado

public class Solicitud {

    private String _id;
    private String jugador;
    private String equipoSolicitado;
    private Integer estadoSolicitud;
    private boolean isVisto;


    public Solicitud(String jugador, String equipoSolicitado) {
        this.jugador = jugador;
        this.equipoSolicitado = equipoSolicitado;
    }

    public Solicitud(String _id, String jugador, String equipoSolicitado, Integer estadoSolicitud) {
        this._id = _id;
        this.jugador = jugador;
        this.equipoSolicitado = equipoSolicitado;
        this.estadoSolicitud = estadoSolicitud;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getEquipoSolicitado() {
        return equipoSolicitado;
    }

    public void setEquipoSolicitado(String equipoSolicitado) {
        this.equipoSolicitado = equipoSolicitado;
    }

    public Integer getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(Integer estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public boolean isVisto() {
        return isVisto;
    }

    public void setVisto(boolean visto) {
        isVisto = visto;
    }
}
