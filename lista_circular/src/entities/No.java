package entities;

public class No {
    int info;
    No prox;
    
    public No(int info, No prox) {
        this.info = info;
        this.prox = prox;
    }
    
    public int getInfo() {
        return info;
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
