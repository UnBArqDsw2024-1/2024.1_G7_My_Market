# Visitor - GoF Comportamental

## 1. Introdução


O padrão Visitor permite separar a estrutura de um objeto da operação que é aplicada a ele. Isso é útil quando você precisa adicionar novas operações a uma classe sem modificar sua estrutura.


Você define uma interface chamada Visitor com métodos para cada tipo de elemento que deseja visitar.
Cada classe concreta implementa essa interface e fornece a implementação específica para cada método.
A classe que contém os elementos a serem visitados (por exemplo, uma coleção de objetos) possui um método que aceita um objeto Visitor.
O objeto Visitor visita cada elemento e executa a operação apropriada.




## 2. Objetivo

Para demonstrar o uso do padrão de design comportamental Visitor (Visitante), que permite adicionar novas operações a objetos sem alterar suas classes vamos  aplicar diferentes descontos a produtos de tipos variados (alimentos e eletrônicos) usando visitantes concretos (implementações de descontos).

## 3. Implementação
### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Lucidchart](https://www.lucidchart.com/pages/).

![image](https://github.com/user-attachments/assets/831707dd-34a5-410c-9df0-d27fb7a16c89)

<h6 align = "center">Figura 1: Desconto. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

### 3.2. Código
O código foi desenvolvido em  Java , Com a colaboração de [Pedro Henrique ](https://github.com/pehenobra2) e [Guilherme Nishimura](https://github.com/Guilherme-nishi).Para ter o codigo desenvolvido acesse aqui docs/PadroesDeProjeto/src.

#### 3.2.1 Interface client
Essa interface Client se encontra no Main.JAVA

![image](https://github.com/user-attachments/assets/b84f9876-f626-4b38-af1a-17b0fd04fe5e)

<h6 align = "center">Figura 2:Client Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.2 Interface Product
Essa interface Product se encontra em Product.JAVA

![image](https://github.com/user-attachments/assets/a897c8b8-8a85-451b-bfa0-eafc033cd769)


<h6 align = "center">Figura 2:Product Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.3 Interface visitor
Essa interface visitor se encontra no Visitor.JAVA


![image](https://github.com/user-attachments/assets/fd8ab575-3cc5-4acc-adaf-1583bc8e4618)

<h6 align = "center">Figura 3:Visitor Fonte: Guilherme Nishimura e Pedro Henrique</h6>


#### 3.2.4 Concret   visitor 1
Concreter visitor Food (comida) que se encontra em Food.java

![image](https://github.com/user-attachments/assets/22ca9939-2d33-4d8b-93ee-f554db156d95)



<h6 align = "center">Figura 4:Food Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.5 Concret  visitor 2
Concrete visitor Eletronics (Eletronics) que se encontra em Eletronics.java

![image](https://github.com/user-attachments/assets/d6ea0f82-2bf5-428a-b5f6-815d356d697f)




<h6 align = "center">Figura 5:Eletronics Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.6 Concret  Element 1
Concrete element Discount A(Desconto a) que se encontra em DiscountA.java


![image](https://github.com/user-attachments/assets/45829ee2-15cc-434f-8024-16062ab00dd5)




<h6 align = "center">Figura 6:Discount A Fonte: Guilherme Nishimura e Pedro Henrique</h6>

#### 3.2.7 Concret  Element 2
Concrete element Discount B(Desconto B) que se encontra em DiscountB.java


![image](https://github.com/user-attachments/assets/974ae4de-fbfd-4da3-9e60-fcd93f086656)




<h6 align = "center">Figura 7:Discount B Fonte: Guilherme Nishimura e Pedro Henrique</h6>

## Resultado

A imagem abaixo ilustra o resultado de um código que aplica descontos específicos aos produtos banana e smartwatch. Para cada produto, são calculados os preços após a aplicação dos descontos, e esses valores são apresentados de forma clara e organizada. 

![WhatsApp Image 2024-07-24 at 09 05 20](https://github.com/user-attachments/assets/416d95b7-b80f-4d26-ab72-069d9ec3b26f)


## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.
> **Design Patterns: Padrões “GoF”**. Disponivel em :https://www.devmedia.com.br/design-patterns-padroes-gof/16781. Acesso em:21/07.2024
## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0    | Inicio da estrutura do documento | Guilherme Nishimura |x | 22/07/2023| x|
| 1.1   | Mais alterações | Guilherme Nishimura | Pedro Henrique  | 23/07/2023| 23/07/2023|
| 1.2   | Finalizando a documentação | Pedro Henrique | Guilherme Nishimura  | 24/07/2023| 24/07/2023|

