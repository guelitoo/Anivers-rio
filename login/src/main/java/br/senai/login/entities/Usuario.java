package br.senai.aluno.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int idade;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String rm;

    @Column(nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogo jogoFavorito;

    // Construtores
    public Aluno() {
    }

    public Aluno(Long id, String nome, int idade, String email, String rm, String senha, Jogo jogoFavorito) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.rm = rm;
        this.senha = senha;
        this.jogoFavorito = jogoFavorito;
    }

    // Getters e Setters (adicionar getter e setter para Jogo)
    public Jogo getJogoFavorito() {
        return jogoFavorito;
    }

    public void setJogoFavorito(Jogo jogoFavorito) {
        this.jogoFavorito = jogoFavorito;
    }
    
    // Outros getters e setters permanecem iguais...
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
