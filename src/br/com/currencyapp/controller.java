package br.com.currencyapp;

import java.util.Scanner;

public class controller {

    private final service service = new service();

    public void start() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            printMenu();

            int option = scanner.nextInt();

            if (option == 0) {
                running = false;
                continue;
            }

            if (option < 0 || option > domain.values().length) {
                System.out.println("Opção inválida.");
                continue;
            }

            domain selected = domain.values()[option - 1];

            System.out.print("Digite o valor em BRL: ");
            double amount = scanner.nextDouble();

            double result = service.convert(amount, selected);

            System.out.printf(
                    "Resultado: %.2f %s%n",
                    result,
                    selected.code()
            );
        }

        scanner.close();
    }

    private void printMenu() {

        System.out.println("\n=== Conversor de Moedas ===");

        int index = 1;
        for (domain currency : domain.values()) {
            System.out.printf(
                    "%d - BRL para %s (%s)%n",
                    index++,
                    currency.code(),
                    currency.label()
            );
        }

        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }
}