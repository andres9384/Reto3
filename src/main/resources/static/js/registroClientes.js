$(document).ready(function () {
    $("#actualizar").hide();
    
    tablaCliente();
    $("#password").val(""),
      $("#name").val(""),
      $("#email").val(""),
      $("#age").val("");
  });
  
  function registrarCliente() {
    datos = {
      
      name: $("#name").val(),
      email: $("#email").val(),
      password:$("#password").val(),
      age: $("#age").val(),
    };
    var datosEnviar = JSON.stringify(datos);
  
    $.ajax({
      type: "POST",
      contentType: "application/json; charset=utf8",
      dataType: "JSON",
      data: datosEnviar,
      url: "http://129.159.52.217:8080/api/Client/save",
      
      
      
      success: function (respuesta) {
        console.log("Registrado");
        console.log(respuesta.age);
      },
      error: function (respuesta) {
        console.log("No Registrado");
      },
      complete: function (respuesta) {
        $("#password").val(""),
          $("#name").val(""),
          $("#email").val(""),
          $("#age").val(""),
          tablaCliente();
      },
    });
  }
  
  function tablaCliente() {
    $.ajax({
      url: "http://129.159.52.217:8080/api/Client/all",
      type: "GET",
      dataType: "JSON",
      success: function (respuesta) {
        console.log("Refresco")
        $("#client").empty();
        var clientes = respuesta;
        console.log(clientes);
        clientes.forEach((cliente) => {
          $("#client").append("<tr>");
          $("#client").append("<td>" + cliente.idClient + "</td>");
          $("#client").append("<td>" + cliente.name + "</td>");
          $("#client").append("<td>" + cliente.email + "</td>");
          $("#client").append("<td>" + cliente.age + "</td>");
          $("#client").append(
            '<td ><button id="eliminar" onclick="eliminarCliente(' +
              cliente.idClient +
              ')">Eliminar</button><button  id="editar" onclick="obtenerInformacion(' +
              cliente.idClient +
              ')">Editar</button></td> '
          );
          $("#client").append("</tr>");
        });
      },
      error: function (respuesta) {
        console.log(respuesta.xhr);
      },
    });
  }
  
  
  function eliminarCliente(idCliente) {
    var datos = {
      id: idCliente,
    };
  
    var datosEnviar = JSON.stringify(datos);
  
    $.ajax({
      type: "DELETE",
      dataType: "jsonp",
      url: "http://129.159.52.217:8080/api/Client/"+idCliente,
      contentType: "application/JSON",
      success: function (respuesta) {
        console.log("Eliminado");
      },
      error: function (respuesta) {
        console.log("No se a podido eliminar");
      },
      complete: function (respuesta) {
        tablaCliente();
      },
    });
  }


  function obtenerInformacion(idElemento) {
    $("#registrar").hide();
    $("#actualizar").show();
    $.ajax({
      dataType: "JSON",
      url: "http://129.159.52.217:8080/api/Client/"+idElemento,
      type: "GET",
      success: function (respuesta) {
        console.log(respuesta);
        var cliente = respuesta;
     
        $("#id").val(cliente.idClient);
        $("#id").prop("disabled",true);
        $("#password").val(cliente.password);
        $("#name").val(cliente.name);
        $("#email").hide();
        $("#age").val(cliente.age);
      },
      error: function (jqXHR, textStatus, errorThrown) {},
    });
  }

  function actualizarCliente() {
    datos = {
        
      idClient: $("#id").val(),
      name: $("#name").val(),
      password: $("#password").val(),
      age: $("#age").val()
    };
    var datosEnviar = JSON.stringify(datos);
    console.log(datosEnviar);
    $.ajax({
      type: "PUT",
      contentType: "application/json; charset=utf8",
      dataType: "JSON",
      data: datosEnviar,
      url: "http://129.159.52.217:8080/api/Client/update",
     
      success: function (respuesta) {
        console.log("Actualizado");
        console.log(respuesta)
      },
      error: function (respuesta) {
        console.log("No se a podido actualizar");
      },
      complete: function (respuesta) {
        $("#email").show();
        $("#registrar").show();
        $("#actualizar").hide();
        $("#id").val(""),
        $("#id").prop("disabled",false);
          $("#name").val(""),
          $("#email").val(""),
          $("#age").val(""),
  
          tablaCliente();
      },
    });
  }