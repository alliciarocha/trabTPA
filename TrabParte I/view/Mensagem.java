package view;

public class Mensagem {
    public static void printCaixa(String cor, String... linhas) {
        int maxLen = 0;
        for (String linha : linhas) {
            if (linha.length() > maxLen) {
                maxLen = linha.length();
            }
        }

        int largura = maxLen + 2;

        printBorda("topo",largura);

        for (String linha : linhas) {
            System.out.printf("║ %s%-" + maxLen + "s%s ║\n", cor, linha, "\u001B[0m");
        }

        printBorda("rodape",largura);
    }

    private static void printBorda(String tipo, int largura) {
        char esquerda = tipo.equals("topo") ? '╔' : '╚';
        char direita  = tipo.equals("topo") ? '╗' : '╝';

        System.out.print(esquerda);
        for (int i = 0; i < largura; i++) System.out.print('═');
        System.out.println(direita);
    }

    public static void FormatoVermelho(String... linhas) {
        printCaixa("\u001B[31m", linhas);
    }

    public static void FormatoAmarelo(String... linhas) {
        printCaixa("\u001B[33m", linhas);
    }
}