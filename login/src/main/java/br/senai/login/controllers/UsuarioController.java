package br.senai.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.senai.login.entities.Usuario;
import br.senai.login.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	// Listar todos os usuários
	@GetMapping
	public List<Usuario> getAll() {
		return usuarioService.findAll();
	}

	// Buscar usuário por ID
	@GetMapping("/{id}")
	public Usuario getById(@PathVariable Long id) {
		return usuarioService.findById(id);
	}

	// Criar novo usuário
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	// Deletar usuário por ID
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}

	
	//Buscar por nome de usuario
	@GetMapping("/buscarpornomeusuario")
	public Usuario getByNomeUsuario(@RequestParam String nomeUsuario) {
		return usuarioService.findByNomeUsuario(nomeUsuario);
	}
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario loginRequest) {
		
		//Chama o metodo de autenticação do service passando o email e senha fornecido no login
		//1. loginRequest.getEmail()- obtem o email enviado pelo usuario da requisição 
		//2. loginRequest.getSenha() - Obtem a senha enviada pelo usuario na requisição
		//3. UsuarioService.autenticarPessoa(Email, senha) -  verifica no banco se existe um usuario com este email e se a senha é valida 
		//4. Retorna o objeto usuarioautenticado, ou null caso falhe na autenticação 
		Usuario pessoa = usuarioService.AutenticarPessoa(loginRequest.getEmail(), loginRequest.getSenha());
		
		//verifica se o service retornou um usuario valido "autenticação bem-sucedida"
		if (pessoa != null) {
			//se autenticado, retorna os dados do usuario
			return pessoa;
		} else {
			//se não autenticadp retorna null indicando falha no login
			return null;
		}
	}
}
	