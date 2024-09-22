// Função para definir o cookie do tema
function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    let expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

// Função para obter o cookie
function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

// Função para alternar o tema
function toggleTheme() {
    const currentTheme = getCookie("theme");
    if (currentTheme === "dark") {
        document.getElementById("theme-stylesheet").href = "/css/style.css";  // Modo claro
        setCookie("theme", "light", 7);  // Armazena o tema claro no cookie
    } else {
        document.getElementById("theme-stylesheet").href = "/css/DarkMode.css";  // Modo escuro
        setCookie("theme", "dark", 7);  // Armazena o tema escuro no cookie
    }
}

// Carregar o tema correto ao carregar a página
window.onload = function () {
    const theme = getCookie("theme");
    if (theme === "dark") {
        document.getElementById("theme-stylesheet").href = "/css/DarkMode.css";
    } else {
        document.getElementById("theme-stylesheet").href = "/css/style.css";
    }

    // Adicionar o evento de clique no botão para mudar o tema
    document.getElementById("temaBtn").addEventListener("click", toggleTheme);
};
