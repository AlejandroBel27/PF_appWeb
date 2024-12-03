/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


document.addEventListener("DOMContentLoaded", function() {
    const commentForm = document.getElementById("commentForm");
    commentForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevenir que se envíe el formulario de manera tradicional

        // Obtener los datos del formulario
        const contenido = document.getElementById("comentarioContenido").value;
        const postId = document.getElementById("postId").value;

        // Verificar que el comentario no esté vacío
        if (contenido.trim() === "") {
            alert("El comentario no puede estar vacío.");
            return;
        }

        // Crear el objeto de datos para enviar al servidor
        const formData = new FormData();
        formData.append("contenido", contenido);
        formData.append("postId", postId);

        // Enviar los datos al servidor usando AJAX
        fetch("${pageContext.request.contextPath}/SvComentar", {
            method: "POST",
            body: formData
        })
        .then(response => response.json()) // Suponemos que el servidor responde con un JSON
        .then(data => {
            if (data.success) {
                // Si el comentario se envió correctamente, agregarlo al DOM
                const commentsSection = document.getElementById("commentsSection");
                const newComment = document.createElement("div");
                newComment.classList.add("comment");
                newComment.innerHTML = `<p><strong>${data.usuario}</strong> (${data.fecha}):</p><p>${data.contenido}</p>`;
                commentsSection.appendChild(newComment);

                // Limpiar el campo de texto
                document.getElementById("comentarioContenido").value = "";
            } else {
                alert("Error al enviar el comentario.");
            }
        })
        .catch(error => {
            console.error("Error al enviar el comentario:", error);
            alert("Ocurrió un error al enviar el comentario.");
        });
    });
});
