package com.example.demo.controller;

import com.example.demo.AlunoRepository;
import com.example.demo.dto.AlunoDTO;
import com.example.demo.dto.NotaDTO;
import com.example.demo.dto.XablauDTO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping(path = "/v1/alunos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity saveAlunos(@RequestBody XablauDTO xablau) {
        List<Aluno> alunosEntity = new ArrayList<>();
        xablau.getAlunos().forEach(a -> {
            alunosEntity.add(new Aluno(a.getNome(), a.getDataNascimento(), a.getNomeMae(), getNotasList(a.getNotas())));
        });

        repository.saveAll(alunosEntity);
        List<Aluno> all = repository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(path = "/v1/alunos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AlunoDTO> getAlunos(){
        List<AlunoDTO> list = new ArrayList<>();
        repository.findAll().forEach(a -> {
            list.add(new AlunoDTO(a.getNome(), a.getDataNascimento(), a.getNomeMae(), getNotasListDTO(a.getNotas())));
        });

        return list;
    }

    private List<Nota> getNotasList(List<NotaDTO> notas) {
        List<Nota> list = new ArrayList<>();

        notas.forEach(n -> {
            list.add(new Nota(n.getNota()));
        });

        return list;
    }

    private List<NotaDTO> getNotasListDTO(List<Nota> notas) {
        List<NotaDTO> list = new ArrayList<>();

        notas.forEach(n -> {
            list.add(new NotaDTO(n.getNota()));
        });

        return list;
    }

    @GetMapping(path = "/v1/alunos-por-nota/{nota}")
    public ResponseEntity getAlunosByNota(@PathVariable("nota") BigDecimal nota){
        return ResponseEntity.ok(repository.findByNotasNota(nota));
    }

}
