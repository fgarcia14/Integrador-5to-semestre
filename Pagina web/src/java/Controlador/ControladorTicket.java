package Controlador;

import include.Ticket;
import java.util.ArrayList;

/**
 *
 * @author chepoluis
 */
public class ControladorTicket {
    
    public boolean crearTicket(Ticket t){
        Consultas con = new Consultas();
        return con.crearTicket(t);
    }
    //Retorna los tickets de X usuario
    //*******
    public String getTickets(int idUsuario){
        String htmlCode = "";

       Consultas co = new Consultas();
        for(Ticket t : co.getTickets(idUsuario)){
            htmlCode += "<div style=\"background-image:url('images/demo/backgrounds/blanco.jpeg');\" class=\"col_1_of_3 span_1_of_3\"><a href='detallesTicket.jsp?idticket="+t.getNo_Ticket()+"' >\n" +
"				     <div class=\"view view-fifth\">\n" +
"				  	  <div class=\"top_box\">\n" +
"					  	<h3 class=\"m_1\">Id Ticket: "+t.getNo_Ticket()+"</h3>\n" +
"					  	<p class=\"m_2\">Fecha de creación: "+t.getFecha()+"</p>\n<br>" +
"					  	<p class=\"m_2\">Departamento: "+t.getDepartamento()+"</p>\n<br>" +
"					  	<p class=\"m_2\">Asunto: "+t.getAsunto()+"</p>\n<br>" +
"					  	<p class=\"m_2\">Mensaje: "+t.getMensaje()+"</p>\n<br>" +
"					  	<p class=\"m_2\">Notas especialista: "+t.getNotas_Especialista()+"</p>\n<br>" +
"				         <div class=\"grid_img\">\n" +
"						   <div class=\"css3\"><img src=\"images/pic.jpg\" alt=\"\"/></div>\n" +
"					          <div class=\"mask\">\n" +
"	                       		<div ></div>\n" +
"			                  </div>\n" +
"	                    </div>\n" +
"                       <div class=\"price\">Estado: "+t.getEstado()+"</div>\n" +
"					   </div>\n" +
"					    </div>\n" +					     
"			    	    <div class=\"clear\"></div>\n" +
"			    	</a></div>";
        }
        
        return htmlCode;
    }
        
    //Retorna todos los tickets
    public String getAllTickets(){
        String htmlCode = "";

       Consultas co = new Consultas();
        for(Ticket t : co.getAllTickets()){
            htmlCode += "<div style=\"background-image:url('images/demo/backgrounds/blanco.jpeg');\" class=\"col_1_of_3 span_1_of_3\"><a href='detallesTicket.jsp?idticket="+t.getNo_Ticket()+"' >\n" +
"				     <div class=\"view view-fifth\">\n" +
"				  	  <div class=\"top_box\">\n" +
"					  	<h3 class=\"m_1\">Id Ticket: "+t.getNo_Ticket()+"</h3>\n" +
"					  	<p class=\"m_2\">Fecha de creación: "+t.getFecha()+"</p>\n<br>" +
"					  	<p class=\"m_2\">Departamento: "+t.getDepartamento()+"</p>\n<br>" +
"					  	<p class=\"m_2\">Asunto: "+t.getAsunto()+"</p>\n<br>" +
"					  	<p class=\"m_2\">Mensaje: "+t.getMensaje()+"</p>\n<br>" +
"					  	<p class=\"m_2\">Notas especialista: "+t.getNotas_Especialista()+"</p>\n<br>" +
"				         <div class=\"grid_img\">\n" +
"						   <div class=\"css3\"><img src=\"images/pic.jpg\" alt=\"\"/></div>\n" +
"					          <div class=\"mask\">\n" +
"	                       		<div ></div>\n" +
"			                  </div>\n" +
"	                    </div>\n" +
"                       <div class=\"price\">Estado: "+t.getEstado()+"</div>\n" +
"					   </div>\n" +
"					    </div>\n" +					     
"			    	    <div class=\"clear\"></div>\n" +
"			    	</a></div>";
        }
        
        return htmlCode;
    }
    
