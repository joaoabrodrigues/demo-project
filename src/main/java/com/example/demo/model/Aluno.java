package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Aluno {

    @Id
    @Column(name = "ALUNO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "NOME_MAE")
    private String nomeMae;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno", orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ALUNO_ID", referencedColumnName = "ALUNO_ID", nullable = false)
    private List<Nota> notas;

    public Aluno() {
    }

    public Aluno(String nome, LocalDate dataNascimento, String nomeMae, List<Nota> notas) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nomeMae = nomeMae;
        this.notas = notas;
    }

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
