package entities;

public class Fila {
    
    private No refInicio;
    private No refFim;
    
    public Fila() {
        this.refInicio = null;
        this.refFim = null;
    }

    public No getRefInicio() {
        return refInicio;
    }

    public void setRefInicio(No refInicio) {
        this.refInicio = refInicio;
    }

    public No getRefFim() {
        return refFim;
    }

    public void setRefFim(No refFim) {
        this.refFim = refFim;
    }
    
    public boolean vazia() {
        return this.refInicio == null;
    }

    public void enqueue(int info) {
        No novoNo = new No(info, null);
        //se a fila estiver vazia
        if(this.vazia()) {
            this.setRefFim(novoNo);
            this.setRefInicio(novoNo);
            novoNo.setProx(null);
        }
        //se nao estiver vazia
        else{
            this.refFim.setProx(novoNo);
            this.setRefFim(novoNo);
        }
    }

    public void dequeue() {
        //se a fila estiver vazia
        if(this.vazia()) {
            System.out.println("fila vazia");
        }
        //se nao estiver vazia, remove o primeiro elemento
        else {
            StringBuilder str = new StringBuilder();
            str.append("Elemento a ser removido: ");
            str.append(this.refInicio.getInfo());
            //remove o primeiro elemento setando o inicio para o prox
            this.setRefInicio(refInicio.getProx());
            System.out.println(str.toString());
        }
    }

    public void imprime() {
        //se a fila estiver vazia
        if(this.vazia()) {
            System.out.println("fila vazia");
        }
        //se nao estiver vazia
        else {
            for(No p = refInicio; p != null; p = p.getProx()) {
                System.out.print(p.getInfo() + " ");
            }
            System.out.println("");
        }
    }
}
