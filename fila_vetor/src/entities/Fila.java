package entities;

public class Fila {
    
    private int inicio;
    private int fim;
    private int tamanho;
    private int numIns;
    private int vetor[];

    public Fila (int tamanho) {
        this.vetor = new int [tamanho];
        this.inicio = -1;
        this.fim = -1;
        this.tamanho = tamanho;
        this.numIns = 0;
    }

    public void inserir(int info) {
        if (numIns >= tamanho) {
            System.out.println("Fila Cheia!");
            return;
        }
    
        if(this.inicio == -1) {
            this.inicio++;
        }
        this.fim = (this.inicio + numIns) % this.tamanho;
        this.vetor[this.fim] = info;
        this.numIns++;
    }

    public int remover() {
        //testa fila vazia
        if(this.inicio == -1 && this.fim == -1) {
            System.out.println("Fila Vazia!");
            return -1;
        }
        //testa fila com 1 elemento
        if(this.inicio == this.fim) {
            int info = this.vetor[inicio];
            this.inicio = -1;
            this.fim = -1;
            this.numIns = 0;
            return info;
        }
        int info = this.vetor[inicio];
        this.inicio = (this.inicio + 1) % this.tamanho;
        this.numIns--;
        return info;
    }

}
