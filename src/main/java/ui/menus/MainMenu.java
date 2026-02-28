package ui.menus;

import ui.MenuOpcoes;
import ui.OpcaoMenu;

public class MainMenu extends MenuOpcoes{
    
    public MainMenu(CategoriaMenu menuCategorias) {
        super("Menu Principal");
        setOpcaoZeroLabel("Sair");

        addOpcao(new OpcaoMenu("Categorias", () -> menuCategorias.exibir(), true));
        addOpcao(new OpcaoMenu("Produtos", () -> System.out.println("Produtos..."), false));
        addOpcao(new OpcaoMenu("Clientes", () -> System.out.println("Clientes..."), false));
        addOpcao(new OpcaoMenu("Pedidos", () -> System.out.println("Pedidos..."), false));
        addOpcao(new OpcaoMenu("Relatórios", () -> System.out.println("Relatórios..."), false));
    }
}
