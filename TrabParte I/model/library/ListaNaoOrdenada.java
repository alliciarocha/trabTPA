package model.library;

import java.util.Iterator;

public class ListaNaoOrdenada<T> {
    private No<T> prim, ult;
    private int quant;


    public ListaNaoOrdenada() {
        this.prim = this.ult = null;
        this.quant = 0;
    }

    public void adicionar(T novoValor){
        No<T> novo = new No(novoValor);
        if (this.prim == null){
            this.prim=novo;
            this.ult=novo;
        }
        else{
            this.ult.setProx(novo);
            this.ult = novo;
        }
        this.quant ++;
    }
    public T pesquisar(T valor) {
        No<T> aux = this.prim;
        while (aux != null){
            if (aux.getValor().equals(valor))
                return valor;
            aux = aux.getProx();
        }
        return null;
    }

}
