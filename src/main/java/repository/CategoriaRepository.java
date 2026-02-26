package repository;

import domain.Categoria;
import domain.exception.BusinessException;
import domain.exception.NotFoundException;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class CategoriaRepository {
    private final List<Categoria> categorias = new ArrayList<>();
    private long nextId = 1;

    public Categoria create(Categoria categoria) {
        if (categoria.getId() != null){
            throw new BusinessException("Não é possível salvar uma categoria que já possui um ID");
        }
        categoria.setId(nextId++);
        categorias.add(categoria);
        return categoria;
    }

    public Categoria update(Categoria categoria) {
        if (categoria.getId() == null) {
            throw new BusinessException("Não é possível atualizar uma categoria sem um ID");
        }

        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId().equals(categoria.getId())) {
                categorias.set(i, categoria);
            }
        }

        throw NotFoundException.of("Categoria", categoria.getId());
    }

    public Optional<Categoria> findById(Long id) {
        if (id == null) return Optional.empty();

        for (Categoria c : categorias) {
            if (id.equals(c.getId())) return Optional.of(c);
        }

        return Optional.empty();
    }

    public List<Categoria> findAll() {
        return categorias;
    }

    public boolean deleteById(Long id) {
        if (id == null) return false;

        for (int i = 0; i < categorias.size(); i++) {
            if (id.equals(categorias.get(i).getId())) {
                categorias.remove(i);
                return true;
            }
        }

        return false;
    }

    public void clear() {
        categorias.clear();
        nextId = 1;
    }
}
