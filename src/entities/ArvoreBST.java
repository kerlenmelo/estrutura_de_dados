package entities;

public class ArvoreBST {
    private No raiz;
    private ArvoreBST arvoreBstEsquerda;
    private ArvoreBST arvoreBstDireita;

    public ArvoreBST() {
        this.raiz = null;
        this.arvoreBstEsquerda = null;
        this.arvoreBstDireita = null;
    }

    public ArvoreBST(No raiz) {
        this.raiz = raiz;
        this.arvoreBstEsquerda = null;
        this.arvoreBstDireita = null;
    }
    
    public boolean isEmpty() {
        return this.raiz == null;
    }

    // INSERIR
    public void insere(No novoNo) {
        
        if (isEmpty()) {
            this.raiz = novoNo;
        }
        else {
            if (novoNo.getInfo() < this.raiz.getInfo()) {
                if (this.arvoreBstEsquerda == null) {
                    this.arvoreBstEsquerda = new ArvoreBST(novoNo);
                }
                else {
                    this.arvoreBstEsquerda.insere(novoNo);
                }
            }
            else if (novoNo.getInfo() > this.raiz.getInfo()) {
                if (this.arvoreBstDireita == null) {
                    this.arvoreBstDireita = new ArvoreBST(novoNo);
                }
                else {
                    this.arvoreBstDireita.insere(novoNo);
                }
            }
        }

    }

    // BUSCAR
    public boolean buscar(int noBuscado) {
        if (!isEmpty()) {
            if (this.raiz.getInfo() == noBuscado) {
                return true;
            }
            else {
                if (noBuscado < this.raiz.getInfo()) {
                    if (this.arvoreBstEsquerda == null) {
                        return false;
                    }
                    else {
                        return this.arvoreBstEsquerda.buscar(noBuscado);
                    }

                }
                else if (noBuscado > this.raiz.getInfo()){
                    if (this.arvoreBstDireita == null) {
                        return false;
                    }
                    else {
                        return this.arvoreBstDireita.buscar(noBuscado);
                    }
                }
            }
        }
        return false;
    }

    // Buscar Maior
    public Integer buscarMaior() {
        if (!isEmpty()) {
            if (this.getArvoreBstDireita() == null) {
                return this.raiz.getInfo();
            } 
            else {
                return this.getArvoreBstDireita().buscarMaior();
            }
        }     
        else {
            return null;
        }
    }

    // Buscar Menor
    public Integer buscarMenor() {
        if (!isEmpty()) {
            if (this.getArvoreBstEsquerda() == null) {
                return this.raiz.getInfo();
            } 
            else {
                return this.getArvoreBstEsquerda().buscarMenor();
            }
        }     
        else {
            return null;
        }
    }

    // Buscar Sucessor
    public Integer buscarSucessor(int buscarSucessorDe) {
        // se o número buscado existe na árvore:
        if (buscar(buscarSucessorDe)) {

            // se o número buscado for a raiz:
            if (buscarSucessorDe == this.getRaiz().getInfo()) {
                
                // caso tenha subárvore à direita
                if (this.getArvoreBstDireita() != null) {
                    // encontra o menor nó na subárvore à direita
                    ArvoreBST menorNo = this.getArvoreBstDireita();
                    while (menorNo.getArvoreBstEsquerda() != null) {
                        menorNo = menorNo.getArvoreBstEsquerda();
                    }
                    return menorNo.getRaiz().getInfo();
                } else {
                    // caso não tenha subárvore à direita, não há sucessor
                    return null;
                }
            }

            // se o número buscado for maior que a raiz:
            else if (buscarSucessorDe > this.getRaiz().getInfo()) {
                // verifica se existe subávore à direita
                if (this.getArvoreBstDireita() != null) {
                    return this.getArvoreBstDireita().buscarSucessor(buscarSucessorDe);
                } 
                else {
                    // não há sucessor
                    return null;
                }
            }   

            // se o número buscado for menor que a raiz:
            else {
                // verifica se existe subárvore à esquerda
                if (this.getArvoreBstEsquerda() != null) {
                    Integer sucessor = this.getArvoreBstEsquerda().buscarSucessor(buscarSucessorDe);
                    if (sucessor != null) {
                        return sucessor;
                    }
                    else {
                        // se não encontrou sucessor na subárvore esquerda, o sucessor é a raiz atual
                        return this.getRaiz().getInfo();
                    }
                }
                else {
                    // se não há subárvore à esquerda, o sucessor é a raiz atual
                    return this.getRaiz().getInfo();
                }
            }    
        }
        // o número buscado não existe na árvore
        return null;
    }

