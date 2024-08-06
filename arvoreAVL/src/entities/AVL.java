package entities;

public class AVL {

    private No noRaiz;

    // CONSTRUTORES
    public AVL() {
        this.noRaiz = null;
    }

    public AVL(int info) {
        this.noRaiz = new No(info);
    }

    
    // CALCULAR ALTURA
    private int calcularAltura(No noParaCalcAltura) {
        if (noParaCalcAltura == null) {
            return 0;
        }
        return noParaCalcAltura.getAltura();
    }

    // ATUALIZAR ALTURA:
    private void atualizarAltura(No noParaAtualizar) {
        if (noParaAtualizar != null) {
            int alturaFilhoEsquerdo = calcularAltura(noParaAtualizar.getEsquerda());
            int alturaFilhoDireito = calcularAltura(noParaAtualizar.getDireita());
            // altura = 1 + altura do filho mais alto
            noParaAtualizar.setAltura(1 + Math.max(alturaFilhoEsquerdo, alturaFilhoDireito));
        }
    }



    // CALCULAR BALANCEAMENTO
    private int getBalanceamento(No noParaBalancear) {
        if (noParaBalancear == null) {
            return 0;
        }
        // fator de balanceamento = alturaEsq - alturaDir
        return calcularAltura(noParaBalancear.getEsquerda()) - calcularAltura(noParaBalancear.getDireita());
         
    }

    // REBALANCEAR:
    private No rebalancear (No noInserido) {
        // Calcular o fator de balanceamento do nó crítico
        int fatorBalanceamento = getBalanceamento(noInserido);

        // Verificar o tipo de desbalanceamento:

        if (fatorBalanceamento > 1) {   // Desbalanceamento à esquerda
            if(getBalanceamento(noInserido.getEsquerda()) >= 0) {
                // caso 1: rotação simples à direita
                return rotacionarDireita(noInserido);
            }   
                // caso 2: rotação dupla esquerda-direita
            else {
                noInserido.setEsquerda(rotacionarEsquerda(noInserido.getEsquerda()));
                return rotacionarDireita(noInserido);
            }  
        }
        else if (fatorBalanceamento < -1) {   // Desbalanceamento à direita 
            if(getBalanceamento(noInserido.getDireita()) <= 0) {
                // caso 3: rotação simples à esquerda
                return rotacionarEsquerda(noInserido);
            }
                // caso 4: rotação dupla direita-esquerda
            else {
                noInserido.setDireita(rotacionarDireita(noInserido.getDireita()));
                return rotacionarEsquerda(noInserido);
            }
        }
        // Retorna o nó atual se não precisar de rebalanceamento
        return noInserido;
    }



    // INSERE():
    public void insere(int info) {
        this.noRaiz = insere(this.noRaiz, info);
    }

    private No insere(No noAtual, int info) {
        
        // Nó não existe na árvore
        if (noAtual == null) {
            return new No(info);
        }

        // inserção à esquerda
        if (info < noAtual.getInfo()) {
            // chama a função recursivamente até a esquerda ser null
            noAtual.setEsquerda(insere(noAtual.getEsquerda(), info));
        }
        
        // inserção à direita
        else if (info > noAtual.getInfo()) {
            // chama a função recursivamente até a direita ser null
            noAtual.setDireita(insere(noAtual.getDireita(), info));
        }
        else {
            return noAtual;
        }
    
        // atualiza altura do nó atual
        atualizarAltura(noAtual);

        // balanceia o nó atual e retorna a nova raiz
        return rebalancear(noAtual);
    }



    // REMOVE():
    public void remove(int info) {
        this.noRaiz = remove(this.noRaiz, info);
    }

