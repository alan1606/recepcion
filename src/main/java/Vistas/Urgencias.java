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
public class Urgencias extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarVenta
     */
    public Urgencias() {
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
        btnCancelar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnNuevoPaciente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        btnRegresar = new javax.swing.JButton();
        btnFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Buscar paciente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 670, -1));

        radioNombre.setText("Nombre");
        jPanel1.add(radioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        radioCurp.setText("CURP");
        jPanel1.add(radioCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        jScrollPane1.setViewportView(tableEstudios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 470, 420));

        jLabel2.setText("Paciente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, -1, 20));
        jPanel1.add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 160, 20));

        jLabel3.setText("Área");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        jPanel1.add(comboArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 120, -1));

        jLabel4.setText("Estudio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, -1, -1));

        jPanel1.add(comboEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, 330, -1));

        jLabel6.setText("Convenio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, -1, 20));

        jPanel1.add(comboInstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 670, 190, 20));

        jLabel7.setText("Hora");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 100, -1, 20));

        jPanel1.add(comboHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 120, 120, -1));

        jLabel10.setText("Sala");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        jPanel1.add(comboSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 330, -1));

        tablePacientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablePacientesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablePacientes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 670, 460));

        btnAgregar.setText("Agregar");
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 180, -1, -1));

        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 670, -1, 30));

        btnCancelar.setText("Limpiar");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 670, -1, 30));

        btnQuitar.setText("Quitar");
        jPanel1.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 180, -1, -1));

        btnNuevoPaciente.setText("Nuevo paciente");
        jPanel1.add(btnNuevoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, -1));

        jLabel5.setText("Fecha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 650, -1, 20));
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 670, 210, 20));

        btnRegresar.setText("Regresar");
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        btnFoto.setText("Agregar foto de órden");
        jPanel1.add(btnFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 670, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Urgencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Urgencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Urgencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Urgencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Urgencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnFoto;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevoPaciente;
    public javax.swing.JButton btnQuitar;
    public javax.swing.JButton btnRegresar;
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
    private javax.swing.JPanel jPanel1;
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