package app;

import entities.ListaCircularDupla;

public class Program {
    public static void main(String[] args) {
        ListaCircularDupla listaCircularDupla = new ListaCircularDupla();

        listaCircularDupla.insere(0);
		listaCircularDupla.insere(1);
		listaCircularDupla.insere(2);
		listaCircularDupla.insere(3);
		listaCircularDupla.insere(4);
		listaCircularDupla.imprime(); //0 1 2 3 4
        listaCircularDupla.remover(0);
        listaCircularDupla.imprime(); // 1 2 3 4
        listaCircularDupla.remover(4);
        listaCircularDupla.imprime(); // 1 2 3
        listaCircularDupla.remover(1);
        listaCircularDupla.remover(2);
        listaCircularDupla.remover(3);
        listaCircularDupla.imprime(); // Lista circular dupla vazia!
        listaCircularDupla.insere(0);
        listaCircularDupla.imprime(); // 0
    }
}
