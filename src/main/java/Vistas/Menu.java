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
        jLabel2 = new javax.swing.JLabel();
        btnCortes = new javax.swing.JButton();
        btnUrgencias = new javax.swing.JButton();
        btnEntradas = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnAgendar = new javax.swing.JButton();
        btnCancelaciones = new javax.swing.JButton();
        btnReagendar = new javax.swing.JButton();
        LabelAgenda = new javax.swing.JLabel();
        jLabelConCita = new javax.swing.JLabel();
        jLabelPO = new javax.swing.JLabel();
        jLabelEYS = new javax.swing.JLabel();
        jLabelUrge = new javax.swing.JLabel();
        jLabelCancelar = new javax.swing.JLabel();
        jLabelREAgendar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HOLA, BIENVENIDO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 670, 70));

        btnCortes.setBackground(new java.awt.Color(204, 204, 204));
        btnCortes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCortes.setForeground(new java.awt.Color(0, 0, 51));
        btnCortes.setText("Cortes");
        btnCortes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnCortes, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 120, 40));

        btnUrgencias.setBackground(new java.awt.Color(204, 204, 204));
        btnUrgencias.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUrgencias.setForeground(new java.awt.Color(0, 0, 51));
        btnUrgencias.setText("Urgencias");
        btnUrgencias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnUrgencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 120, 40));

        btnEntradas.setBackground(new java.awt.Color(204, 204, 204));
        btnEntradas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEntradas.setForeground(new java.awt.Color(0, 0, 51));
        btnEntradas.setText("Entradas/salidas");
        btnEntradas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradasActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 120, 40));

        btnPagar.setBackground(new java.awt.Color(204, 204, 204));
        btnPagar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(0, 0, 51));
        btnPagar.setText("Pagar orden");
        btnPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 120, 40));

        btnConfirmar.setBackground(new java.awt.Color(204, 204, 204));
        btnConfirmar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(0, 0, 51));
        btnConfirmar.setText("Confirmar cita");
        btnConfirmar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 120, 40));

        btnAgendar.setBackground(new java.awt.Color(204, 204, 204));
        btnAgendar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAgendar.setForeground(new java.awt.Color(0, 0, 51));
        btnAgendar.setText("Agendar");
        btnAgendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgendar.setContentAreaFilled(false);
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 110, 30));

        btnCancelaciones.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelaciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCancelaciones.setForeground(new java.awt.Color(0, 0, 51));
        btnCancelaciones.setText("Cancelaciones");
        btnCancelaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnCancelaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 120, 40));

        btnReagendar.setBackground(new java.awt.Color(204, 204, 204));
        btnReagendar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReagendar.setForeground(new java.awt.Color(0, 0, 51));
        btnReagendar.setText("Reagendar");
        btnReagendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnReagendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 120, 40));

        LabelAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agendarmenu1.png"))); // NOI18N
        getContentPane().add(LabelAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabelConCita.setText("jLabel1");
        getContentPane().add(jLabelConCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        jLabelPO.setText("jLabel1");
        getContentPane().add(jLabelPO, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        jLabelEYS.setText("jLabel1");
        getContentPane().add(jLabelEYS, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        jLabelUrge.setText("jLabel1");
        getContentPane().add(jLabelUrge, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        jLabelCancelar.setText("jLabel1");
        getContentPane().add(jLabelCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        jLabelREAgendar.setText("jLabel1");
        getContentPane().add(jLabelREAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntradasActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgendarActionPerformed

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
    private javax.swing.JLabel LabelAgenda;
    public javax.swing.JButton btnAgendar;
    public javax.swing.JButton btnCancelaciones;
    public javax.swing.JButton btnConfirmar;
    public javax.swing.JButton btnCortes;
    public javax.swing.JButton btnEntradas;
    public javax.swing.JButton btnPagar;
    public javax.swing.JButton btnReagendar;
    public javax.swing.JButton btnUrgencias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCancelar;
    private javax.swing.JLabel jLabelConCita;
    private javax.swing.JLabel jLabelEYS;
    private javax.swing.JLabel jLabelPO;
    private javax.swing.JLabel jLabelREAgendar;
    private javax.swing.JLabel jLabelUrge;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
