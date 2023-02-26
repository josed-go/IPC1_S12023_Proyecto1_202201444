package proyecto1;

import proyecto1.controlador.ControladorUsuario;

/**
 *
 * @author JD
 */
public class Principal {

    public static void main(String[] args) {
        ControladorUsuario userController = new ControladorUsuario();
  
        userController.CrearAdmin(); // CREACION DE USUARIO ADMIN
    }
    
}
