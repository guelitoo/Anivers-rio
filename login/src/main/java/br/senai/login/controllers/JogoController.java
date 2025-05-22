package br.senai.aluno.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.senai.aluno.entities.Jogo;
import br.senai.aluno.services.JogoService;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<Jogo> getAll() {
        return jogoService.findAll();
    }

    @GetMapping("/{id}")
    public Jogo getById(@PathVariable Long id) {
        return jogoService.findById(id);
    }

    @PostMapping
    public Jogo create(@RequestBody Jogo jogo) {
        return jogoService.save(jogo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        jogoService.delete(id);
    }
}
