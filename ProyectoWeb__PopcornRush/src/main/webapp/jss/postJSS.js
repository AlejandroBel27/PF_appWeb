document.addEventListener("DOMContentLoaded", function () {
    // Manejar el clic del botón para enviar el comentario
    const submitButton = document.getElementById("submitComment");
    if (submitButton) {
        submitButton.addEventListener("click", function () {
            const contenido = document.getElementById("contenido").value;
            const postId = document.getElementById("postId").value;

            // Hacer la solicitud POST con fetch
            fetch("/SvComentar", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ contenido, postId }),
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
