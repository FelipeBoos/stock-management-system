package repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import domain.Produto;
import domain.exception.BusinessException;
import domain.exception.NotFoundException;

public class ProdutoRepository {
    private final List<Produto> listaProdutos = new ArrayList<>();
    private long nextId = 1;

    public Produto create(Produto produto) {
        if (produto.getId() != null) {
            throw new BusinessException("Não é possível salvar um produto que já possui um id");
        }

        produto.setId(nextId++);
        listaProdutos.add(produto);
        return produto;
    }

    public Produto update(Produto produto) {
        if (produto.getId() == null) {
            throw new BusinessException("Não é possível editar um produto sem um Id");
        }

        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId().equals(produto.getId())) {
                listaProdutos.set(i, produto);
                return produto;
            }
        }

        throw NotFoundException.of("Produto", produto.getId());
    }

    public Optional<Produto> findById(Long id) {
        if (id == null) return Optional.empty();

        for (Produto produto : listaProdutos) {
            if (produto.getId().equals(id)) return Optional.of(produto);
        }

        return Optional.empty();
    }

    public List<Produto> findAll() {
        return new ArrayList<>(listaProdutos);
    }

    public boolean deleteById(Long id) {
        if (id == null) return false;

        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId().equals(id)) {
                listaProdutos.remove(i);
                return true;
            }
        }

        return false;
    }

    public void clear() {
        listaProdutos.clear();
        nextId = 1;
    }

    public boolean existsBySku(String sku) {
        if (sku == null) return false;

        for (Produto produto : listaProdutos) {
            if (produto.getSku() != null && produto.getNome().equalsIgnoreCase(sku)) return true;
        }

        return false;
    }

    public boolean existsByNome(String nome) {
        if (nome == null) return false;

        for (Produto produto : listaProdutos) {
            if (produto.getNome() != null && produto.getNome().equalsIgnoreCase(nome)) return true;
        }

        return false;
    }
}
