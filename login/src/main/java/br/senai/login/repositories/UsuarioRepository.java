package br.senai.aluno.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.senai.aluno.entities.Aluno;
import br.senai.aluno.entities.Jogo;

@Repository
public interface UsuarioRepository extends JpaRepository<Aluno, Long> {
    
    // Consulta para encontrar por RM
    Aluno findByRm(String rm);
    
    // Consulta para encontrar por email
    Aluno findByEmail(String email);
    
    // Consulta para encontrar alunos por jogo favorito
    List<Aluno> findByJogoFavorito(Jogo jogo);
}
