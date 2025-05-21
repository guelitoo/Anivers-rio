package br.senai.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.senai.login.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//Consulta para encontra o nome de usuario
	Usuario findByNomeUsuario(String nomeUsuario);
	
	//Consulta para encontrar por email
	Usuario findByEmail(String email);
}
