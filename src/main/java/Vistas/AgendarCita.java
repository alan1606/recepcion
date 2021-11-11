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
public class AgendarCita extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarVenta
     */
    public AgendarCita() {
        try {
                    initComponents();

        } catch (Exception e) {
            e.printStackTrace(System.out);
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
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        radioNombre = new javax.swing.JRadioButton();
        radioCurp = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEstudios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboEstudio = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboInstitucion = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboHora = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboSala = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevoPaciente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        btnRegresar = new javax.swing.JButton();
        btnFoto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnModificarPaciente = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnMin = new javax.swing.JButton();
        jLabelLOGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Buscar paciente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 670, -1));

        radioNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radioNombre.setText("Nombre");
        jPanel1.add(radioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        radioCurp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radioCurp.setText("CURP");
        jPanel1.add(radioCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        jScrollPane1.setViewportView(tableEstudios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 470, 320));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Paciente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 20));
        jPanel1.add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 160, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Área");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, -1, -1));

        jPanel1.add(comboArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 120, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Estudio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, -1, -1));

        jPanel1.add(comboEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, 330, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Convenio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, -1, 20));

        jPanel1.add(comboInstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 190, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Hora");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 130, -1, 20));

        jPanel1.add(comboHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 150, 120, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Sala");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, -1, -1));

        jPanel1.add(comboSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 330, -1));

        tablePacientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablePacientesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablePacientes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 670, 370));

        btnAgregar.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 51));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar2.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.setContentAreaFilled(false);
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 190, 100, 30));

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 51));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar2.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setContentAreaFilled(false);
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1141, 570, 100, 30));

        btnNuevoPaciente.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevoPaciente.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNuevoPaciente.setForeground(new java.awt.Color(0, 0, 51));
        btnNuevoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/anadir-Paciente2.png"))); // NOI18N
        btnNuevoPaciente.setText("Nuevo paciente");
        btnNuevoPaciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevoPaciente.setContentAreaFilled(false);
        jPanel1.add(btnNuevoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 150, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Fecha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, -1, 20));
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, 210, 20));

        btnRegresar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegresar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 51));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/flecha-regresar.png"))); // NOI18N
        btnRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 40));

        btnFoto.setBackground(new java.awt.Color(204, 204, 204));
        btnFoto.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnFoto.setForeground(new java.awt.Color(0, 0, 51));
        btnFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camara2.png"))); // NOI18N
        btnFoto.setText("Agregar órden");
        btnFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFoto.setContentAreaFilled(false);
        jPanel1.add(btnFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 570, 140, 30));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificarPaciente.setBackground(new java.awt.Color(204, 204, 204));
        btnModificarPaciente.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnModificarPaciente.setForeground(new java.awt.Color(0, 0, 51));
        btnModificarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        btnModificarPaciente.setText("Modificar paciente");
        btnModificarPaciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificarPaciente.setContentAreaFilled(false);
        jPanel3.add(btnModificarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 160, 30));

        btnQuitar.setBackground(new java.awt.Color(204, 204, 204));
        btnQuitar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(0, 0, 51));
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar2.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnQuitar.setContentAreaFilled(false);
        jPanel3.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 130, -1, 30));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/limpiar2.png"))); // NOI18N
        btnCancelar.setText("Limpiar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setContentAreaFilled(false);
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 90, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1220, 560));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CerrarSecundario.png"))); // NOI18N
        btnSalir.setContentAreaFilled(false);
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 30, 30));

        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/minSecundario.png"))); // NOI18N
        btnMin.setContentAreaFilled(false);
        jPanel1.add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 30, 30));

        jLabelLOGO.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLOGO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabelLOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 160, 45));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tablePacientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablePacientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePacientesKeyReleased

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
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnFoto;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnMin;
    public javax.swing.JButton btnModificarPaciente;
    public javax.swing.JButton btnNuevoPaciente;
    public javax.swing.JButton btnQuitar;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> comboArea;
    public javax.swing.JComboBox<String> comboEstudio;
    public javax.swing.JComboBox<String> comboHora;
    public javax.swing.JComboBox<String> comboInstitucion;
    public javax.swing.JComboBox<String> comboSala;
    public com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelLOGO;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JRadioButton radioCurp;
    public javax.swing.JRadioButton radioNombre;
    public javax.swing.JTable tableEstudios;
    public javax.swing.JTable tablePacientes;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtPaciente;
    // End of variables declaration//GEN-END:variables
}
