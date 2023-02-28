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
    
    
    
}
