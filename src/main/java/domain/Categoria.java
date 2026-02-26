package domain;

import java.time.LocalDateTime;

import domain.exception.ValidationException;

public class Categoria {
    private Long id;
    private String nome;

    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Categoria() {}

    public Categoria(String nome) {
        setNome(nome);
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = this.criadoEm;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new ValidationException("Nome da categoria é obrigatório");
        }

        this.nome = nome.trim();
        touch();
    }

    private void touch(){
        if (this.criadoEm == null) {
            this.criadoEm = LocalDateTime.now();
        }
        this.atualizadoEm = LocalDateTime.now();
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    @Override
    public String toString() {
        return "Categoria{id=" + id + ", nome='" + nome + "'}";
    }

}
