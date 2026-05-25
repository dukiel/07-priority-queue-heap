import java.util.Arrays;

/**
 * classe da fila de prioridade fazendo com heap binario de maximo
 *
 * o pacinte com maior prioridade fica na head do vetor pos 0.
 */
public class FilaPrioridadeHeap {
    private Paciente[] heap;
    private int tamanho;

    /**
     * cria o inicio da fila de prioridade ja com maximo setado
     *
     * @param capacidade setado maximo
     */
    public FilaPrioridadeHeap(int capacidade) {
        this.heap = new Paciente[capacidade];
        this.tamanho = 0;
    }

    /**
     * insere no final e sobe a heap
     *
     * @param paciente paciente no final
     */
    public void enfileirar(Paciente paciente) {
        if (tamanho == heap.length) {
            aumentarCapacidade();
        }

        heap[tamanho] = paciente;
        sobeHeap(tamanho);
        tamanho++;
    }

    /**
     * remove o paciente de maior priridae
     * se for a raiz, move o ultimo pra ser raiz e desce a heap
     *
     * @return paciente mais priorizado
     */
    public Paciente desenfileirar() {
        if (estaVazia()) {
            return null;
        }

        Paciente pacienteRemovido = heap[0];
        heap[0] = heap[tamanho - 1];
        heap[tamanho - 1] = null;
        tamanho--;

        if (!estaVazia()) {
            desceHeap(0);
        }

        return pacienteRemovido;
    }

    /**
     * sobe enquanto tem mais prioridae
     *
     * @param indice pos inicial do vetor
     */
    private void sobeHeap(int indice) {
        while (indice > 0) {
            int indicePai = (indice - 1) / 2;

            if (heap[indice].temMaisPrioridadeQue(heap[indicePai])) {
                trocar(indice, indicePai);
                indice = indicePai;
            } else {
                break;
            }
        }
    }

    /**
     * faz descer trocando o filho de maior prioriudade
     *
     * @param indice pos inicial do vetor
     */
    private void desceHeap(int indice) {
        while (true) {
            int filhoEsquerdo = 2 * indice + 1;
            int filhoDireito = 2 * indice + 2;
            int maiorPrioridade = indice;

            if (filhoEsquerdo < tamanho
                    && heap[filhoEsquerdo].temMaisPrioridadeQue(heap[maiorPrioridade])) {
                maiorPrioridade = filhoEsquerdo;
            }

            if (filhoDireito < tamanho
                    && heap[filhoDireito].temMaisPrioridadeQue(heap[maiorPrioridade])) {
                maiorPrioridade = filhoDireito;
            }

            if (maiorPrioridade != indice) {
                trocar(indice, maiorPrioridade);
                indice = maiorPrioridade;
            } else {
                break;
            }
        }
    }

    /**
     * faz o swap de pos dentro do vetor
     *
     * @param i primeira pos
     * @param j segunda pos
     */
    private void trocar(int i, int j) {
        Paciente auxiliar = heap[i];
        heap[i] = heap[j];
        heap[j] = auxiliar;
    }

    /**
     * aumenta o tamanho do vetor se precisar
     */
    private void aumentarCapacidade() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    /**
     * verifica se eh vazia
     *
     * @return true se na otem pacientes
     */
    public boolean estaVazia() {
        return tamanho == 0;
    }

    /**
     * Retorna o tamanho
     *
     * @return tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * imprime a heap respeitando ordem
     */
    public void imprimirHeap() {
        System.out.print("Heap: ");

        for (int i = 0; i < tamanho; i++) {
            System.out.print(heap[i]);

            if (i < tamanho - 1) {
                System.out.print(" | ");
            }
        }

        System.out.println();
    }
}
