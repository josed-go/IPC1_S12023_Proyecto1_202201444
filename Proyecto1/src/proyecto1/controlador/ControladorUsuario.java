package proyecto1.controlador;

import java.util.ArrayList;
import proyecto1.modelo.Usuario;

/**
 *
 * @author JD
 */
public class ControladorUsuario {
    
    static ArrayList<Usuario> arrayUser = new ArrayList<>();
    Usuario user = new Usuario();
    
    public void CrearAdmin() {
        arrayUser.add(new Usuario());
    }
    
    public boolean VerificarUsuario(String correo, String pass) {
        
        for (Usuario u: arrayUser) {
            if(u.getCorreo().equals(correo) && u.getPassword().equals(pass)) {
                return true;
            }
        }
        
        return false;
    }
    
    public void RegistrarUsuario(String correo, String nombre, String apellido, String password, String dpi, String fechaC, String genero, String nacionalidad, String usuario, String telefono, String rol, String foto) {
        boolean usuarioCreado = false;
        for (Usuario u: arrayUser) {
            if(u.getCorreo().equals(correo)) {
                usuarioCreado = true;
            }
        }
        
        if(!usuarioCreado) {
            arrayUser.add(new Usuario(correo, nombre, apellido, password, dpi, fechaC, genero, nacionalidad, usuario, telefono, rol, foto));
        }
    }
    
    public boolean ValidarPassword(String pass) {
        String b;
        int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0;
        for(int i = 0; i < pass.length(); i++) {
            b = Character.toString(pass.charAt(i));
            if(b.matches("[A-Z]")) {
                cont1++;
            } else if(b.matches("[a-z]")) {
                cont2++;
            } else if(b.matches("[0-9]")) {
                cont3++;
            } else if(b.matches("[!@#$%^&*(),.?\\\":{}|<>]")) {
                cont4++;
            }
        }
        
        if(cont1 >= 1 && cont2 >= 1 && cont3 >= 1 && cont4 >= 1) {
            return true;
        }
        return false;
    }
    
    
    
}
