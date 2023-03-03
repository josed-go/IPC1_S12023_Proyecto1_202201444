package proyecto1.modelo;

/**
 *
 * @author JD
 */
public class Region {
    private String codigo;
    private String nombre;
    private double estandar;
    private double especial;
    
    public Region(String codigo, String nombre, double estandar, double especial) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estandar = estandar;
        this.especial = especial;
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

    public double getEstandar() {
        return estandar;
    }

    public void setEstandar(double estandar) {
        this.estandar = estandar;
    }

    public double getEspecial() {
        return especial;
    }

    public void setEspecial(double especial) {
        this.especial = especial;
    }
    
}
