package br.senai.aluno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.senai.aluno.entities.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    Jogo findByNome(String nome);
}
