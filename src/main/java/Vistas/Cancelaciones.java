/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author alanm
 */
public class Cancelaciones extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarVenta
     */
    public Cancelaciones() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEstudios = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        comboPaciente = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOrdenes = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        dateFecha = new com.toedter.calendar.JDateChooser();
        btnRegresar = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLCanOrden = new javax.swing.JLabel();
        jLabelRegresar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnMin = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabelLOGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(tableEstudios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 520, 190));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Paciente");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jPanel1.add(comboPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 330, -1));

        jScrollPane2.setViewportView(tableOrdenes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 520, 190));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Fecha");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));
        jPanel1.add(dateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 160, -1));

        btnRegresar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegresar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 51));
        btnRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresar.setContentAreaFilled(false);
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 40, 40));
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 670, 210, 20));

        jLabel5.setText("Fecha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 650, -1, 20));
        jPanel1.add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 330, -1));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 51));
        btnCancelar.setText("Cancelar órden");
        btnCancelar.setBorder(null);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 350, 110, 20));

        jLCanOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar-orden2.png"))); // NOI18N
        jLCanOrden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLCanOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 340, 140, -1));

        jLabelRegresar.setBackground(new java.awt.Color(204, 204, 204));
        jLabelRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/flecha-regresar.png"))); // NOI18N
        jLabelRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabelRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 40, 40));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1090, 320));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CerrarSecundario.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 20, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/minSecundario.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, -1, 30));

        btnMin.setText("jButton2");
        btnMin.setContentAreaFilled(false);
        jPanel1.add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1093, 0, 30, 30));

        btnSalir.setContentAreaFilled(false);
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1123, 0, 40, 30));

        jLabelLOGO.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLOGO.setText("LOGO");
        jLabelLOGO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabelLOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, 45));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Cancelaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cancelaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cancelaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cancelaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cancelaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnMin;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> comboPaciente;
    public com.toedter.calendar.JDateChooser dateFecha;
    public com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLCanOrden;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelLOGO;
    private javax.swing.JLabel jLabelRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableEstudios;
    public javax.swing.JTable tableOrdenes;
    public javax.swing.JTextField txtPaciente;
    // End of variables declaration//GEN-END:variables
}
