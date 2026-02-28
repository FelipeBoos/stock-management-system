package util;

import java.util.Scanner;

public class ConsoleIO {
    private static final Scanner scanner = new Scanner(System.in);

    public int lerInt(String mensagem) {
        System.out.println(mensagem);

        return Integer.parseInt(scanner.nextLine());
    }

    public String lerString(String mensagem) {
        System.out.println(mensagem);

        return scanner.nextLine();
    }

    public void pausar() {
        System.out.println("\nDigite ENTER para continuar:");

        scanner.nextLine();
    }
}
