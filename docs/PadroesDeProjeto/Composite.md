# Composite - GoF Comportamental

## 1. Introdução
O padrão de projeto Composite é um padrão estrutural que permite a composição de objetos em estruturas de árvore para representar hierarquias parte-todo. Ele trata objetos individuais e composições de objetos de maneira uniforme, simplificando o design de sistemas que precisam manipular uma coleção de objetos de forma hierárquica. O Composite é especialmente útil em situações onde você quer que o cliente interaja com objetos simples e compostos de maneira idêntica.


## 2. Objetivo
O principal objetivo do padrão Composite é permitir que os clientes tratem objetos individuais e composições de objetos de maneira uniforme. Isso é alcançado ao definir uma interface comum para todos os objetos na composição. O padrão facilita a adição de novos tipos de componentes, já que o cliente não precisa se preocupar se está manipulando um objeto simples ou uma composição complexa. Esse padrão promove um design mais flexível e escalável, reduzindo a complexidade do código e melhorando a manutenibilidade do sistema.


## 3. Implementação



### 3.1. Diagrama UML


<
<h6 align = "center">Figura 01 Fonte: Artur Rodrigues Sousa Alves e João Víctor Costa Andrade</h6>

### 3.2. Código
```java
import java.util.ArrayList;
import java.util.List;

// Interface Componente
abstract class HoraTrabalhada {
    protected String nome;

    public HoraTrabalhada(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract int getHoraTrabalhada();

    public void add(HoraTrabalhada horaTrabalhada) {
        throw new UnsupportedOperationException();
    }

    public void remove(HoraTrabalhada horaTrabalhada) {
        throw new UnsupportedOperationException();
    }
}

// Folha: Funcionario
class Funcionario extends HoraTrabalhada {
    private int horas;

    public Funcionario(String nome, int horas) {
        super(nome);
        this.horas = horas;
    }

    @Override
    public int getHoraTrabalhada() {
        return horas;
    }
}

// Composto: Organizacao
class Organizacao extends HoraTrabalhada {
    private List<HoraTrabalhada> departamentos = new ArrayList<>();

    public Organizacao(String nome) {
        super(nome);
    }

    @Override
    public void add(HoraTrabalhada horaTrabalhada) {
        departamentos.add(horaTrabalhada);
    }

    @Override
    public void remove(HoraTrabalhada horaTrabalhada) {
        departamentos.remove(horaTrabalhada);
    }

    @Override
    public int getHoraTrabalhada() {
        int totalHoras = 0;
        for (HoraTrabalhada horaTrabalhada : departamentos) {
            totalHoras += horaTrabalhada.getHoraTrabalhada();
        }
        return totalHoras;
    }
}

// Cliente
public class Program {
    public static void main(String[] args) {
        Funcionario func1 = new Funcionario("Funcionario 1", 40);
        Funcionario func2 = new Funcionario("Funcionario 2", 35);
        Funcionario func3 = new Funcionario("Funcionario 3", 30);

        Organizacao departamento1 = new Organizacao("Departamento 1");
        departamento1.add(func1);
        departamento1.add(func2);

        Organizacao departamento2 = new Organizacao("Departamento 2");
        departamento2.add(func3);

        Organizacao empresa = new Organizacao("Empresa");
        empresa.add(departamento1);
        empresa.add(departamento2);

        System.out.println("Horas trabalhadas no " + departamento1.getNome() + ": " + departamento1.getHoraTrabalhada());
        System.out.println("Horas trabalhadas no " + departamento2.getNome() + ": " + departamento2.getHoraTrabalhada());
        System.out.println("Horas trabalhadas na " + empresa.getNome() + ": " + empresa.getHoraTrabalhada());
    }
}
```

## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.
## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0 | Criação do documento | [João Costa](https://github.com/jvcostta) | [Artur Rodrigues](https://github.com/ArturRSA19)| 22/07/2024 | 22/07/2024 |
| 1.2 | Adicionando codigo | [João Costa](https://github.com/jvcostta) | [Artur Rodrigues](https://github.com/ArturRSA19)| 22/07/2024 | 22/07/2024 |
