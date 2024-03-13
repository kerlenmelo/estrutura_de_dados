package app;

import entities.Lista;

public class Program {
    public static void main(String[] args) {
        
        Lista lista = new Lista();
        lista.insere(5);
        lista.insere(4);
        lista.insere(3);
        lista.insere(2);
        lista.insere(1);
        System.out.println(lista.imprime());
    }
}
