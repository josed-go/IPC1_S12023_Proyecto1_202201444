package proyecto1.modelo;

/**
 *
 * @author JD
 */
public class DatosFacturacion {
    private String nombre;
    private String apellido;
    private String direccion;
    private String nit;
    private String usuario;

    public DatosFacturacion(String nombre, String apellido, String direccion, String nit, String usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.nit = nit;
        this.usuario = usuario;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
      
}
