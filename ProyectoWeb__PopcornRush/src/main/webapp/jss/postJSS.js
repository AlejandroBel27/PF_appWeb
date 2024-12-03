document.addEventListener("DOMContentLoaded", function () {
    // Obtener el ID del post desde algún lugar en la página
    const postId = document.getElementById("postId").value; // O cualquier otro elemento que tenga el postId

    // Hacer la solicitud GET para obtener los comentarios
    fetch(`/ProyectoWeb__PopcornRush/SvComentar?postId=${postId}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
            .then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert("Error: " + data.error);
                } else {
                    // Limpiar el contenedor de comentarios
                    const comentariosContainer = document.getElementById("comentarios-container");
                    comentariosContainer.innerHTML = ''; // Limpiar antes de agregar nuevos comentarios

                    // Iterar sobre los comentarios y agregarlos al contenedor
                    data.forEach(comentario => {
                        const comentarioDiv = document.createElement("div");
                        comentarioDiv.classList.add("comment");

                        const comentarioHTML = `
                        <p><strong>${comentario.usuarioNormal.nombreCompleto}</strong> (${new Date(comentario.fechaHora.time).toLocaleString()}):</p>
                        <p>${comentario.contenido}</p>
                    `;

                        comentarioDiv.innerHTML = comentarioHTML;
                        comentariosContainer.appendChild(comentarioDiv);
                    });
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("Ocurrió un error al obtener los comentarios.");
            });

    // Manejar el clic del botón para enviar el comentario
    const submitButton = document.getElementById("submitComment");
    if (submitButton) {
        submitButton.addEventListener("click", function () {
            const contenido = document.getElementById("contenido").value;
            const postId = document.getElementById("postId").value;

            // Verificar que el contenido y el ID del post no estén vacíos
            if (!contenido.trim() || !postId.trim()) {
                alert("Por favor, ingrese un comentario");
                return;
            }

            // Hacer la solicitud POST para enviar el comentario
            fetch("/ProyectoWeb__PopcornRush//SvComentar", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    postId: postId, // Asegúrate de que este nombre coincida con el backend
                    contenido: contenido
                })
            })
                    .then(response => response.json())
                    .then(data => {
                        if (data.error) {
                            alert("Error: " + data.error);
                        } else {
                            alert(data.message);
                            location.reload(); // Recarga la página para mostrar el nuevo comentario
                        }
                    })
                    .catch(error => {
                        console.error("Error:", error);
                        alert("Ocurrió un error inesperado. Inténtalo más tarde.");
                    });
        });
    }
});
