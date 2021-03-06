/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PI17;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Fidel
 */
public class Especialistas extends javax.swing.JFrame {

    /**
     * Creates new form Especialistas
     */
    
    Principal p;
    Connection con;
    DBConection db;
    Especialista e;
    
    public Especialistas() {
        initComponents();
        myInitComponents();
        
    }
    
    public Especialistas(Especialista e){
        initComponents();
        this.e=e;
        myInitComponents();
    }
    
    public void Principal(Principal p){
        this.p=p;
    }
    
    public void mostrarEspecialistas(){
        try {
            db.comando = (Statement) db.conexion.createStatement();
            String query="SELECT * FROM Especialistas WHERE No_Trabajador!="+e.getNo_Trabajador()+" ORDER BY 1 ASC";
            db.registro = db.comando.executeQuery(query);
            DefaultListModel modelo=new DefaultListModel();
            while (db.registro.next()) {
                modelo.addElement(db.registro.getString(1));
            }
            lstEspecialistas.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Especialistas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrarAreas(){
        try {
            cbxDepartamento.addItem("---SELECCIONE DPTO---");
            db.comando = (Statement) db.conexion.createStatement();
            String query="SELECT Nombre FROM Departamento ORDER BY 1 ASC";
            db.registro = db.comando.executeQuery(query);
            while(db.registro.next()){
                cbxDepartamento.addItem(db.registro.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Especialistas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void myInitComponents(){
        db=new DBConection();
        con=db.MySQLConnect();
        
        mostrarEspecialistas();
        mostrarAreas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEspecialistas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        cbxDepartamento = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lstEspecialistas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEspecialistasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEspecialistas);

        jLabel1.setText("----------------------------------------------------------------------------");

        jButton1.setText("Agregar nuevo especialista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nº Trabajador:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Correo:");

        jLabel5.setText("Departamento:");

        txtNo.setEditable(false);

        txtNombre.setEditable(false);

        txtCorreo.setEditable(false);

        cbxDepartamento.setEnabled(false);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar Especialista");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar))
                            .addComponent(txtNo)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(cbxDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnActualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        p.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void lstEspecialistasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEspecialistasValueChanged
        try {
            db.comando = (Statement) db.conexion.createStatement();
            String query="SELECT * FROM Especialistas WHERE No_Trabajador="+lstEspecialistas.getSelectedValue()+" ORDER BY 1 ASC";
            db.registro = db.comando.executeQuery(query);
            while(db.registro.next()){
                txtNo.setText(db.registro.getString(1));
                txtNombre.setText(db.registro.getString(3));
                txtCorreo.setText(db.registro.getString(4));
                int cont=1;
                while(!cbxDepartamento.getItemAt(cont).equals(db.registro.getString(5))){
                    cont++;
                }
                cbxDepartamento.setSelectedIndex(cont);
            }
            txtNombre.setEditable(true);
            txtCorreo.setEditable(true);
            cbxDepartamento.setEnabled(true);
            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(Especialistas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lstEspecialistasValueChanged

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (cbxDepartamento.getSelectedIndex()!=0) {
            try {
                db.comando = (Statement) db.conexion.createStatement();
                String query="UPDATE Especialistas SET Nombre='"+txtNombre.getText()+"', Correo='"+txtCorreo.getText()+"', Departamento='"+cbxDepartamento.getSelectedItem()+"' WHERE No_Trabajador="+txtNo.getText()+"";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "El especialista ha sido actualizado", "Correcto", 1);
                mostrarEspecialistas();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha podido actualizar especialista", "Error", 1);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un departamento correcto", "Error", 2);
            
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opc=JOptionPane.showConfirmDialog(null, "Estas seguro de realizar esta accion?\nEsta opcion no se puede deshacer");
        if (opc==JOptionPane.YES_OPTION) {
            try {
                db.comando = (Statement) db.conexion.createStatement();
                String query="DELETE FROM Especialistas WHERE No_Trabajador="+txtNo.getText();
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "El especialista se ha eliminado correctamente", "Correcto", 1);
                mostrarEspecialistas();
                txtNo.setText("");
                txtNombre.setText("");
                txtCorreo.setText("");
                cbxDepartamento.setSelectedIndex(1);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha podido eliminar especialista", "Error", 2);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    String pass;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String i=(JOptionPane.showInputDialog(null,"Numero del trabajador (Este debe estar registrado como usuario)"));
        if (i!=null) {
            try {
                int num=Integer.parseInt(i);
                db.comando = (Statement) db.conexion.createStatement();
                String query="SELECT * FROM Usuarios WHERE Id_Usuario="+num+" AND Tipo_Usuario='Trabajador' AND Id_Usuario!="+e.getNo_Trabajador();
                db.registro = db.comando.executeQuery(query);
                if (db.registro.next()) {
                    txtNo.setText(db.registro.getString(1));
                    pass=db.registro.getString(2);
                    txtNombre.setText(db.registro.getString(3));
                    txtCorreo.setText(db.registro.getString(4));
                    cbxDepartamento.setSelectedIndex(0);
                    cbxDepartamento.setEnabled(true);
                    btnActualizar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnAgregar.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro trabajador","Error",2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Especialistas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Escriba un numero de trabajador correcto");
                jButton1ActionPerformed(evt);
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
         if (cbxDepartamento.getSelectedIndex()!=0) {
             try {
                 db.comando = (Statement) db.conexion.createStatement();
                 String query="INSERT INTO Especialistas (No_Trabajador, Contraseña, Nombre, Correo, Departamento) VALUES ("+txtNo.getText()+",'"+pass+"','"+txtNombre.getText()+"','"+txtCorreo.getText()+"','"+cbxDepartamento.getSelectedItem()+"')";
                 System.out.println(query);
                 PreparedStatement preparedStmt = con.prepareStatement(query);
                 preparedStmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Se ha agregado el especialista, use la misma contraseña creada de la pagina web para acceder");
                 mostrarEspecialistas();
             } catch (SQLException ex) {
                 System.out.println(ex);
                 
             }
        }else{
             JOptionPane.showMessageDialog(null, "Seleccione un departamento correcto", "Error", 2);
         }
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(Especialistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Especialistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Especialistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Especialistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Especialistas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxDepartamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstEspecialistas;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
