package proyecto1.controlador;

import java.util.ArrayList;
import proyecto1.modelo.Usuario;

/**
 *
 * @author JD
 */
public class ControladorUsuario {
    
    static ArrayList<Usuario> arrayUser = new ArrayList<Usuario>();
    Usuario user = new Usuario();
    
    public void CrearAdmin() {
        arrayUser.add(new Usuario());
        System.out.println(arrayUser.get(0).getCorreo());
        System.out.println(arrayUser.get(0).getRol());
    }
    
    
    
}
