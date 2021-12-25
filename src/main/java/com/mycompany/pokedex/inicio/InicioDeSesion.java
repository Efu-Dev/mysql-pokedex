package com.mycompany.pokedex.inicio;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;



public class InicioDeSesion extends javax.swing.JFrame {

  
    public InicioDeSesion() {
        initComponents();
    }
    
    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        LabelLoginUsuario = new javax.swing.JLabel();
        LabelPasswordUsuario = new javax.swing.JLabel();
        EntradaUsuario1 = new javax.swing.JTextField();
        BotonLogin = new javax.swing.JButton();
        BotonRegistroNuevo = new javax.swing.JButton();
        ShowPassword = new javax.swing.JCheckBox();
        jPasswordField1 = new javax.swing.JPasswordField();
        Fondo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokedex: Inicio de Sesion");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLoginUsuario.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        LabelLoginUsuario.setForeground(new java.awt.Color(240, 240, 240));
        LabelLoginUsuario.setText("Usuario");
        getContentPane().add(LabelLoginUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 79, -1));

        LabelPasswordUsuario.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        LabelPasswordUsuario.setForeground(new java.awt.Color(240, 240, 240));
        LabelPasswordUsuario.setText("Contraseña");
        LabelPasswordUsuario.setToolTipText("");
        getContentPane().add(LabelPasswordUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 121, -1));

        EntradaUsuario1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(EntradaUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 152, 30));

        BotonLogin.setBackground(new java.awt.Color(255, 255, 255));
        BotonLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonLogin.setText("Iniciar Sesion");
        BotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(BotonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, 33));

        BotonRegistroNuevo.setBackground(new java.awt.Color(255, 255, 255));
        BotonRegistroNuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonRegistroNuevo.setText("Registrar");
        BotonRegistroNuevo.addActionListener((java.awt.event.ActionEvent evt) -> {
            BotonRegistroNuevoActionPerformed(evt);
        });
        getContentPane().add(BotonRegistroNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 33));

        ShowPassword.setBackground(new java.awt.Color(204, 0, 51));
        ShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        ShowPassword.setText("Mostrar Contraseña");
        getContentPane().add(ShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 140, 30));
	ShowPassword.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                jPasswordField1.setEchoChar((char) 0);
            } else {
                jPasswordField1.setEchoChar('*');
            }
        });

        jPasswordField1.setText("");
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 150, -1));

        Fondo1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\Imagenes\\Fondo1.jpg")); // NOI18N
        Fondo1.setText("jLabel1");
        getContentPane().add(Fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 340));

        pack();
    }// </editor-fold>                        

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
    }                                            

    private void BotonRegistroNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
     Registro newframe = new Registro();
     newframe.setVisible(true);
     this.dispose();
    }                                                  

    private void BotonLoginActionPerformed(java.awt.event.ActionEvent evt) {                                           
           
        String pass = new String(jPasswordField1.getPassword()).trim();
        String usuario = new String(EntradaUsuario1.getText()).trim();
        
        if(!usuario.equals("") && !pass.equals(""))
        {
            int id = SQLusuarios.login(usuario, pass);
            if (id != -1){
                MenuPrincipal newframe = new MenuPrincipal(id);
                newframe.setVisible(true);
                this.dispose();
            } else {
                 JOptionPane.showMessageDialog(null, "Datos Incorrectos.");
            }
             
   } else {
       JOptionPane.showMessageDialog(null, "Los Campo estan vacios, por favor, ingrese sus datos e intente nuevamente.");
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
            java.util.logging.Logger.getLogger(InicioDeSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioDeSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioDeSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioDeSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioDeSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BotonLogin;
    private javax.swing.JButton BotonRegistroNuevo;
    private javax.swing.JTextField EntradaUsuario1;
    private javax.swing.JLabel Fondo1;
    private javax.swing.JLabel LabelLoginUsuario;
    private javax.swing.JLabel LabelPasswordUsuario;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration                   
}
