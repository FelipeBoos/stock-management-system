package ui;

import java.util.List;
import java.util.ArrayList;

import util.ConsoleIO;

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
        escolherOpcao();
    }

    public void listarOpcoes() {
        for(int i = 0; i < listaOpcoes.size(); i++) {
            System.out.println("(" + (i + 1) + ") - " + listaOpcoes.get(i).getNome());
        }
    }

    public void escolherOpcao() {
        ConsoleIO consoleIO = new ConsoleIO();
        int opcao = consoleIO.lerInt("\nEscolha uma opção: ");
        listaOpcoes.get(opcao - 1).executarOpcao();
    }

    public void addOpcao(OpcaoMenu opcao) {
        listaOpcoes.add(opcao);
    }
}
