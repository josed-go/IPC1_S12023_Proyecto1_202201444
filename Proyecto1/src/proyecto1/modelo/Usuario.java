package proyecto1.modelo;

/**
 *
 * @author JD
 */
public class Usuario {
    private String correo;
    private String nombre;
    private String apellido;
    private String password;
    private String dpi;
    private String fechaC;
    private String genero;
    private String nacionalidad;
    private String usuario;
    private String telefono;
    private String rol;
    private String foto;
    private String codigoKiosco;
    private int paquetesEnviados;

    public Usuario(String correo, String nombre, String apellido, String password, String dpi, String fechaC, String genero, String nacionalidad, String usuario, String telefono, String rol, String foto, int paquetesEnviados) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.dpi = dpi;
        this.fechaC = fechaC;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.usuario = usuario;
        this.telefono = telefono;
        this.rol = rol;
        this.foto = foto;
        this.paquetesEnviados = paquetesEnviados;
    }
    
    public Usuario(String correo, String nombre, String apellido, String password, String dpi, String fechaC, String genero, String nacionalidad, String usuario, String telefono, String rol, String foto, String codigoKiosco, int paquetesEnviados) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.dpi = dpi;
        this.fechaC = fechaC;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.usuario = usuario;
        this.telefono = telefono;
        this.rol = rol;
        this.foto = foto;
        this.codigoKiosco = codigoKiosco;
        this.paquetesEnviados = paquetesEnviados;
    }
    
    public Usuario() {
        correo = "ipc1_202201444@ipc1delivery.com";
        password = "202201444";
        rol = "ADMIN";
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCodigoKiosco() {
        return codigoKiosco;
    }

    public void setCodigoKiosco(String codigoKiosco) {
        this.codigoKiosco = codigoKiosco;
    }

    public int getPaquetesEnviados() {
        return paquetesEnviados;
    }

    public void setPaquetesEnviados(int paquetesEnviados) {
        this.paquetesEnviados = paquetesEnviados;
    }
    
}
