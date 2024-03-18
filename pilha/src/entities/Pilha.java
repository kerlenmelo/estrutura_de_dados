package entities;

public class Pilha {
    
    private No refTopo;

    public Pilha() {
        this.refTopo = null;
    }

    public No getRefTopo() {
        return refTopo;
    }

    public void setRefTopo(No refTopo) {
        this.refTopo = refTopo;
    }
    
    public boolean vazia() {
        return this.refTopo == null;
    }

    public void push(int info) {
        No novoNo = new No(info, null);
        //se a pilha estiver vazia
        if (this.vazia()){
            this.refTopo = novoNo;
        }
        //se não estiver vazia
        else {
            novoNo.setProx(refTopo);
            this.setRefTopo(novoNo);
        }
    }

    public void pop() {
        //se a pilha estiver vazia
        if (this.vazia()) {
            System.out.println("pilha vazia");
        }
        //se nao estiver vazia
        else {
            this.setRefTopo(refTopo.getProx());
        }
    }

    public void imprime() {
        //se a pilha estiver vazia
        if(this.vazia()) {
            System.out.println("pilha vazia");
        }
        else {
            for(No p = refTopo; p != null; p = p.getProx()) {
                System.out.println(p.getInfo());
            }
        }
    }
}
