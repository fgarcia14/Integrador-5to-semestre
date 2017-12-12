package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chepoluis
 */
public class Conexion {
    private String USERNAME = "fidel";
    private String PASSWORD = "lagunas242";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "PI17";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private Connection con;
    
    //Constructor, hace la conexion a la base de datos
    public Conexion(){
        try{
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(ClassNotFoundException e){
            System.err.println("ERROR " + e);
        }catch(SQLException e){
            System.err.println("ERROR " + e);
        }
    }
    
    //Regresa la conexion
    public Connection getConexion(){
        return con;
    }
    
    public static void main(String[] args){
        Conexion con = new Conexion();
    }
}
