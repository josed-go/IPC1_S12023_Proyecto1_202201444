package proyecto1.modelo;

/**
 *
 * @author JD
 */
public class Municipio {
    private String codigoDepartamento;
    private String nombre;

    public Municipio(String codigoDepartamento, String nombre) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombre = nombre;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
