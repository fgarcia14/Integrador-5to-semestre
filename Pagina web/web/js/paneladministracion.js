$(function(){
   $('tr #btn-eliminar').click(function(e){
      e.preventDefault();
      var opcion = confirm("Desea Eliminar el ticket");
      
      if(opcion){
           var fila = $(this).parent().parent();  
           
           //fila.find('#no_ticket').text();
           var idticket  = fila.find('#no_ticket').text();  
           var data = {idTicket:idticket};
           
           //Enviamos a un servlet
           $.post("deleteTicket", data, function(res, est, jqXHR){
               alert(res);
               fila.remove();
           });
      }    
   });
   
   $('#btnmodificarticket').click(function(e){
       e.preventDefault();
      var data = $('#frmmodificar').serialize();       
      $.post("updateTicket", data, function(res, est, jqXHR){
            alert(res);
       });
   });
   
   
});
