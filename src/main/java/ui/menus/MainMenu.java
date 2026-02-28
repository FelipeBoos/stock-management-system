package ui.menus;

import ui.MenuOpcoes;
import ui.OpcaoMenu;

public class MainMenu extends MenuOpcoes{
    CategoriaMenu menuCategorias = new CategoriaMenu();
    
    public MainMenu() {
        super("Menu Principal");

        addOpcao(new OpcaoMenu("Categorias", () -> menuCategorias.exibir()));
        addOpcao(new OpcaoMenu("Produtos", () -> System.out.println("Produtos...")));
        addOpcao(new OpcaoMenu("Clientes", () -> System.out.println("Clientes...")));
        addOpcao(new OpcaoMenu("Pedidos", () -> System.out.println("Pedidos...")));
        addOpcao(new OpcaoMenu("Relatórios", () -> System.out.println("Relatórios...")));
        addOpcao(new OpcaoMenu("Sair", () -> System.out.println("Finalizando programa...")));
    }
}
