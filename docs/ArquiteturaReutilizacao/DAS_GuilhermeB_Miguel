# Documento de Arquitetura de Software (DAS) - Sistema de Gerenciamento de Estoque e Inventário

## O documento em questão foi criado e desenvolvido pelos alunos [Miguel de Frias](https://github.com/migueldefrias) e [Guilherme Basilio](https://github.com/GuilhermeBES)

## 1. Introdução

O **Documento de Arquitetura de Software (DAS)** É um documento crucial no desenvolvimento de sistemas, oferecendo uma visão aprofundada da estrutura e organização do sistema. Ele detalha os principais componentes, suas interações e os princípios de design que orientam sua construção, ajudando a comunicar de forma eficaz entre todas as partes envolvidas e assegurando uma compreensão compartilhada do sistema.

Este DAS é focado no sistema de gerenciamento de um chatbot de atendimento para o projeto "My Market", uma plataforma de e-commerce para uma loja. O documento segue o modelo arquitetural 4+1, que inclui cinco visões diferentes para capturar e abordar diversas preocupações dos stakeholders, conforme proposto por Philippe Kruchten em 1995.

## 2. Objetivo

Este documento tem como objetivo ilustrar a arquitetura do sistema de gerenciamento de chatbot de atendimento do projeto "MyMarket", empregando o modelo arquitetural **4+1**. A abordagem sistemática aborda as diferentes preocupações dos stakeholders e oferece uma visão clara e acessível do sistema.

![Exemplo de modelo arquitetural 4+1](image.png)

<h6 align = "center">Figura 1: Exemplo de modelo arquitetural 4+1. Fonte: Mateus Orlando, Pedro Lucas e Thiago Vivan.</h6>

## 3. Visão de Casos de Uso

A visão de casos de uso ilustra como o sistema de gerenciamento do chatbot de atendimento interage com os usuários e outros sistemas. Cada caso de uso especifica uma funcionalidade particular e as interações necessárias para executar essa funcionalidade.

Casos de uso elicitados:
<center>

| Código  | Descrição do Caso de Uso                         |
|---------|--------------------------------------------------|
| UC01    | Consulta de Produtos                             |
| UC02    | Acompanhamento de Pedido                         |
| UC03    | Perguntas Frequentes (FAQ)                       |
| UC04    | Suporte Técnico                                  |
| UC05    | Recomendações Personalizadas                     |
| UC06    | Trocas e Devoluções                              |
| UC07    | Suporte em Tempo Real                            |


Tabela 2: Casos de uso elicitados

</center> 

### Diagrama de Casos de Uso (DCU)

O diagrama de caso de uso pode ser visualizado abaixo:
<div align = "center"><img src="" alt="Diagrama de Casos de Uso">
<p>Figura 2 - Diagrama de Casos de Uso<br> Autor: Guilherme Basilio e Miguel de Frias</p></div>

## 4. Visão Lógica

A Visão Lógica apresenta a estrutura estática do sistema, detalhando a organização dos principais componentes, como classes e pacotes, e suas interações. Ela é fundamental para entender as funcionalidades e a arquitetura interna do sistema.

### 4.1 Diagrama de Classes

O diagrama de classes exibe a estrutura do sistema de gerenciamento do chatbot de atendimento, detalhando as classes, seus atributos, métodos e as relações entre elas. Esse diagrama é essencial para o desenvolvimento e a documentação do sistema.

O diagrama de classes pode ser visualizado abaixo:
<div align = "center"><img src="" alt="Diagrama de Classes">
<p>Figura 3 - Diagrama de Classes<br> Autor: Guilherme Basilio e Miguel de Frias</p></div>

### 4.2 Diagrama de Estados

