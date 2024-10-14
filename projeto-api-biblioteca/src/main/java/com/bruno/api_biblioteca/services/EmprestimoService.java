package com.bruno.api_biblioteca.services;

import com.bruno.api_biblioteca.models.EmprestimoModel;
import com.bruno.api_biblioteca.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    //Listar todos os emprestimos
    public List<EmprestimoModel> consultarEmprestimos(){
        List<EmprestimoModel> emprestimos = emprestimoRepository.findAll();
        return emprestimos;
    }

    //Listar empréstimo por ID
    public Optional<EmprestimoModel> consultarEmprestimosId(Integer id){
        return emprestimoRepository.findById(id);
    }

    //Cadastrar empréstimo
    public EmprestimoModel salvarEmprestimo(@RequestBody EmprestimoModel emprestimoModel){
        return emprestimoRepository.save(emprestimoModel);
    }

    //Excluir Data
    public void excluirEmprestimo(Integer id){
        emprestimoRepository.deleteById(id);
    }
}
