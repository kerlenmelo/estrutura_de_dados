package app;

import entities.AVL;

public class Program {
    public static void main(String[] args) {
        AVL arvoreAVL = new AVL();
        arvoreAVL.insere(5);
        arvoreAVL.insere(3);
        arvoreAVL.insere(7);
        System.out.println(arvoreAVL.preOrdem());
        
        arvoreAVL.insere(4);
        arvoreAVL.insere(9);
        arvoreAVL.insere(1);
        System.out.println(arvoreAVL.preOrdem());

    }
}
