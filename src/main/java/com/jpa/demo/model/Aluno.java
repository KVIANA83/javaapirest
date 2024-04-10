package com.jpa.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.UUID;

import java.time.LocalDate;

@Entity // Anotação que informa ao Spring que esta classe será uma entidade do banco de dados
@Data // Gera automaticamente métodos toString, equals, hashCode, bem como getters e setters para todos os campos da classe
@Builder // Gera um padrão de design Builder para a classe, facilitando a criação de instâncias com muitos campos e fornecendo uma maneira mais legível de configurar esses campos
@AllArgsConstructor // Gera um construtor com todos os campos da classe como argumentos
@NoArgsConstructor // Gera um construtor sem argumentos
@Table(name = "tb_aluno") // Anotação que define qual o nome da tabela no banco de dados
public class Aluno implements Serializable { // A classe Aluno implementa uma interface responsável pela serialização.

    private static final long versionSerialUID = 1L;    // Esta variável define a versão da serialização. Caso haja uma mudança significativa na estrutura da classe Aluno o valor da versão deve ser alterado

    @Id // Anotação que informa ao Spring qual será a chave primária da tabela tb_aluno
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação que gera automaticamente um valor para a chave primária
    private int id;
    private String cpf;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

}