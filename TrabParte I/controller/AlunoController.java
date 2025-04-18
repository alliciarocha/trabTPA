package controller;

import model.*;
import model.library.ListaNaoOrdenada;
import model.library.ListaOrdenada;
import view.Mensagem;

import java.io.IOException;
import java.util.*;

import static view.Mensagem.*;

public class AlunoController {
    private final ListaNaoOrdenada<Aluno> listaNaoOrdenada;
    private ListaOrdenada<Aluno> listaOrdenada;

    public AlunoController() {
        this.listaNaoOrdenada = new ListaNaoOrdenada<>();
        this.listaOrdenada = new ListaOrdenada<>(new ComparadorPorMatricula());
    }


    private void adicionarAlunosNaLista(List<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            listaNaoOrdenada.adicionar(aluno);
            listaOrdenada.adicionar(aluno);
        }
    }

    public void carregarDados() {
        LeitorArquivos leitor = new LeitorArquivos();

        try {
            //leitura e cálculo da não ordenada
            long inicioNaoOrd = System.nanoTime();
            leitor.ler(listaNaoOrdenada);
            long fimNaoOrd = System.nanoTime();

            //leitura e cálculo da ordenada
            long inicioOrd = System.nanoTime();
            leitor.lerOrdenada(listaOrdenada);
            long fimOrd = System.nanoTime();

            FormatoVerde(
                    "LISTAS CRIADAS COM SUCESSO!"
            );


            double tempoNaoOrdSeg = (fimNaoOrd - inicioNaoOrd) / 1_000_000_000.0;
            double tempoOrdSeg = (fimOrd - inicioOrd) / 1_000_000_000.0;

            String tempoNaoOrdStr = String.format("%.6f", tempoNaoOrdSeg);
            String tempoOrdStr = String.format("%.6f", tempoOrdSeg);

            Mensagem.FormatoVerde(
                    "LISTAS CRIADAS COM SUCESSO!"
            );

            Mensagem.FormatoAzul(
                    "TEMPOS DE CRIAÇÃO DAS LISTAS:",
                    "Lista NÃO Ordenada: " + tempoNaoOrdStr + " segundos",
                    "Lista ORDENADA: " + tempoOrdStr + " segundos"
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
            //descomentar somente quando querer visualizar se está certinho a geração das listas
            listaNaoOrdenada.imprimir();
            System.out.println("/n");
            listaOrdenada.imprimir();

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
                        "ERRO: ALUNO NÃO ENCONTRADO NO SISTEMA!",
                        "TEMPO DE EXECUÇÃO DA PESQUISA",
                        "Tempo: " + tempoStr + " segundos"
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

    public void pesquisarAlunoPorMatriculaOrdenada(String matriculaStr) {
        try {
            long inicio = System.nanoTime();

            int matricula = Integer.parseInt(matriculaStr);
            Aluno chave = new Aluno(matricula, "", 0.0f);

            Aluno resultado = listaOrdenada.pesquisar(chave);

            long fim = System.nanoTime();
            double tempoSegundos = (fim - inicio) / 1_000_000_000.0;
            String tempoStr = String.format("Tempo de execução: %.6f segundos", tempoSegundos);

            if (resultado != null) {
                TextoAmarelo("***  O ALUNO FOI ENCONTRADO COM SUCESSO NA LISTA ORDENADA!!!  ***");
                Mensagem.FormatoAzul(
                        "DADOS DO ALUNO:",
                        "Nome: " + resultado.getNome(),
                        "Matrícula: " + resultado.getMatricula(),
                        "Nota: " + resultado.getNota(),
                        "TEMPO DE EXECUÇÃO DA PESQUISA",
                        "Tempo: " + tempoStr + " segundos"
                );
            } else {
                Mensagem.FormatoVermelho(
                        "ERRO: ALUNO NÃO ENCONTRADO NO SISTEMA!",
                        "TEMPO DE EXECUÇÃO DA PESQUISA",
                        "Tempo: " + tempoStr + " segundos"
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

}
