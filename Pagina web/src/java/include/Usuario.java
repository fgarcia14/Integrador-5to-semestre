package include;

/**
 *
 * @author chepoluis
 */
public class Usuario {
    private String idUsuario;
    private String pass;
    private String nombreUsuario;
    private String correoElectronico;
    private String campus;
    private String tipoUsuario;
    private String escuela;

    public Usuario(){
        
    }
    
    public Usuario(String idUsuario, String pass, String nombreUsuario, String correoElectronico, String campus, String tipoUsuario, String escuela){
        this.idUsuario = idUsuario;
        this.pass = pass;
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.campus = campus;
        this.tipoUsuario = tipoUsuario;
        this.escuela = escuela;
    }
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
