/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.vista;

import javax.swing.JOptionPane;
import proyecto1.controlador.ControladorDepartamento;
import proyecto1.controlador.ControladorMunicipio;

/**
 *
 * @author JD
 */
public class AccionesMunicipio extends javax.swing.JFrame {

    /**
     * Creates new form AccionesMunicipio
     */
    
    ControladorDepartamento controladorD = new ControladorDepartamento();
    ControladorMunicipio controladorM = new ControladorMunicipio();
    MunicipioVista vistaM = new MunicipioVista();
    String nombreE;
    
    public AccionesMunicipio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        btnAccion = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("DEPARTAMENTO");

        txtDepartamento.setEditable(false);
        txtDepartamento.setFocusable(false);

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("AGREGAR");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnAccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAccion.setText("AGREGAR");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("NOMBRE");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("CÓDIGO DEPARTAMENTO");

        txtCodigo.setEditable(false);
        txtCodigo.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAccion)
                            .addGap(102, 102, 102)
                            .addComponent(btnCancelar))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(19, 19, 19)
                .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccion)
                    .addComponent(btnCancelar))
                .addGap(48, 48, 48))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        if(btnAccion.getText().equals("AGREGAR")) {
            if(ValidarTextField()) {
                if(!controladorM.ValidarMunicipio(txtCodigo.getText(), txtNombre.getText())) {
                    controladorM.AgregarMunicipios(txtCodigo.getText(), txtNombre.getText());
                    controladorM.MunicipiosPorDepartamento(txtCodigo.getText());
                    JOptionPane.showMessageDialog(this, "Municipio agregado.");
                    this.setVisible(false);
                    vistaM.LlenarTabla();
                    vistaM.setVisible(true);
                    RegresarNombre();
                } else {
                    JOptionPane.showMessageDialog(this, "Ya existe ese municipio en este departamento.");
                }

            }
        }else if(btnAccion.getText().equals("EDITAR")) {
            if(ValidarTextField()) {
                if(!controladorM.ValidarMunicipio(txtCodigo.getText(), txtNombre.getText()) || nombreE.equalsIgnoreCase(txtNombre.getText())) {
                    controladorM.EditarMunicipio(nombreE, txtCodigo.getText(), txtNombre.getText());
                    controladorM.MunicipiosPorDepartamento(txtCodigo.getText());
                    JOptionPane.showMessageDialog(this, "Municipio editado");
                    this.setVisible(false);
                    vistaM.LlenarTabla();
                    vistaM.setVisible(true);
                    RegresarNombre();
                } else {
                    JOptionPane.showMessageDialog(this, "Ya existe ese municipio en este departamento.");
                }
            }
        }
    }//GEN-LAST:event_btnAccionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        vistaM.setVisible(true);
        this.setVisible(false);
        RegresarNombre();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void DatosDepartamento(String nombre) {
        txtCodigo.setText(controladorD.ObtenerDepartamentoNombre(nombre).getCodigoDepartamento());
        txtDepartamento.setText(controladorD.ObtenerDepartamentoNombre(nombre).getNombre());
    }
    
    private boolean ValidarTextField() {
        if(txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos.");
            return false;
        }
        return true;
    }
    
    public void TextFieldEditar(String nombre) {
        txtNombre.setText(nombre);
        nombreE = nombre;
    }
    
    public void Tipo(String tipo) {
        if(tipo.equals("AGREGAR")) {
            lblTitulo.setText("AGREGAR");
            btnAccion.setText("AGREGAR");
        } else if(tipo.equals("EDITAR")) {
            lblTitulo.setText("EDITAR");
            btnAccion.setText("EDITAR");
        }
    }
    
    public void RegresarNombre() {
        vistaM.Departamento(txtDepartamento.getText());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccionesMunicipio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccionesMunicipio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccionesMunicipio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccionesMunicipio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccionesMunicipio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
