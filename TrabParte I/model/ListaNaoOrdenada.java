package model;

import java.util.ArrayList;
import java.util.List;

public class ListaNaoOrdenada<T> {
    private List<T> elementos;

    public ListaNaoOrdenada() {
        this.elementos = new ArrayList<>();
    }

    public void adicionar(T novoValor){
        this.elementos.add(novoValor);
    }

    public T pesquisar(T valor) {
        for (T elemento : elementos) {
            if (elemento.equals(valor)) {
                return elemento;
            }
        }
        return null;
    }
}
