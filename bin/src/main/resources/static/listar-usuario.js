


 // NO ESTÁ ENLAZADA!!! SOLO COMO INFO!!!!




listarUsuarios();

function listarUsuarios() {
	$.ajax({
		type: "post",
		cache: false,
		dataType: 'json',
		//data:{idcounter:idcounter},
		url: "/usuario/listar",
		success: function(json) {
			mostrarUsuarios(json);
			console.log("Usuarios");
			console.log(json);

		}
	});

}

function mostrarUsuarios(json) {
	$.each(json, function(index, usuario) {
		// Crea una nueva fila de la tabla para cada usuario
		var fila = $('<tr>');

		// Crea una nueva celda de la tabla para el nombre del usuario y asigna el valor correspondiente
		var nombreCelda = $('<td>').text(usuario.nombre);

		// Crea una nueva celda de la tabla para el email del usuario y asigna el valor correspondiente
		var emailCelda = $('<td>').text(usuario.email);

		var botonEditar = $('<td>').html('<a href="/usuario/listar/' + usuario.id + '" class="btn btn-primary btn-editar">Editar</a>');

		$(document).on('click', '.btn-editar', function(e) {
			e.preventDefault();
			var idUsuario = $(this).attr('href').split('/').pop();
			editarUsuario(idUsuario);
		});



		var botonEliminar = $('<td>').html('<button type="button" class="btn btn-danger btn-eliminar" data-id="' + usuario.id + '">Eliminar</button>');

		$('body').on('click', '.btn-eliminar', function() {
			var idUsuario = $(this).data('id');
			eliminarUsuario(idUsuario);
		});

		// Agrega las celdas a la fila de la tabla
		fila.append(nombreCelda, emailCelda, botonEditar, botonEliminar);

		// Agrega la fila de la tabla al cuerpo de la tabla
		$('#lista-usuarios').append(fila);
	});
}

function editarUsuario(idUsuario) {
	// Aquí puedes hacer una llamada AJAX para buscar el usuario correspondiente por ID y mostrar un formulario de edición
	// Puedes usar el siguiente código como ejemplo:
	$.ajax({
		type: "post",
		cache: false,
		dataType: 'json',
		data: { id: idUsuario },
		 url: `/usuario/listar/${idUsuario}`,
		success: function(usuario) {
			mostrarFormularioEdicion(usuario);
			console.log(usuario);
			
			
		}
	});
	
	
	function mostrarFormularioEdicion(usuario) {
    // Crea un formulario para editar el usuario con los datos obtenidos
    var formulario = $('<form>').append(
        $('<div>').addClass('form-group').append(
            $('<label>').text('Nombre'),
            $('<input>').addClass('form-control').attr('id', 'nombre').val(usuario.nombre)
        ),
        $('<div>').addClass('form-group').append(
            $('<label>').text('Email'),
            $('<input>').addClass('form-control').attr('id', 'exampleInputEmail').val(usuario.email)
        ),
        $('<button>').addClass('btn btn-primary').text('Guardar').on('click', function(e){
            e.preventDefault();
            
            var nombre = $('#nombre').val();
            var email = $('#exampleInputEmail').val();
            
            $.ajax({ 
                type: "post",
                cache: false,
                dataType: "json",
                contentType: "application/json", // Agrega esta línea
                data: JSON.stringify({nombre: nombre, email: email}), // Convierte los datos a JSON
                url: `/usuario/editar/${usuario.id}`,
                success: function(json) {
                    mostrarMensaje("Usuario editado correctamente");
                    console.log("Usuario");
                    console.log(json);
                },
                error: function() {
                    mostrarMensaje("Ha ocurrido un error al editar el usuario");
                } 
            });
        })
    );
    
    // Muestra el formulario en la página
    $('#formulario').empty().append(formulario);
}

}