Um diagrama de estados é uma representação gráfica que descreve os estados possíveis de um objeto ao longo do tempo, juntamente com as transições entre esses estados. Ele mostra como o sistema reage a eventos ou condições, detalhando as mudanças de estado de um objeto específico. Usado frequentemente para modelar o comportamento dinâmico de sistemas, o diagrama ajuda a entender e projetar processos, especialmente aqueles que envolvem ciclos de vida, como o processamento de pedidos ou interações de usuários.

O diagrama de estados a seguir, ilustra os diferentes estados que ocorrem durante a funcionalidade Troca e Devolução, oferecida pelo chatbot.

*Fluxo de Estados do Chatbot:*
<div align = "center"><img src="" alt="Diagrama de Estados">
<p>Figura 4 - Diagrama de Estados<br> Autor: Guilherme Basilio e Miguel de Frias </p></div>

### 4.3 Diagrama de Pacotes

O diagrama de pacotes organiza e representa a estrutura modular do chatbot de atendimento, destacando a forma como os pacotes são agrupados e as dependências entre eles.

O diagrama de pacotes pode ser visualizado a seguir:

<div align = "center"><img src="" alt="Diagrama de Pacotes">
<p>Figura 5 - Diagrama de Pacotes<br> Autor: Guilherme Basilio e Miguel de Frias</p></div>

## 5. Visão de Processo

A visão de processo detalha como as atividades fundamentais do chatbot de atendimento são realizadas, incluindo as interações e funções principais.

### Usuário

| Nome                      | Descrição                                     | Destino                  |
|---------------------------|-----------------------------------------------|---------------------------|
| u1: iniciarConversa()     | Inicia uma conversa com o chatbot             | Chatbot de Atendimento    |
| u2: fazerPergunta()       | Envia uma pergunta para o chatbot             | Chatbot de Atendimento    |
| u3: fornecerFeedback()    | Fornece feedback sobre a conversa             | Chatbot de Atendimento    |
| u4: encerrarConversa()    | Finaliza a interação com o chatbot            | Chatbot de Atendimento    |

*Tabela 3: Descrição dos processos do Usuário*

### Sistema de Atendimento

| Nome                      | Descrição                                     | Destino                  |
|---------------------------|-----------------------------------------------|---------------------------|
| sa1: processarPergunta()  | Processa as perguntas enviadas pelos usuários | Chatbot de Atendimento    |
| sa2: gerarResposta()      | Gera respostas baseadas nas perguntas         | Chatbot de Atendimento    |
| sa3: registrarFeedback()  | Registra o feedback fornecido pelos usuários  | Banco de Dados            |
| sa4: finalizarConversa()  | Finaliza a conversa e armazena informações    | Banco de Dados            |

*Tabela 4: Descrição dos processos do Sistema de Atendimento*

## 6. Visão de Implementação

A Visão de Implementação detalha a organização do sistema em termos de módulos e pacotes de código. Ela ilustra como os componentes estão estruturados e como interagem entre si para garantir uma implementação eficiente.

### 6.1 Diagrama de Componentes

O diagrama de Componentes pode ser visualizado abaixo:
<div align = "center"><img src="" alt="Diagrama de Implementação">
<p>Figura 6 - Diagrama de Componentes<br> Autor: Guilherme Basilio e Miguel de Frias</p></div>

### 6.2 Explicação dos Componentes do Chatbot

#### Chatbot Engine:

- Dialogue Management: Gerencia o fluxo de conversa e o estado da interação com o usuário.
- Intent Recognition: Identifica a intenção do usuário com base nas entradas fornecidas.
- Response Generation: Gera respostas adequadas com base nas intenções identificadas.

#### Integration APIs:

- User Data API: Interface para acessar e manipular dados de usuários.
- Product Data API: Interface para acessar e manipular dados de produtos.
- Order Data API: Interface para acessar e manipular dados de pedidos.

Esses componentes permitem que o chatbot interaja com o sistema existente de forma eficaz, acessando dados relevantes e realizando operações necessárias para atender às solicitações dos usuários.


## 7. Visão de Implantação

