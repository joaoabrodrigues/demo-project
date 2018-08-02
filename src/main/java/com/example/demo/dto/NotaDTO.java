package com.example.demo.dto;

import java.math.BigDecimal;

public class NotaDTO {

    private BigDecimal nota;

    public NotaDTO() {

    }

    public NotaDTO(BigDecimal nota) {
        this.nota = nota;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }
}
