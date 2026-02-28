package ui.menus;

import java.util.List;

import ui.MenuOpcoes;
import ui.OpcaoMenu;
import service.CategoriaService;
import util.ConsoleIO;
import domain.Categoria;

public class CategoriaMenu extends MenuOpcoes{
    private final CategoriaService service;
    
    public CategoriaMenu(CategoriaService service) {
        super("Menu Categorias");
        this.service = service;

        addOpcao(new OpcaoMenu("Cadastrar categoria", () -> cadastrarCategoria(), false));
        addOpcao(new OpcaoMenu("Listar categorias", () -> listarCategorias(), false));
        addOpcao(new OpcaoMenu("Editar categoria", () -> System.out.println("Editando categoria..."), false));
        addOpcao(new OpcaoMenu("Excluir categoria", () -> System.out.println("Excluindo categoria..."), false));
    }

    public void cadastrarCategoria() {
        ConsoleIO consoleIO = new ConsoleIO();

        String nome = consoleIO.lerString("Digite o nome da nova categoria:");
        Categoria categoria = service.criar(nome);
        System.out.println("Categoria criada com sucesso: " + categoria.getNome());
    }

    public void listarCategorias() {
        List<Categoria> lista = service.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada até o momento");
            return;
        }

        System.out.println("\n* Listando categorias *\n");

        for (int i = 0; i < lista.size(); i++) {
            Categoria categoria = lista.get(i);
            System.out.println("Id: " + categoria.getId() + " | Nome: " + categoria.getNome());
        }
    }

}
