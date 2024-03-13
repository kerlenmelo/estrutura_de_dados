package entities;

public class No {
    
    int info;
    No prox;
    No ant;
    
    public No(int info, No prox, No ant) {
        this.info = info;
        this.prox = prox;
        this.ant = ant;
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
    
    public No getAnt() {
        return ant;
    }
    
    public void setAnt(No ant) {
        this.ant = ant;
    }

}
