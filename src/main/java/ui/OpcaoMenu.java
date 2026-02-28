package ui;

public class OpcaoMenu {
    private String nome;
    private AcaoOpcaoMenu acao;
    private boolean ehSubmenu;

    public OpcaoMenu(String nome, AcaoOpcaoMenu acao, boolean ehSubmenu) {
        this.nome = nome;
        this.acao = acao;
        this.ehSubmenu = ehSubmenu;
    }

    public String getNome() { return nome; }

    public void executar() { acao.executar(); }

    public boolean ehSubmenu() { return ehSubmenu; }
}
