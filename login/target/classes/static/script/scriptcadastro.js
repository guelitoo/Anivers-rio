document.addEventListener('DOMContentLoaded', () => {
	const form = document.getElementById('cadastroForm');

	form.addEventListener('submit', function(event) {
		event.preventDefault();

		const nome = document.getElementById('nome').value;
		const nomeUsuario = document.getElementById('nomeUsuario').value;
		const email = document.getElementById('email').value;
		const senha = document.getElementById('senha').value;

		fetch('http://localhost:8080/api/usuarios', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				nome,
				nomeUsuario,
				email,
				senha
			})
		})
			.then(response => {
				if (response.ok) {
					return response.json();
				} else {
					throw new Error('Erro ao cadastrar usuário');
				}
			})
			.then(data => {
				alert('Usuário cadastrado com sucesso!\nNome: ' + data.nome);
				window.location.href = 'index.html';
			})
			.catch(error => {
				alert('Falha no cadastro: ' + error.message);
			});
	});
});
