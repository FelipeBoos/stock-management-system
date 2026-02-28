package app;

import ui.menus.MainMenu;
import ui.menus.CategoriaMenu;
import repository.CategoriaRepository;
import service.CategoriaService;

public class Main {
    
    public static void main(String[] args){
        CategoriaRepository categoriaRepository = new CategoriaRepository();
        CategoriaService categoriaService = new CategoriaService(categoriaRepository);
        CategoriaMenu menuCategorias = new CategoriaMenu(categoriaService);

        MainMenu menuPrincipal = new MainMenu(menuCategorias);

        menuPrincipal.exibir();

        System.out.println("Finalizando programa...");
        
    }
}
