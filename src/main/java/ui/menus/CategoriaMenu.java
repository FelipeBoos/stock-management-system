package ui.menus;

import ui.MenuOpcoes;
import ui.OpcaoMenu;

public class CategoriaMenu extends MenuOpcoes{
    
    public CategoriaMenu() {
        super("Menu Categorias");

        addOpcao(new OpcaoMenu("Cadastrar categoria", () -> System.out.println("Cadastrando categoria...")));
        addOpcao(new OpcaoMenu("Listar categorias", () -> System.out.println("Listando categorias...")));
        addOpcao(new OpcaoMenu("Editar categoria", () -> System.out.println("Editando categoria...")));
        addOpcao(new OpcaoMenu("Excluir categoria", () -> System.out.println("Excluindo categoria...")));
    }
}
