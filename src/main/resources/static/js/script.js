$(document).ready(function () {
    // Função para deletar uma música
    $('#tabelaMusicas').on('click', '.deletar-musica', function (event) {
        event.preventDefault();
        var musicaId = $(this).data('musica-id');
        var csrfToken = getCsrfToken();

        if (confirm('Tem certeza de que deseja deletar esta música?')) {
            $.ajax({
                url: `/api/musicas/${musicaId}`,
                type: 'DELETE',
                headers: {
                    'X-CSRF-TOKEN': csrfToken
                },
                success: function () {
                    $('#musica-' + musicaId).remove();
                    alert('Música deletada com sucesso!');
                },
                error: function (error) {
                    alert('Erro ao deletar a música. Detalhes: ' + error.responseText);
                }
            });
        }
    });
});
