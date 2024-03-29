package proyecto1;

import proyecto1.controlador.ControladorDepartamento;
import proyecto1.controlador.ControladorMunicipio;
import proyecto1.controlador.ControladorRegion;
import proyecto1.controlador.ControladorUsuario;

import proyecto1.vista.Login;

/**
 *
 * @author JD
 */
public class Principal {
    
    public static void main(String[] args) {
        ControladorUsuario userController = new ControladorUsuario();
        ControladorRegion controladorR = new ControladorRegion();
        ControladorDepartamento controladorD = new ControladorDepartamento();
        ControladorMunicipio controladorM = new ControladorMunicipio();
        controladorR.CrearRegiones();
        controladorD.DepartamentosPrincipales();
        controladorM.CrearMunicipios();
        Login login = new Login();
        userController.CrearAdmin(); // CREACION DE USUARIO ADMIN
        login.setVisible(true);
        
    }

}
