package br.com.alura.adopet.api.validacoes.abrigo;

import br.com.alura.adopet.api.dto.AbrigoCadastroDTO;

public interface ValidacaoAbrigo {
    void validar(AbrigoCadastroDTO dto);
}
