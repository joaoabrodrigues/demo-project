package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class Nota {

    @Id
    @Column(name = "NOTA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal nota;

//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "ALUNO_ID", table = "NOTA", nullable = false)
//    private Aluno aluno;

    public Nota() {}

    public Nota(BigDecimal nota) {
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }
//
//    public Aluno getAluno() {
//        return aluno;
//    }
//
//    public void setAluno(Aluno aluno) {
//        this.aluno = aluno;
//    }
}
