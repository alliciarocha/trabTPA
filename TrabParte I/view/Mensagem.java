package view;

public class Mensagem {
    private static final String RESET = "\u001B[0m";
    private static final String AMARELO = "\u001B[33m";
    private static final String AZUL = "\u001B[34m";
    private static final String VERMELHO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";

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
            System.out.printf("║ %s%-" + maxLen + "s%s ║\n", cor, linha, RESET);
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
        printCaixa(VERMELHO, linhas);
    }

    public static void FormatoAmarelo(String... linhas) {
        printCaixa(AMARELO, linhas);
    }

    public static void FormatoAzul(String... linhas) {
        printCaixa(AZUL, linhas);
    }

    public static void FormatoVerde(String... linhas) {
        printCaixa(VERDE, linhas);
    }

    public static void TextoVerde(String texto) {
        System.out.println(VERDE + texto + RESET);
    }

    public static void TextoAzul(String texto) {
        System.out.println(AZUL + texto + RESET);
    }

    public static void TextoAmarelo(String texto) {
        System.out.println(AMARELO + texto + RESET);
    }

    public static void TextoVermelho(String texto) {
        System.out.println(VERMELHO + texto + RESET);
    }
}