# Identificação

**Atividade:** Trabalho M2 - Fila de Prioridade com Heap  
**Disciplina:** Estrutura de Dados  
**Professor:** Luiz Henrique A. Salazar  
**Aluno:** Daniel Luiz Cardoso

# Fila de Prioridade com Heap Binário

Criar uma **fila de prioridade** usando *heap binário**, simular uma triagem onde sao atendidos por prioridade clínica.

## Javadoc

A documentação do projeto foi gerada automatica com o **Javadoc** e publicada pelo **GitHub Pages**. Link:
```text
https://dukiel.github.io/07-priority-queue-heap/
```

## Descrição do trabalho

O sistema registra pacientes em uma fila de prioridade baseada em **Max-Heap**.

A cada inserção, o paciente é adicionado ao final da heap e reposicionado usando o algoritmo **Sobe Heap**.

A cada remoção, o paciente de maior prioridade é retirado da raiz da heap. Depois, o último elemento é colocado na raiz e reposicionado usando o algoritmo **Desce Heap**.

## Regras de Prioridade

A prioridade de atendimento é definida por três critérios, nesta ordem:

1. **Nível de urgência**: paciente com maior nível de urgência é atendido primeiro.
2. **Tempo de espera**: em caso de mesmo nível de urgência, o paciente com maior tempo de espera é atendido primeiro.
3. **Grupo vulnerável**: em caso de mesmo nível e mesmo tempo de espera, o paciente vulnerável é atendido primeiro.

## Níveis de Urgência

| Nível | Cor | Classificação |
|---|---|---|
| 5 | Vermelho | Imediato |
| 4 | Laranja | Muito Urgente |
| 3 | Amarelo | Urgente |
| 2 | Verde | Pouco Urgente |
| 1 | Azul | Não Urgente |

## Pacientes de Teste

| Nome | Urgência | Espera | Vulnerável |
|---|---:|---:|---|
| Carlos | 2 | 45 | false |
| Maria | 5 | 5 | false |
| Joao | 3 | 20 | false |
| Beatriz | 3 | 35 | true |
| Pedro | 5 | 2 | false |
| Helena | 2 | 45 | true |

## Ordem Esperada de Atendimento

```text
Maria
Pedro
Beatriz
Joao
Helena
Carlos
```

## Estrutura do Projeto

```text
07-priority-queue-heap/
├── src/
│   ├── Main.java
│   ├── Paciente.java
│   └── FilaPrioridadeHeap.java
├── .github/
│   └── workflows/
│       └── javadoc.yaml
├── .gitignore
└── README.md
```

## Requisitos

Para compilar e executar o projeto, e necessario ter instalado:

- Java JDK 21 ou superior;
- Git, caso deseje clonar ou enviar alteracoes para o repositorio;
- Navegador web, caso deseje visualizar o Javadoc publicado no GitHub Pages.

Tambem e necessario que a estrutura do projeto mantenha os arquivos `.java` dentro da pasta `src`.



## Classes Implementadas

### Paciente

Representa a entidade do paciente atendido na triagem.

Atributos principais:

- `nome`
- `nivelUrgencia`
- `tempoEsperaMinutos`
- `grupoVulneravel`

Também possui o método responsável por comparar a prioridade entre dois pacientes.

### FilaPrioridadeHeap

Representa a fila de prioridade implementada com Heap Binário.

Métodos principais:

- `enfileirar(Paciente paciente)`
- `desenfileirar()`
- `sobeHeap(int indice)`
- `desceHeap(int indice)`
- `trocar(int i, int j)`
- `estaVazia()`
- `imprimirHeap()`

### Main

Classe principal usada para testar a aplicação com os pacientes exigidos no enunciado.

## Como Compilar

Na raiz do projeto, execute:

```bash
javac src/*.java
```

## Como Executar

Depois de compilar, execute:

```bash
java -cp src Main
```

## Exemplo de Saída

```text
ORDEM DE ATENDIMENTO

Maria - Vermelho, espera: 5 min, vulneravel: false
Pedro - Vermelho, espera: 2 min, vulneravel: false
Beatriz - Amarelo, espera: 35 min, vulneravel: true
Joao - Amarelo, espera: 20 min, vulneravel: false
Helena - Verde, espera: 45 min, vulneravel: true
Carlos - Verde, espera: 45 min, vulneravel: false
```

## Algoritmo Sobe Heap

O algoritmo **Sobe Heap** é usado na inserção.

Funcionamento:

1. O novo paciente entra no final do vetor.
2. Ele é comparado com o pai.
3. Se tiver maior prioridade que o pai, os dois trocam de posição.
4. O processo continua até a raiz ou até a heap ficar organizada.

## Algoritmo Desce Heap

O algoritmo **Desce Heap** é usado na remoção.

Funcionamento:

1. O paciente da raiz é removido.
2. O último paciente da heap é colocado na raiz.
3. Ele é comparado com os filhos.
4. Se algum filho tiver maior prioridade, ocorre a troca.
5. O processo continua até a heap ficar organizada.

## GitHub Pages

O deploy da documentação é feito automaticamente pelo workflow:

```text
.github/workflows/javadoc.yaml
```

Para funcionar corretamente, o repositório deve estar configurado em:

```text
Settings → Pages → Source → GitHub Actions
```

## Tecnologias Utilizadas

- Java
- Heap Binário
- Fila de Prioridade
- GitHub Actions
- GitHub Pages
- Javadoc
