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
public class DatosFacturacionVista extends javax.swing.JFrame {

    /**
     * Creates new form DatosFacturacion
     */
    public DatosFacturacionVista() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtRfc = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboCfdi = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboMetodoPago = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnMin = new javax.swing.JButton();
        jLabelLOGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nombre o raz??n social");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("RFC");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 51));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar2.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setContentAreaFilled(false);
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 100, 30));
        jPanel2.add(txtRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 240, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 240, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Calle");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        jPanel2.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 240, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Colonia");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));
        jPanel2.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 240, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("CP");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 60, -1));
        jPanel2.add(txtCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 280, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Ciudad");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 80, -1));
        jPanel2.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 280, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Correo electr??nico");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 150, -1));
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 280, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Uso CFDI");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 100, -1));
        jPanel2.add(comboCfdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 280, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("M??todo de pago");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        jPanel2.add(comboMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 240, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Total");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 20, 70, -1));
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 280, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 660, 500));

        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/minSecundario.png"))); // NOI18N
        btnMin.setContentAreaFilled(false);
        jPanel1.add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 20, 30));

        jLabelLOGO.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLOGO.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabelLOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 160, 45));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DatosFacturacionVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosFacturacionVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosFacturacionVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosFacturacionVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosFacturacionVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnMin;
    public javax.swing.JComboBox<String> comboCfdi;
    public javax.swing.JComboBox<String> comboMetodoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLOGO;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtCalle;
    public javax.swing.JTextField txtCiudad;
    public javax.swing.JTextField txtColonia;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtCp;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtRfc;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
