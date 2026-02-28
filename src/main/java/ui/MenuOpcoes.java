package ui;

import java.util.List;
import java.util.ArrayList;

import util.ConsoleIO;

public class MenuOpcoes {
    private String titulo;
    private List<OpcaoMenu> listaOpcoes;
    private String opcaoZeroLabel = "Voltar";
    private final ConsoleIO consoleIO = new ConsoleIO();

    public MenuOpcoes(String titulo) {
        this.titulo = titulo;
        this.listaOpcoes = new ArrayList<>();
    }

    public void exibir() {
        while (true) {
            System.out.println("\n--- " + titulo + " ---\n");
            listarOpcoes();
            int opcao = escolherOpcao();
            if (opcao == 0) break;
            executarOpcao(opcao); 
        }
    }

    public void listarOpcoes() {
        for(int i = 0; i < listaOpcoes.size(); i++) {
            exibirOpcao((i + 1), listaOpcoes.get(i).getNome());
        }
        exibirOpcao(0, opcaoZeroLabel);
    }

    public void exibirOpcao(int numOpcao, String nome) {
        System.out.println("(" + numOpcao + ") - " + nome);
    }

    public void esperarEnter() {
        consoleIO.pausar();
    }

    public int escolherOpcao() {
        return consoleIO.lerInt("\nEscolha uma opção: ");
    }

    public void executarOpcao(int opcao) {
        listaOpcoes.get(opcao - 1).executar();
        if (!listaOpcoes.get(opcao - 1).ehSubmenu()) esperarEnter();
    }

    public void addOpcao(OpcaoMenu opcao) {
        listaOpcoes.add(opcao);
    }

    public void setOpcaoZeroLabel(String opcaoZeroLabel) { this.opcaoZeroLabel = opcaoZeroLabel; }
}