    // REMOÇÃO
    public ArvoreBST remove(No elementoParaRemover) {
        // Primeiro caso: achei o elemento
        if (this.getRaiz().getInfo() == elementoParaRemover.getInfo()) {
            // caso mais simples: elemento não possui filhos
            if (this.getArvoreBstDireita() == null && this.getArvoreBstEsquerda() == null) {
                return null;
            }
            else { 
                // caso menos complicado: somente filhos à esquerda
                if (this.getArvoreBstEsquerda() != null && this.getArvoreBstDireita() == null) {
                    return this.getArvoreBstEsquerda();
                }
                // ... somente filhos à direita
                else if (this.getArvoreBstDireita() != null && this.getArvoreBstEsquerda() == null) {
                    return this.getArvoreBstDireita();
                }
                // filhos dos dois lados: (esquerda e direita)
                else {
                    // estratégia do maior dentre os menores
                    ArvoreBST arvoreAuxiliar = this.getArvoreBstEsquerda();
                    while (arvoreAuxiliar.getArvoreBstDireita() != null) {   // enquanto houver filhos à direita
                        arvoreAuxiliar = arvoreAuxiliar.getArvoreBstDireita();
                    }

                    //troco os elementos da árvore
                    this.raiz = arvoreAuxiliar.getRaiz();   // nó atual recebe o elemento da arvore auxiliar
                                                                    // o maior dentre os menores 
                    arvoreAuxiliar.setRaiz(elementoParaRemover);// insiro no ultimo nó folha, o elemento à ser eliminado
                    this.arvoreBstEsquerda = arvoreBstEsquerda.remove(elementoParaRemover);
                }
            }
        }
        else if (elementoParaRemover.getInfo() < this.getRaiz().getInfo()) {
            // delegar a responsabilidade à subárvore da esquerda
            this.arvoreBstEsquerda = this.arvoreBstEsquerda.remove(elementoParaRemover);
        }
        else if (elementoParaRemover.getInfo() > this.getRaiz().getInfo()) {
            // delegar a responsabilidade à subárvore da direita
            this.arvoreBstDireita = this.arvoreBstDireita.remove(elementoParaRemover);
        }
        return this;
    }

    // IMPRIMIR
    public String preOrdem() {
        StringBuilder preOrdemString = new StringBuilder();
        if (!isEmpty()) {
            preOrdemString.append(this.raiz.getInfo()).append(" ");
            // System.out.println(this.raiz.getInfo());
            if (this.arvoreBstEsquerda != null) {
                preOrdemString.append(this.arvoreBstEsquerda.preOrdem());
            }
            if (this.arvoreBstDireita != null) {
                preOrdemString.append(this.arvoreBstDireita.preOrdem());
            }
        }
        return preOrdemString.toString();
    }

    // getters and setters
    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public ArvoreBST getArvoreBstEsquerda() {
        return arvoreBstEsquerda;
    }

    public void setArvoreBstEsquerda(ArvoreBST arvoreBstEsquerda) {
        this.arvoreBstEsquerda = arvoreBstEsquerda;
    }

    public ArvoreBST getArvoreBstDireita() {
        return arvoreBstDireita;
    }

    public void setArvoreBstDireita(ArvoreBST arvoreBstDireita) {
        this.arvoreBstDireita = arvoreBstDireita;
    }
}
