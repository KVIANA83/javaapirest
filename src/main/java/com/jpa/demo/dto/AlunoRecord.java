package com.jpa.demo.dto;

import java.time.LocalDate;

public record AlunoRecord(String cpf, String nome, LocalDate dataNascimento) {
    
}