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
	
    
    @Override
	public String toString() {
		return "Lista [ref=" + ref + "]";
	}

	public void insere(int info) {
		No novo = new No(info, ref);
		this.setRef(novo);
	}
	
	public boolean vazia() {
		return ref == null;
	}
	
	public void imprime() {
		if(this.vazia()) {
			System.out.println("Lista vazia!\n");
			return;
		}
		for(No p = this.getRef(); p != null ; p = p.getProx()) {
			System.out.print(p.getInfo() + " ");
		}
		System.out.println();
	}

    public void remove(int num) {
        if(this.vazia()) {
			System.out.println("Lista vazia!\n");
			return;
		}
		for(No p = this.getRef(); p != null; p = p.getProx()) {
			if(p.getInfo() == num && ref.equals(p)){
				this.ref=p.getProx();
				break;
			}
			else if(p.getProx().getInfo()==(num)){
				p.setProx(p.getProx().getProx());								
				break;
			}
			else{	
				if(p.getProx().equals(null)){
					p.setProx(null);
					break;
				}			
				
			}
		}
	}
}	

