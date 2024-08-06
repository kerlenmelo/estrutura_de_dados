package app;

import java.util.Scanner;

import entities.ArvoreBST;
import entities.No;

public class Program {
    public static void main(String[] args) {
        ArvoreBST arvoreBST = new ArvoreBST();

        // INSERÇÃO:
        arvoreBST.insere(new No(5));
        arvoreBST.insere(new No(3));
        arvoreBST.insere(new No(1));
        arvoreBST.insere(new No(4));
        arvoreBST.insere(new No(7));
        arvoreBST.insere(new No(9));

        // IMPRESSÃO:
        System.out.println("\nImpressão PRE ORDEM:");
        System.out.println(arvoreBST.preOrdem()); // Saída esperada: 5 3 1 4 7 9

        // BUSCA:
        System.out.println("\nBuscar um elemento na árvore:\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o elemento que deseja buscar: ");
        int busca = sc.nextInt();
        sc.nextLine();
        if (arvoreBST.buscar(busca)) {
            System.out.println("O elemento " + busca + " existe na Árvore BST!");
        } else {
            System.out.println("Elemento " + busca + " não existe na Árvore BST!");
        }
        
        
        // BUSCA MAIOR ELEMENTO:
        System.out.println("\nO maior elemento da árvore: " + arvoreBST.buscarMaior());
        // BUSCA MENOR ELEMENTO:
        System.out.println("\nO menor elemento da árvore: " + arvoreBST.buscarMenor());
        
        // BUSCA SUCESSOR:
        System.out.print("\nInforme o elemento que deseja buscar o sucessor: ");
        int buscarSucessor = sc.nextInt();
        sc.nextLine();
        Integer sucessor = arvoreBST.buscarSucessor(buscarSucessor);
        if (sucessor != null) {
            System.out.println("O sucessor de " + buscarSucessor + " é: " + sucessor);
        } else {
            System.out.println("Não há sucessor para " + buscarSucessor + " nesta Árvore BST.");
        }

        sc.close();
    }
}
