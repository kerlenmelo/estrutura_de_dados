package entities;

public class ListaCircularDupla {
    
    No ref;

    public ListaCircularDupla() {
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
            No novoNo = new No(info, null, null);
            this.setRef(novoNo);
            novoNo.setProx(novoNo);
            novoNo.setAnt(novoNo);
        } else {
            No novoNo = new No(info, null, ref);
            novoNo.setProx(ref.getProx());
            this.ref.setProx(novoNo);
            novoNo.getProx().setAnt(novoNo);
            this.setRef(novoNo);
        }
    }

    public void remover(int info) {
        if(this.vazia()) {
            System.out.println("Lista circular dupla vazia!");
            return;
        }
        if(ref==ref.getProx()) {
			ref.setProx(null);
			ref.setAnt(null);
			ref=null;
			return;
        }
        //Chamar de p ou aux, tanto faz
        for (No p = ref.getProx(); p != ref; p = p.getProx()) {
            if(info == p.getInfo() && p == ref.getProx()) {
                this.getRef().setProx(p.getProx());
                p.getProx().setAnt(p.getAnt());
                return;
            } else if(info == p.getProx().getInfo() && p.getProx() == ref) {
                p.setProx(ref.getProx());
                ref.getProx().setAnt(ref.getAnt());
                this.setRef(p);
                return;
            } else if(info == p.getProx().getInfo()) {
                p.setProx(p.getProx().getProx());
                p.getProx().getProx().setAnt(p);
                return;
            }
        }
    }

    public void imprime() {
        if(this.vazia()) {
            System.out.println("Lista circular dupla vazia!");
            return;
        }

        for (No p = ref.getProx(); p != ref; p = p.getProx()) {
            System.out.print(p.getInfo() + " ");
        }
        System.out.println(ref.getInfo());
    }
}
