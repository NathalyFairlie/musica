// Função para alternar entre os temas claro e escuro
function toggleTheme() {
    const body = document.body;
    const currentTheme = body.classList.contains('dark-mode') ? 'dark' : 'light';
    
    if (currentTheme === 'light') {
        body.classList.add('dark-mode');
        localStorage.setItem('theme', 'dark');
    } else {
        body.classList.remove('dark-mode');
        localStorage.setItem('theme', 'light');
    }
}

// Carrega o tema salvo no armazenamento local
document.addEventListener("DOMContentLoaded", function() {
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme === 'dark') {
        document.body.classList.add('dark-mode');
    }
});

// Adiciona um evento para o botão de alternância de tema
document.getElementById('toggle-theme-btn').addEventListener('click', toggleTheme);