    public String getDetalleTicket(int No_Ticket){
        String htmlcode = "";
        Ticket t = new Consultas().getTicket(No_Ticket);
        htmlcode = "<div class=\"single\" >\n" +
"         \n" +
"		<div class=\"cont span_2_of_3\">\n" +
"			  <div class=\"labout span_1_of_a1\">\n" +
"				\n" +
"					\n" +
"					\n" +
"			<!-- end product_slider -->\n" +
"			</div>\n" +
"			<div class=\"cont1 span_2_of_a1\">\n" +
"				<h3 class=\"m_3\">"+t.getAsunto()+"</h3>\n" +
"                       <p class=\"m_text\">Id usuario: "+t.getId_Usuario()+"</p>\n" +
"                       <p class=\"m_text\">Id Ticket: "+t.getNo_Ticket()+"</p>\n" +
"                       <p class=\"m_text\">Fecha de creación: "+t.getFecha()+"</p>\n" +
"                       <p class=\"m_text\">Departamento: "+t.getDepartamento()+"</p>\n" +
"                       <p class=\"m_text\">Departamento: "+t.getDepartamento()+"</p>\n" +
"				<ul class=\"add-to-links\">\n" +
"    			   <li><img src=\"\" alt=\"\"/><a href=\"#\"></a></li>\n" +
"    			</ul>\n" +
"    			<p class=\"m_desc\"></p>\n" +
"    			\n" +
"     	<h3 class=\"m_3\"></h3>\n" +
"     	<p class=\"m_text\"></p>\n" +
"     </div>					\n" +
"	 <div class=\"toogle\">\n" +
"     	<h3 class=\"m_3\">Mensaje:</h3>\n" +
"     	<p class=\"m_text\">"+t.getMensaje()+"</p>\n" +
"     </div>\n" +
"     </div>\n" +
"     <div class=\"clear\"></div>\n" +
"	 \n" +
"	 \n" +
"       </div>";
        
        return htmlcode;
    }
    
    //aaaaaaaaaa
    //**********
    public String getPanelView(int idUsuario){
        String htmlcode = "";
        Consultas co = new Consultas();
        ArrayList<Ticket> tickets = co.getTickets(idUsuario);
        
        htmlcode += "<table border=\"1\" style=\"background-image:url('images/demo/backgrounds/blanco.jpeg');\">\n" +
"            <tr>\n" +
                
"                <th>ID</th>\n" +
"                <th>Ausunto</th>\n" +
"                <th>Mensaje</th>\n" +
"                <th>Acciones</th>\n" +
"            </tr>\n";
        
        for(Ticket t : tickets){
            htmlcode += "<tr>\n" +
"                <td id='no_ticket'>"+t.getNo_Ticket()+"</td>\n" +
"                <td>"+t.getAsunto()+"</td>\n" +
"                <td>"+t.getMensaje()+"</td>\n" +
"                <td><a id='btn-eliminar' href=\"\">Eliminar</a> <a href='modificar.jsp?noticket="+t.getNo_Ticket()+"'>Modificar</a></td>\n" +
"            </tr>\n";
        }
        
        htmlcode += "</table>";
        
        return htmlcode;
    }
    
    public boolean deleteTicket(int no){
        Consultas co = new Consultas();
        return co.deleteTicket(no);
    }
    
    public String getEditViewTicket(int noTicket){
        Consultas co = new Consultas();
        Ticket t = co.getTicket(noTicket);
        
        String htmlcode = "";
        
        htmlcode += "<form id='frmmodificar' name='frmmodificar'>\n" +
"            <table>\n" +
"                \n" +
                "<tr>\n" +
"                    <td><input type=\"hidden\" name=\"noticket\" id=\"noticket\" value='"+t.getNo_Ticket()+"'></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><label for=\"\">Departamento:</label></td>\n" +
"                    <td>\n" +
"                        <select name=\"departamento\" id=\"departamento\">\n" +
"                            <option value='opcion'>"+t.getDepartamento()+"</option>\n" +
"                            <option value='Programacion'>Programacion</option>\n" +
"                            <option value='Redes'>Redes</option>\n" +
"                            <option value='Hardware'>Hardware</option>\n" +
"                            \n" +
"                        </select>\n" +
"                    </td>\n" +
"                </tr>\n" +
"                \n" +
"                <tr>\n" +
"                    <td><label for=\"\">Asunto:</label></td>\n" +
"                    <td><input type=\"text\" name=\"asunto\" id=\"asunto\" value='"+t.getAsunto()+"'></td>\n" +
"                </tr>\n" +
"                \n" +
"                <tr>\n" +
"                    <td><label for=\"\">Mensaje:</label></td>\n" +
"                    <td><textarea cols=\"30\" rows=\"6\" name=\"mensaje\" id=\"mensaje\">"+t.getMensaje()+"</textarea></td>\n" +
"                </tr>\n" +
"                \n" +
"                <tr>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td></td>\n" +
"                    <td><input type=\"submit\" value=\"Modificar ticket\" id=\"btnmodificarticket\"></td>\n" +
"                </tr>\n" +
"                \n" +
"            </table>\n" +
"        </form>";
        
        return htmlcode;
    }
    
    public boolean updateTicket(Ticket t){
        Consultas co = new Consultas();
        return co.updateTicket(t);
    }
    
}
