package ui.menus;

import java.util.List;

import ui.MenuOpcoes;
import ui.OpcaoMenu;
import service.CategoriaService;
import util.ConsoleIO;
import domain.Categoria;
import domain.exception.NotFoundException;
import domain.exception.ValidationException;
import domain.exception.BusinessException;

public class CategoriaMenu extends MenuOpcoes{
    private final CategoriaService service;
    private final ConsoleIO consoleIO = new ConsoleIO();
    
    public CategoriaMenu(CategoriaService service) {
        super("Menu Categorias");
        this.service = service;

        addOpcao(new OpcaoMenu("Cadastrar categoria", () -> opcaoCadastrarCategoria(), false));
        addOpcao(new OpcaoMenu("Listar categorias", () -> opcaoListarCategorias(), false));
        addOpcao(new OpcaoMenu("Editar categoria", () -> opcaoEditarCategoria(), false));
        addOpcao(new OpcaoMenu("Excluir categoria", () -> opcaoExcluirCategoria(), false));
    }

    public void opcaoCadastrarCategoria() {
        String nome = consoleIO.lerString("Digite o nome da nova categoria:");
        Categoria categoria = service.criar(nome);
        System.out.println("Categoria criada com sucesso: " + categoria.getNome());
    }

    public void opcaoListarCategorias() {
        exibirTituloOpcao("Listando categorias");

        exibirCategoriasCadastradas();
    }

    public void opcaoEditarCategoria() {
        exibirTituloOpcao("Editando categoria");
        System.out.println("Categorias cadastradas:\n");
        exibirCategoriasCadastradas();

        while (true) {
            try {
                long idDigitado = consoleIO.lerInt("\nDigite o Id da categoria que deseja editar (0 para cancelar):");
                if (idDigitado == 0) return;
                if (idDigitado < 0) {
                    System.out.println("Id inválido. Tente novamente");
                    continue;
                }

                Long id = idDigitado;

                Categoria categoria = service.buscarPorId(id);

                String nome = consoleIO.lerString("\nDigite o novo nome para a categoria \"" + categoria.getNome() + 
                    "\" (ENTER para manter o atual): ");
                if (nome.trim().equals("0")) return;

                if (nome.isBlank() || nome.trim().equalsIgnoreCase(categoria.getNome())) {
                    System.out.println("\nNenhuma alteracao realizada.");
                    return;
                }

                service.editar(id, nome);

                System.out.println("Categoria alterada com sucesso");
                break;
            
            } catch (NotFoundException e) {
                System.out.println("Não existe categoria cadastrada para o ID informado. Tente novamente");
            } catch (ValidationException e) {
                System.out.println("Erro ao editar: " + e.getMessage());
            } catch (BusinessException e) {
                System.out.println("Erro ao editar: " + e.getMessage());
            }
        }
    }

    public void opcaoExcluirCategoria() {
        exibirTituloOpcao("Excluindo categoria");
        System.out.println("Categorias cadastradas:\n");
        exibirCategoriasCadastradas();

        while (true) {
            try {
                long idDigitado = consoleIO.lerInt("\nDigite o ID da categoria que deseja excluir (0 para cancelar):");
                if (idDigitado == 0) return;
                if (idDigitado < 0) {
                    System.out.println("Id inválido. Tente novamente");
                    continue;
                }

                Long id = idDigitado;

                Categoria categoria = service.buscarPorId(id);

                String resposta = consoleIO.lerString("Tem certeza que deseja excluir a categoria \"" +
                    categoria.getNome() + "\"? Digite s para confirmar (qualquer outra tecla para cancelar");

                if (!resposta.trim().equalsIgnoreCase("s")) return;

                service.remover(id);

                System.out.println("Categoria removida com sucesso.");
                break;

            } catch (NotFoundException e) {
                System.out.println("Não existe categoria cadastrada para o ID informado. Tente novamente");
            } catch (BusinessException e) {
                System.out.println("Erro ao excluir categoria: " + e.getMessage());
            }
        }
    }

    private void exibirCategoriasCadastradas() {
        List<Categoria> lista = service.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada até o momento");
            return;
        }

        for (int i = 0; i < lista.size(); i++) {
            Categoria categoria = lista.get(i);
            System.out.println("Id: " + categoria.getId() + " | Nome: " + categoria.getNome());
        }
    }

    private void exibirTituloOpcao(String titulo) {
        System.out.println("\n* " + titulo + " *\n");
    }
}
