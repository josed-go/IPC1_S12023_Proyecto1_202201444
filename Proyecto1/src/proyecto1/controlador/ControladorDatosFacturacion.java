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
    
    public boolean ValidarDatos(String direccion) {
        
        for(DatosFacturacion d: arrayDatos) {
            if(d.getUsuario().equals(usuario.UsuarioLogeado().getCorreo()) && d.getDireccion().equalsIgnoreCase(direccion)) {
                return true;
            }
        }
        
        return false;
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
