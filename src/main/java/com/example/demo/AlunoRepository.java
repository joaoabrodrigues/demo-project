package com.example.demo;

import com.example.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "aluno", path = "aluno")
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNotasNota(@Param("nota") BigDecimal nota);

}
