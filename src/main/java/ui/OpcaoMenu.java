package ui;

public class OpcaoMenu {
    private String nome;
    private AcaoOpcaoMenu acao;

    public OpcaoMenu(String nome, AcaoOpcaoMenu acao) {
        this.nome = nome;
        this.acao = acao;
    }

    public String getNome() { return nome; }

    public void executarOpcao() { acao.executar(); }
}
