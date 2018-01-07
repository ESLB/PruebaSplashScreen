package wlind.levano.eduardo.pruebas.APIGOL.models;

//equipoRetador, equipoRetado, locacion

public class Reto {

    private String _id;
    private String equipoRetador;
    private String equipoRetado;
    private String locacion;
    private Integer estadoReto;
    private boolean isVisto;

    public Reto(String equipoRetador, String equipoRetado, String locacion) {
        this.equipoRetador = equipoRetador;
        this.equipoRetado = equipoRetado;
        this.locacion = locacion;
    }

    public Reto(String _id, String equipoRetador, String equipoRetado, String locacion, Integer estadoReto) {
        this._id = _id;
        this.equipoRetador = equipoRetador;
        this.equipoRetado = equipoRetado;
        this.locacion = locacion;
        this.estadoReto = estadoReto;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEquipoRetador() {
        return equipoRetador;
    }

    public void setEquipoRetador(String equipoRetador) {
        this.equipoRetador = equipoRetador;
    }

    public String getEquipoRetado() {
        return equipoRetado;
    }

    public void setEquipoRetado(String equipoRetado) {
        this.equipoRetado = equipoRetado;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public Integer getEstadoReto() {
        return estadoReto;
    }

    public void setEstadoReto(Integer estadoReto) {
        this.estadoReto = estadoReto;
    }

    public boolean isVisto() {
        return isVisto;
    }

    public void setVisto(boolean visto) {
        isVisto = visto;
    }
}
