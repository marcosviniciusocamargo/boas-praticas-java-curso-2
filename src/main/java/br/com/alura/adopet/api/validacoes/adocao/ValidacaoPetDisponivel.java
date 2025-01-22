package br.com.alura.adopet.api.validacoes.adocao;

import br.com.alura.adopet.api.dto.AdocaoSolicitacaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao{

    @Autowired
    private PetRepository petRepository;

    public void validar(AdocaoSolicitacaoDTO dto){
        boolean petJaAdotado = petRepository.existsByAdotadoTrueAndId(dto.idPet());
        if (petJaAdotado) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }
}
