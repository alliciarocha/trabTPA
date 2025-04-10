package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static view.Mensagem.FormatoVerde;

public class LeitorArquivos {
    private static final String NOME_ARQUIVO = "TrabParte I/resources/alunosOrdenados.txt";
    public List<Aluno> ler() throws IOException {
        List<Aluno> alunos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
//            System.out.println("Número de registros: " + numRegistros);

            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(";");
                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);
                alunos.add(new Aluno(matricula, nome, nota));
            }

            FormatoVerde(
                    "ARQUIVO LIDO COM SUCESSO!",
                    "Total de alunos: " + numRegistros + " alunos"
            );

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }
        return alunos;
    }
}