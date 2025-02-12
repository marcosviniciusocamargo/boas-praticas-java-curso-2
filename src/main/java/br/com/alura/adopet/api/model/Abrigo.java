package br.com.alura.adopet.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "abrigos")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}")
    @Column(name = "telefone")
    private String telefone;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference("abrigo_pets")
    private List<Pet> pets;

    public Abrigo(){}

    public Abrigo(@NotBlank String nome, @NotBlank String telefone, @NotBlank String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abrigo abrigo = (Abrigo) o;
        return Objects.equals(id, abrigo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
