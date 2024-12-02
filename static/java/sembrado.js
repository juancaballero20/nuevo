// Funcionalidad para el seguimiento de cultivo
function iniciarSeguimiento(plantaId) {
    const modal = document.getElementById('progreso-modal');
    modal.style.display = 'block';

    // Guardar el ID de la planta actual
    sessionStorage.setItem('plantaActual', plantaId);
}

// Cerrar modal
document.querySelector('.close').onclick = function() {
    document.getElementById('progreso-modal').style.display = 'none';
}

// Manejar el formulario de progreso
document.getElementById('progreso-form').onsubmit = function(e) {
    e.preventDefault();
    const plantaId = sessionStorage.getItem('plantaActual');
    const fecha = document.getElementById('fecha-inicio').value;
    const notas = document.getElementById('notas').value;
    const estado = document.getElementById('estado').value;

    // Enviar los datos al servidor usando fetch
    fetch('/api/registrar-seguimiento/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            plantaId: plantaId,
            fecha: fecha,
            notas: notas,
            estado: estado,
        }),
    })
    .then(response => response.json())
    .then(data => {
        if (data.message) {
            alert(data.message);
            document.getElementById('progreso-modal').style.display = 'none';
        } else if (data.error) {
            alert('Error al guardar el progreso: ' + data.error);
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Ocurrió un error al guardar el progreso.');
    });
};