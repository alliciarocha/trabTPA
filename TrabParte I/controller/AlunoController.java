package controller;

import model.*;
import model.library.ListaNaoOrdenada;
import view.Mensagem;

import java.io.IOException;
import java.util.*;

import static view.Mensagem.*;

public class AlunoController {
    private final ListaNaoOrdenada<Aluno> listaNaoOrdenada;
//    private ListaOrdenada<Aluno> listaOrdenada;

    public AlunoController() {
        this.listaNaoOrdenada = new ListaNaoOrdenada<>();
//        this.listaOrdenada = new ListaOrdenada<>();
    }

    private void adicionarAlunosNaLista(List<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            listaNaoOrdenada.adicionar(aluno);
//        listaOrdenada.adicionar(aluno);
        }
    }

    public void carregarDados() {
        LeitorArquivos leitor = new LeitorArquivos();

        try {
            long inicio = System.nanoTime();

            List<Aluno> alunos = leitor.ler();
            adicionarAlunosNaLista(alunos);

            FormatoVerde(
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
            Mensagem.FormatoVermelho(
                    "ERRO AO LER ARQUIVO",
                    "Motivo:" + e.getMessage()
            );
        }
    }

    public void pesquisarAlunoPorMatricula(String matricula) {
        try {
            long inicio = System.nanoTime();

            int matriculaInt = Integer.parseInt(matricula);
            Aluno chave = new Aluno(matriculaInt, "", 0.0f);
            Aluno resultado = listaNaoOrdenada.pesquisar(chave);

            long fim = System.nanoTime();
            double tempoSegundos = (fim - inicio) / 1_000_000_000.0;
            String tempoStr = String.format("Tempo de execução: %.6f segundos", tempoSegundos);
            if (resultado != null) {
                TextoAmarelo("***  O ALUNO FOI ENCONTRADO COM SUCESSO!!!  ***");
                Mensagem.FormatoAzul(
                        "DADOS DO ALUNO: ",
                        "Nome: " + resultado.getNome(),
                        "Matrícula: " + resultado.getMatricula(),
                        "Nota: " + resultado.getNota(),
                        "TEMPO DE EXECUÇÃO DA PESQUISA",
                        "Tempo: " + tempoStr + " segundos"
                );
            } else {
                Mensagem.FormatoVermelho(
                        "ERRO: ALUNO NÃO ENCONTRADO NO SISTEMA!"
                );
            }
        } catch (NumberFormatException e) {
            Mensagem.FormatoAmarelo(
                    "ERRO: Matrícula inválida!",
                    "Apenas números inteiros são permitidos!",
                    "Tente novamente."
            );
        }
    }

    public void printConteudoListas() {
        System.out.println("\n--- Lista Não Ordenada ---");
    }
}
