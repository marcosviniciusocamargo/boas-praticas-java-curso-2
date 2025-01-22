package br.com.alura.adopet.api.validacoes.abrigo;

import br.com.alura.adopet.api.dto.AbrigoCadastroDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidacaoTelefoneJaCadastrado implements ValidacaoAbrigo{

    @Autowired
    private AbrigoRepository repository;

    @Override
    public void validar(AbrigoCadastroDTO dto) {
        if (repository.existsByTelefone(dto.telefone())) throw new ValidacaoException("Telefone já cadastrado!");
    }
}
