package com.bruno.api_biblioteca.controllers;

import com.bruno.api_biblioteca.models.LivroModel;
import com.bruno.api_biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAllLivros() {
        return ResponseEntity.ok().body(livroService.listarLivros());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok().body(livroService.listarLivroId(id));
    }

    @PostMapping(value = "/cadastrar-livro")
    public ResponseEntity<LivroModel> inserirLivro(@RequestBody LivroModel livroModel) {
        return ResponseEntity.ok().body(livroService.salvarLivro(livroModel));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> atualizarLivro(@PathVariable(value = "id") Integer id, @RequestBody LivroModel livroModel) {
        Optional<LivroModel> livro = livroService.listarLivroId(id);
        LivroModel livroRecuperado = livro.get();
        livroRecuperado.setTitulo(livroModel.getTitulo());
        livroRecuperado.setAutor(livroModel.getAutor());
        livroRecuperado.setEditora(livroModel.getEditora());
        livroRecuperado.setAno_publicacao(livroModel.getAno_publicacao());
        return ResponseEntity.ok().body(livroService.salvarLivro(livroRecuperado));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletarLivroId(@PathVariable(value = "id") Integer id){
        livroService.excluirLivro(id);
        return ResponseEntity.ok().body("Livro excluido com sucesso!");
    }
}
