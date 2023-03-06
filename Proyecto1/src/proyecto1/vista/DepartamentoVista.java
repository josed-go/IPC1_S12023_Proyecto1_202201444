/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.vista;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import proyecto1.controlador.ControladorDepartamento;
import proyecto1.controlador.ControladorMunicipio;
import proyecto1.modelo.Departamento;

/**
 *
 * @author JD
 */
public class DepartamentoVista extends javax.swing.JFrame {

    /**
     * Creates new form DepartamentoVista
     */
    ControladorDepartamento controladorD = new ControladorDepartamento();
    ControladorMunicipio controladorM = new ControladorMunicipio();
    
    public DepartamentoVista() {
        initComponents();
        LlenarTabla();
        btnMunicipios.setVisible(false);
        btnCancelar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableD = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnMunicipios = new javax.swing.JButton();
        btnAction = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("DEPARTAMENTOS");

        btnRegresar.setText("REGRESAR");
        btnRegresar.setFocusPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tableD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOMBRE", "REGION", "CÓDIGO REGIÓN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableDFocusLost(evt);
            }
        });
        tableD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableD);

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnMunicipios.setText("MUNICIPIOS");
        btnMunicipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMunicipiosActionPerformed(evt);
            }
        });

        btnAction.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAction.setText("AGREGAR");
        btnAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMunicipios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(btnAction, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnRegresar)))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnMunicipios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnAction)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tableDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableDFocusLost

    }//GEN-LAST:event_tableDFocusLost

    private void tableDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDMouseClicked
        if(tableD.getSelectedRow() >= 0) {
            btnAction.setText("EDITAR");
            btnCancelar.setVisible(true);
            btnMunicipios.setVisible(true);
        }
    }//GEN-LAST:event_tableDMouseClicked

    private void btnActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionActionPerformed
        AccionesDepartamento accionesD = new AccionesDepartamento();
        accionesD.Tipo(btnAction.getText());
        
        this.setVisible(false);
        
        if(btnAction.getText().equals("AGREGAR")) {
            accionesD.setVisible(true);
        } else if(btnAction.getText().equals("EDITAR")) {
            accionesD.CamposEditar((String)tableD.getValueAt(tableD.getSelectedRow(), 0));
            accionesD.setVisible(true);
        }
        
    }//GEN-LAST:event_btnActionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnAction.setText("AGREGAR");
        btnCancelar.setVisible(false);
        btnMunicipios.setVisible(false);
        tableD.clearSelection();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMunicipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMunicipiosActionPerformed
        controladorM.MunicipiosPorDepartamento((String)tableD.getValueAt(tableD.getSelectedRow(), 0));
        this.setVisible(false);
        MunicipioVista vistaM = new MunicipioVista();
        vistaM.setVisible(true);
        vistaM.Departamento((String)tableD.getValueAt(tableD.getSelectedRow(), 1));
    }//GEN-LAST:event_btnMunicipiosActionPerformed

    public void LlenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"CÓDIGO", "NOMBRE", "REGIÓN", "CÓDIGO REGIÓN"}, controladorD.ObtenerDepartamento().size());
        tableD.setModel(modelo);
        
        TableModel modeloDatos = tableD.getModel();
        for(int i = 0; i < controladorD.ObtenerDepartamento().size(); i++) {
            Departamento departamento = controladorD.ObtenerDepartamento().get(i);
            modeloDatos.setValueAt(departamento.getCodigoDepartamento(), i, 0);
            modeloDatos.setValueAt(departamento.getNombre(), i, 1);
            modeloDatos.setValueAt(departamento.getRegion(), i, 2);
            modeloDatos.setValueAt(departamento.getCodigoRegion(), i, 3);
        }  
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
            java.util.logging.Logger.getLogger(DepartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartamentoVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAction;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMunicipios;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tableD;
    // End of variables declaration//GEN-END:variables
}
