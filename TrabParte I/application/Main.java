package application;
import controller.AlunoController;

import java.io.*;
import view.Menu;

import static view.Menu.show;

public class Main {
    public static void main(String[] args) {
        AlunoController controller = new AlunoController();

        String NOME_ARQUIVO = "alunosBalanceados.txt";
        controller.carregarDados(NOME_ARQUIVO);

        show();
    }
}
