package entities;

public class No {
    
    private int info;
    private No prox;
    
    public No(int info, No prox) {
        this.info = info;
        this.prox = prox;
    }

    public int getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "No [info=" + info + ", prox=" + prox + "]";
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
    
}
