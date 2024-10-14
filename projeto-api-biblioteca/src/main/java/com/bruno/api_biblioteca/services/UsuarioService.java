package com.bruno.api_biblioteca.services;

import com.bruno.api_biblioteca.models.UsuarioModel;
import com.bruno.api_biblioteca.repositories.LivroRepository;
import com.bruno.api_biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Listar todos os usuários
    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();

    }

    //Listar usuario por Id
    public Optional<UsuarioModel> listarUsuarioId(Integer id) {
        return usuarioRepository.findById(id);
    }

    //Cadastrar Usuário
    public UsuarioModel salvarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    //Excluir Usuário
    public void excluirUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}