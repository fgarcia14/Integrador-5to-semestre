package include;

import java.sql.Date;

/**
 *
 * @author chepoluis
 */
public class Ticket {

    private int No_Ticket;
    private int Id_Usuario;
    private String Fecha;
    private String Departamento;
    private String Asunto;
    private String Mensaje;
    private String Notas_Especialista;
    private String Estado;
 
    public Ticket(){
        
    }
    
    public Ticket(int No_Ticket, int Id_Usuario, String Fecha, String Departamento, String Asunto, String Mensaje, String Notas_Especialista, String Estado){
        this.Id_Usuario = Id_Usuario;
        this.Fecha = Fecha;
        this.Departamento = Departamento;
        this.Asunto = Asunto;
        this.Mensaje = Mensaje;
        this.No_Ticket = No_Ticket;
        this.Estado = Estado;
        this.Notas_Especialista = Notas_Especialista;
    }
    
    public int getNo_Ticket() {
        return No_Ticket;
    }
    
    /**
     * @return the Id_Usuario
     */
    public int getId_Usuario() {
        return Id_Usuario;
    }

    /**
     * @param Id_Usuario the Id_Usuario to set
     */
    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    /**
     * @return the Fecha
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the Departamento
     */
    public String getDepartamento() {
        return Departamento;
    }

    /**
     * @param Departamento the Departamento to set
     */
    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    /**
     * @return the Asunto
     */
    public String getAsunto() {
        return Asunto;
    }

    /**
     * @param Asunto the Asunto to set
     */
    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    /**
     * @return the Mensaje
     */
    public String getMensaje() {
        return Mensaje;
    }

    /**
     * @param Mensaje the Mensaje to set
     */
    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    } 
    
        public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
        public String getNotas_Especialista() {
        return Notas_Especialista;
    }

    public void setNotas_Especialista(String Notas_Especialista) {
        this.Notas_Especialista = Notas_Especialista;
    }
}
