var fecha = new Date();

var dia_semana = [
  "Domingo",
  "Lunes",
  "Martes",
  "Miércoles",
  "Jueves",
  "Viernes",
  "Sábado"
];

var mes = [
  "Enero",
  "Febrero",
  "Marzo",
  "Abril",
  "Mayo",
  "Junio",
  "Julio",
  "Agosto",
  "Septiembre",
  "Octubre",
  "Noviembre",
  "Dicimbre"
];

//var hora = new Date();
//var get_hora = hora.getHours()+ ":" + hora.getMinutes() + ":" + hora.getSeconds();
//document.write("<p>" + get_hora() + "</p>");

var get_fecha = dia_semana[fecha.getDay()] + "-" + fecha.getDate() + "-" + mes[fecha.getMonth()] + "-" + fecha.getFullYear() + " Hora: " + fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds();
//var mostrarFecha = document.querySelector('#fecha');
//mostrarFecha.innerHTML = mostrarFecha;
document.write("<p>" + get_fecha + "</p>");



