package Controlador;

import com.mysql.jdbc.Connection;
import include.Ticket;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import include.Ticket;
import include.Usuario;
/**
 *
 * @author chepoluis
 */

//Cuando llamamos este metodo llama la clase conexion automaticamente
public class Consultas extends Conexion{
    
    public boolean auntenticación(String usuario, String contraseña){
        PreparedStatement pst = null;
        //Variable para guardar la consulta
        ResultSet rs = null;
        
        try{
            //manera correcta de hacer consultas, para evitar sqlinjection
            String consulta = "select * from Usuarios where Id_Usuario = ? and contraseña = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            //Ejecuta a consulta y la guarda
            rs = pst.executeQuery();
            
            //Si encuentra un registro regresa true
            if(rs.absolute(1)){
                return true;
            }
        }catch(Exception e){
            System.err.println("ERROR " + e);
        }finally{
            //Cerramos las conexiones
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            }catch(Exception e){
                System.err.println("ERROR " + e);
            }
        }
        return false;
    }
   
    public boolean registrar(Usuario t){
        PreparedStatement pst = null;
        
        try{
            //values(?,?,?,?) evita el sql injection
            String consulta = "insert into Usuarios(Id_Usuario, Contraseña, Nombre, Correo, Campus, Tipo_Usuario, Escuela) values(?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            //Mandamos los parametros, se pueden mandar distintos parametros(int, boolean, etc)
            pst.setString(1, t.getIdUsuario());
            pst.setString(2, t.getPass());
            pst.setString(3, t.getNombreUsuario());
            pst.setString(4, t.getCorreoElectronico());
            pst.setString(5, t.getCampus());
            pst.setString(6, t.getNombreUsuario());
            pst.setString(7, t.getEscuela());
            
            if(pst.executeUpdate() == 1){
                return true;
            }
        }catch(Exception ex){
            System.err.println("ERROR " + ex);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            }catch (Exception e){
                System.err.println("ERROR " + e);
            }
            
        }
        return false;
    }
    
    /*
    public boolean enviarTicket(String idUsuario, String fecha, String departamento, String asunto, String mensaje, String contacto, String estado, int especialista, String prioridad){
        PreparedStatement pst = null;
        
        try{
            //values(?,?,?,?) evita el sql injection
            String consulta = "insert into Ticket(Id_Usuario, Fecha, Departamento, Asunto, Mensaje, Contacto, Estado, Especialista, Prioridad) values(?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            //Mandamos los parametros, se pueden mandar distintos parametros(int, boolean, etc)
            pst.setString(1, idUsuario);
            pst.setString(2, fecha);
            pst.setString(3, departamento);
            pst.setString(4, asunto);
            pst.setString(5, mensaje);
            pst.setString(6, contacto);
            pst.setString(7, estado);
            pst.setInt(8, especialista);
            pst.setString(9, prioridad);
            
            if(pst.executeUpdate() == 1){
                return true;
            }
        }catch(Exception ex){
            System.err.println("ERROR " + ex);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            }catch (Exception e){
                System.err.println("ERROR " + e);
            }
            
        }
        return false;
    }
    */
    
    public boolean crearTicket(Ticket t){
        PreparedStatement pst = null;
        boolean flag = false;
        
        try{
            String sql = "insert into Ticket(Id_Usuario, Fecha, Departamento, Asunto, Mensaje) values(?,?,?,?,?)";
            pst = getConexion().prepareStatement(sql);
            
            pst.setInt(1, t.getId_Usuario());
            pst.setString(2, t.getFecha());
            pst.setString(3, t.getDepartamento());
            pst.setString(4, t.getAsunto());
            pst.setString(5, t.getMensaje());
            
            if(pst.executeUpdate() == 1){
                flag = true;
            }
        }catch(Exception e){
            System.out.println("ERROR " + e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            }catch (Exception e){
                System.err.println("ERROR " + e);
            }
        }        
        return flag;
    }
    
    //Mostrar de X usuario
    //***
    public ArrayList<Ticket> getTickets(int idUsuario){
        Ticket t = new Ticket();
        ArrayList<Ticket> tickets = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int usuario = t.getId_Usuario();
        
        try {
            String sql = "select * from Ticket where Id_Usuario = ? AND Estado='Pendiente de revision' UNION select * from Ticket where Id_Usuario = ? AND Estado='Resolviendo problematica' UNION select * from Ticket where Id_Usuario = ? AND Estado='Finalizado' UNION select * from Ticket where Id_Usuario = ? AND Estado='Cancelado'";
            pst = getConexion().prepareCall(sql);
            pst.setInt(1, idUsuario);
            pst.setInt(2, idUsuario);
            pst.setInt(3, idUsuario);
            pst.setInt(4, idUsuario);
            rs = pst.executeQuery();
            while (rs.next()) {                
                tickets.add(new Ticket(rs.getInt("No_Ticket"), rs.getInt("Id_Usuario"), rs.getString("Fecha"), rs.getString("Departamento"), rs.getString("Asunto"), rs.getString("Mensaje"), rs.getString("Notas_Especialista"), rs.getString("Estado")));
            }
            
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }finally{
            try {
                if(getConexion() != null)getConexion().close();
                if(pst != null)pst.close();
                if(rs !=null)rs.close();
            } catch (Exception e) {
                System.out.println("ERROR " + e);
            }            
        }       
        
        return tickets;
    }  

