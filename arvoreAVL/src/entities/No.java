package entities;

public class No {
    
    private int info;
    private No esquerda;
    private No direita;
    private int altura;
    
    public No(int info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }

    
    // GETTERS AND SETTERS
    public int getInfo() {
        return info;
    }
    
    public void setInfo(int info) {
        this.info = info;
    }
    
    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}