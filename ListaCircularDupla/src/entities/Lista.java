package entities;

public class Lista {

    No ref;

    public Lista() {
        this.ref = null;
    }

    public No getRef() {
        return ref;
    }

    public void setRef(No ref) {
        this.ref = ref;
    }
    
    public boolean vazia() {
        return ref==null;
    }

    public void insere(int info) {
        //se a lista estiver vazia
        if(this.vazia()) {
            No novoNo = new No(info, null, null);
            novoNo.setProx(novoNo);
            novoNo.setAnt(novoNo);
            this.setRef(novoNo);
        }
        //se não estiver vazia
        else {
            No novoNo = new No(info, null, ref);
            novoNo.setProx(ref.getProx());
            this.ref.setProx(novoNo);
            novoNo.getProx().setAnt(novoNo);
        }
    }

    public String imprime() {
        //se a lista estiver vazia
        if(this.vazia()) {
            return "lista vazia";
        }
        
        StringBuilder imprime = new StringBuilder();
        imprime.append("Sentido normal:");
        //pegar todas as infos e a ref também
        for(No p = ref.getProx(); p != ref; p = p.getProx()) {
            imprime.append(p.getInfo() + " ");
        }
        imprime.append(ref.getInfo());

        imprime.append("  Sentido contrário:");
        imprime.append(ref.getInfo() + " ");    //começa da ref para o inicio
        for(No p = ref.getProx(); p!=ref; p = p.getProx()) {
            if(p.getProx() == ref) {
                for(No p2 = p; p2 != ref; p2 = p2.getAnt()) {
                    imprime.append(p2.getInfo() + " ");
                }
            }   
        }
        imprime.append(" ");
        return imprime.toString();
    }

    public void remove(int info, boolean duplicados) {
        //se a lista estiver vazia
        if(this.vazia()) {
            System.out.println("lista vazia");
            return;
        }
        //se existir somente um elemento
        if(ref == ref.getProx()) {
            ref.setProx(null);
            ref.setAnt(null);
            ref = null;
            return;
        }
        //se duplicados == true
        if(duplicados){
            for(No p = ref.getProx(); p != ref; p = p.getProx()) {
                //se ultimo elemento, no caso, ref == info
                if(p.getProx() == ref && ref.getInfo() == info) {
                    p.setProx(ref.getProx());
                    ref.getProx().setAnt(p);
                    this.setRef(p);
                }
                //se primeiro elemento, no caso, ref.getProx() == info
                else if(p == ref.getProx() && p.getInfo() == info) {
                    p.getProx().setAnt(p.getAnt());
                    ref.setProx(p.getProx());
                }
                //se o elemento nao for nem o primeiro e nem o ultimo
                else if(p.getInfo() == info) {
                    p.getProx().setAnt(p.getAnt());
                    p.getAnt().setProx(p.getProx());
                }
            }
        }
        //se duplicados == false 
        else {
            for(No p = ref.getProx(); p != ref; p = p.getProx()) {
                //se ultimo elemento, no caso, ref == info
                if(p.getProx() == ref && ref.getInfo() == info) {
                    p.setProx(ref.getProx());
                    ref.getProx().setAnt(p);
                    this.setRef(p);
                    return;
                }
                //se primeiro elemento, no caso, ref.getProx() == info
                else if(p == ref.getProx() && p.getInfo() == info) {
                    p.getProx().setAnt(p.getAnt());
                    ref.setProx(p.getProx());
                    return;
                }
                //se o elemento nao for nem o primeiro e nem o ultimo
                else if(p.getInfo() == info) {
                    p.getProx().setAnt(p.getAnt());
                    p.getAnt().setProx(p.getProx());
                    return;
                }
            }
        }
    }
}
