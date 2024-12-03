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

                    data.forEach(comentario => {
                        const comentarioDiv = document.createElement("div");
                        comentarioDiv.classList.add("comment");

                        // Convertir el valor en milisegundos a un objeto Date
                        const fecha = new Date(comentario.fechaHora);  // Esto usará el valor en milisegundos

                        // Formatear la fecha para que sea legible
                        const fechaFormateada = fecha.toLocaleString();


                        // Crear el HTML del comentario
                        const comentarioHTML = `<div class="comentario-header">
                            <img src="${comentario.usuarioNormal.avatar}" alt="Foto de ${comentario.usuarioNormal.nombreCompleto}" class="foto-usuario">
                            <strong>${comentario.usuarioNormal.nombreCompleto}</strong> (${fechaFormateada}):
                            </div><p>${comentario.contenido}</p>`;
                        console.log(comentario.usuarioNormal.avatar);
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

function formatearFechaPersonalizada(fechaTexto) {
    // Dividir la fecha en partes (YYYY-MM-DD y HH:mm:ss)
    const [fecha, hora] = fechaTexto.split(" ");
    const [año, mes, día] = fecha.split("-");
    const [horas, minutos, segundos] = hora.split(":");

    // Retornar en el formato deseado, por ejemplo: DD/MM/YYYY HH:mm:ss
    return `${día}/${mes}/${año} ${horas}:${minutos}:${segundos}`;
}
