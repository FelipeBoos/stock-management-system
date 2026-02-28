package ui.menus;

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
        addOpcao(new OpcaoMenu("Listar categorias", () -> System.out.println("Listando categorias..."), false));
        addOpcao(new OpcaoMenu("Editar categoria", () -> System.out.println("Editando categoria..."), false));
        addOpcao(new OpcaoMenu("Excluir categoria", () -> System.out.println("Excluindo categoria..."), false));
    }

    public void cadastrarCategoria() {
        ConsoleIO consoleIO = new ConsoleIO();

        String nome = consoleIO.lerString("Digite o nome da nova categoria:");
        Categoria categoria = service.criar(nome);
        System.out.println("Categoria criada com sucesso: " + categoria.getNome());
    }


}
