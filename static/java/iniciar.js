document.addEventListener('DOMContentLoaded', () => {
    const slides = document.querySelectorAll('.carousel-item');
    const dots = document.querySelectorAll('.carousel-dot');
    let currentSlide = 0;

    function showSlide(index) {
        // Reset all slides
        slides.forEach(slide => {
            slide.classList.remove('active');
            slide.style.transform = 'translateX(100%)';
        });

        // Set active slide
        currentSlide = (index + slides.length) % slides.length;
        slides[currentSlide].classList.add('active');
        slides[currentSlide].style.transform = 'translateX(0)';

        // Update dots
        dots.forEach((dot, i) => {
            dot.classList.toggle('active', i === currentSlide);
        });
    }

    function nextSlide() {
        showSlide(currentSlide + 1);
    }

    // Manual dot navigation
    dots.forEach((dot, index) => {
        dot.addEventListener('click', () => {
            showSlide(index);
        });
    });

    // Initial setup
    showSlide(0);

    // Auto-rotate every 3 seconds
    setInterval(nextSlide, 3000);
});