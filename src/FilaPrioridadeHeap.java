import java.util.Arrays;

/**
 * Implementa uma fila de prioridade usando Heap Binario de Maximo.
 *
 * O paciente de maior prioridade fica sempre na raiz do heap, posicao 0 do vetor.
 */
public class FilaPrioridadeHeap {
    private Paciente[] heap;
    private int tamanho;

    /**
     * Cria uma fila de prioridade com capacidade inicial informada.
     *
     * @param capacidade capacidade inicial do vetor interno
     */
    public FilaPrioridadeHeap(int capacidade) {
        this.heap = new Paciente[capacidade];
        this.tamanho = 0;
    }

    /**
     * Insere um paciente no final do vetor e aplica o algoritmo Sobe Heap.
     *
     * @param paciente paciente que sera inserido na fila
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
     * Remove e retorna o paciente de maior prioridade da fila.
     * Apos remover a raiz, move o ultimo elemento para a raiz e aplica Desce Heap.
     *
     * @return paciente com maior prioridade
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
     * Faz o elemento subir enquanto ele tiver mais prioridade que seu pai.
     *
     * @param indice posicao inicial do elemento no vetor
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
     * Faz o elemento descer trocando com o filho de maior prioridade.
     *
     * @param indice posicao inicial do elemento no vetor
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
     * Troca dois pacientes de posicao dentro do vetor da heap.
     *
     * @param i primeira posicao
     * @param j segunda posicao
     */
    private void trocar(int i, int j) {
        Paciente auxiliar = heap[i];
        heap[i] = heap[j];
        heap[j] = auxiliar;
    }

    /**
     * Aumenta a capacidade do vetor interno quando ele fica cheio.
     */
    private void aumentarCapacidade() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    /**
     * Verifica se a fila esta vazia.
     *
     * @return true se a fila nao possui pacientes
     */
    public boolean estaVazia() {
        return tamanho == 0;
    }

    /**
     * Retorna a quantidade de pacientes na fila.
     *
     * @return tamanho atual da fila
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Imprime o estado interno do heap, respeitando a ordem do vetor.
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
