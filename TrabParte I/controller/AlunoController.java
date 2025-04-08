package controller;

import model.*;
import java.util.*;

import static view.Mensagem.*;

public class AlunoController {
    private ListaNaoOrdenada<Aluno> listaNaoOrdenada;
//    private ListaOrdenada<Aluno> listaOrdenada;

    public AlunoController() {
        this.listaNaoOrdenada = new ListaNaoOrdenada<>();
//        this.listaOrdenada = new ListaOrdenada<>();
    }

    public void carregarDados() {
        LeitorArquivos leitor = new LeitorArquivos();

        try {
            long inicio = System.nanoTime();

            List<Aluno> alunos = leitor.ler();

            for (Aluno a : alunos) {
                listaNaoOrdenada.adicionar(a);
//                listaOrdenada.adicionar(a);
            }

            FormatoVerde(
                    "ARQUIVO LIDO COM SUCESSO!",
                    "Total de alunos: " + alunos.size() + " alunos",
                    "LISTAS CRIADAS COM SUCESSO!"
            );

            long fim = System.nanoTime();
            double tempoSegundos = (fim - inicio) / 1_000_000_000.0;

            String tempoToString = String.format("%.3f", tempoSegundos);
            String string = "Tempo: " + tempoToString + " segundos";
            FormatoAzul(
                    "TEMPO GASTO NO PROCESSO DE LER O ARQUIVO E CRIAR LISTAS",
                    string
            );

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void printConteudoListas() {
        System.out.println("\n--- Lista Não Ordenada ---");
        listaNaoOrdenada.forEach(System.out::println);
    }
}
