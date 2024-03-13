package app;

import entities.ListaCircular;

public class Program {
    public static void main(String[] args) {
        ListaCircular listaCircular = new ListaCircular();
        listaCircular.insere(0);
        listaCircular.insere(1);
        listaCircular.insere(2);
        listaCircular.imprime(); // 2 1 0
        listaCircular.remover(0);
        listaCircular.remover(1);
        listaCircular.remover(2);
        listaCircular.imprime(); // Lista circular vazia!
        listaCircular.insere(0);
        listaCircular.imprime(); // 0
    }
}
