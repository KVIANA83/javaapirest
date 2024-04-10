package com.jpa.demo.repository;

import com.jpa.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.time.LocalDate;

@Repository // Informa ao Spring que esta interface atuará como um repositório de banco de dados.
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
    // são métodos de consulta personalizados que permitem buscar um aluno pelo campo de data de nascimento ou pelo CPF
    Optional<Aluno> findByDataNascimento(LocalDate dataNascimento);
    Optional<Aluno> findByCpf(String cpf);
    
    // Optional indica que o resultado pode ser nulo
}