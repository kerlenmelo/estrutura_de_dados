package app;

import entities.Fila;

public class Program {
    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.enqueue(0);
        fila.enqueue(1);
        fila.enqueue(2);
        fila.imprime(); //0 1 2
        fila.dequeue();
        fila.imprime(); //1 2
        fila.enqueue(4);
        fila.enqueue(6);
        fila.enqueue(8);
        fila.dequeue();
        fila.imprime(); //2 4 6 8
    }
}
