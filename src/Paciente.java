/**
 * Representa um paciente da triagem do Hospital Sao Binario.
 *
 * A prioridade do paciente e definida por tres criterios:
 * nivel de urgencia, tempo de espera e grupo vulneravel.
 */
public class Paciente {
    private String nome;
    private int nivelUrgencia;
    private int tempoEsperaMinutos;
    private boolean grupoVulneravel;

    /**
     * Cria um paciente com os dados utilizados na fila de prioridade.
     *
     * @param nome nome do paciente
     * @param nivelUrgencia nivel de urgencia entre 1 e 5
     * @param tempoEsperaMinutos tempo de espera em minutos
     * @param grupoVulneravel true se o paciente pertence ao grupo vulneravel
     */
    public Paciente(String nome, int nivelUrgencia, int tempoEsperaMinutos, boolean grupoVulneravel) {
        this.nome = nome;
        this.nivelUrgencia = nivelUrgencia;
        this.tempoEsperaMinutos = tempoEsperaMinutos;
        this.grupoVulneravel = grupoVulneravel;
    }

    /**
     * Compara este paciente com outro paciente seguindo as regras de prioridade.
     *
     * @param outro paciente que sera comparado
     * @return true se este paciente tem mais prioridade que o outro
     */
    public boolean temMaisPrioridadeQue(Paciente outro) {
        if (this.nivelUrgencia != outro.nivelUrgencia) {
            return this.nivelUrgencia > outro.nivelUrgencia;
        }

        if (this.tempoEsperaMinutos != outro.tempoEsperaMinutos) {
            return this.tempoEsperaMinutos > outro.tempoEsperaMinutos;
        }

        if (this.grupoVulneravel != outro.grupoVulneravel) {
            return this.grupoVulneravel;
        }

        return false;
    }

    /**
     * Retorna a cor associada ao nivel de urgencia do paciente.
     *
     * @return cor do nivel de urgencia
     */
    public String getCorUrgencia() {
        switch (nivelUrgencia) {
            case 5:
                return "Vermelho";
            case 4:
                return "Laranja";
            case 3:
                return "Amarelo";
            case 2:
                return "Verde";
            case 1:
                return "Azul";
            default:
                return "Desconhecido";
        }
    }

    public String getNome() {
        return nome;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public int getTempoEsperaMinutos() {
        return tempoEsperaMinutos;
    }

    public boolean isGrupoVulneravel() {
        return grupoVulneravel;
    }

    @Override
    public String toString() {
        return nome + "[urgencia=" + nivelUrgencia
                + ", espera=" + tempoEsperaMinutos
                + ", vulneravel=" + grupoVulneravel + "]";
    }
}
