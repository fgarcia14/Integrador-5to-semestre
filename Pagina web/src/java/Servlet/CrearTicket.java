package Servlet;

import Controlador.Consultas;
import Controlador.ControladorTicket;
import include.Ticket;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author chepoluis
 */
public class CrearTicket extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        FileItemFactory file_factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(file_factory);
        
        /*
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> imgs = new ArrayList<>();
        
        try{
            //request: objeto donde podemos traer todos los datos de la pagina
            List items = sfu.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                
                //isFormField: se refiere a si es un campo de fomulario: texto...
                if(!item.isFormField()){
                    File archivo = new File("C:\\Users\\chepoluis\\Desktop\\code\\java\\PI_17\\web\\imagenes\\tickets\\"+item.getName());
                    item.write(archivo);
                    imgs.add("imagenes/tickets/"+item.getName());
                }else{
                    campos.add(item.getString());
                }
            }
        }catch(Exception ex){
            System.out.println("ERROR " + ex);
        }
        
        Ticket t = new Ticket(0, Integer.parseInt(campos.get(0)), campos.get(1), campos.get(2), campos.get(3), campos.get(4), campos.get(5), imgs.get(0));
        ControladorTicket ct = new ControladorTicket();
        if(ct.crearTicket(t)){
            response.getWriter().println("Ticket Creado Exitosamente");
        }else{
            response.getWriter().println("ERROR al crear el ticket");
        }
        */
        
        //Codigo para enviar solo "texto"
        PrintWriter out = response.getWriter();
        
        int idUsuario = Integer.parseInt(request.getParameter("nombre"));
        String fecha = request.getParameter("fecha");
        String departamento = request.getParameter("departamento");
        String asunto = request.getParameter("asunto");
        String mensaje = request.getParameter("mensaje");
        
        
        
        Consultas co = new Consultas(); 
        if(co.crearTicket(new Ticket(0, idUsuario, fecha, departamento, asunto, mensaje, "", ""))){
            response.sendRedirect("menu.jsp");
            out.println("alert('Ticket creado exitosamente');");
        }else{
            response.sendRedirect("crearTicket.jsp");
            out.println("alert('Error al crear el ticket');");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
