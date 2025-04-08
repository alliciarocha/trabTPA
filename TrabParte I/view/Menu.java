package view;

import java.util.Scanner;

public class Menu {

    public static void show() {

        Scanner menu = new Scanner (System.in);

        System.out.print("##-------------------Menu-------------------##\n\n");
        System.out.print("|--------------------------------------------|\n");
        System.out.print("| Opção 1 - Pesquisar na lista não ordenada  |\n");
        System.out.print("| Opção 2 - Pesquisar na lista ordenada      |\n");
        System.out.print("| Opção 3 - Sair                             |\n");
        System.out.print("|--------------------------------------------|\n");
        System.out.print("Digite uma opção: ");

        int opcao = menu.nextInt();


        switch (opcao) {
            case 1:
                System.out.print("\nOpção Pesquisar na lista não ordenada");
                break;

            case 2:
                System.out.print("\nOpção Pesquisar na lista ordenada\n");
                break;

            default:
                System.out.print("\nOpção Inválida!");
                break;

            case 3:
                System.out.print("\nAté logo!");
                menu.close();
        }
    }
}