package com.bruno.api_biblioteca.controllers;

import com.bruno.api_biblioteca.models.UsuarioModel;
import com.bruno.api_biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllUsuarios(){
        return ResponseEntity.ok().body(usuarioService.listarUsuarios());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(usuarioService.listarUsuarioId(id));
    }

    @PostMapping(value = "/cadastrar-usuario")
    public ResponseEntity<UsuarioModel> inserirUsuario(@RequestBody UsuarioModel usuarioModel){
        return ResponseEntity.ok().body(usuarioService.salvarUsuario(usuarioModel));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable (value = "id") Integer id, @RequestBody UsuarioModel usuarioModel){
        Optional<UsuarioModel> usuario = usuarioService.listarUsuarioId(id);
        UsuarioModel usuarioRecuperado = usuario.get();
        usuarioRecuperado.setNome(usuarioModel.getNome());
        usuarioRecuperado.setEmail(usuarioModel.getEmail());
        usuarioRecuperado.setTelefone(usuarioModel.getTelefone());
        return ResponseEntity.ok().body(usuarioService.salvarUsuario(usuarioRecuperado));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable(value = "id") Integer id){
        usuarioService.excluirUsuario(id);
        return ResponseEntity.ok().body("Usuario excluído com sucesso");
    }
}