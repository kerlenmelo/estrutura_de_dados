package app;

import entities.AVL;

public class Program {
    public static void main(String[] args) {
        AVL arvoreAVL = new AVL();
        arvoreAVL.insere(30);
        arvoreAVL.insere(20);
        arvoreAVL.insere(10);
        System.out.println(arvoreAVL.preOrdem());

    }
}
