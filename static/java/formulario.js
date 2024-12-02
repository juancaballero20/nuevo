// Selección de elementos del DOM
const modal = document.getElementById('modal');
const modalTitle = document.getElementById('modal-title');
const modalDescription = document.getElementById('modal-description');
const modalPlanting = document.getElementById('modal-planting');
const modalLink = document.getElementById('modal-link');

// Función para mostrar los detalles del producto en el modal
function showDetails(title, description, planting, link) {
    // Actualizar contenido del modal
    modalTitle.textContent = title;
    modalDescription.textContent = description;
    modalPlanting.textContent = `Cómo sembrar: ${planting}`;
    modalLink.href = link;

    // Mostrar el modal
    modal.style.display = 'block';
}

// Función para cerrar el modal
function closeModal() {
    modal.style.display = 'none';
}

// Cerrar el modal al hacer clic fuera del contenido
window.onclick = function(event) {
    if (event.target === modal) {
        closeModal();
    }
};
