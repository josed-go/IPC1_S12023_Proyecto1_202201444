package proyecto1.controlador;

import java.util.ArrayList;
import proyecto1.modelo.Municipio;

/**
 *
 * @author JD
 */
public class ControladorMunicipio {
    
    static ArrayList<Municipio> arrayMunicipio = new ArrayList<>();
    
    static ArrayList<Municipio> arrayMuniDepar = new ArrayList<>();
    
    public void CrearMunicipios() {
        // MUNICIPIOS DEPARTAMENTO 1
        arrayMunicipio.add(new Municipio("01", "Guatemala"));
        arrayMunicipio.add(new Municipio("01", "Santa Catarina Pinula"));
        arrayMunicipio.add(new Municipio("01", "San Jose Pinula"));
        arrayMunicipio.add(new Municipio("01", "San Jose Del Golfo"));
        arrayMunicipio.add(new Municipio("01", "Mixco"));
        
        // MUNICIPIOS DEPARTAMENTO 2
        arrayMunicipio.add(new Municipio("15", "Salama"));
        arrayMunicipio.add(new Municipio("15", "San Miguel Chicaj"));
        arrayMunicipio.add(new Municipio("15", "Rabinal"));
        arrayMunicipio.add(new Municipio("15", "Cubulco"));
        arrayMunicipio.add(new Municipio("15", "Granados"));
        
        // MUNICIPIOS DEPARTAMENTO 3
        arrayMunicipio.add(new Municipio("20", "Chiquimula"));
        arrayMunicipio.add(new Municipio("20", "San José La Arada"));
        arrayMunicipio.add(new Municipio("20", "Jocotan"));
        arrayMunicipio.add(new Municipio("20", "Esquipulas"));
        arrayMunicipio.add(new Municipio("20", "Quezaltepeque"));
        
        // MUNICIPIOS DEPARTAMENTO 4
        arrayMunicipio.add(new Municipio("07", "Solola"));
        arrayMunicipio.add(new Municipio("07", "San José Chacaya"));
        arrayMunicipio.add(new Municipio("07", "Panajachel"));
        arrayMunicipio.add(new Municipio("07", "San Lucas Toliman"));
        arrayMunicipio.add(new Municipio("07", "Santiago Atitlan"));
        
        // MUNICIPIOS DEPARTAMENTO 5
        arrayMunicipio.add(new Municipio("14", "Chiche"));
        arrayMunicipio.add(new Municipio("14", "Santa Cruz del Quiche"));
        arrayMunicipio.add(new Municipio("14", "Chajul"));
        arrayMunicipio.add(new Municipio("14", "Nebaj"));
        arrayMunicipio.add(new Municipio("14", "Ixcan"));
    }
    
    public void AgregarMunicipios(String codigoDepartamento, String nombre) {
        if(!ValidarMunicipio(codigoDepartamento, nombre)) {
            arrayMunicipio.add(new Municipio(codigoDepartamento, nombre));
        }        
    }
    
    public void EditarMunicipio(String nombreEditar, String codigoDepartamento, String nombre) {
        for(Municipio m: arrayMunicipio) {
            if(m.getNombre().equalsIgnoreCase(nombreEditar)) {
                if(!ValidarMunicipio(codigoDepartamento, nombre)) {
                    m.setCodigoDepartamento(codigoDepartamento);
                    m.setNombre(nombre);
                }
            }
        }
        
    }
    
    public boolean ValidarMunicipio(String codigo, String nombre) {
        for(Municipio m: arrayMunicipio) {
            if(m.getCodigoDepartamento().equalsIgnoreCase(codigo) && m.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    public void MunicipiosPorDepartamento(String codigo) {
        LimpiarArray();
        for(Municipio m: arrayMunicipio) {
           if(m.getCodigoDepartamento().equalsIgnoreCase(codigo)) {
               arrayMuniDepar.add(new Municipio(m.getCodigoDepartamento(), m.getNombre()));
           }
        }
    }
    
    public ArrayList<Municipio> ObtenerMunicipios() {
        
        return arrayMuniDepar;
    }
    
    public void LimpiarArray() {
        arrayMuniDepar.clear();
    }
    
}
