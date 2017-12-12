<%-- 
    Document   : modificar
    Created on : 08-nov-2017, 0:38:23
    Author     : chepoluis
--%>

<%@page import="Controlador.ControladorTicket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="images/demo/gallery/help.png" type="gallery/help.png" rel="shortcut icon" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar ticket</title>
        <script src="js/jquery.min.js"></script>
        <script src="js/paneladministracion.js"></script>
    </head>
    <body style="background-image:url('images/demo/gallery/udc05.jpg'); background-size: 1400px 700px;">
        <h1>Modificar ticket</h1>
        
        <%ControladorTicket ct = new ControladorTicket();
            int noTicket = Integer.parseInt(request.getParameter("noticket"));
        %>
        <%=ct.getEditViewTicket(noTicket)%>
        
        <a href="menu.jsp">Menu principal</a>
    </body>
</html>
