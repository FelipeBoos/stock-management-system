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

        addOpcao(new OpcaoMenu("Cadastrar categoria", () -> System.out.println("TODO: Cadastrando categoria...")));
        addOpcao(new OpcaoMenu("Listar categorias", () -> System.out.println("Listando categorias...")));
        addOpcao(new OpcaoMenu("Editar categoria", () -> System.out.println("Editando categoria...")));
        addOpcao(new OpcaoMenu("Excluir categoria", () -> System.out.println("Excluindo categoria...")));
    }


}