    private No remove(No noAtual, int info) {
        // Nó não existe na árvore
        if (noAtual == null) {
            return null;
        }

        // Realizar remoção:

        // nó a ser removido está na subárvore à esquerda da raiz
        if (info < noAtual.getInfo()) {
            // a função é chamada recursivamente para esquerda até encontrar o nó e então tratar os casos
            noAtual.setEsquerda(remove(noAtual.getEsquerda(), info));
        }
        // nó a ser removido está na subárvore à direita da raiz
        else if (info > noAtual.getInfo()) {
            // a função é chamada recursivamente para direita até encontrar o nó e então tratar os casos
            noAtual.setDireita(remove(noAtual.getDireita(), info));
        }
        else {
            // Casos de Remoção:

                // 1º Caso: Nó com nenhum filho
            if (noAtual.getEsquerda() == null && noAtual.getDireita() == null) {
                return null;
            }

                // 2º Caso: Nó somente com filho à esquerda
            else if (noAtual.getDireita() == null) {
                return noAtual.getEsquerda(); // Substituímos o nó pelo seu filho à esquerda
            }

                // 3º Caso: Nó somente com filho à direita
            else if (noAtual.getEsquerda() == null) {
                return noAtual.getDireita(); // Substituímos o nó pelo seu filho à direita
            }

                // 4º Caso: Nó com dois filhos
            else {
                No sucessor = encontrarSucessor(noAtual.getDireita()); // o menor dentre os maiores
                noAtual.setInfo(sucessor.getInfo());
                // remove o sucessor da posição original
                noAtual.setDireita(remove(noAtual.getDireita(), sucessor.getInfo()));
            }
        }    

        // atualizar a altura
        atualizarAltura(noAtual);

        // balancear
        return rebalancear(noAtual);
    }



    // IMPRIME():
    public String preOrdem() {
        return stringPreOrdem(this.noRaiz).trim();
    }

    private String stringPreOrdem(No no) {
        // 
        if (no == null) {
            return "";
        }
        return no.getInfo() + "("+ getBalanceamento(no) +") " + stringPreOrdem(no.getEsquerda()) + stringPreOrdem(no.getDireita());
    }



    // SUCESSOR:
    private No encontrarSucessor(No noRaiz) {
        while (noRaiz.getEsquerda() != null) {
            noRaiz = noRaiz.getEsquerda();
        }
        return noRaiz;
    }



    // ROTAÇÕES:

    private No rotacionarDireita(No noDesbalanceado) {
        // Árvore desbalanceada à esquerda
        No novaRaiz = noDesbalanceado.getEsquerda(); // a nova raiz da subárvore rotacionada será o filho a esquerda do nó desbalanceado
        No subDireita = novaRaiz.getDireita();  // subàrvore a direita da nova raiz

        // Executar rotação:
        novaRaiz.setDireita(noDesbalanceado);   // nova raiz se torna a raiz da subárvore, e o no desbalanceado agora é o filho à direita
        novaRaiz.setEsquerda(subDireita);   // a subàrvore à direita, agora é o filho à esquerda da nova raiz

        // Atualizando as alturas:
        atualizarAltura(noDesbalanceado);
        atualizarAltura(novaRaiz);

        // retorna a nova "raiz"
        return novaRaiz;    // a nova raiz da subárvore rotacionada
    }

    private No rotacionarEsquerda(No noDesbalanceado) {
        // Árvore desbalanceada à direita
        No novaRaiz = noDesbalanceado.getDireita(); // a nova raiz da subárvore rotacionada será o filho a esquerda do nó desbalanceado
        No subDireita = novaRaiz.getEsquerda();  // subàrvore a direita da nova raiz

        // Executar rotação:
        novaRaiz.setEsquerda(noDesbalanceado);   // nova raiz se torna a raiz da subárvore, e o no desbalanceado agora é o filho à direita
        novaRaiz.setDireita(subDireita);   // a subàrvore à direita, agora é o filho à esquerda da nova raiz

        // Atualizando as alturas:
        atualizarAltura(noDesbalanceado);
        atualizarAltura(novaRaiz);

        // retorna a nova "raiz"
        return novaRaiz;    // a nova raiz da subárvore rotacionada
    }

    // GETTERS AND SETTERS
    public No getNoRaiz() {
        return noRaiz;
    }

    public void setNoRaiz(No noRaiz) {
        this.noRaiz = noRaiz;
    }
}
