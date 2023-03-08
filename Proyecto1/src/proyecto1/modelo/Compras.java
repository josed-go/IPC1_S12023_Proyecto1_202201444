package proyecto1.modelo;

/**
 *
 * @author JD
 */
public class Compras {
    // ORIGEN
    private String departamentoO;
    private String muicipioO;
    private String direccionO;
    // DESTINO
    private String departamentoD;
    private String municipioD;
    private String direccionD;
    
    private String idPaquete;
    private String numeroP;
    private String tamanioP;
    private String pesoP;
    private String tipoPago;
    private String datosFacturacion;
    private String total;
    private String usuario;

    public Compras(String departamentoO, String muicipioO, String direccionO, String departamentoD, String municipioD, String direccionD, String idPaquete, String numeroP, String tamanioP, String pesoP, String tipoPago, String datosFacturacion, String total, String usuario) {
        this.departamentoO = departamentoO;
        this.muicipioO = muicipioO;
        this.direccionO = direccionO;
        this.departamentoD = departamentoD;
        this.municipioD = municipioD;
        this.direccionD = direccionD;
        this.idPaquete = idPaquete;
        this.numeroP = numeroP;
        this.tamanioP = tamanioP;
        this.pesoP = pesoP;
        this.tipoPago = tipoPago;
        this.datosFacturacion = datosFacturacion;
        this.total = total;
        this.usuario = usuario;
    }

    public String getDepartamentoO() {
        return departamentoO;
    }

    public void setDepartamentoO(String departamentoO) {
        this.departamentoO = departamentoO;
    }

    public String getMuicipioO() {
        return muicipioO;
    }

    public void setMuicipioO(String muicipioO) {
        this.muicipioO = muicipioO;
    }

    public String getDireccionO() {
        return direccionO;
    }

    public void setDireccionO(String direccionO) {
        this.direccionO = direccionO;
    }

    public String getDepartamentoD() {
        return departamentoD;
    }

    public void setDepartamentoD(String departamentoD) {
        this.departamentoD = departamentoD;
    }

    public String getMunicipioD() {
        return municipioD;
    }

    public void setMunicipioD(String municipioD) {
        this.municipioD = municipioD;
    }

    public String getDireccionD() {
        return direccionD;
    }

    public void setDireccionD(String direccionD) {
        this.direccionD = direccionD;
    }

    public String getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(String idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNumeroP() {
        return numeroP;
    }

    public void setNumeroP(String numeroP) {
        this.numeroP = numeroP;
    }

    public String getTamanioP() {
        return tamanioP;
    }

    public void setTamanioP(String tamanioP) {
        this.tamanioP = tamanioP;
    }

    public String getPesoP() {
        return pesoP;
    }

    public void setPesoP(String pesoP) {
        this.pesoP = pesoP;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDatosFacturacion() {
        return datosFacturacion;
    }

    public void setDatosFacturacion(String datosFacturacion) {
        this.datosFacturacion = datosFacturacion;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
