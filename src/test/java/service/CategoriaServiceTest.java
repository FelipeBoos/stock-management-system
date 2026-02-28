package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Categoria;
import repository.CategoriaRepository;
import service.CategoriaService;
import domain.exception.ValidationException;
import domain.exception.NotFoundException;

public class CategoriaServiceTest {
    private CategoriaRepository repository;
    private CategoriaService service;

    @BeforeEach
    void setup() {
        repository = new CategoriaRepository();
        service = new CategoriaService(repository);
    }

    @Test
    void t1_criar_deveCriarCategoria_quandoNomeValido() {
        Categoria categoria = service.criar("Eletrônicos");
        assertNotNull(categoria.getId());
        assertEquals("Eletrônicos", categoria.getNome());
        assertEquals(1, service.listar().size());
    }

    @Test
    void t2_criar_deveLancarValidationException_quandoNomeVazio() {
        assertThrows(ValidationException.class, () -> service.criar(" "));
        assertThrows(ValidationException.class, () -> service.criar(""));
        assertThrows(ValidationException.class, () -> service.criar(null));
    }

    @Test
    void t3_editar_deveEditarCategoria_quandoIdExistenteENomeValido() {
        Categoria categoria = service.criar("Eletrônicos");

        Categoria editada = service.editar(categoria.getId(), "Eletro");

        assertEquals(categoria.getId(), editada.getId());
        assertEquals("Eletro", editada.getNome());
    }

    @Test
    void t4_editar_deveLancarValidationException_quandoNovoNomeDuplicado() {
        Categoria categoria1 = service.criar("Eletrônicos");
        Categoria categoria2 = service.criar("Mercado");

        assertThrows(ValidationException.class,
            () -> service.editar(categoria2.getId(), "Eletrônicos"));

        assertEquals("Mercado", categoria2.getNome());
        assertEquals("Eletrônicos", categoria1.getNome());
    }

    @Test
    void t5_editar_deveLancarNotFoundException_quandoIdNaoExistente() {
        assertThrows(NotFoundException.class,
            () -> service.editar(999L, "Nova"));
    }

    @Test
    void t6_editar_deveLancarValidationException_quandoNovoNomeDuplicado() {
        service.criar("Eletrônicos");
        Categoria categoria2 = service.criar("Mercado");

        assertThrows(ValidationException.class,
            () -> service.editar(categoria2.getId(), "Eletrônicos")
        );
    }

    @Test
    void t7_remover_deveRemoverCategoria_quandoIdExistente() {
        Categoria categoria1 = service.criar("Eletrônicos");
        service.remover(categoria1.getId());
        assertEquals(0, service.listar().size());
    }

    @Test
    void t8_remover_deveLancarNotFoundException_quandoIdNaoExiste() {
        assertThrows(NotFoundException.class,
            () -> service.remover(123L)
        );
    }

}
