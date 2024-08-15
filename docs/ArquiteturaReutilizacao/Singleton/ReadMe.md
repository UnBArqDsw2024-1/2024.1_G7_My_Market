# Reutilização

## Gerenciamento de Carrinho de Compras
Na segunda etapa do projeto, foram modelados diagramas que se enquadravam em duas denominações: os Estáticos (Classes, Pacotes, Componentes e Implantação) e os Dinâmicos (de Atividades e de Estados), por meio dos quais podemos observar e compreender diversas partes do sistema. Ao olhar para o diagrama de classes, especificamente para a classe CarrinhoDeCompras, constatamos que o usuário cliente deve possuir um carrinho de compras, e para isso, no momento da adição de itens, o carrinho deve ser gerenciado de forma eficiente.

Para esse gerenciamento, foi utilizado um código já existente utilizado por um dos membros em outros projetos e foi adaptado para o nosso contexto. O código em questão foi criado utilizando o padrão GoF Singleton que será apresentado a seguir:

O padrão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a essa instância. No caso do gerenciamento de carrinho de compras, você pode implementar o padrão Singleton para garantir que cada usuário tenha um único carrinho de compras que pode ser acessado e modificado de qualquer parte da aplicação.

Neste sentido, criaremos uma única instância para gerenciar o carrinho de compras de um usuário:

### 1. Classe **CarrinhoDeCompras**

A classe CarrinhoDeCompras, apresentada abaixo na figura 01, define os métodos que gerenciam os itens no carrinho de compras.

![CarrinhoDeCompras](https://github.com/user-attachments/assets/9edda299-9e0b-4f5e-ab08-81755381e382)
Figura 01: Classe CarrinhoDeCompras.

### 2. Classe **CarrinhoDeComprasManager**

A classe CarrinhoDeComprasManager, apresentada abaixo na figura 02, implementa o padrão Singleton para garantir que cada usuário tenha um único carrinho de compras.

![CarrinhoDeComprasManager](https://github.com/user-attachments/assets/41a159a1-8f6d-46ff-a474-6f31bc9b032d)
Figura 02: Classe CarrinhoDeComprasManager.

### 3. Classe **CarrinhoDeComprasContext**

A classe CarrinhoDeComprasContext, apresentada na figura 03 abaixo, é usada para aplicar diferentes estratégias de gerenciamento conforme necessário.

![CarrinhoDeComprasContext](https://github.com/user-attachments/assets/7527226f-e0f6-465b-8fa8-4c28cf05fa11)
Figura 03: Classe CarrinhoDeComprasContext.

### 4. Classe **Item**

A classe Item, apresentada na figura 04 abaixo, é uma classe 

![Item](https://github.com/user-attachments/assets/dc172756-4594-4249-8643-2accb036b51a)
Figura 04: Classe Item.

### 5. Exemplo de uso

Para testar o gerenciador de carrinho de compras, fizemos o teste apresentado abaixo na figura 05 e 06.

![Main](https://github.com/user-attachments/assets/a9d202db-8d24-4533-894a-933f9caaa553)
Figura 04: Classe Main que testa o gerenciador de carrinho de compras

![Resultado](https://github.com/user-attachments/assets/3a871cb8-6137-44e0-ac25-2c83e7bea192)
Figura 05: Resultado do teste