package proyecto1.modelo;

/**
 *
 * @author JD
 */
public class Tarjetas {
    private String nombre;
    private String tipo;
    private String numero;
    private String fecha;
    private String usuario;

    public Tarjetas(String nombre, String tipo, String numero, String fecha, String usuario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.numero = numero;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
