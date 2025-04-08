package controller;

import model.*;
import java.util.*;

public class AlunoController {
    private ListaNaoOrdenada<Aluno> listaNaoOrdenada;
//    private ListaOrdenada<Aluno> listaOrdenada;

    public AlunoController() {
        this.listaNaoOrdenada = new ListaNaoOrdenada<>();
//        this.listaOrdenada = new ListaOrdenada<>();
    }

    public void carregarDados(String caminhoArquivo) {
        LeitorArquivos leitor = new LeitorArquivos();

        try {
            long inicio = System.nanoTime();

            List<Aluno> alunos = leitor.ler(caminhoArquivo);

            for (Aluno a : alunos) {
                listaNaoOrdenada.adicionar(a);
//                listaOrdenada.adicionar(a);
            }

//            long fim = System.nanoTime();
//            double tempoSegundos = (fim - inicio) / 1_000_000_000.0;
//
//            System.out.printf("Dados carregados em %.3f segundos.\n", tempoSegundos);

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void printConteudoListas() {
        System.out.println("\n--- Lista Não Ordenada ---");
        listaNaoOrdenada.forEach(System.out::println);
    }
}
