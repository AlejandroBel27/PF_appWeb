/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function fijarPost(postId) {
    console.log("Intentando fijar el post con ID:", postId); // Depuración
    fetch(`${contextPath}/SvFijarPost`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ postId: postId })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('¡Publicación fijada con éxito!');
            // Opcional: Actualizar la interfaz
            location.reload(); // O actualizar dinámicamente
        } else {
            alert('Hubo un problema al fijar la publicación.');
        }
    })
    .catch(error => console.error('Error:', error));
}

function eliminarPost(postId) {
    console.log("Intentando eliminar el post con ID:", postId); // Depuración

    // Enviar la solicitud al servidor para eliminar el post
    fetch(`${contextPath}/SvEliminarPost`, {
        method: 'POST',  // Usamos el método POST para eliminar (aunque en la práctica puede ser DELETE, es más sencillo usar POST en este caso)
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ postId: postId })  // Enviamos el ID del post a eliminar
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('¡Publicación eliminada con éxito!');
            // Opcional: Actualizar la interfaz, por ejemplo recargar la página
            location.reload();  // O actualizar dinámicamente
        } else {
            alert('Hubo un problema al eliminar la publicación.');
        }
    })
    .catch(error => console.error('Error:', error));
}
