/*
$(function(){
    
    function validarFields(asunto, mensaje, contacto, fecha){
        if(asunto.length > 1 && asunto.length <= 30){
            if(mensaje.length > 1 && mensaje.length <= 500){
                if(contacto.length > 1 && contacto.length <= 50){
                    if(fecha.length > 1){
                        
                            
                            //Validar campo tipo file
                            var archivos = document.getElementById('imagenes').files;
                            for(var i = 0; i < archivos.length; i++){
                                var name = archivos[i].name;
                                var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
                                if(ext != 'jpg' && ext != "png"){
                                    alert('Archivo ' + name + ' incorrecto, solo imagenes.');
                                    return false;
                                }
                            }
                        
                    }else{alert("Ingrese una fecha");}
                }else{alert("Escriba un contacto");}
            }else{alert("Escriba un mensaje");}
        }else{alert("Escriba un asunto");}
        return false;
    }
    
    $('#btnEnviarTicket').click(function (e){
        e.preventDefault();
        var asunto = $('#asunto').val();
        var mensaje = $('#mensaje').val();
        var contacto = $('#contacto').val();
        var fecha = $('#fecha').val();
        
        
        if(validarFields(asunto, mensaje, contacto, fecha)){
            var data = new FormData($('#frm_nuevoTicket')[0]);
            $.ajax({
                url : "ticket",
                type : "post",
                data : data,
                contentType : false,
                processData : false,
                success : function(data){
                    alert(data);
                }
            });
        }
    });
    
});
*/