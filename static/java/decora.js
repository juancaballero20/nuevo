document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById('modal');
    const modalText = document.getElementById('modal-text');
    const span = document.getElementsByClassName('close')[0];
    const plantItems = document.querySelectorAll('.plant-item');

    plantItems.forEach(item => {
        item.addEventListener('click', () => {
            const info = item.getAttribute('data-info');
            modalText.textContent = info;
            modal.style.display = 'block';
        });
    });

    span.onclick = function() {
        modal.style.display = 'none';
    }

    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    }
});
