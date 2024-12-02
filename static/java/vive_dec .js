document.addEventListener("DOMContentLoaded", function() {
    // Obtiene todas las imágenes de los viveros
    const viveroImages = document.querySelectorAll(".vivero img");
    const modal = document.getElementById("modal");
    const modalText = document.getElementById("modal-text");
    const span = document.getElementsByClassName("close")[0];

    // Añade un evento de clic a cada imagen
    viveroImages.forEach(function(img) {
        img.addEventListener("click", function() {
            const info = this.parentElement.getAttribute("data-info");
            modalText.textContent = info;
            modal.style.display = "block";
        });
    });

    // Cierra el modal cuando se hace clic en el botón de cerrar
    span.onclick = function() {
        modal.style.display = "none";
    }

    // Cierra el modal cuando se hace clic fuera del contenido del modal
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
});
