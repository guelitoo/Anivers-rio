package br.senai.aluno.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.senai.aluno.entities.Jogo;
import br.senai.aluno.repositories.JogoRepository;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> findAll() {
        return jogoRepository.findAll();
    }

    public Jogo findById(Long id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public Jogo save(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public void delete(Long id) {
        jogoRepository.deleteById(id);
    }

    public Jogo findByNome(String nome) {
        return jogoRepository.findByNome(nome);
    }
}
