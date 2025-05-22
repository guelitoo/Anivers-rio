package br.senai.aluno.controllers;

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
import br.senai.aluno.entities.Aluno;
import br.senai.aluno.services.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class UsuarioController {

    @Autowired
    private AlunoService alunoService;

    // Listar todos os alunos
    @GetMapping
    public List<Aluno> getAll() {
        return alunoService.findAll();
    }

    // Buscar aluno por ID
    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    // Criar novo aluno
    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    // Deletar aluno por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alunoService.delete(id);
    }
    
    // Buscar por RM
    @GetMapping("/buscarporrm")
    public Aluno getByRm(@RequestParam String rm) {
        return alunoService.findByRm(rm);
    }
    
    // Login
    @PostMapping("/login")
    public Aluno login(@RequestBody Aluno loginRequest) {
        // Chama o método de autenticação do service passando email e senha
        Aluno aluno = alunoService.AutenticarAluno(loginRequest.getEmail(), loginRequest.getSenha());
        
        if (aluno != null) {
            return aluno;
        } else {
            return null;
        }
    }
    
    // Buscar alunos por jogo favorito
    @GetMapping("/porjogo/{jogoId}")
    public List<Aluno> getByJogoFavorito(@PathVariable Long jogoId) {
        return alunoService.findByJogoFavorito(jogoId);
    }
}
