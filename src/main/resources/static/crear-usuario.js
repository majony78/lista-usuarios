$('#crearUsuarioBtn').on('click', function(e){
     e.preventDefault();
     
     var nombre = $('#nombre').val();
     var email = $('#exampleInputEmail').val();
     
     $.ajax({ 
    	    type: "post",
    	    cache: false,
    	    dataType: "json",
    	    contentType: "application/json", // Agrega esta línea
    	    data: JSON.stringify({nombre: nombre, email: email}), // Convierte los datos a JSON
    	    url: "/usuario/save",
    	    success: function(json) {
    	        mostrarMensaje("Usuario creado correctamente");
    	        console.log("Usuario");
    	        console.log(json);
    	        // Redirigir a la página deseada
           window.location.href = "http://localhost:8080/listausuario";
    	    },
    	    error: function() {
    	        mostrarMensaje("Ha ocurrido un error al crear el usuario");
    	       
    	    } 
    	});
     
});

function mostrarMensaje(mensaje){
    // Muestra el mensaje al usuario
    alert(mensaje);
}
