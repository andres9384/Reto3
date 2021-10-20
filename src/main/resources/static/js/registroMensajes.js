$(document).ready(function () {
    $("#actualizar").hide();
    
    tablaMensaje();
    clientes();
    computadores()

      $("#message").val("");

      
  });
  
  function registrarMensaje() {
    
    datos = {
      client: {idClient:$("#clientes5>option:selected").attr("value")},
      computer: {id:$("#computadores>option:selected").attr("value")},
      messageText:$("#message").val(),
      
    };
    var datosEnviar = JSON.stringify(datos);
    console.log(datosEnviar)
  
    $.ajax({
      type: "POST",
      contentType: "application/json; charset=utf8",
      dataType: "JSON",
      data: datosEnviar,
      url: "http://129.159.52.217:8080/api/Message/save",
      
      
      
      success: function (respuesta) {
        console.log("Registrado");
        tablaMensaje();
       
      },
      error: function (respuesta) {
        console.log("No Registrado");
      },
      complete: function (respuesta) {
        $("#message").val("");
        
          tablaCategoria();
      },
    });
  }
  
  function clientes() {
    $.ajax({
      url: "http://129.159.52.217:8080/api/Client/all",
      type: "GET",
      dataType: "JSON",
      success: function (respuesta) {
        $("#clientes5").empty();
        var clientes = respuesta;
        clientes.forEach((cliente) => {
          $("#clientes5").append("<option  id='"+cliente.idClient+"' value='"+cliente.idClient+"'>"  + cliente.name + "</option");
        });
      },
      error: function (respuesta) {
        console.log(respuesta.xhr);
      },
    });
  }

  function computadores() {
    $.ajax({
      url: "http://129.159.52.217:8080/api/Computer/all",
      type: "GET",
      dataType: "JSON",
      success: function (respuesta) { 
        $("#computadores").empty();
        var computadores = respuesta;
        computadores.forEach((computador) => {
          $("#computadores").append("<option  id='"+computador.id+"' value='"+computador.id+"'>"  + computador.name + "</option");
        });
      },
      error: function (respuesta) {
        console.log(respuesta.xhr);
      },
    });
  }

  function tablaMensaje() {
    $.ajax({
      url: "http://129.159.52.217:8080/api/Message/all",
      type: "GET",
      dataType: "JSON",
      success: function (respuesta) {
    
        $("#mensajes").empty();
        var mensajes = respuesta;
        
        mensajes.forEach((mensaje) => {
          $("#mensajes").append("<tr>");
          $("#mensajes").append("<td>" + mensaje.idMessage + "</td>");
          $("#mensajes").append("<td>" + mensaje.client.name + "</td>");
          $("#mensajes").append("<td>" + mensaje.computer.name + "</td>");
          $("#mensajes").append("<td>" + mensaje.messageText + "</td>");
          $("#mensajes").append(
            '<td ><button id="eliminar" onclick="eliminarCliente(' +
            mensaje.idMessage +
              ')">Eliminar</button><button  id="editar" onclick="obtenerInformacion(' +
              mensaje.idMessage +
              ')">Editar</button></td> '
          );
          $("#mensajes").append("</tr>");
        });
      },
      error: function (respuesta) {
        console.log(respuesta.xhr);
      },
    });
  }
  
  // function eliminarCliente(idComputador) {
  //   var datos = {
  //     id: idComputador,
  //   };
  
  //   var datosEnviar = JSON.stringify(datos);
  
  //   $.ajax({
  //     dataType: "JSON",
  //     data: datosEnviar,
  //     url: "https://ga0076687dcad1a-reto1.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
  //     type: "DELETE",
  //     contentType: "application/JSON",
  //     success: function (respuesta) {
  //       console.log("Eliminado");
  //     },
  //     error: function (respuesta) {
  //       console.log("No se a podido eliminar");
  //     },
  //     complete: function (respuesta) {
  //       tablaCliente();
  //     },
  //   });
  // }


  // function obtenerInformacion(idElemento) {
  //   $("#registrar").hide();
  //   $("#actualizar").show();
  //   $.ajax({
  //     dataType: "JSON",
      
      
  //     url: "https://ga0076687dcad1a-reto1.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client/" +
  //       idElemento,
  //     type: "GET",
  //     success: function (respuesta) {
  //       console.log(respuesta);
  //       var cliente = respuesta.items[0];
     
  //       $("#id").val(cliente.id);
  //       $("#id").prop("disabled",true);
  //       $("#name").val(cliente.name);
  //       $("#email").val(cliente.email);
  //       $("#age").val(cliente.age);
  //     },
  //     error: function (jqXHR, textStatus, errorThrown) {},
  //   });
  // }

  // function actualizarComputador() {
  //   datos = {
        
  //     id: $("#id").val(),
  //     name: $("#name").val(),
  //     email: $("#email").val(),
  //     age: $("#age").val()
  //   };
  //   var datosEnviar = JSON.stringify(datos);
  
  //   $.ajax({
  //     dataType: "JSON",
  //     data: datosEnviar,
  //     url: "https://ga0076687dcad1a-reto1.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
  //     type: "PUT",
  //     contentType: "application/JSON",
  //     success: function (respuesta) {
  //       console.log("Actualizado");
  //     },
  //     error: function (respuesta) {
  //       console.log("No se a podido actualizar");
  //     },
  //     complete: function (respuesta) {
       
  //       $("#registrar").show();
  //       $("#actualizar").hide();
  //       $("#id").val(""),
  //       $("#id").prop("disabled",false);
  //         $("#name").val(""),
  //         $("#email").val(""),
  //         $("#age").val(""),
  
  //         tablaCliente();
  //     },
  //   });
  // }