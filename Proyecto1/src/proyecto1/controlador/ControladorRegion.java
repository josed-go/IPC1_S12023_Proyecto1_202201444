package proyecto1.controlador;

import java.util.ArrayList;
import proyecto1.modelo.Region;

/**
 *
 * @author JD
 */
public class ControladorRegion {
    
    static ArrayList<Region> arrayRegion = new ArrayList<>();
    
    public void CrearRegiones() {
        arrayRegion.add(new Region("M", "Metropolitana", 35,25));
        arrayRegion.add(new Region("NT", "Norte", 68.5,45.55));
        arrayRegion.add(new Region("NO", "Nororiente", 58.69,35.48));
        arrayRegion.add(new Region("SO", "Suroriente", 38.68,32.48));
        arrayRegion.add(new Region("SOC", "Suroccidente", 34,29));
        arrayRegion.add(new Region("NOC", "Noroccidente", 44.5,40));
    }
    
    public void EditarPrecio(String codigo, double pEstandar, double pEspecial) {
        
        for(Region r: arrayRegion) {
            if(r.getCodigo().equals(codigo)){
                r.setEstandar(pEstandar);
                r.setEspecial(pEspecial);
            }
        }
    }
    
    public String ObtenerRegion(String codigo) {
        for(Region r: arrayRegion) {
            if(r.getCodigo().equals(codigo)) {
                return r.getNombre();
            }
        }
        
        return null;
    }
    
    public ArrayList<Region> ObtenerRegiones() {
        return arrayRegion;
    }
    
    public Region ObtenerRegionSeleccionada(String codigo) {
        for(Region r: arrayRegion) {
            if(r.getCodigo().equals(codigo)) {
               return r;
            }
        }
        return null;
    }
    
}
