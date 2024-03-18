package app;

import entities.Pilha;

public class Program {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        pilha.push(0);
        pilha.push(1);
        pilha.push(2);
        pilha.imprime(); // 2 1 0
        pilha.pop();
        pilha.imprime(); // 1 0
    }
}
