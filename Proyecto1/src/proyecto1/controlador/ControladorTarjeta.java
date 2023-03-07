package proyecto1.controlador;

import java.util.ArrayList;
import proyecto1.modelo.Tarjetas;

/**
 *
 * @author JD
 */
public class ControladorTarjeta {
    
    static ArrayList<Tarjetas> arrayTarjeta = new ArrayList<>();
    ControladorUsuario controladorU = new ControladorUsuario();
    static ArrayList<Tarjetas> arrayTarjetasUsuario = new ArrayList<>();
    
    public void CrearTarjeta(String nombre, String tipo, String numero, String fecha) {
        if(!ValidarTarjeta(numero)) {
            arrayTarjeta.add(new Tarjetas(nombre, tipo, numero, fecha, controladorU.UsuarioLogeado().getCorreo()));
        }
    }
    
    public boolean ValidarTarjeta(String numero) {
        
        for(Tarjetas t: arrayTarjeta){
            if(t.getUsuario().equals(controladorU.UsuarioLogeado().getCorreo()) && t.getNumero().equals(numero)) {
                return true;
            }
        
        }
        return false;
    }
    
    public void TarjetasUsuario() {
        LimpiarArray();
        for(Tarjetas t: arrayTarjeta) {
            if(t.getUsuario().equals(controladorU.UsuarioLogeado().getCorreo())) {
                arrayTarjetasUsuario.add(new Tarjetas(t.getNombre(), t.getTipo(), OcultarNumero(t.getNumero()),t.getFecha(), t.getUsuario()));
            }
        }
    }
    
    public String OcultarNumero(String numero) {
        char[] num = numero.toCharArray();
        for(int i = 0; i <= num.length-5; i++) {
            num[i] = "X".charAt(0);
        }
        return String.valueOf(num);
    }
    
    public ArrayList<Tarjetas> ObtenerTarjetasUsuario() {
        return arrayTarjetasUsuario;
    }
    
    public void LimpiarArray() {
        arrayTarjetasUsuario.clear();
    }
    
}
