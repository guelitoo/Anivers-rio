document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('cadastroAlunoForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const nome = document.getElementById('nome').value;
        const idade = document.getElementById('idade').value;
        const rm = document.getElementById('rm').value;
        const email = document.getElementById('email').value;
        const senha = document.getElementById('senha').value;
        const jogoId = document.getElementById('jogoFavorito').value;

        fetch('http://localhost:8080/api/alunos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                nome,
                idade,
                rm,
                email,
                senha,
                jogoFavorito: {
                    id: jogoId
                }
            })
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                return response.json().then(err => {
                    throw new Error(err.message || 'Erro ao cadastrar aluno');
                });
            }
        })
        .then(data => {
            alert('Aluno cadastrado com sucesso!\nNome: ' + data.nome);
            window.location.href = 'login.html';
        })
        .catch(error => {
            alert('Falha no cadastro: ' + error.message);
        });
    });

    // Carrega os jogos disponíveis para o select
    fetch('http://localhost:8080/api/jogos')
        .then(response => response.json())
        .then(jogos => {
            const select = document.getElementById('jogoFavorito');
            jogos.forEach(jogo => {
                const option = document.createElement('option');
                option.value = jogo.id;
                option.textContent = jogo.nome;
                select.appendChild(option);
            });
        })
        .catch(error => console.error('Erro ao carregar jogos:', error));
});
