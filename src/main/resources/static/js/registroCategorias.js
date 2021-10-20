$(document).ready(function () {
    $("#actualizar").hide();
    
    tablaCategoria();
  
      $("#name").val(""),
      $("#description").val("");
      
  });
  
  function registrarCategoria() {
    datos = {
      
      name: $("#name").val(),
      description: $("#description").val(),
      
    };
    var datosEnviar = JSON.stringify(datos);
  
    $.ajax({
      type: "POST",
      contentType: "application/json; charset=utf8",
      dataType: "JSON",
      data: datosEnviar,
      url: "http://129.159.52.217:8080/api/Category/save",
      
      
      
      success: function (respuesta) {
        console.log("Registrado");
        console.log(respuesta.name);
      },
      error: function (respuesta) {
        console.log("No Registrado");
      },
      complete: function (respuesta) {
        $("#password").val(""),
          $("#name").val(""),
          $("#description").val(""),
        
          tablaCategoria();
      },
    });
  }
  
  function tablaCategoria() {
    $.ajax({
      url: "http://129.159.52.217:8080/api/Category/all",
      type: "GET",
      dataType: "JSON",
      success: function (respuesta) {
        console.log("Refresco")
        $("#category").empty();
        var categorias = respuesta;
        console.log(categorias);
        categorias.forEach((categoria) => {
          $("#category").append("<tr>");
          $("#category").append("<td>" + categoria.id + "</td>");
          $("#category").append("<td>" + categoria.name + "</td>");
          $("#category").append("<td>" + categoria.description + "</td>");
          $("#category").append(
            '<td ><button id="eliminar" onclick="eliminarCliente(' +
              categoria.id +
              ')">Eliminar</button><button  id="editar" onclick="obtenerInformacion(' +
              categoria.id +
              ')">Editar</button></td> '
          );
          $("#category").append("</tr>");
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