A Visão de Implantação descreve a distribuição física dos componentes de software e como eles interagem em um ambiente de produção.

Os diagramas de implantação são fundamentais para arquitetos de software e engenheiros de sistemas, pois permitem visualizar e planejar a distribuição física dos componentes de software. Eles asseguram que todos os aspectos físicos da implantação do sistema sejam compreendidos e documentados, facilitando a comunicação entre as partes interessadas e garantindo uma implementação bem-sucedida.

Este documento apresenta a arquitetura de implantação de um sistema distribuído, com ênfase em eficiência, segurança e escalabilidade. O sistema é organizado em vários nós principais: Cliente, Proxy, Web Server e Database, cada um contendo componentes e entidades específicas. Vale ressaltar que o diagrama foi criado sem a definição completa das tecnologias a serem utilizadas e pode ser ajustado conforme as decisões do grupo evoluem.

<div align = "center"><img src="" alt="Diagrama de implantação" alt="Diagrama de implantação">
<p>Figura 7 - Diagrama de Implantação<br> Autor: Guilherme Basilio e Miguel de Frias </p></div>

## 7. Arquitetura de Implantação

### 7.1 Nó Cliente

**Componentes:**
- **Interface de Chat:** Permite ao usuário interagir com o chatbot de atendimento.

**Comunicação:**
- Conecta-se ao servidor através de HTTPS para garantir a segurança da comunicação.

### 7.2 Nó Servidor de Aplicação

**Componentes:**
- **Gerenciamento de Conversas:** Lida com a lógica e fluxo das interações do chatbot.
- **API de Integração:** Facilita a comunicação com outros sistemas e serviços externos.

**Comunicação:**
- Estabelece conexão com o banco de dados utilizando SQL para armazenar e recuperar informações.

### 7.3 Nó Banco de Dados

**Componentes:**
- **MySQL:** Armazena dados relacionados às interações do chatbot, histórico de conversas e perfis de usuários.

### 7.4 Fluxo de Dados e Controle

- **Do Cliente para o Servidor:** As interações do usuário são enviadas ao servidor por meio de HTTPS.
- **Do Servidor para o Banco de Dados:** O servidor realiza consultas e atualizações no banco de dados conforme necessário.
- **Respostas ao Cliente:** O servidor processa as informações e envia as respostas de volta para o cliente.

### Conclusão

A arquitetura descrita para o sistema de chatbot de atendimento oferece uma solução eficaz e escalável, com foco em segurança e usabilidade. A visão detalhada da distribuição física e das interações entre os componentes proporciona uma base sólida para a implementação e manutenção contínua do sistema.

## Referências

> **Arquitetura e Desenho de Software - Aula DAS**. Material de apoio em slides. Milene Serrano.

## Histórico de Versões

| Versão |     Data    | Descrição   | Autor(es) | Revisor(es) |
| ------ | ----------- | ----------- | --------- | ----------- |
| `1.0`  | 12/08/2024 | Criação da estrutura do artefato |  [Miguel de Frias](https://github.com/migueldefrias) e [Guilherme Basilio](https://github.com/GuilhermeBES)| [Miguel de Frias](https://github.com/migueldefrias) |
| `2.0`  | 12/08/2024 | Desenvolvimento do Artefato | [Miguel de Frias](https://github.com/migueldefrias) e [Guilherme Basilio](https://github.com/GuilhermeBES) | [Miguel de Frias](https://github.com/migueldefrias) |
| `3.0`  | 12/08/2024 | Adição do diagrama de Casos de Uso | [Miguel de Frias](https://github.com/migueldefrias) e [Guilherme Basilio](https://github.com/GuilhermeBES)| [Miguel de Frias](https://github.com/migueldefrias) |
| `4.0`  | 15/08/2024 | Adição dos diagramas restantes | [Miguel de Frias](https://github.com/migueldefrias)  | [Guilherme Basilio](https://github.com/GuilhermeBES)|