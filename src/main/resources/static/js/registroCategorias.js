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
            '<td ><button id="eliminar" onclick="eliminarCategoria(' +
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
  
  function eliminarCategoria(idCategoria) {
    console.log(idCategoria);
    var datos = {
      id: idCategoria,
    };
  
    var datosEnviar = JSON.stringify(datos);
  
    $.ajax({
      
      type: "DELETE",
      dataType: "jsonp",
      // contentType: "application/json; charset=utf8",
      // dataType: "JSON",
      url: "http://129.159.52.217:8080/api/Category/"+idCategoria,
      
      // contentType: "application/JSON",
      success: function (respuesta) {
        console.log("Eliminado");

      },
      error: function (respuesta) {
        console.log("No se a podido eliminar");
        console.log(respuesta);
      },
      complete: function (respuesta) {
        tablaCategoria();
      },
    });
  }


  function obtenerInformacion(idElemento) {
    $("#registrar").hide();
    $("#actualizar").show();

    $.ajax({
      url: "http://129.159.52.217:8080/api/Category/"+idElemento,
      type: "GET",
      dataType: "JSON",

      
      
      
      
      success: function (respuesta) {
        console.log(respuesta);
        var categoria = respuesta;
     
        $("#id").val(categoria.id);
        $("#id").prop("disabled",true);
        $("#name").val(categoria.name);
        $("#description").val(categoria.description);
      
      },
      error: function (jqXHR, textStatus, errorThrown) {},
    });
  }

  function actualizarCategoria() {
    datos = {
        
      id: $("#id").val(),   
      name : $("#name").val(),
      description :$("#description").val()
    };
    var datosEnviar = JSON.stringify(datos);
  
    $.ajax({

      type: "PUT",
      contentType: "application/json; charset=utf8",
      dataType: "JSON",
      data: datosEnviar,
      url: "http://129.159.52.217:8080/api/Category/update",

      success: function (respuesta) {
        console.log("Actualizado");
      },
      error: function (respuesta) {
        console.log("No se a podido actualizar");
      },
      complete: function (respuesta) {
       
        $("#registrar").show();
        $("#actualizar").hide();
        $("#id").val(""),
        $("#id").prop("disabled",false);
          $("#name").val(""),
          $("#description").val(""),
     
  
          tablaCategoria()
      },
    });
  }