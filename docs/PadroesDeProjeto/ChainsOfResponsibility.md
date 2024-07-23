# Chain of Responsibility - GoF Comportamental

## 1. Introdução

O Chain of Responsibility é um padrão de projeto comportamental que permite que pedidos sejam enviados por uma cadeia de handlers (manipuladores). Cada handler na cadeia tem a oportunidade de processar o pedido ou passá-lo para o próximo handler. Este padrão promove o desacoplamento entre o remetente do pedido e seus receptores, facilitando a adição ou modificação de handlers sem impactar os demais componentes do sistema.

## 2. Objetivo
No aplicativo My Market, um pedido precisa passar por várias etapas de validação e processamento antes de ser aprovado. Cada uma dessas etapas pode ser gerenciada por um módulo diferente do sistema. Por exemplo:

- Verificação de Estoque: Primeira etapa onde o sistema verifica se o item solicitado está disponível em estoque.
- Validação de Pagamento: Após a verificação de estoque, o sistema valida as informações de pagamento do cliente.
- Aprovação do Gerente: Finalmente, o pedido pode necessitar de uma aprovação adicional por parte de um gerente, especialmente para transações de alto valor ou itens restritos.

Cada uma dessas etapas é responsabilidade de um handler específico. O padrão Chain of Responsibility permite que o pedido seja passado sequencialmente por cada handler, onde cada um decide se processa o pedido ou o encaminha para o próximo handler. Isso promove uma estrutura flexível e modular, facilitando a manutenção e a expansão do sistema.

## 3. Implementação
...
### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Lucidchart](https://www.lucidchart.com/pages/).

![image](https://github.com/user-attachments/assets/831707dd-34a5-410c-9df0-d27fb7a16c89)

<h6 align = "center">Figura x: Desconto. Fonte: Guilherme Nishimura e Pedro Henrique</h6>

### 3.2. Código

x


## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.

## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0    | Inicio da estrutura do documento | Guilherme Nishimura |x | 22/07/2023| x|