//        //Mostrar de X usuario
//    //***
//    public ArrayList<Ticket> getTickets(int idUsuario){
//        Ticket t = new Ticket();
//        ArrayList<Ticket> tickets = new ArrayList<>();
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        int usuario = t.getId_Usuario();
//        
//        try {
//            String sql = "select * from Ticket where Id_Usuario = ?";
//            pst = getConexion().prepareCall(sql);
//            pst.setInt(1, idUsuario);
//            rs = pst.executeQuery();
//            while (rs.next()) {                
//                tickets.add(new Ticket(rs.getInt("No_Ticket"), rs.getInt("Id_Usuario"), rs.getString("Fecha"), rs.getString("Departamento"), rs.getString("Asunto"), rs.getString("Mensaje"), rs.getString("Notas_Especialista"), rs.getString("Estado")));
//            }
//            
//        } catch (Exception e) {
//            System.out.println("ERROR " + e);
//        }finally{
//            try {
//                if(getConexion() != null)getConexion().close();
//                if(pst != null)pst.close();
//                if(rs !=null)rs.close();
//            } catch (Exception e) {
//                System.out.println("ERROR " + e);
//            }            
//        }       
//        
//        return tickets;
//    } 
    
    public ArrayList<Ticket> getAllTickets(){
        Ticket t = new Ticket();
        ArrayList<Ticket> tickets = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int usuario = t.getId_Usuario();
        
        try {
            String sql = "select * from Ticket";
            pst = getConexion().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                tickets.add(new Ticket(rs.getInt("No_Ticket"), rs.getInt("Id_Usuario"), rs.getString("Fecha"), rs.getString("Departamento"), rs.getString("Asunto"), rs.getString("Mensaje"), rs.getString("Notas_Especialista"), rs.getString("Estado")));
            }
            
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }finally{
            try {
                if(getConexion() != null)getConexion().close();
                if(pst != null)pst.close();
                if(rs !=null)rs.close();
            } catch (Exception e) {
                System.out.println("ERROR " + e);
            }            
        }       
        
        return tickets;
    }  
    
    public Ticket getTicket(int noTicket){
        Ticket t = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        try {
            String sql = "select * from Ticket where No_Ticket = ?";
            pst = getConexion().prepareCall(sql);
            pst.setInt(1, noTicket);
            rs = pst.executeQuery();
            while (rs.next()) {                
                t = new Ticket(rs.getInt("No_Ticket"), rs.getInt("Id_Usuario"), rs.getString("Fecha"), rs.getString("Departamento"), rs.getString("Asunto"), rs.getString("Mensaje"), rs.getString("Notas_Especialista"), rs.getString("Estado"));
            }
            
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }finally{
            try {
                if(getConexion() != null)getConexion().close();
                if(pst != null)pst.close();
                if(rs !=null)rs.close();
            } catch (Exception e) {
                System.out.println("ERROR " + e);
            }            
        }       
        
        return t;
    }  
    
    public boolean deleteTicket(int noTicket){
        
        boolean flag = false;
        PreparedStatement pst = null;        
        
        try {
            String sql = "DELETE FROM Ticket WHERE No_Ticket = ?";
            pst = getConexion().prepareCall(sql);
            pst.setInt(1, noTicket);            
            
            if(pst.executeUpdate() == 1){
                flag = true;
            }            
        } catch (Exception e) {
        }finally{
            try {
                if(getConexion() != null)getConexion().close();
                if(pst != null)pst.close();                
            } catch (Exception e) {
            
            }            
        } 
        return flag;
    }
    
    public boolean updateTicket(Ticket t){
        PreparedStatement pst = null;
        boolean flag = false;
        
        try{
            String sql = "update Ticket set departamento = ?, Asunto = ?, Mensaje = ? where No_Ticket = ?";
            pst = getConexion().prepareStatement(sql);
            
            pst.setString(1, t.getDepartamento());
            pst.setString(2, t.getAsunto());
            pst.setString(3, t.getMensaje());
            pst.setInt(4, t.getNo_Ticket());
            
            if(pst.executeUpdate() == 1){
                flag = true;
            }
        }catch(Exception e){
            System.out.println("ERROR " + e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            }catch (Exception e){
                System.err.println("ERROR " + e);
            }
        }        
        return flag;
    }
    
//    public String getTablas(String dataBase){
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        String tablas = "";
//        
//        try {
//            String sql = "SHOW FULL TABLES FROM ?";
//            pst = getConexion().prepareCall(sql);
//            pst.setString(1, dataBase);
//            rs = pst.executeQuery();
//            
//            while (rs.next()) {  
//            tablas = rs.getString("Usuarios");
//            }
//            
//        } catch (Exception e) {
//            System.out.println("ERROR " + e);
//        }finally{
//            try {
//                if(getConexion() != null)getConexion().close();
//                if(pst != null)pst.close();
//                if(rs !=null)rs.close();
//            } catch (Exception e) {
//                System.out.println("ERROR " + e);
//            }            
//        }       
//        
//        return tablas;
//    }
    
    //main
    /*
    public static void main(String[] args){
        Consultas co = new Consultas();
        //System.out.println(co.auntenticación("asd", "asd"));
        //Error con el especialista 
        //System.out.println(co.updateTicket(new Ticket(54, 0, "2012-08-21", "Redes", "Holaaaaaaaaaaaaa", "Mensaje chido")));
        //System.out.println(co.getTickets(3));
        System.out.println(co.getTablas("PI17"));
    }
    */
}
