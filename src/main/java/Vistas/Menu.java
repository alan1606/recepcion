/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import javax.swing.JOptionPane;


/**
 *
 * @author alanm
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        
        
        
    }

     private void cerrar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Salir", dialog);

        if (result == 0) {
            System.exit(0);
        } else {
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnAgendar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPagar.setText("Pagar orden");
        jPanel1.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 99, 40));

        btnConfirmar.setText("Confirmar cita");
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, 40));

        btnAgendar.setText("Agendar");
        jPanel1.add(btnAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 99, 40));

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));
        jPanel2.setForeground(new java.awt.Color(52, 73, 94));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\alanm\\Documents\\NetBeansProjects\\recepcion\\src\\images\\icons8_multiply_30px.png")); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 38, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\alanm\\Documents\\NetBeansProjects\\recepcion\\src\\images\\icons8_minus_50px.png")); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 35, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setState(Menu.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Menu menu = new Menu();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgendar;
    public javax.swing.JButton btnConfirmar;
    public javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
