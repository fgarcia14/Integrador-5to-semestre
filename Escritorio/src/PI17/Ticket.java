package PI17;

/**
 *
 * @author Fidel
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
    private int Especialista;
    private String Prioridad;
    
    public Ticket siguiente;

    public int getNo_Ticket() {
        return No_Ticket;
    }

    public void setNo_Ticket(int No_Ticket) {
        this.No_Ticket = No_Ticket;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    public String getNotas_Especialista(){
        return Notas_Especialista;
    }
    
    public void setNotas_Especialista(String Notas_Especialista){
        this.Notas_Especialista=Notas_Especialista;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getEspecialista() {
        return Especialista;
    }

    public void setEspecialista(int Especialista) {
        this.Especialista = Especialista;
    }

    public String getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(String Prioridad) {
        this.Prioridad = Prioridad;
    }

    public Ticket(int No_Ticket, int Id_Usuario, String Fecha, String Departamento, String Asunto, String Mensaje, String Notas_Especialista, String Estado, int Especialista, String Prioridad) {
        this.No_Ticket = No_Ticket;
        this.Id_Usuario = Id_Usuario;
        this.Fecha = Fecha;
        this.Departamento = Departamento;
        this.Asunto = Asunto;
        this.Mensaje = Mensaje;
        this.Notas_Especialista=Notas_Especialista;
        this.Estado = Estado;
        this.Especialista = Especialista;
        this.Prioridad = Prioridad;
    }
}
