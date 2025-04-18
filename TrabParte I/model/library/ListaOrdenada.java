package model.library;

import java.util.Comparator;

public class ListaOrdenada<T> {
    private No<T> prim, ult;
    private int quant;
    private final Comparator<T> comparador;

    public ListaOrdenada(Comparator<T> comparador) {
        this.prim = this.ult = null;
        this.quant = 0;
        this.comparador = comparador;
    }

    public void adicionar(T novoValor) {
        No<T> novo = new No<>(novoValor);

        if (prim == null) { //se tiver nada na lista
            prim = ult = novo;
        }
        else if (comparador.compare(novoValor, prim.getValor()) < 0) {
            // Colocar no início
            novo.setProx(prim);
            prim = novo;
        }
        else {
            //a lista não está vazia ou então não é o primeiro elem
            No<T> atual = prim;
            No<T> anterior = null;

            while (atual != null && comparador.compare(novoValor, atual.getValor()) >= 0) {
                anterior = atual;
                atual = atual.getProx();
            }

            novo.setProx(atual);
            anterior.setProx(novo);

            if (atual == null) {
                //agr se o elemento não tiver no meio
                ult = novo;
            }
        }
        quant++;
    }

    public T pesquisar(T valor) {
        No<T> aux = this.prim;
        while (aux != null) {
            int comparacao = comparador.compare(valor, aux.getValor());

            if (comparacao == 0) {
                return aux.getValor();
            }
            else if (comparacao < 0) {
                return null;
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
        System.out.println();
    }

    public int tamanho() {
        return quant;
    }
}
