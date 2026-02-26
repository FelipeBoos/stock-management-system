package service;

import domain.Categoria;
import repository.CategoriaRepository;
import domain.exception.ValidationException;
import domain.exception.NotFoundException;

public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria criar(String nome) {
        String normalized = normalizeNome(nome);

        if (repository.existsByNome(normalized)) {
            throw new ValidationException( "Já existe uma categoria com esse nome: " + normalized);
        }

        Categoria categoria = new Categoria(normalized);
        return repository.create(categoria);
    }

    public Categoria buscarPorId(Long id) {
        if (id == null) {
            throw new ValidationException("Id da categoria é obrigatório para realizar busca");
        }

        return repository.findById(id)
                .orElseThrow(() -> NotFoundException.of("Categoria", id));
    }

    public void remover(Long id) {
        if (id == null) {
            throw new ValidationException("Id da categoria é obrigatório");
        }

        boolean removed = repository.deleteById(id);
        if (!removed) {
            throw NotFoundException.of("Categoria", id);
        }
    }

    private String normalizeNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new ValidationException("Nome da categoria é obrigatório");
        }

        return nome.trim();
    }
}
