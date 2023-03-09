package proyecto1.controlador;

import java.util.ArrayList;
import java.util.Random;
import proyecto1.modelo.Compras;

/**
 *
 * @author JD
 */
public class ControladorCompra {
    
    static ArrayList<Compras> arrayCompra = new ArrayList<>();
    static ArrayList<Compras> arrayCompraUsuario = new ArrayList<>();
    ControladorRegion controladorR = new ControladorRegion();
    ControladorDepartamento controladorD = new ControladorDepartamento();
    ControladorUsuario usuario = new ControladorUsuario();
    
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
    
    public void RealizarCompra(String depaO, String muniO, String direccionO, String deparD, String muniD, String direccionD, String cantidad, String peso, String tipoPago, String numeroT, String tipoRegion, String datosF) {
        double totalC = Double.parseDouble(Cotizar( depaO,  muniO,  direccionO,  deparD,  muniD,  direccionD,  cantidad,  peso,  tipoRegion));
        if(tipoPago.equalsIgnoreCase("Contra entrega")) {
            totalC = totalC +5;
            arrayCompra.add(new Compras(depaO, muniO, direccionO, deparD, muniD, direccionD, CodigoPaquete(), tipoRegion, cantidad, peso, tipoPago, datosF, String.valueOf(totalC), usuario.UsuarioLogeado().getCorreo() ));
            
        } else if (tipoPago.equalsIgnoreCase("con tarjeta")) {
            arrayCompra.add(new Compras(depaO, muniO, direccionO, deparD, muniD, direccionD, CodigoPaquete(), tipoRegion, cantidad, peso, tipoPago,numeroT, datosF, String.valueOf(totalC), usuario.UsuarioLogeado().getCorreo() ));
        }
        
    }
    
    public String CodigoPaquete() {
        Random r = new Random();
        boolean flag = true;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
        char[] code = new char[5];
        do{
            for(int i = 0; i < code.length; i++) {
                code[i] = alphabet.charAt(r.nextInt(alphabet.length()));
            }
        
            if(ValidarCodigo(String.valueOf(code))) {
                flag = false;
            }
        } while(flag == false);

        return "IPC1D"+String.valueOf(code);
    }
    
    public boolean ValidarCodigo(String code) {
        for(Compras c: arrayCompra) {
            if(c.getIdPaquete().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
    
    public void GuardarComprasUsuario() {
        LimpiarArray();
        for(Compras c: arrayCompra) {
            if(c.getUsuario().equals(usuario.UsuarioLogeado().getCorreo())) {
                arrayCompraUsuario.add(new Compras(c.getDepartamentoO(),c.getMuicipioO(),c.getDepartamentoO(), c.getDepartamentoD(), c.getMunicipioD(), c.getDireccionD(), c.getIdPaquete(), c.getTipoServicio(),c.getNumeroP(),c.getPesoP(), c.getTipoPago(),c.getNumeroTarjeta(), c.getDatosFacturacion(),c.getTotal(), c.getUsuario()));
            }
        }
    }
    
    public ArrayList<Compras> ObtenerComprasUsuario() {
        return arrayCompraUsuario;
    }
    
    public void LimpiarArray() {
        arrayCompraUsuario.clear();
    }
    
}
