/**
 * classe pacientes a serem incorporados
 *
 * aqui a gente adiciona os pacientes ja com base na prioridad deles.
 */
public class Paciente {
    private String nome;
    private int nivelUrgencia;
    private int tempoEsperaMinutos;
    private boolean grupoVulneravel;

    /**
     * cria o paciente com base na fial de prioridae
     *
     * @param nome nome do paciente
     * @param nivelUrgencia nivel de urgencia
     * @param tempoEsperaMinutos tempo de espera
     * @param grupoVulneravel true se o eh crianca ou idoso
     */
    public Paciente(String nome, int nivelUrgencia, int tempoEsperaMinutos, boolean grupoVulneravel) {
        this.nome = nome;
        this.nivelUrgencia = nivelUrgencia;
        this.tempoEsperaMinutos = tempoEsperaMinutos;
        this.grupoVulneravel = grupoVulneravel;
    }

    /**
     * Compara este paciente com outro
     *
     * @param outro paciente comparado
     * @return true se tem mais prioridade que o outro
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
     * Retorna a cor da urgencia do paciente.
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
