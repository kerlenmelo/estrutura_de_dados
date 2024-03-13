package entities;

public class ListaCircular {
    No ref;

    public ListaCircular() {
        this.ref = null;
    }

    public No getRef() {
        return ref;
    }

    public void setRef(No ref) {
        this.ref = ref;
    }
    
    public boolean vazia() {
        return ref == null;
    }

    public void insere(int info) {
        if(this.vazia()) {
            No novoNo = new No(info, null);
            novoNo.setProx(novoNo);
            this.setRef(novoNo);
        } else {
            No novoNo = new No(info, null);
            novoNo.setProx(this.getRef().getProx());
            this.getRef().setProx(novoNo);
        }
    }

    public void remover(int info) {
        if(this.vazia()) {
            System.out.println("Lista circular vazia!");
            return;
        }
        if(ref == ref.getProx()) {
            ref.setProx(null);
            ref=null;
            return;
        }
        for(No aux = this.getRef().getProx(); aux != ref; aux = aux.getProx()) {
            if(info == aux.getInfo() && aux == ref.getProx()) {
                this.getRef().setProx(aux.getProx());
                return;
            } else if(info == aux.getProx().getInfo() && aux.getProx() == ref) {
                aux.setProx(this.getRef().getProx());
                this.setRef(aux);
                return;
            } else if(info == aux.getProx().getInfo()) {
                aux.setProx(aux.getProx().getProx());
                return;
            }
        }
    }

    public void imprime() {
        if(this.vazia()) {
            System.out.println("Lista circular vazia!");
            return;
        }
        for(No aux = this.getRef().getProx(); aux != ref; aux = aux.getProx()) {
            System.out.print(aux.getInfo() + " ");
        }
        System.out.println(this.ref.getInfo());
    }
}
