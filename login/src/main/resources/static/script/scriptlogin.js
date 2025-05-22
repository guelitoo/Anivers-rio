document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('loginAlunoForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const email = document.getElementById('email').value;
        const senha = document.getElementById('senha').value;

        fetch('http://localhost:8080/api/alunos/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                senha: senha
            })
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else if (response.status === 401) {
                throw new Error('Email ou senha inválidos.');
            } else {
                throw new Error('Erro na autenticação.');
            }
        })
        .then(aluno => {
            alert('Login realizado com sucesso! Bem-vindo, ' + aluno.nome);
            // Armazena os dados do aluno e redireciona
            localStorage.setItem('alunoLogado', JSON.stringify(aluno));
            window.location.href = 'perfilaluno.html';
        })
        .catch(error => {
            alert(error.message);
        });
    });
});
