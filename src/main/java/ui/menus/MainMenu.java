package ui.menus;

import ui.MenuOpcoes;
import ui.OpcaoMenu;

public class MainMenu extends MenuOpcoes{
    
    public MainMenu() {
        super("Menu Principal");

        addOpcao(new OpcaoMenu("Categorias"));
        addOpcao(new OpcaoMenu("Produtos"));
        addOpcao(new OpcaoMenu("Clientes"));
        addOpcao(new OpcaoMenu("Pedidos"));
        addOpcao(new OpcaoMenu("Relatórios"));
        addOpcao(new OpcaoMenu("Sair"));
    }
}
