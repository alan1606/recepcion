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
public class NuevoPaciente extends javax.swing.JFrame {

    /**
     * Creates new form NuevoPaciente
     */
    public NuevoPaciente() {
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
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        dateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        comboSexo = new javax.swing.JComboBox<>();
        comboPais = new javax.swing.JComboBox<>();
        comboEntidad = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtNombre.setNextFocusableComponent(txtApellidoPaterno);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 270, -1));

        jLabel2.setText("Apellido paterno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        txtApellidoPaterno.setNextFocusableComponent(txtApellidoMaterno);
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 270, -1));

        jLabel3.setText("Apellido materno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        txtApellidoMaterno.setNextFocusableComponent(dateFechaNacimiento);
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 270, -1));

        jLabel4.setText("Fecha de nacimiento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel5.setText("Sexo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        jLabel6.setText("País de orígen");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        jLabel7.setText("Entidad de nacimiento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jLabel8.setText("CURP ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, -1, -1));

        txtCurp.setNextFocusableComponent(btnGuardar);
        jPanel1.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 270, -1));

        jLabel9.setText("Teléfono");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, -1, -1));

        txtTelefono.setNextFocusableComponent(txtCurp);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 270, -1));

        jLabel10.setText("Correo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));

        txtCorreo.setNextFocusableComponent(txtTelefono);
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 270, -1));

        dateFechaNacimiento.setNextFocusableComponent(comboPais);
        jPanel1.add(dateFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 270, -1));

        comboSexo.setNextFocusableComponent(txtCorreo);
        jPanel1.add(comboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 270, -1));

        comboPais.setNextFocusableComponent(comboEntidad);
        comboPais.setOpaque(false);
        jPanel1.add(comboPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 270, -1));

        comboEntidad.setNextFocusableComponent(comboSexo);
        jPanel1.add(comboEntidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 270, -1));

        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 630, -1, -1));

        btnCancelar.setText("Cancelar");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, -1, -1));

        btnLimpiar.setText("Limpiar");
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 630, -1, -1));

        btnRegresar.setText("Regresar");
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(NuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JComboBox<String> comboEntidad;
    public javax.swing.JComboBox<String> comboPais;
    public javax.swing.JComboBox<String> comboSexo;
    public com.toedter.calendar.JDateChooser dateFechaNacimiento;
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
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtApellidoMaterno;
    public javax.swing.JTextField txtApellidoPaterno;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtCurp;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
