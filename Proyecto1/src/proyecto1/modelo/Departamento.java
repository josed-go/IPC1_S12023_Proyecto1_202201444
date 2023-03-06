package proyecto1.modelo;

/**
 *
 * @author JD
 */
public class Departamento {
    private String codigoRegion;
    private String region;
    private String nombre;
    private String codigoDepartamento;

    public Departamento(String codigoRegion, String region, String nombre, String codigoDepartamento) {
        this.codigoRegion = codigoRegion;
        this.region = region;
        this.nombre = nombre;
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        this.codigoRegion = codigoRegion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }
    
}
