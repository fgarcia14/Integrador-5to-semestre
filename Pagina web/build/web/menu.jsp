<%-- 
    Document   : menu
    Created on : 05-nov-2017, 12:00:29
    Author     : chepoluis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Código Java-->
<%
    HttpSession objSesion = request.getSession(false);
    String usuario = (String)objSesion.getAttribute("usuario");
    //Si la variable usuario esta vacia(no existe sesión), redirecciona al index
    if(usuario.equals("")){
        response.sendRedirect("index.jsp");
    //Faltaria cerrar sesion
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <link href="images/demo/gallery/help.png" type="gallery/help.png" rel="shortcut icon" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
    </head>
    <body id="top"  style="background-image:url('images/demo/gallery/udc10.jpg'); background-size: 1400px 700px;">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- Top Background Image Wrapper -->
<div class="bgded"> 
  <!-- ################################################################################################ -->
  <div class=
       "wrapper overlay">
    <header id="header" class="hoc clear">
      <nav id="mainav" class="clear"> 
        <!-- ################################################################################################ -->
        <ul class="clear">
            <h1>Bienvenido</h1>
          <li><a href="crearTicket.jsp">Crear ticket</a></li>
          <li><a href="misTickets.jsp">Mis tickets</a></li>
          <li><a href="bdConocimiento.jsp">Base de datos del conocimiento</a></li>
          <li><a href="administracion.jsp">Modificar / Eliminar mis tickets</a></li>
          <li><a href="index.jsp">Cerrar sesión</a></li>
        </ul>
        <!-- ################################################################################################ -->
      </nav>
      <div id="logo"> 
        <!-- ################################################################################################ -->
        <h1><a href="https://www.ucol.mx/">Universidad de Colima</a></h1>
        
        <!-- ################################################################################################ -->
      </div>
    </header>
  </div>
  <!-- ################################################################################################ -->
  <!-- ################################################################################################ -->
  <!-- ################################################################################################ -->
  <div id="pageintro" class="hoc clear"> 

    <!-- ################################################################################################ -->
  </div>
  <!-- ################################################################################################ -->
</div>
<!-- End Top Background Image Wrapper -->
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="layout/scripts/jquery.min.js"></script>
<script src="layout/scripts/jquery.backtotop.js"></script>
<script src="layout/scripts/jquery.mobilemenu.js"></script>
<!-- IE9 Placeholder Support -->
<script src="layout/scripts/jquery.placeholder.min.js"></script>
<!-- / IE9 Placeholder Support -->
        
        <!--
        <h1>Bienvenido <% out.println(usuario); %></h1>
        <a href="crearTicket.jsp" >Crear ticket</a>
        <a href="misTickets.jsp">Ver mis tickets</a>
        <a href="administracion.jsp">Modificar/Eliminar tickets</a>
        -->
    </body>
</html>
