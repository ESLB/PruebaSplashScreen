package wlind.levano.eduardo.pruebas.APIS;

//nombre, edad, email, password, ubicacion, telephone
public class Jugador {

    private String _id;
    private String nombre;
    private Integer edad;
    private String email;
    private String password;
    private String ubicacion;
    private String telephone;
    private String solicitudes;
    private String retos;
    private String teams;
    private String perfilImagen;

    public Jugador(String nombre, Integer edad, String email, String password, String ubicacion, String telephone) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.ubicacion = ubicacion;
        this.telephone = telephone;
    }

    public Jugador(String _id, String nombre, Integer edad, String email, String password, String ubicacion, String telephone, String solicitudes, String retos, String teams, String perfilImagen) {
        this._id = _id;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.ubicacion = ubicacion;
        this.telephone = telephone;
        this.solicitudes = solicitudes;
        this.retos = retos;
        this.teams = teams;
        this.perfilImagen = perfilImagen;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(String solicitudes) {
        this.solicitudes = solicitudes;
    }

    public String getRetos() {
        return retos;
    }

    public void setRetos(String retos) {
        this.retos = retos;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getPerfilImagen() {
        return perfilImagen;
    }

    public void setPerfilImagen(String perfilImagen) {
        this.perfilImagen = perfilImagen;
    }
}
