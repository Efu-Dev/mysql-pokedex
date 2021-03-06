/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pokedex.inicio;

import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Artzaint
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public Registro() {
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

        LabelVentanaRegistro = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        EntradaUsuario = new javax.swing.JTextField();
        LabelNombre = new javax.swing.JLabel();
        EntradaNombre = new javax.swing.JTextField();
        LabelPassword = new javax.swing.JLabel();
        EntradaPassword = new javax.swing.JPasswordField();
        ShowPassword = new javax.swing.JCheckBox();
        FinalizarRegistro = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        genero = new javax.swing.JComboBox<>();
        Fondo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokedex: Registro de Entrenador");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelVentanaRegistro.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        LabelVentanaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        LabelVentanaRegistro.setText("Registro de Entrenador");
        LabelVentanaRegistro.setToolTipText("");
        LabelVentanaRegistro.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(LabelVentanaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        LabelUsuario.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(240, 240, 240));
        LabelUsuario.setText("Usuario");
        getContentPane().add(LabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 88, -1));

        EntradaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(EntradaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 188, 31));

        LabelNombre.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(240, 240, 240));
        LabelNombre.setText("Nombre");
        getContentPane().add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        EntradaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaNombreActionPerformed(evt);
            }
        });
        getContentPane().add(EntradaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 188, 31));

        LabelPassword.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        LabelPassword.setForeground(new java.awt.Color(240, 240, 240));
        LabelPassword.setText("Contrase??a");
        getContentPane().add(LabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        EntradaPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(EntradaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 188, 31));
        ShowPassword.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                EntradaPassword.setEchoChar((char) 0);
            } else {
                EntradaPassword.setEchoChar('*');
            }
        });

        ShowPassword.setBackground(new java.awt.Color(204, 0, 51));
        ShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        ShowPassword.setText("Mostrar Contrase??a");
        getContentPane().add(ShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 126, -1));

        FinalizarRegistro.setBackground(new java.awt.Color(204, 0, 0));
        FinalizarRegistro.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        FinalizarRegistro.setText("Registrar");
        FinalizarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(FinalizarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 275, 131, 30));

        Regresar.setBackground(new java.awt.Color(255, 255, 255));
        Regresar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        getContentPane().add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, -1));

        genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Hombre", "Mujer"}));
        genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generoActionPerformed(evt);
            }
        });
        getContentPane().add(genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, -1));

        Fondo2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\Imagenes\\Fondo1.jpg"));
        getContentPane().add(Fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EntradaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EntradaUsuarioActionPerformed

    private void EntradaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EntradaNombreActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
     InicioDeSesion newframe = new InicioDeSesion();
        newframe.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void FinalizarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarRegistroActionPerformed
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        if(SQLusuarios.registrar(con, genero.getSelectedItem().toString(),
                EntradaNombre.getText(), EntradaUsuario.getText(), EntradaPassword.getText())){
            JOptionPane.showMessageDialog(this, "El usuario fue creado correctamente.");
            RegresarActionPerformed(null);
        }
        else
            JOptionPane.showMessageDialog(this, "Ocurri?? un error al registrar el usuario. "
                    + "Revise que el Usuario no est?? ocupado.");
        
        if (EntradaUsuario.getText().equals("")|| EntradaPassword.equals("") || EntradaNombre.equals("")){
            
            JOptionPane.showMessageDialog(null, "Hay Campos Vacios Aun, por favor llenelos e intente nuevamente.");
            
        }
    }//GEN-LAST:event_FinalizarRegistroActionPerformed

    private void EntradaPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EntradaPasswordActionPerformed

    private void generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generoActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EntradaNombre;
    private javax.swing.JPasswordField EntradaPassword;
    private javax.swing.JTextField EntradaUsuario;
    private javax.swing.JButton FinalizarRegistro;
    private javax.swing.JLabel Fondo2;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JLabel LabelVentanaRegistro;
    private javax.swing.JButton Regresar;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JComboBox<String> genero;
    // End of variables declaration//GEN-END:variables
}
