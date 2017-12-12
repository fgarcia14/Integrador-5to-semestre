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
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     * @param e
     * @param c
     */
    Especialista e;
    Connection c;
    DBConection db;
    Tickets t;
    
    public Principal(Especialista e, Connection c, DBConection db){
        this.e=e;
        this.c=c;
        this.db=db;
        t=new Tickets();
        initComponents();
        MyInitComponents();
        
    }
    
    public Principal(){
        initComponents();
        
        MyInitComponents();
    }
    
    private void cbx1Area(){
        try {
            String query="SELECT Nombre FROM Departamento ORDER BY 1 DESC;";
            db.comando = (Statement) db.conexion.createStatement();
            db.registro = db.comando.executeQuery(query);
            int cont=0;
            int cont2=0;
            boolean ban=false;
            while(db.registro.next()){
                cbxAreas1.addItem(db.registro.getString(1));
                cbx1Areas.addItem(db.registro.getString(1));
                if (db.registro.getString(1).equals(e.getDepartamento())) {
                    ban=true;
                    cont2=cont;
                }
                cont++;
            }
            if (ban) {
                cbxAreas1.setSelectedIndex(cont2);
            }
            mostrar1TicketsArea();
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrar1TicketsArea(){
        try {
            String area;
            area = (String) cbxAreas1.getSelectedItem();
            //System.out.println(area);
            t=null;
            t=new Tickets();
            db.comando = (Statement) db.conexion.createStatement();
            String query="SELECT * FROM Ticket WHERE Departamento='"+area+"' AND Estado='Pendiente de revisión' ORDER BY 1 DESC";
            db.registro = db.comando.executeQuery(query);
            DefaultListModel modelo=null; 
            modelo = new DefaultListModel();
            while(db.registro.next()){
                Ticket tk=new Ticket(db.registro.getInt(1), db.registro.getInt(2), db.registro.getString(3), db.registro.getString(4), db.registro.getString(5), db.registro.getString(6),db.registro.getString(7), db.registro.getString(8), db.registro.getInt(9), db.registro.getString(10));
                t.agregar(tk);
                modelo.addElement("Ticket Nº "+tk.getNo_Ticket());
            }
            
            lstTicketsDep.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrar2TicketsEspecialista(){
        try {
            db.comando=(Statement) db.conexion.createStatement();
            String query="SELECT * FROM Ticket WHERE Especialista='"+e.getNo_Trabajador()+"' ORDER BY 1 DESC;";
            db.registro=db.comando.executeQuery(query);
            DefaultListModel modelo=null;
            modelo=new DefaultListModel();
            
            Tickets tEsp=new Tickets();
            while(db.registro.next()){
                Ticket t=new Ticket(db.registro.getInt(1), db.registro.getInt(2), db.registro.getString(3), db.registro.getString(4), db.registro.getString(5), db.registro.getString(6),db.registro.getString(7), db.registro.getString(8), db.registro.getInt(9), db.registro.getString(10));
                tEsp.agregar(t);
                if (db.registro.getString(8).equals("Ticket tomado por especialista, esperando respuesta")) {
                    modelo.addElement("Pendiente: Ticket Nº "+t.getNo_Ticket());
                }else{
                    modelo.addElement("En proceso: Ticket Nº"+t.getNo_Ticket());
                }
            }
            lst2TicktetsEsp.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrar3TicketsUsuarios(int No_Usuario){
        try {
            db.comando=(Statement) db.conexion.createStatement();
            String query="SELECT * FROM Usuarios WHERE Id_Usuario="+No_Usuario+";";
            db.registro=db.comando.executeQuery(query);
            if (db.registro.next()) {
                db.comando=(Statement) db.conexion.createStatement();
                query="SELECT No_Ticket, Estado FROM Ticket WHERE Id_Usuario="+No_Usuario+";";
                DefaultListModel modelo=new DefaultListModel();
                db.registro=db.comando.executeQuery(query);
                while(db.registro.next()){
                    if (!db.registro.getString(2).equals("Finalizado") && !db.registro.getString(2).equals("Cancelado")) {
                        modelo.addElement("Sin finalizar: Ticket Nº "+db.registro.getString(1));
                    }else{
                        modelo.addElement("Finalizado: Ticket Nº "+db.registro.getString(1));
                    }
                }
                lst3TicketsUsuario.setModel(modelo);
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el usuario con la cuenta "+No_Usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void mostrar4info(){
        try {
            txt4NoTrabajador.setText(String.valueOf(e.getNo_Trabajador()));
            txt4Nombre.setText(e.getNombre());
            txt4Area.setText(e.getDepartamento());
            txt4Correo.setText(e.getCorreo());
            db.comando=(Statement) db.conexion.createStatement();
            String query="SELECT COUNT(*) FROM Ticket WHERE Especialista="+e.getNo_Trabajador();
            db.registro=db.comando.executeQuery(query);
            db.registro.next();                  
            txt4NoTickets.setText(db.registro.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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

        Pestañas = new javax.swing.JTabbedPane();
        pnlTicketsDisponibles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTicketsDep = new javax.swing.JList<>();
        cbxAreas1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt1NoTicket = new javax.swing.JTextField();
        txt1Usuario = new javax.swing.JTextField();
        txt1Cuenta = new javax.swing.JTextField();
        txt1Fecha = new javax.swing.JTextField();
        txt1Tipo = new javax.swing.JTextField();
        cbx1Areas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt1NotasUser = new javax.swing.JTextArea();
        btn1Tomar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btn1Cambiar = new javax.swing.JButton();
        pnlMisTickets = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lst2TicktetsEsp = new javax.swing.JList<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt2NoTicket = new javax.swing.JTextField();
        txt2Usuario = new javax.swing.JTextField();
        txt2TipoUsuario = new javax.swing.JTextField();
        txt2Contacto = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt2NotasUsuario = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt2NotasEsp = new javax.swing.JTextArea();
        cbx2Estado = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        lblUser3 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cbx2Prioridad = new javax.swing.JComboBox<>();
        pnlTicketsUsuarios = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt3NoUsuario = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt3Nombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt3NoTicket = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        lst3TicketsUsuario = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt3NotasUsuario = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt3NotasEspecialista = new javax.swing.JTextArea();
        btn3DetallesTicket = new javax.swing.JButton();
        lblUser2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txt3Fecha = new javax.swing.JTextField();
        btn3DetallesUsuario = new javax.swing.JButton();
        pnlOpciones = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt4NoTrabajador = new javax.swing.JTextField();
        txt4Nombre = new javax.swing.JTextField();
        txt4Area = new javax.swing.JTextField();
        txt4Correo = new javax.swing.JTextField();
        txt4NoTickets = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        lblUser4 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mesa de ayuda UCOL");
        setResizable(false);

        Pestañas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PestañasMouseClicked(evt);
            }
        });

        lstTicketsDep.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Ticket 1", "Ticket 2", "Ticket 3", "Ticket 4" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstTicketsDep.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTicketsDepValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstTicketsDep);

        cbxAreas1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAreas1ItemStateChanged(evt);
            }
        });

        jLabel1.setText("Nº de Ticket:");

        jLabel2.setText("Usuario solicitante:");

        jLabel3.setText("Tipo de usuario:");

        jLabel4.setText("Fecha y hora:");

        jLabel5.setText("Nº de cuenta/trabajador:");

        jLabel6.setText("Notas del usuario:");

        jLabel7.setText("Area:");

        txt1NoTicket.setEditable(false);

        txt1Usuario.setEditable(false);

        txt1Cuenta.setEditable(false);

        txt1Fecha.setEditable(false);

        txt1Tipo.setEditable(false);

        jScrollPane2.setHorizontalScrollBar(null);

        txt1NotasUser.setEditable(false);
        txt1NotasUser.setColumns(20);
        txt1NotasUser.setLineWrap(true);
        txt1NotasUser.setRows(5);
        txt1NotasUser.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(txt1NotasUser);

        btn1Tomar.setText("Tomar ticket");
        btn1Tomar.setEnabled(false);
        btn1Tomar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1TomarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Seleccione un ticket en el panel derecho");

        lblUser.setText("jLabel27");

        btn1Cambiar.setText("Cambiar");
        btn1Cambiar.setEnabled(false);
        btn1Cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1CambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTicketsDisponiblesLayout = new javax.swing.GroupLayout(pnlTicketsDisponibles);
        pnlTicketsDisponibles.setLayout(pnlTicketsDisponiblesLayout);
        pnlTicketsDisponiblesLayout.setHorizontalGroup(
            pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                        .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(22, 22, 22))
                            .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)))
                        .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt1Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt1Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt1Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt1Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt1NoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                                .addComponent(cbx1Areas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn1Cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                        .addComponent(btn1Tomar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGap(29, 29, 29)
                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAreas1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
            .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTicketsDisponiblesLayout.setVerticalGroup(
            pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTicketsDisponiblesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt1NoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbxAreas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                        .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cbx1Areas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn1Cambiar))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt1Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt1Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt1Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(pnlTicketsDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt1Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(63, 63, 63)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn1Tomar))
                    .addGroup(pnlTicketsDisponiblesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser))
        );

        Pestañas.addTab("Tickets disponibles", pnlTicketsDisponibles);

        pnlMisTickets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lst2TicktetsEsp.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst2TicktetsEspValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(lst2TicktetsEsp);

        pnlMisTickets.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 35, 201, 425));

        jLabel16.setText("Nº Ticket:");
        pnlMisTickets.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 40, -1, -1));

        jLabel17.setText("Usuario:");
        pnlMisTickets.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 72, -1, -1));

        jLabel18.setText("Tipo de usuario:");
        pnlMisTickets.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 104, -1, -1));

        jLabel19.setText("Contacto:");
        pnlMisTickets.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 136, -1, -1));

        jLabel20.setText("Notas del usuario:");
        pnlMisTickets.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 163, -1, -1));

        jLabel22.setText("Notas del especialista:");
        pnlMisTickets.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 259, -1, -1));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Estado del ticket:");
        pnlMisTickets.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 142, -1));

        txt2NoTicket.setEditable(false);
        pnlMisTickets.add(txt2NoTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 35, 244, -1));

        txt2Usuario.setEditable(false);
        pnlMisTickets.add(txt2Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 67, 244, -1));

        txt2TipoUsuario.setEditable(false);
        pnlMisTickets.add(txt2TipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 99, 244, -1));

        txt2Contacto.setEditable(false);
        pnlMisTickets.add(txt2Contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 131, 244, -1));

        txt2NotasUsuario.setEditable(false);
        txt2NotasUsuario.setColumns(20);
        txt2NotasUsuario.setLineWrap(true);
        txt2NotasUsuario.setRows(5);
        jScrollPane7.setViewportView(txt2NotasUsuario);

        pnlMisTickets.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 163, -1, -1));

        txt2NotasEsp.setColumns(20);
        txt2NotasEsp.setLineWrap(true);
        txt2NotasEsp.setRows(5);
        jScrollPane8.setViewportView(txt2NotasEsp);

        pnlMisTickets.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 259, -1, -1));

        cbx2Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ticket tomado por especialista, esperando respuesta", "Resolviendo problematica", "Cancelado", "Finalizado" }));
        pnlMisTickets.add(cbx2Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 398, 244, -1));

        jButton4.setText("Aceptar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnlMisTickets.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 431, 244, -1));

        lblUser3.setText("jLabel27");
        pnlMisTickets.add(lblUser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 701, -1));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Prioridad:");
        pnlMisTickets.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 359, 142, -1));

        cbx2Prioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Seleccione una opcion---", "Alta", "Media", "Baja" }));
        pnlMisTickets.add(cbx2Prioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 355, 240, -1));

        Pestañas.addTab("Mis tickets", pnlMisTickets);

        jLabel10.setText("Nº de cuenta/trabajador:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("-----------------------------------------------------------------------------------");

        jLabel12.setText("Nombre:");

        txt3Nombre.setEditable(false);

        jLabel13.setText("Nº de Ticket:");

        txt3NoTicket.setEditable(false);

        lst3TicketsUsuario.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst3TicketsUsuarioValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lst3TicketsUsuario);

        jLabel14.setText("Notas del usuario:");

        txt3NotasUsuario.setEditable(false);
        txt3NotasUsuario.setColumns(20);
        txt3NotasUsuario.setLineWrap(true);
        txt3NotasUsuario.setRows(5);
        jScrollPane4.setViewportView(txt3NotasUsuario);

        jLabel15.setText("Notas del especialista:");

        txt3NotasEspecialista.setEditable(false);
        txt3NotasEspecialista.setColumns(20);
        txt3NotasEspecialista.setLineWrap(true);
        txt3NotasEspecialista.setRows(5);
        jScrollPane5.setViewportView(txt3NotasEspecialista);

        btn3DetallesTicket.setText("Detalles de ticket");
        btn3DetallesTicket.setEnabled(false);
        btn3DetallesTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3DetallesTicketActionPerformed(evt);
            }
        });

        lblUser2.setText("jLabel27");

        jLabel28.setText("Fecha:");

        txt3Fecha.setEditable(false);

        btn3DetallesUsuario.setText("Detalles de usuario");
        btn3DetallesUsuario.setEnabled(false);
        btn3DetallesUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3DetallesUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTicketsUsuariosLayout = new javax.swing.GroupLayout(pnlTicketsUsuarios);
        pnlTicketsUsuarios.setLayout(pnlTicketsUsuariosLayout);
        pnlTicketsUsuariosLayout.setHorizontalGroup(
            pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTicketsUsuariosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txt3NoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(pnlTicketsUsuariosLayout.createSequentialGroup()
                .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTicketsUsuariosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE))
                    .addGroup(pnlTicketsUsuariosLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt3NoTicket)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane5)
                            .addComponent(txt3Fecha)
                            .addGroup(pnlTicketsUsuariosLayout.createSequentialGroup()
                                .addComponent(txt3Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn3DetallesUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn3DetallesTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblUser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTicketsUsuariosLayout.setVerticalGroup(
            pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTicketsUsuariosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt3NoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTicketsUsuariosLayout.createSequentialGroup()
                        .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt3Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn3DetallesUsuario))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt3NoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(pnlTicketsUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txt3Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn3DetallesTicket))
                    .addComponent(jScrollPane3))
                .addGap(30, 30, 30)
                .addComponent(lblUser2))
        );

        Pestañas.addTab("Tickets de usuarios", pnlTicketsUsuarios);

        jLabel9.setText("Nº de trabajador:");

        jLabel21.setText("Nombre completo:");

        jLabel24.setText("Area:");

        jLabel25.setText("Nº de tickets atendidos:");

        jLabel26.setText("Correo:");

        txt4NoTrabajador.setEditable(false);

        txt4Nombre.setEditable(false);

        txt4Area.setEditable(false);

        txt4Correo.setEditable(false);

        txt4NoTickets.setEditable(false);

        jButton9.setText("Cambiar contraseña");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Cerrar Sesion");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        lblUser4.setText("jLabel27");

        jLabel29.setText("----------------------------------------------");

        jLabel30.setText("----------------------------------------------");

        jButton17.setText("Ver escuelas");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Ver Departamentos");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Ver Especialistas");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel29)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlOpcionesLayout.createSequentialGroup()
                            .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel26)
                                .addComponent(jLabel25)
                                .addComponent(jLabel24)
                                .addComponent(jLabel21)
                                .addComponent(jLabel9))
                            .addGap(18, 18, 18)
                            .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt4NoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txt4Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txt4Area, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txt4Correo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txt4NoTickets, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                        .addGroup(pnlOpcionesLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel30))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt4NoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt4Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt4Area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txt4Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt4NoTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser4))
        );

        Pestañas.addTab("Opciones", pnlOpciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pestañas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pestañas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    boolean banCbxAreas=true;
    private void cbxAreas1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAreas1ItemStateChanged
        banCbxAreas=!banCbxAreas;
        if(banCbxAreas){
            mostrar1TicketsArea();
        }
    }//GEN-LAST:event_cbxAreas1ItemStateChanged

    
    private void lstTicketsDepValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTicketsDepValueChanged
        banCbxAreas=!banCbxAreas;
        if (banCbxAreas) {
            try {
                String a = lstTicketsDep.getSelectedValue();
                String n="";
                for (int i = 0; i < a.length(); i++) {
                    if (Character.isDigit(a.charAt(i))) {
                        n+=a.charAt(i);
                    }
                }
                int No_Ticket=Integer.parseInt(n);             
                db.comando = (Statement) db.conexion.createStatement();
                String query="SELECT T.No_Ticket, U.Nombre, U.Id_Usuario, U.Tipo_Usuario, T.Fecha, T.Departamento, T.Mensaje, T.Asunto FROM Ticket T INNER JOIN Usuarios U ON T.Id_Usuario=U.Id_Usuario WHERE T.No_Ticket="+No_Ticket+";";
                db.registro = db.comando.executeQuery(query);
                while(db.registro.next()){
                    txt1NoTicket.setText(db.registro.getString(1));
                    txt1Usuario.setText(db.registro.getString(2));
                    txt1Cuenta.setText(db.registro.getString(3));
                    txt1Tipo.setText(db.registro.getString(4));
                    txt1Fecha.setText(db.registro.getString(5));
                    for (int i = 0; i < cbx1Areas.getItemCount(); i++) {
                        if (db.registro.getString(6).toLowerCase().equals(cbx1Areas.getItemAt(i).toLowerCase())) {
                            cbx1Areas.setSelectedIndex(i);
                        }
                    }
                    txt1NotasUser.setText("Asunto: "+db.registro.getString(8)+"\n\nMensaje:\n"+db.registro.getString(7));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        btn1Tomar.setEnabled(true);
        btn1Cambiar.setEnabled(true);
    }//GEN-LAST:event_lstTicketsDepValueChanged

    private void btn1CambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1CambiarActionPerformed
        try {
            int No_Ticket=Integer.parseInt(txt1NoTicket.getText());
            db.comando = (Statement) db.conexion.createStatement();
            String query="UPDATE Ticket SET Departamento='"+cbx1Areas.getSelectedItem()+"' WHERE No_Ticket="+No_Ticket+";";
            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado el departamento del ticket");
            mostrar1TicketsArea();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn1CambiarActionPerformed

    private void btn1TomarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1TomarActionPerformed
        try {
            int No_Ticket=Integer.parseInt(txt1NoTicket.getText());
            db.comando = (Statement) db.conexion.createStatement();
            String query="UPDATE Ticket SET Especialista="+e.getNo_Trabajador()+", Estado='Ticket tomado por especialista, esperando respuesta' WHERE No_Ticket="+No_Ticket+";";
            PreparedStatement p = c.prepareStatement(query);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha tomado el ticket, puedes consultarlo en Mis Tickets");
            mostrar1TicketsArea();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn1TomarActionPerformed

    private void PestañasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PestañasMouseClicked
        switch(Pestañas.getSelectedIndex()){
            case 0:
                mostrar1TicketsArea();
            break;
            case 1:
                mostrar2TicketsEspecialista();
                break;
            case 3:
                mostrar4info();
        }
    }//GEN-LAST:event_PestañasMouseClicked
    
    boolean banLstTicketsEsp=true;
    private void lst2TicktetsEspValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst2TicktetsEspValueChanged
        //banLstTicketsEsp=!banLstTicketsEsp;
        if (banLstTicketsEsp) {
            try {
                String a=lst2TicktetsEsp.getSelectedValue();
                String n="";
                for (int i = 0; i < a.length(); i++) {
                    if (Character.isDigit(a.charAt(i))) {
                        n+=a.charAt(i);
                    }
                }
                int No_Ticket=Integer.parseInt(n);
                db.comando = (Statement) db.conexion.createStatement();
                String query="SELECT t.No_Ticket, u.Nombre, u.Tipo_Usuario, u.Correo, t.Asunto, t.Mensaje, t.Notas_Especialista, t.Prioridad, t.Estado FROM Ticket t INNER JOIN Usuarios u ON t.Id_Usuario=u.Id_Usuario WHERE t.Especialista='"+e.getNo_Trabajador()+"' AND t.No_Ticket="+No_Ticket+";";
                db.registro=db.comando.executeQuery(query);
                while(db.registro.next()){
                    txt2NoTicket.setText(db.registro.getString(1));
                    txt2Usuario.setText(db.registro.getString(2));
                    txt2TipoUsuario.setText(db.registro.getString(3));
                    txt2Contacto.setText(db.registro.getString(4));
                    txt2NotasUsuario.setText("Asunto: "+db.registro.getString(5)+"\n\nMensaje:\n"+db.registro.getString(6));
                    txt2NotasEsp.setText(db.registro.getString(7));
                    switch (db.registro.getString(8)){
                        case "Alta": cbx2Prioridad.setSelectedIndex(1); break;
                        case "Media": cbx2Prioridad.setSelectedIndex(2); break;
                        case "Baja": cbx2Prioridad.setSelectedIndex(3); break;
                        default: cbx2Prioridad.setSelectedIndex(0); break;
                    }
                    switch(db.registro.getString(9)){
                        case "Ticket tomado por especialista, esperando respuesta": cbx2Estado.setSelectedIndex(0); break;
                        case "Contactandolo a su correo": cbx2Estado.setSelectedIndex(1); break;
                        case "Resolviendo problematica": cbx2Estado.setSelectedIndex(2); break;
                        case "Cancelado": cbx2Estado.setSelectedIndex(3); break;
                        case "Finalizado": cbx2Estado.setSelectedIndex(4); break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_lst2TicktetsEspValueChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (cbx2Prioridad.getSelectedIndex()!=0) {
            try {
                int No_Ticket=Integer.parseInt(txt2NoTicket.getText());
                db.comando = (Statement) db.conexion.createStatement();
                String query="UPDATE Ticket SET Notas_Especialista='"+txt2NotasEsp.getText()+"', Estado='"+cbx2Estado.getSelectedItem()+"', Prioridad='"+cbx2Prioridad.getSelectedItem()+"' WHERE No_Ticket="+No_Ticket+";";
                PreparedStatement preparedStmt = c.prepareStatement(query);
                preparedStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha actualizado el ticket");
                mostrar2TicketsEspecialista();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una prioridad valida");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    String detallesUsuario="";
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txt3NoTicket.setText("");
        txt3NotasUsuario.setText("");
        txt3NotasEspecialista.setText("");
        txt3Fecha.setText("");
        lst3TicketsUsuario.removeAll();
        try {
            db.comando = (Statement) db.conexion.createStatement();
            String query="SELECT Id_Usuario, Nombre, Correo, Campus, Tipo_Usuario, Escuela FROM Usuarios WHERE Id_Usuario="+txt3NoUsuario.getText();
            db.registro=db.comando.executeQuery(query);
            if (db.registro.next()) {
                txt3Nombre.setText(db.registro.getString(2));
                detallesUsuario="No. Cuenta: "+db.registro.getString(1)+"\nCorreo: "+db.registro.getString(3)+"\nCampus: "+db.registro.getString(4)+"\nTipo de usuario: "+db.registro.getString(5)+"\nEscuela: "+db.registro.getString(6);
                btn3DetallesUsuario.setEnabled(true);
                mostrar3TicketsUsuarios(Integer.parseInt(txt3NoUsuario.getText()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro Nº de cuenta");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    boolean banls3=false;
    String detallesTicket="";
    private void lst3TicketsUsuarioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst3TicketsUsuarioValueChanged
        banls3=!banls3;
        btn3DetallesTicket.setEnabled(true);
        if (banls3) {
            try {
                String a=lst3TicketsUsuario.getSelectedValue();
                String n="";
                for (int i = 0; i < a.length(); i++) {
                    if (Character.isDigit(a.charAt(i))) {
                        n+=a.charAt(i);
                    }
                }
                int No_Ticket=Integer.parseInt(n);
                db.comando = (Statement) db.conexion.createStatement();
                String query="SELECT No_Ticket, Asunto, Mensaje, Notas_Especialista, Fecha, Departamento, Estado, Prioridad FROM Ticket o WHERE No_Ticket="+No_Ticket+";";
                db.registro=db.comando.executeQuery(query);
                while(db.registro.next()){
                    txt3NoTicket.setText(db.registro.getString(1));
                    txt3NotasUsuario.setText("Asunto: "+db.registro.getString(2)+"\n\nMensaje: "+db.registro.getString(3));
                    txt3NotasEspecialista.setText(db.registro.getString(4));
                    txt3Fecha.setText(db.registro.getString(5));
                    detallesTicket="Datos del ticket:\nDepartamento: "+db.registro.getString(6)+"\nEstado: "+db.registro.getString(7)+"\nPrioridad: "+db.registro.getString(8);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }//GEN-LAST:event_lst3TicketsUsuarioValueChanged

    private void btn3DetallesTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3DetallesTicketActionPerformed
        JOptionPane.showMessageDialog(null, detallesTicket, "Detalles del ticket ", 1);
    }//GEN-LAST:event_btn3DetallesTicketActionPerformed

    private void btn3DetallesUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3DetallesUsuarioActionPerformed
        JOptionPane.showMessageDialog(null, detallesUsuario, "Detalles del usuario", 1);
    }//GEN-LAST:event_btn3DetallesUsuarioActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            String contraseña0=JOptionPane.showInputDialog(null, "Ingrese su contraseña","Cambiar contraseña", 1);
            String contraseña1=JOptionPane.showInputDialog(null, "Ingrese nueva contraseña","Cambiar contraseña", 1);
            String contraseña2=JOptionPane.showInputDialog(null, "Repita nueva contraseña","Cambiar contraseña", 1);
            db.comando = (Statement) db.conexion.createStatement();
            String query="SELECT * FROM Especialistas WHERE No_Trabajador="+e.getNo_Trabajador()+" AND Contraseña=md5('"+contraseña0+"')";
            db.registro=db.comando.executeQuery(query);
            if (db.registro.next()) {
                if (contraseña1.equals(contraseña2)) {
                    db.comando = (Statement) db.conexion.createStatement();
                    query="UPDATE Especialistas SET Contraseña=md5('"+contraseña1+"') WHERE No_Trabajador="+e.getNo_Trabajador();
                    PreparedStatement preparedStmt = c.prepareStatement(query);
                    preparedStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Su contrasñea ha sido cambiada","Contrasñea cambiada",1);
                }else{
                    JOptionPane.showMessageDialog(null, "Las contraseñas con coinciden", "Error",3);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta","Error",2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Login l=new Login();
        setVisible(false);
        l.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        Escuelas e=new Escuelas();
        this.setEnabled(false);
        e.setLocationRelativeTo(null);
        e.Principal(this);
        e.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        Departamentos d=new Departamentos();
        this.setEnabled(false);
        d.setLocationRelativeTo(null);
        d.Principal(this);
        d.setVisible(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        Especialistas e=new Especialistas(this.e);
        this.setEnabled(false);
        e.setLocationRelativeTo(null);
        e.Principal(this);
        e.setVisible(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    
    private void MyInitComponents(){
        //this.setTitle("Mesa de ayuda UCOL");
        String m="Usuario: "+e.getNombre();
        lblUser.setText(m);
        lblUser2.setText(m);
        lblUser3.setText(m);
        lblUser4.setText(m);

        cbx1Area();
    }
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args){
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Departamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Departamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Departamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Departamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Pestañas;
    private javax.swing.JButton btn1Cambiar;
    private javax.swing.JButton btn1Tomar;
    private javax.swing.JButton btn3DetallesTicket;
    private javax.swing.JButton btn3DetallesUsuario;
    private javax.swing.JComboBox<String> cbx1Areas;
    private javax.swing.JComboBox<String> cbx2Estado;
    private javax.swing.JComboBox<String> cbx2Prioridad;
    private javax.swing.JComboBox<String> cbxAreas1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUser2;
    private javax.swing.JLabel lblUser3;
    private javax.swing.JLabel lblUser4;
    private javax.swing.JList<String> lst2TicktetsEsp;
    private javax.swing.JList<String> lst3TicketsUsuario;
    private javax.swing.JList<String> lstTicketsDep;
    private javax.swing.JPanel pnlMisTickets;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlTicketsDisponibles;
    private javax.swing.JPanel pnlTicketsUsuarios;
    private javax.swing.JTextField txt1Cuenta;
    private javax.swing.JTextField txt1Fecha;
    private javax.swing.JTextField txt1NoTicket;
    private javax.swing.JTextArea txt1NotasUser;
    private javax.swing.JTextField txt1Tipo;
    private javax.swing.JTextField txt1Usuario;
    private javax.swing.JTextField txt2Contacto;
    private javax.swing.JTextField txt2NoTicket;
    private javax.swing.JTextArea txt2NotasEsp;
    private javax.swing.JTextArea txt2NotasUsuario;
    private javax.swing.JTextField txt2TipoUsuario;
    private javax.swing.JTextField txt2Usuario;
    private javax.swing.JTextField txt3Fecha;
    private javax.swing.JTextField txt3NoTicket;
    private javax.swing.JTextField txt3NoUsuario;
    private javax.swing.JTextField txt3Nombre;
    private javax.swing.JTextArea txt3NotasEspecialista;
    private javax.swing.JTextArea txt3NotasUsuario;
    private javax.swing.JTextField txt4Area;
    private javax.swing.JTextField txt4Correo;
    private javax.swing.JTextField txt4NoTickets;
    private javax.swing.JTextField txt4NoTrabajador;
    private javax.swing.JTextField txt4Nombre;
    // End of variables declaration//GEN-END:variables
}