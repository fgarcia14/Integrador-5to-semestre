window.addEventListener('load', function(){
    
    document.getElementById('btnIniciar').addEventListener('click', function(){
       var usuario = document.getElementById('txtUsuario').value;
       var contraseña = document.getElementById('txtPass').value;
       
       var bandera = false;
       
       if(usuario.length > 0 && contraseña.length > 0){
           bandera = true;
       }
       
       if(bandera){
           //submit envia la peticion
           document.getElementById('formInicio').submit();
       }else{
           alert('Llene todos los campos de registro');
       }
    });
});

