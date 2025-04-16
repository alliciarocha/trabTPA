package model.library;

import model.Aluno;

public class ListaOrdenada<T extends Aluno> {
    private No<T> prim, ult;
    private int quant;

    public ListaOrdenada() {
        this.prim = this.ult = null;
        this.quant = 0;
    }

    public void adicionar(T novoValor) {
        No<T> novo = new No<>(novoValor);

        if (prim == null) {
            prim = ult = novo;
        } else if (novoValor.getMatricula() < prim.getValor().getMatricula()) {
            // Inserção no início
            novo.setProx(prim);
            prim = novo;
        } else {
            No<T> atual = prim;
            No<T> anterior = null;

            while (atual != null && atual.getValor().getMatricula() < novoValor.getMatricula()) {
                anterior = atual;
                atual = atual.getProx();
            }

            novo.setProx(atual);
            anterior.setProx(novo);

            if (atual == null) {
                ult = novo;
            }
        }

        quant++;
    }

    public T pesquisar(T valor) {
        No<T> aux = this.prim;
        while (aux != null) {
            if (aux.getValor().equals(valor)) {
                return aux.getValor();
            }
            aux = aux.getProx();
        }
        return null;
    }

    public void imprimir() {
        No<T> aux = prim;
        while (aux != null) {
            System.out.println(aux.getValor());
            aux = aux.getProx();
        }
    }

    public int tamanho() {
        return quant;
    }
}
