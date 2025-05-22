document.addEventListener('DOMContentLoaded', () => {
    // Verifica se o aluno está logado
    const alunoJson = localStorage.getItem('alunoLogado');

    if (!alunoJson) {
        alert('Aluno não está logado! Redirecionando para o login...');
        window.location.href = 'loginaluno.html';
        return;
    }
  
  // Usa o método JSON.parse para converter a string JSON armazenada na variável 'usuarioJson' em um objeto JavaScript.
  // Isso é necessário porque os dados armazenados no localStorage são sempre strings, e para acessar suas propriedades como 'nome' ou 'email',
  // precisamos transformá-los de volta em objeto.
  // O resultado é armazenado na constante 'usuario', que agora pode ser usada para acessar os dados do usuário como um objeto normal.
  const aluno = JSON.parse(alunoJson);

  // Busca o elemento HTML que possui o id 'nome' na página usando getElementById.
  // Depois, atribui ao conteúdo de texto interno (textContent) desse elemento o valor da propriedade 'nome' do objeto 'usuario'.
  // O operador lógico OR (||) é usado para garantir que, caso 'usuario.nome' seja undefined, null ou vazio, o conteúdo do elemento será definido como uma string vazia (''),
  // evitando que apareça 'undefined' ou erro na página.
  document.getElementById('nome').textContent = aluno.nome || '';
  document.getElementById('idade').textContent = aluno.idade || '';
  document.getElementById('rm').textContent = aluno.rm || '';
  document.getElementById('email').textContent = aluno.email || '';
  document.getElementById('jogoFavorito').textContent = aluno.jogoFavorito?.nome || '';

// Configura o botão de logout
    document.getElementById('logoutBtn').addEventListener('click', () => {
        localStorage.removeItem('alunoLogado');
        alert('Logout efetuado!');
        window.location.href = 'loginaluno.html';
    });

    // Opcional: Botão para deletar conta
    document.getElementById('deleteBtn')?.addEventListener('click', () => {
        if (confirm('Tem certeza que deseja excluir sua conta? Esta ação não pode ser desfeita.')) {
            fetch(`http://localhost:8080/api/alunos/${aluno.id}`, {
                method: 'DELETE',
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`
                }
            })
            .then(response => {
                if (response.ok) {
                    localStorage.removeItem('alunoLogado');
                    alert('Conta excluída com sucesso!');
                    window.location.href = 'index.html';
                } else {
                    throw new Error('Falha ao excluir conta');
                }
            })
            .catch(error => {
                alert(error.message);
            });
        }
    });
});
