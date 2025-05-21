package br.senai.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.login.entities.Usuario;
import br.senai.login.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario findByNomeUsuario(String nomeUsuario) {
		return usuarioRepository.findByNomeUsuario(nomeUsuario);
	}
	
	public Usuario AutenticarPessoa(String email, String senha) {
		
		//Buscar no banco de dados um usuario que tenha um email informado.
		Usuario pessoa = usuarioRepository.findByEmail(email);
		
		//Verifica se o usuario foi encontrado e se a semha informada conferi com a senha do usuariouu
		if (pessoa != null && pessoa.getSenha().equals(senha)) {
			//se email e senha estiverem corretos, retorna o objeto usuario autenticado
			return pessoa;
		} else{
			// se o usuario ´não existir ou a senha não estivar correto, retorna null(falha na altenticacao)
			return null;
		}
		
	}
}
