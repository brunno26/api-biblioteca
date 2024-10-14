package com.bruno.api_biblioteca.controllers;

import com.bruno.api_biblioteca.dto.EmprestimoDTO;
import com.bruno.api_biblioteca.models.EmprestimoModel;
import com.bruno.api_biblioteca.models.LivroModel;
import com.bruno.api_biblioteca.models.UsuarioModel;
import com.bruno.api_biblioteca.repositories.EmprestimoRepository;
import com.bruno.api_biblioteca.services.EmprestimoService;
import com.bruno.api_biblioteca.services.LivroService;
import com.bruno.api_biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LivroService livroService;
    @Autowired
    private EmprestimoRepository emprestimoRepository;


    @GetMapping
    public ResponseEntity <List<EmprestimoModel>> findAllEmprestimos(){
        return ResponseEntity.ok().body(emprestimoService.consultarEmprestimos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Object> finById(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok().body(emprestimoService.consultarEmprestimosId(id));
    }

    @PostMapping(value = "/cadastrar-emprestimo")
    public ResponseEntity<EmprestimoModel> inserirEmprestimo(@RequestBody EmprestimoDTO dto) {
        EmprestimoModel emprestimoModel = new EmprestimoModel();
        emprestimoModel.setData_emprestimo(dto.getData_emprestimo());
        emprestimoModel.setData_devolucao(dto.getData_devolucao());

        Optional<LivroModel> livro = livroService.listarLivroId(dto.getId_livro());
        emprestimoModel.setLivro(livro.orElse(null));

        Optional<UsuarioModel> usuario = usuarioService.listarUsuarioId(dto.getId_usuario());
        emprestimoModel.setUsuario(usuario.orElse(null));

        return ResponseEntity.ok().body(emprestimoService.salvarEmprestimo(emprestimoModel));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> atualizarEmprestimo(@PathVariable(value = "id") Integer id, @RequestBody EmprestimoModel emprestimoModel) {
        Optional<EmprestimoModel> emprestimo = emprestimoService.consultarEmprestimosId(id);
        EmprestimoModel emprestimoRecuperado = emprestimo.get();
        emprestimoRecuperado.setData_emprestimo(emprestimoModel.getData_emprestimo());
        emprestimoRecuperado.setData_devolucao(emprestimoModel.getData_devolucao());
        return ResponseEntity.ok().body(emprestimoService.salvarEmprestimo(emprestimoRecuperado));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletarEmprestimoId(@PathVariable(value = "id") Integer id) {
        emprestimoService.excluirEmprestimo(id);
        return ResponseEntity.ok().body("Emprestimo excluido com sucesso!");
    }
}