package proyecto1.controlador;

import java.util.ArrayList;
import proyecto1.modelo.Kiosco;

/**
 *
 * @author JD
 */
public class ControladorKiosco {
    
    static ArrayList<Kiosco> arrayKiosco = new ArrayList<>();
    
    public boolean AgregarKiosco(String codigo, String nombre, String region) {
        
        if(!ValidarCodigo(codigo)) {
            arrayKiosco.add(new Kiosco(codigo, nombre, region));
        }
        
        return false;
    }
    
    public boolean ValidarCodigo(String codigo) {
        
        for(Kiosco k: arrayKiosco) {
            if(k.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    public void EditarKiosco(String codigoEditar, String codigo, String nombre, String region) {
        for(Kiosco k: arrayKiosco) {
            if(k.getCodigo().equals(codigoEditar)) {
                if(!ValidarCodigo(codigo) || codigoEditar.equals(codigo)) {
                    k.setCodigo(codigo);
                    k.setNombre(nombre);
                    k.setCodigoRegion(region);
                }
            }
        }
    }
    
    public Kiosco ValidarSeleccion(String codigo) {
        for(Kiosco k: arrayKiosco) {
            if(k.getCodigo().equals(codigo)) {
               return k;
            }
        }
        return null;
    }
    
    public ArrayList<Kiosco> ObtenerKioscos() {
        return arrayKiosco;
    }
    
    
}
