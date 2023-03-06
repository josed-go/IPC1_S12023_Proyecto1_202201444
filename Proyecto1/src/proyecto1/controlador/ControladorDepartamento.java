package proyecto1.controlador;

import java.util.ArrayList;
import proyecto1.modelo.Departamento;

/**
 *
 * @author JD
 */
public class ControladorDepartamento {
    
    static ArrayList<Departamento> arrayDepartamento = new ArrayList<>();
    static String departamento;
    
    public void DepartamentosPrincipales() {
        arrayDepartamento.add(new Departamento("M","Metropolitana","Guatemala", "01"));
        arrayDepartamento.add(new Departamento("NT","Norte","Baja Verapaz","15"));
        arrayDepartamento.add(new Departamento("NO","Nororiente","Chiquimula","20"));
        arrayDepartamento.add(new Departamento("SOC","Suroccidente","Sololá","07"));
        arrayDepartamento.add(new Departamento("NOC","Noroccidente","Quiché","14"));
    }
    
    public void AgregarDepartamento(String codigoRegion, String region, String nombre, String codigo) {
        if(!ValidarDepartamento(nombre)) {
            arrayDepartamento.add(new Departamento(codigoRegion, region, nombre, codigo));
        }
    }
    
    public void EditarDepartamento(String codigoEditar, String nombreEditar, String codigoRegion, String region, String nombre, String codigo) {
        for(Departamento d: arrayDepartamento) {
            if(d.getCodigoDepartamento().equals(codigoEditar)) {
                if(!ValidarDepartamento(nombre) || codigoEditar.equalsIgnoreCase(codigo) || nombreEditar.equalsIgnoreCase(nombre)) {
                    d.setCodigoRegion(codigoRegion);
                    d.setRegion(region);
                    d.setNombre(nombre);
                    d.setCodigoDepartamento(codigo);
                }
                
            }
        }
    }
    
    public boolean ValidarDepartamento(String nombre) {
        
        for(Departamento d: arrayDepartamento) {
            if(d.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean ValidarCodigo(String codigo) {
        for(Departamento d: arrayDepartamento) {
            if(d.getCodigoDepartamento().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    public Departamento ValidarSeleccion(String codigo) {
        for(Departamento d: arrayDepartamento) {
            if(d.getCodigoDepartamento().equals(codigo)) {
               return d;
            }
        }
        return null;
    }
    
    public ArrayList<Departamento> ObtenerDepartamento() {
        return arrayDepartamento;
    }
    
    public Departamento ObtenerDepartamentoNombre(String nombre) {
        for(Departamento d: arrayDepartamento) {
            if(d.getNombre().equalsIgnoreCase(nombre)) {
                return d;
            }
        }
        
        return null;
    }
    
}
