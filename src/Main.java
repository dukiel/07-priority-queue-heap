/**
 * Main da aplicacao
 *
 * Registra os pacientes de teste, mostra os passos de insercao
 * e mostra a saida depois da remocao deles.
 */
public class Main {
    public static void main(String[] args) {
        FilaPrioridadeHeap fila = new FilaPrioridadeHeap(6);

        Paciente[] pacientes = {
                new Paciente("Carlos", 2, 45, false),
                new Paciente("Maria", 5, 5, false),
                new Paciente("Joao", 3, 20, false),
                new Paciente("Beatriz", 3, 35, true),
                new Paciente("Pedro", 5, 2, false),
                new Paciente("Helena", 2, 45, true)
        };

        System.out.println("INSERINDO PACIENTES\n");

        for (Paciente paciente : pacientes) {
            System.out.println("Chegada: " + paciente);
            fila.enfileirar(paciente);
            fila.imprimirHeap();
            System.out.println();
        }

        System.out.println("ORDEM DE ATENDIMENTO\n");

        while (!fila.estaVazia()) {
            Paciente atendido = fila.desenfileirar();
            System.out.println(atendido.getNome()
                    + " - " + atendido.getCorUrgencia()
                    + ", espera: " + atendido.getTempoEsperaMinutos() + " min"
                    + ", vulneravel: " + atendido.isGrupoVulneravel());
        }
    }
}
