package proyecto1.controlador;

import java.util.ArrayList;
import proyecto1.modelo.Compras;

/**
 *
 * @author JD
 */
public class ControladorCompra {
    
    static ArrayList<Compras> arrayCompra = new ArrayList<>();
    ControladorRegion controladorR = new ControladorRegion();
    ControladorDepartamento controladorD = new ControladorDepartamento();
    
    public String Cotizar(String depaO, String muniO, String direccionO, String deparD, String muniD, String direccionD, String cantidad, String peso, String tipoRegion) {
        double total = 0;
        double precioRegion = 0;
        int tamanioP = 0;
        int numeroP = Integer.parseInt(cantidad);
        
        if(tipoRegion.equalsIgnoreCase("estándar")) {
            precioRegion = controladorR.ObtenerRegionSeleccionada(controladorD.ObtenerDepartamentoNombre(deparD).getCodigoRegion()).getEstandar();
        } else if(tipoRegion.equalsIgnoreCase("especial")) {
            precioRegion = controladorR.ObtenerRegionSeleccionada(controladorD.ObtenerDepartamentoNombre(deparD).getCodigoRegion()).getEspecial();
        }
        
        if(peso.equalsIgnoreCase("pequeño")) {
            tamanioP = 15;
        } else if(peso.equalsIgnoreCase("mediano")) {
            tamanioP = 25;
        } else if(peso.equalsIgnoreCase("grande")) {
            tamanioP = 35;
        }
        
        total = precioRegion*tamanioP*numeroP;
        
        return String.valueOf(total);
    }
    
}
