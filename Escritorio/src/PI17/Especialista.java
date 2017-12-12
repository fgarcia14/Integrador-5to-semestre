package PI17;

public class Especialista {
    
    private int No_Trabajador;
    private String Contraseña;
    private String Nombre;
    private String Correo;
    private String Departamento;

    public int getNo_Trabajador() {
        return No_Trabajador;
    }

    public void setNo_Trabajador(int No_Trabajador) {
        this.No_Trabajador = No_Trabajador;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
    
    public Especialista(int No_Trabajador, String Contraseña, String Nombre, String Correo, String Departamento) {
        this.No_Trabajador = No_Trabajador;
        this.Contraseña = Contraseña;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Departamento = Departamento;
    }
    
}