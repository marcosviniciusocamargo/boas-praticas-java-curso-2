package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AbrigoCadastroDTO;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.validacoes.abrigo.ValidacaoAbrigo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    @Autowired
    private List<ValidacaoAbrigo> validacao;

    public void cadastrar(@Valid AbrigoCadastroDTO dto) {
        validacao.forEach(v -> v.validar(dto));
        Abrigo abrigo = new Abrigo(dto.nome(), dto.telefone(), dto.email());
        repository.save(abrigo);
    }

    public List<Pet> listaPets(String idOuNome) {
        if (idOuNome.matches("\\d+")) {
            return repository.findAllByAbrigoId(idOuNome);
        } else {
            return repository.findAllByNome(idOuNome);
        }
    }
}
