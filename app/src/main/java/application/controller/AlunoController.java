package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.model.Aluno;
import application.repository.AlunoRepository;

@RestController
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepo;

    @GetMapping("/alunos")
    public List<Aluno> getAlunos(){
        return (List<Aluno>) alunoRepo.findAll();
    }
    
    @GetMapping("/alunos/{id}")
    public Aluno getAluno(@PathVariable Long id){
        return alunoRepo.findById(id).get();
    }

    @PostMapping("/alunos")
    public Aluno postAluno(@RequestBody Aluno aluno){
        return alunoRepo.save(aluno);
    }

    @PutMapping("/alunos/{id}")
    public Aluno putAluno (@RequestBody Aluno aluno, @PathVariable Long id){
        Aluno resposta = alunoRepo.findById(id).get();

        resposta.setNome(aluno.getNome());
        resposta.setCurso(aluno.getCurso());
        resposta.setIdade(aluno.getIdade());

        return alunoRepo.save(resposta);
    }

    @DeleteMapping("/alunos/{id}")
    public void deleteAlunos (@PathVariable Long id){
        alunoRepo.deleteById(id);
    }
}
