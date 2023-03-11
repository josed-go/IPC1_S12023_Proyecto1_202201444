package proyecto1.controlador;

import java.util.ArrayList;
import proyecto1.modelo.DatosFacturacion;

/**
 *
 * @author JD
 */
public class ControladorDatosFacturacion {
    
    static ArrayList<DatosFacturacion> arrayDatos = new ArrayList<>();
    ControladorUsuario usuario = new ControladorUsuario();
    static ArrayList<DatosFacturacion> arrayDatosUsuario = new ArrayList<>();
    
    public void AgregarDatos(String nombre, String apellido, String direccion, String nit) {
        if(!ValidarDatos(direccion)) {
            arrayDatos.add(new DatosFacturacion(nombre, apellido, direccion, nit, usuario.UsuarioLogeado().getCorreo(), "Datos"));
        }
    }
    
    public void EditarDato(String nombreE, String direccionE, String nitE, String nombre, String apellido, String direccion, String nit) {
        
        for(DatosFacturacion d: arrayDatos) {
            if((d.getNombre()+" "+d.getApellido()).equals(nombreE) && d.getDireccion().equals(direccionE) && d.getNit().equals(nitE)) {
                if(!ValidarDatos(direccion) || direccionE.equals(direccion)) {
                    d.setNombre(nombre);
                    d.setApellido(apellido);
                    d.setDireccion(direccion);
                    d.setNit(nit);
                }
            }
        }
        
    }
    
    public boolean ValidarDatos(String direccion) {
        
        for(DatosFacturacion d: arrayDatos) {
            if(d.getUsuario().equals(usuario.UsuarioLogeado().getCorreo()) && d.getDireccion().equalsIgnoreCase(direccion)) {
                return true;
            }
        }
        
        return false;
    }
    
    public DatosFacturacion ObtenerDato(String nombre, String direccion, String nit) {
        for(DatosFacturacion d: arrayDatosUsuario) {
            if((d.getNombre()+" "+d.getApellido()).equals(nombre) && d.getDireccion().equals(direccion) && d.getNit().equals(nit)) {
                return d;
            }
        }
        return null;
    }
    
    public void DatosUsuario() {
        LimpiarArray();
        for(DatosFacturacion d: arrayDatos) {
            if(d.getUsuario().equals(usuario.UsuarioLogeado().getCorreo())) {
                arrayDatosUsuario.add(new DatosFacturacion(d.getNombre(), d.getApellido(), d.getDireccion(),d.getNit(),d.getUsuario(), "Datos"));
            }
        }
    }
    
    public ArrayList<DatosFacturacion> ObtenerDatos() {
        return arrayDatosUsuario;
    }
    
    public void LimpiarArray() {
        arrayDatosUsuario.clear();
    }
    
    
}
