package br.senai.aluno.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.senai.aluno.entities.Aluno;
import br.senai.aluno.entities.Jogo;
import br.senai.aluno.repositories.AlunoRepository;
import br.senai.aluno.repositories.JogoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private JogoRepository jogoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id).get();
    }

    public Aluno save(Aluno aluno) {
        // Verifica se o jogo foi informado e busca no banco
        if(aluno.getJogoFavorito() != null && aluno.getJogoFavorito().getId() != null) {
            Jogo jogo = jogoRepository.findById(aluno.getJogoFavorito().getId()).get();
            aluno.setJogoFavorito(jogo);
        }
        return alunoRepository.save(aluno);
    }

    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
    
    public Aluno findByRm(String rm) {
        return alunoRepository.findByRm(rm);
    }
    
    public Aluno AutenticarAluno(String email, String senha) {
        
        // Buscar no banco de dados um aluno que tenha o email informado
        Aluno aluno = alunoRepository.findByEmail(email);
        
        // Verifica se o aluno foi encontrado e se a senha informada confere
        if (aluno != null && aluno.getSenha().equals(senha)) {
            // Se email e senha estiverem corretos, retorna o objeto aluno autenticado
            return aluno;
        } else {
            // Se o aluno não existir ou a senha não estiver correta, retorna null (falha na autenticação)
            return null;
        }
    }
    
    public List<Aluno> findByJogoFavorito(Long jogoId) {
        Jogo jogo = jogoRepository.findById(jogoId).get();
        return alunoRepository.findByJogoFavorito(jogo);
    }
}
