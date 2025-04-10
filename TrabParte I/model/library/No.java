package model.library;

public class No <T> {
    private T valor;
    private No prox;

    public No(T valor){
        this.valor = valor;
        this.prox = null;
    }
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}

