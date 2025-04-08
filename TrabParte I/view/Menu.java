package view;

import java.util.Scanner;
import java.util.InputMismatchException;
import view.Mensagem;

public class Menu {

    public static void show() {

        Scanner menu = new Scanner (System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.print("\n");
            System.out.print("╔═══════════════════════════════════════════╗\n");
            System.out.print("║                   MENU                    ║\n");
            System.out.print("╠═══════════════════════════════════════════╣\n");
            System.out.print("║ 1 - Pesquisar na lista não ordenada       ║\n");
            System.out.print("║ 2 - Pesquisar na lista ordenada           ║\n");
            System.out.print("║ 3 - Sair                                  ║\n");
            System.out.print("╚═══════════════════════════════════════════╝\n");
            System.out.print("DIGITE UMA OPÇÃO: ");

            try {
                opcao = menu.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("\nVocê escolheu: *** PESQUISAR NA LISTA NÃO ORDENADA ***");
                        break;

                    case 2:
                        System.out.println("\nVocê escolheu: *** PESQUISAR NA LISTA ORDENADA ***");
                        break;

                    case 3:
                        System.out.println("\nAté logo! Encerrando o programa...");
                        menu.close();
                        break;
                    default:
                        Mensagem.FormatoAmarelo(
                                "ATENÇÃO: Opção inválida!",
                                "Digite uma opção válida!"
                        );
                }
            } catch (InputMismatchException e) {
                Mensagem.FormatoVermelho(
                        "ERRO: Entrada inválida!",
                        "Apenas números inteiros são permitidos!",
                        "Tente novamente."
                );
                menu.next();
            }
        }

        menu.close();

    }
}
