# Decorator - GoF Estrutural

## 1. Introdução

O padrão Decorator permite adicionar responsabilidades a objetos de forma dinâmica. Este padrão é útil quando você deseja estender as funcionalidades de classes de maneira flexível e sem a necessidade de modificar o código existente.

Você define uma interface comum para os componentes e os decoradores. Os decoradores implementam essa interface e adicionam funcionalidades adicionais ao encapsular os componentes.

## 2. Objetivo

Demonstrar o uso do padrão de design estrutural Decorator, que permite adicionar novas funcionalidades a objetos de forma dinâmica. Vamos aplicar diferentes funcionalidades a produtos de tipos variados (alimentos e eletrônicos) usando decoradores concretos (implementações de funcionalidades adicionais).

## 3. Implementação
### 3.1 Diagrama UML
Modelagem utilizando a ferramenta online [Lucidchart](https://www.lucidchart.com/pages/).

![diagrama-decorator](https://github.com/user-attachments/assets/16877221-6a08-4368-ace0-35dffd14ae0f)
<h6 align = "center">Figura 1: Desconto. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

### 3.2 Código
O código foi desenvolvido em  Java , Com a colaboração de [Pedro Henrique ](https://github.com/pehenobra2) e [Guilherme Nishimura](https://github.com/Guilherme-nishi).Para ter o codigo desenvolvido acesse [ aqui](https://github.com/UnBArqDsw2024-1/2024.1_G7_My_Market/tree/Guilherme_Pedro/Entrega03/docs/PadroesDeProjeto/src/Decorator/Main.java).

#### 3.2.1 Classe base Product
Essa classe se encontra em Main.JAVA

![product-decorator](https://github.com/user-attachments/assets/9816f193-8c89-4dff-96fb-8e7d912f1249)
<h6 align = "center">Figura 3:Product Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.2 Subclasse Food
Essa classe se encontra em Main.java

![subclasse-food-decorator](https://github.com/user-attachments/assets/1c80e937-4e87-4d12-b458-951940ed8ca8)
<h6 align = "center">Figura 3: Subclasse Food. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.3 Subclasse Eletronics
Essa classe se encontra em Main.java

![subclasse-eletronics-decorator](https://github.com/user-attachments/assets/528186c1-8c8d-4089-a5f8-9e3f48518742)
<h6 align = "center">Figura 4: Subclasse Eletronics. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.3 Subclasse DiscountDecorator
Essa classe se encontra em Main.java

![DiscountDecorator](https://github.com/user-attachments/assets/921130fd-472f-4d20-81e3-720953a96bb1)
<h6 align = "center">Figura 5: Subclasse DiscountDecorator. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.4 Subclasse FixedDiscountDecorator
Essa classe se encontra em Main.java

![fixedDiscountDecorator](https://github.com/user-attachments/assets/8f98e7ff-41af-4e2e-858f-04c046b381fe)
<h6 align = "center">Figura 6: Subclasse FixedDiscountDecorator. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.5 Subclasse PercentageDiscountDecorator
Essa classe se encontra em Main.java

![PercentageDiscountDecorator](https://github.com/user-attachments/assets/335ddb91-6359-4713-b21f-479ade778bf1)
<h6 align = "center">Figura 7: Subclasse PercentageDiscountDecorator. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.6 Main.java
Essa classe se encontra em Main.java

![main-decorator](https://github.com/user-attachments/assets/b2ed8fa9-ffc9-48cc-83cc-9819108b9f05)
<h6 align = "center">Figura 7: Subclasse PercentageDiscountDecorator. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

## Resultado
Abaixo esta o  resultado do código que aplica o padrão de projeto Decorator, criando dois produtos: uma banana com preço original de $1,00 e um smartwatch com preço original de $250,00. O código aplica um desconto percentual de 10% na banana, resultando em um preço com desconto de $0,90. Para o smartwatch, é aplicado um desconto fixo de $50,00, resultando em um preço com desconto de $200,00. Esses resultados demonstram como o padrão Decorator pode ser utilizado para adicionar funcionalidades de desconto aos produtos de maneira flexível e extensível.


![image](https://github.com/user-attachments/assets/5b45b3f2-101d-4fe3-84f1-e0a7958c9105)

<h6 align = "center">Figura 8: Resultado. Fonte: Guilherme Nishimura e Pedro Henrique</h6>


## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Estruturais**. Material de apoio em slides. Milene Serrano.
> **Design Patterns: Padrões “GoF”**. Disponível em: https://www.devmedia.com.br/design-patterns-padroes-gof/16781. Acesso em:24/07/2024
> **Decorator** Disponível em: https://refactoring.guru/pt-br/design-patterns/decorator. Acesso em 24/07/2024

## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0    | Inicio da estrutura do documento | Pedro Henrique |x | 24/07/2023| x|
| 1.1    | Adicionando mudanças | Pedro Henrique | Guilherme Nishimura | 24/07/2023| 24/07/2023|
| 1.2   | Mais ajustes | Pedro Henrique | Guilherme Nishimura | 24/07/2023| 24/07/2023|




