package com.bruno.api_biblioteca.services;

import com.bruno.api_biblioteca.models.LivroModel;
import com.bruno.api_biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    //Listar todos os livros
    public List<LivroModel> listarLivros(){
        List<LivroModel> livros = livroRepository.findAll();
        return livros;
    }

    //Listar Livro por Id
    public Optional<LivroModel> listarLivroId(Integer id){
        return livroRepository.findById(id);
    }

    //Cadastrar Livro
    public LivroModel salvarLivro(@RequestBody LivroModel livroModel){
        return livroRepository.save(livroModel);
    }

    //Excluir Livro
    public void excluirLivro(Integer id){
        livroRepository.deleteById(id);
    }
}
