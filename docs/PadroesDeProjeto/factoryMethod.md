# Factory Method - GoF Criacional

## 1. Introdução

O padrão Factory Method é um padrão de criação que define uma interface para criar objetos em uma superclasse, mas permite que as subclasses alterem o tipo de objetos que serão criados. Esse padrão promove a flexibilidade e a extensibilidade, permitindo que novas classes de produtos sejam adicionadas sem modificar o código existente.

Para implementar o padrão Factory Method, primeiramente defina uma classe base abstrata ou interface que declare os métodos comuns a todas as subclasses. Em seguida, cria subclasses concretas que implementem ou herdem da classe base, fornecendo usas próprias implementações específicas. Depois, defina uma classe abstrata ou interface Factory com um método abstrato para criar objetos do da classe base. Cria subclasses concretas Factory que implementem o método para instanciar e retornar objetos das subclasses específicas. Finalmente, no código cliente, utilize as Factorys concretas para criar instâncias das subclasses criadas sempre precisar conhecer a classe exata da subclasse, promovendo flexibilidade e extensibilidade no sistema.

## 2. Objetivo



## 3. Implementação
### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Lucidchart](https://www.lucidchart.com/pages/).

![diagrama-factory-method](https://github.com/user-attachments/assets/fbab7b72-97ad-4846-b966-e7b25e6ff6b2)

<h6 align = "center">Figura 1: Generalização produto. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

### 3.2. Código
O código foi desenvolvido em  Java , Com a colaboração de [Pedro Henrique ](https://github.com/pehenobra2) e [Guilherme Nishimura](https://github.com/Guilherme-nishi).Para ter o codigo desenvolvido acesse [ aqui](https://github.com/UnBArqDsw2024-1/2024.1_G7_My_Market/tree/Guilherme_Pedro/Entrega03/docs/PadroesDeProjeto/src).

#### 3.2.1 Classe base Product
Essa classe se encontra em Main.java

![classe-product](https://github.com/user-attachments/assets/a192c3eb-5006-4c03-806d-aad0fe9739f4)

<h6 align = "center">Figura 2: Classe base Product. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.2 Subclasse Food
Essa classe se encontra em Main.java

![subclasse-food](https://github.com/user-attachments/assets/0d8597a4-221c-4c53-9b6f-54bbdea2aab8)

<h6 align = "center">Figura 3: Subclasse Food. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.3 Subclasse Eletronics
Essa classe se encontra em Main.java

![subclasse-eletronics](https://github.com/user-attachments/assets/76208872-80fc-4865-8170-ccadb81e7fa9)

<h6 align = "center">Figura 4: Subclasse Eletronics. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.4 ProductFactory
Essa classe se encontra em Main.java

![productFactory](https://github.com/user-attachments/assets/860008e8-d3c2-453e-afba-5611b913dd37)

<h6 align = "center">Figura 5: ProductFactory. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.5 Subclasse FoodFactory
Essa classe se encontra em Main.java

![foodFactory](https://github.com/user-attachments/assets/bdbc3a76-158d-4b7f-8c2e-e7012c202682)

<h6 align = "center">Figura 6: Subclasse FoodFactory. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.6 Subclasse EletronicsFactory
Essa classe se encontra em Main.java

![eletronicsFactory](https://github.com/user-attachments/assets/1b53b05f-8f6c-4be4-a950-74ebec93759b)

<h6 align = "center">Figura 7: Subclasse EletronicsFactory. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.7 Main
Essa parte do código se encontra em Main.java

![main](https://github.com/user-attachments/assets/ad80ee3a-05f5-49c2-80b5-b07cd33f1c71)

<h6 align = "center">Figura 8: Main. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

## Resultado

<h6 align = "center">Figura 9: Resultados Fonte: Guilherme Nishimura e Pedro Henrique</h6>


## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Criacinais**. Material de apoio em slides. Milene Serrano.
> **Design Patterns: Padrões “GoF”**. Disponivel em :https://www.devmedia.com.br/design-patterns-padroes-gof/16781. Acesso em:24/07.2024
## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0    | Inicio da estrutura do documento | Pedro Henrique |x | 24/07/2023| x|
| 1.1   | Mais alterações | Pedro Henrique | Guilherme Nishimura  | 24/07/2023| 24/07/2023|


