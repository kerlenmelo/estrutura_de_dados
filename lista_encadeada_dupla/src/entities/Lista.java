package entities;

public class Lista {

    private No ref;

    public Lista() {
        this.setRef(null);
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

    public void insere (int info) {
        if(this.vazia()) {
            No novo = new No(info, ref);
            this.setRef(novo);
            novo.setAnt(null);
            novo.setProx(null);
        } 
        else {
            No novo = new No(info, ref);
            novo.setProx(ref);
            ref.setAnt(novo);
            this.setRef(novo);
            novo.setAnt(null);
        }
    }

    public void imprime() {
        if (this.vazia()) {
            System.out.println("Lista vazia!\n");
            return;
        } 
        for(No p = this.getRef(); p != null; p=p.getProx()){
            System.out.print(p.getInfo() + " ");
        }
            System.out.println();
    }

    public void imprimeInverso() {
        if (this.vazia()) {
            System.out.println("Lista vazia!\n");
            return;
        }
        for(No p = this.getRef(); p != null; p=p.getProx()){
            if(p.getProx()==null) {
                for(No p2 = p; p2 != null; p2=p2.getAnt()) {
                    System.out.print(p2.getInfo() + " ");
                }
            }
        }
        System.out.println();
    }

    public void remove(int num) {
        if (this.vazia()) {
            System.out.println("Lista vazia!\n");
            return;
        }
        for (No p = this.getRef(); p!= null; p=p.getProx()) {
            if (p.getInfo() == num && ref.equals(p)) {
                this.ref = p.getProx();
                p.getProx().setAnt(null);
                break;
            }
            else if(p.getInfo() == num && p.getProx() == null) {
                p.getAnt().setProx(null);
                break;
            }
            else if(p.getInfo() == num){
                p.getAnt().setProx(p.getProx());
                p.getProx().setAnt(p.getAnt());
                break;   
            }
        }
    } 
    
}
