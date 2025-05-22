package br.senai.aluno.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String desenvolvedora;

    // Construtores
    public Jogo() {
    }

    public Jogo(Long id, String nome, String genero, String desenvolvedora) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.desenvolvedora = desenvolvedora;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }
}
