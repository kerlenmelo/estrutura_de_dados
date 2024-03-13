package app;

import entities.Fila;

public class Program {
    public static void main(String[] args) {
        
        Fila f = new Fila(5);
        f.inserir(0);
        f.inserir(1);
        f.inserir(2);
        f.inserir(3);
        System.out.println(f.remover()); //0
        System.out.println(f.remover()); //1
        f.inserir(4);
        f.inserir(5);
        f.inserir(6);
        System.out.println(f.remover()); //2
        System.out.println(f.remover()); //3
        System.out.println(f.remover()); //4
        System.out.println(f.remover()); //5
        System.out.println(f.remover()); //6
        f.inserir(44);
        f.inserir(55);
        f.inserir(66);
        System.out.println(f.remover()); //44
        System.out.println(f.remover()); //55
        System.out.println(f.remover()); //66
    }
}
