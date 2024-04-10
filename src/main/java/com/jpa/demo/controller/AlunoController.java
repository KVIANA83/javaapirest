package com.jpa.demo.controller;

import com.jpa.demo.repository.AlunoRepository;
import com.jpa.demo.dto.AlunoRecord;
import com.jpa.demo.model.Aluno;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/aluno") // Define o endpoint da aplicação, um endereco utilizado para comunicação entre uma API e um sistema externo.
public class AlunoController {

    @Autowired // Injeção de dependêcia, permite que o Spring controle as instância da classe AlunoRepository
    private AlunoRepository alunoRepository;
    
    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @PostMapping // Método POST
    // ResponseEntity representa toda a resposta HTTP
    // @RequestBody mapeia o corpo HttpRequest para um objeto de transferência
    public ResponseEntity<AlunoRecord> salvaAluno(@RequestBody AlunoRecord alunoRecord){
        Aluno alunoObj = new Aluno(alunoRecord.cpf()); // alunoObj vai receber o DTO de alunoRecord
        alunoRepository.save(alunoObj); // invoca o método save para armazenar o objeto no banco de dados
        return ResponseEntity.status(HttpStatus.CREATED).build(); // Retorna o status da resposta HTTP após a compilação
    }

    // Atualizar aluno
    @PutMapping("/{id}") 
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable int id, @RequestBody AlunoRecord alunoRecord) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        
        if (alunoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Aluno aluno = alunoOptional.get();
        aluno.setCpf(alunoRecord.getCpf());
        aluno.setNome(alunoRecord.getNome());
        aluno.setDataNascimento(alunoRecord.getDataNascimento());
        aluno.setEmail(alunoRecord.getEmail());
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return ResponseEntity.ok(alunoAtualizado);
    }

    // Deletar Aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable int id) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}