package proyecto1.modelo;

/**
 *
 * @author JD
 */
public class Kiosco {
    private String codigo;
    private String nombre;
    private String codigoRegion;

    public Kiosco(String codigo, String nombre, String codigoRegion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoRegion = codigoRegion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        this.codigoRegion = codigoRegion;
    }
    
}
