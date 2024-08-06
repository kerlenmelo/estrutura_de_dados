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
        if (noParaAtualizar == null) {
            
        }
        else if (noParaAtualizar != null) {
            int alturaFilhoEsquerdo = calcularAltura(noParaAtualizar.getEsquerda());
            int alturaFilhoDireito = calcularAltura(noParaAtualizar.getDireita());
            // altura = 1 + altura do filho mais alto
            noParaAtualizar.setAltura(1 + Math.max(alturaFilhoEsquerdo, alturaFilhoDireito));
            noParaAtualizar.setBalanceamento(getFatorBalanceamento(noParaAtualizar));
        }
    }

    // CALCULAR BALANCEAMENTO
    private int getFatorBalanceamento(No noParaBalancear) {
        if (noParaBalancear == null) {
            return 0;
        }
        // fator de balanceamento = alturaEsq - alturaDir
        return calcularAltura(noParaBalancear.getEsquerda()) - calcularAltura(noParaBalancear.getDireita());

    }

 

    // REBALANCEAR:
    private No rebalancear(No no) {
        if (no == null) {
            return null;
        }

        // Calcular o fator de balanceamento do nó crítico
        int fatorBalanceamento = getFatorBalanceamento(no);

        // Verificar o tipo de desbalanceamento:

        if (fatorBalanceamento > 1) { // Desbalanceamento à esquerda
            if (getFatorBalanceamento(no.getEsquerda()) >= 0) {
                // caso 1: rotação simples à direita
                return rotacionarDireita(no);
            }
            // caso 2: rotação dupla esquerda-direita
            else {
                no.setEsquerda(rotacionarEsquerda(no.getEsquerda()));
                return rotacionarDireita(no);
            }
        }

        else if (fatorBalanceamento < -1) { // Desbalanceamento à direita
            if (getFatorBalanceamento(no.getDireita()) <= 0) {
                // caso 3: rotação simples à esquerda
                return rotacionarEsquerda(no);
            }
            // caso 4: rotação dupla direita-esquerda
            else {
                no.setDireita(rotacionarDireita(no.getDireita()));
                return rotacionarEsquerda(no);
            }
        }
        // Retorna o nó já balanceado, se precisar de balanceamento
        return no;
    }



    // INSERE():
    public void insere(int info) {
        this.noRaiz = insere(this.noRaiz, info);
    }

    private No insere(No no, int info) {

        // Nó não existe na árvore
        if (no == null) {
            return new No(info);
        }

        // inserção à esquerda
        if (info < no.getInfo()) {
            // chama a função recursivamente até a esquerda ser null
            no.setEsquerda(insere(no.getEsquerda(), info));
        }

        // inserção à direita
        else if (info > no.getInfo()) {
            // chama a função recursivamente até a direita ser null
            no.setDireita(insere(no.getDireita(), info));
        } else {
            return no;
        }

        // atualiza altura do nó atual
        atualizarAltura(no);

        // balanceia a árvore a partir do nó crítico
        return rebalancear(no);
    }

    // REMOVE():
    public void remove(int info) {
        this.noRaiz = remove(this.noRaiz, info);
    }

    private No remove(No no, int info) {
        // Nó não existe na árvore
        if (no == null) {
            return null;
        }

        // Realizar remoção:

        // nó a ser removido está na subárvore à esquerda da raiz
        if (info < no.getInfo()) {
            // a função é chamada recursivamente para esquerda até encontrar o nó e então
            // tratar os casos
            no.setEsquerda(remove(no.getEsquerda(), info));
        }
        // nó a ser removido está na subárvore à direita da raiz
        else if (info > no.getInfo()) {
            // a função é chamada recursivamente para direita até encontrar o nó e então
            // tratar os casos
            no.setDireita(remove(no.getDireita(), info));
        } else {
            // Casos de Remoção:

            // 1º Caso: Nó com nenhum filho
            if (no.getEsquerda() == null && no.getDireita() == null) {
                return null;
            }

            // 2º Caso: Nó somente com filho à esquerda
            else if (no.getDireita() == null) {
                return no.getEsquerda(); // Substituímos o nó pelo seu filho à esquerda
            }

            // 3º Caso: Nó somente com filho à direita
            else if (no.getEsquerda() == null) {
                return no.getDireita(); // Substituímos o nó pelo seu filho à direita
            }

            // 4º Caso: Nó com dois filhos
            else {
                No sucessor = encontrarSucessor(no.getDireita()); // o menor dentre os maiores
                no.setInfo(sucessor.getInfo());
                // remove o sucessor da posição original
                no.setDireita(remove(no.getDireita(), sucessor.getInfo()));
            }
        }

        // atualizar a altura
        atualizarAltura(no);

        // balanceia a árvore a partir do nó crítico
        return rebalancear(no);
    }

    // IMPRIME():
    public String preOrdem() {
        StringBuilder sb = new StringBuilder();
        stringPreOrdem(this.noRaiz, sb);
        return sb.toString();
    }

    private static void stringPreOrdem(No no, StringBuilder sb) {
        if (no == null) {
            return;
        }
        sb.append(no.getInfo()).append("(").append(no.getBalanceamento()).append(") ");
        stringPreOrdem(no.getEsquerda(), sb);
        stringPreOrdem(no.getDireita(), sb);
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
        No novaRaiz = noDesbalanceado.getEsquerda();
        noDesbalanceado.setEsquerda(novaRaiz.getDireita());


        novaRaiz.setDireita(noDesbalanceado);
    

        atualizarAltura(noDesbalanceado);
        atualizarAltura(novaRaiz);

        return novaRaiz;
    }
    

    private No rotacionarEsquerda(No noDesbalanceado) {
        No novaRaiz = noDesbalanceado.getDireita();
        noDesbalanceado.setDireita(novaRaiz.getEsquerda());
    


        novaRaiz.setEsquerda(noDesbalanceado);
    

        atualizarAltura(noDesbalanceado);
        atualizarAltura(novaRaiz);
    
        return novaRaiz;
    }
    

    // GETTERS AND SETTERS
    public No getNoRaiz() {
        return noRaiz;
    }

    public void setNoRaiz(No noRaiz) {
        this.noRaiz = noRaiz;
    }
}
