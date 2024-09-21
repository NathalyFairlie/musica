document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector('form');

    // Validação adicional antes do envio do formulário
    form.addEventListener('submit', function(event) {
        const nota = document.getElementById('nota').value;
        const comentario = document.getElementById('comentario').value;

        if (nota < 1 || nota > 10) {
            alert('Por favor, insira uma nota entre 1 e 10.');
            event.preventDefault(); // Impede o envio do formulário
        }

        if (comentario.trim() === "") {
            alert('O comentário não pode estar vazio.');
            event.preventDefault(); // Impede o envio do formulário
        }
    });
});
