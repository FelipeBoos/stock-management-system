package ui;

import java.util.List;
import java.util.ArrayList;

public class MenuOpcoes {
    private String titulo;
    private List<OpcaoMenu> listaOpcoes;

    public MenuOpcoes(String titulo) {
        this.titulo = titulo;
        this.listaOpcoes = new ArrayList<>();
    }

    public void exibir() {
        System.out.println("\n--- " + titulo + " ---\n");
        listarOpcoes();
    }

    public void listarOpcoes() {
        for(int i = 0; i < listaOpcoes.size(); i++) {
            System.out.println("(" + (i + 1) + ") - " + listaOpcoes.get(i).getNome());
        }
    }

    public void addOpcao(OpcaoMenu opcao) {
        listaOpcoes.add(opcao);
    }
}
