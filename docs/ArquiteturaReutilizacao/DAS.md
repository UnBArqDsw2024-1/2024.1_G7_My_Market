# Documento de Arquitetura de Software (DAS) - Fluxo de Descontos e Cupons

## 1. Introdução

O **Documento de Arquitetura de Software (DAS)** é um artefato essencial no desenvolvimento de sistemas complexos, fornecendo uma visão detalhada da estrutura e organização do sistema. Ele descreve os principais componentes, suas interações e os princípios de design que guiam sua construção, facilitando a comunicação entre todas as partes interessadas e garantindo uma compreensão comum do sistema.

Este DAS é focado no fluxo de descontos e cupons para o projeto "SupermarketX", um sistema de e-commerce para um supermercado. O documento utiliza o modelo arquitetural **4+1**, que inclui cinco visões diferentes para capturar e abordar diversas preocupações dos stakeholders, conforme proposto por Philippe Kruchten em 1995.

## 2. Objetivo

Este documento visa representar a arquitetura do sistema de fluxo de descontos e cupons do projeto "MyMrket", utilizando o modelo arquitetural **4+1**. A abordagem estruturada captura as diversas preocupações dos stakeholders e proporciona uma visão clara e compreensível do sistema.

![Exemplo de modelo arquitetural 4+1](image.png)

<h6 align = "center">Figura 01: Exemplo de modelo arquitetural 4+1. Fonte: Mateus Orlando, Pedro Lucas e Thiago Vivan.</h6>

## 3. Visão de Casos de Uso

A visão de casos de uso descreve como o sistema de descontos e cupons interage com seus usuários e outros sistemas. Cada caso de uso define uma funcionalidade específica e as interações necessárias para realizar essa funcionalidade.

Casos de uso elicitados:
<center>

| Código  | Descrição do Caso de Uso                         |
|---------|--------------------------------------------------|
| UC01    | Aplicar um cupom de desconto                     |
| UC02    | Verificar a validade de um cupom                 |
| UC03    | Gerar novos cupons de desconto                    |
| UC04    | Listar todos os cupons disponíveis                |
| UC05    | Remover um cupom de desconto                      |
| UC06    | Aplicar desconto progressivo                     |
| UC07    | Consultar histórico de uso de cupons             |
| UC08    | Configurar regras para cupons                    |
| UC09    | Notificar usuários sobre cupons expiring          |
| UC10    | Validar descontos aplicados no carrinho           |
| UC11    | Integrar cupons com campanhas promocionais       |
| UC12    | Exportar relatórios de uso de cupons             |
| UC13    | Importar cupons em massa                         |
| UC14    | Validar regras de desconto                       |
| UC15    | Aplicar cupons em promoções combinadas           |
| UC16    | Gerar relatórios de desempenho de cupons          |
| UC17    | Gerenciar limites de uso de cupons                |
| UC18    | Configurar regras de expiração de cupons          |

Tabela 2: Casos de uso elicitados

</center> 

### Diagrama de Casos de Uso (DCU)

O diagrama de caso de uso pode ser visualizado abaixo:
![Diagrama de Casos de Uso](https://github.com/user-attachments/assets/ad8d0df4-530a-48c4-abd1-a78b5c6b10f5)

## 4. Visão Lógica

A Visão Lógica descreve a estrutura estática do sistema, mostrando como os principais componentes, como classes e pacotes, estão organizados e como interagem. É essencial para compreender as funcionalidades e a arquitetura interna do sistema.

### 4.1 Diagrama de Classes

O diagrama de classes mostra a estrutura do sistema de descontos e cupons, detalhando as classes, atributos, métodos e suas relações. Este diagrama é fundamental para o desenvolvimento e a documentação do sistema.

O diagrama de classes pode ser visualizado abaixo:
![Diagrama de Classes](https://github.com/user-attachments/assets/26e83e4a-66ef-4ae5-9f28-9993eb4b3081)

### 4.2 Diagrama de Estados

O diagrama de estados representa os diferentes estados que um cupom pode ter ao longo de seu ciclo de vida, como criação, validação, aplicação e expiração.

*Fluxo de Estados do Cupom:*
<div align = "center"><img src="https://raw.githubusercontent.com/UnBArqDsw2024-1/2024.1_G7_My_Market/main/docs/Imagens/Diagramas/DiagramaEstado.jpeg" alt="Diagrama de Estados">
<p>Figura 2 - Diagrama de Estados<br> Autor: Guilherme Nishimura</p></div>

### 4.3 Diagrama de Pacotes

O diagrama de pacotes organiza e visualiza a estrutura modular do sistema de cupons e descontos, mostrando como os pacotes se agrupam e as dependências entre eles.

O diagrama de pacotes pode ser visualizado a seguir:

![Diagrama de Pacotes](https://github.com/user-attachments/assets/76d2e89e-a9b3-4b09-a2eb-c3a29d86dd15)

## 5. Visão de Processo

A visão de processo descreve como as atividades essenciais do sistema de cupons e descontos são executadas, incluindo interações e funções principais.

### Usuário

| Nome                    | Descrição                                     | Destino           |
|-------------------------|-----------------------------------------------|--------------------|
| u1: aplicarCupom()      | Aplica um cupom de desconto no carrinho       | Sistema de Cupons  |
| u2: verificarValidade() | Verifica se o cupom é válido                  | Sistema de Cupons  |
| u3: consultarCupons()   | Lista todos os cupons disponíveis             | Sistema de Cupons  |
| u4: resgatarCupom()     | Resgata um cupom para uso futuro              | Sistema de Cupons  |

*Tabela 3: Descrição do processo Usuário*

### Sistema de Cupons

| Nome                    | Descrição                                     | Destino           |
|-------------------------|-----------------------------------------------|--------------------|
| sc1: validarCupom()     | Valida a aplicação de um cupom                | Banco de Dados     |
| sc2: gerarCupom()       | Cria novos cupons de desconto                 | Banco de Dados     |
| sc3: aplicarDesconto()  | Aplica o desconto no carrinho de compras      | Carrinho           |
| sc4: exportarRelatorio()| Exporta relatórios de uso de cupons           | Usuário/Admin      |

*Tabela 4: Descrição do processo Sistema de Cupons*

## 6. Visão de Implementação

A Visão de Implementação descreve como o sistema é organizado em termos de módulos e pacotes de código. Mostra a estrutura dos componentes e suas interações para uma implementação eficaz.

O diagrama de componentes pode ser visualizado abaixo:
![Diagrama de Componentes](https://github.com/user-attachments/assets/cc637887-fc8a-457f-8e37-78425b30bbcd)


## 7. Visão de Implantação

A Visão de Implantação detalha a distribuição física dos componentes de software e como eles interagem em um ambiente de produção.

### 7.1 Nó Cliente
- Componentes:
  - Interface Web: Acesso ao sistema de cupons e descontos.
- Comunicação:
  - Conexão com o servidor via HTTPS.

### 7.2 Nó Servidor de Aplicação
- Componentes:
  - Gerenciamento de Cupons: Lida com a lógica de cupons e descontos.
  - API de Promoções: Interface para integração com sistemas externos.
- Comunicação:
  - Conexão com o banco de dados via SQL.

### 7.3 Nó Banco de Dados
- Componentes:
  - MySQL: Armazena dados sobre cupons, descontos e histórico de uso.

### 7.4 Fluxo de Dados e Controle
1. Do Cliente ao Servidor: O tráfego inicia no cliente e é enviado ao servidor via HTTPS.
2. Do Servidor ao Banco de Dados: O servidor consulta e atualiza dados no banco de dados.
3. Respostas ao Cliente: O servidor envia respostas e atualizações de volta ao cliente.

### Conclusão

A arquitetura apresentada para o sistema de descontos e cupons do "SupermarketX" garante uma solução robusta e escalável, com ênfase na eficiência, segurança e usabilidade. A visão detalhada da distribuição física e das interações entre os componentes proporciona uma base sólida para a implementação e manutenção contínua do sistema.

## Referências

> **Arquitetura e Desenho de Software - Aula DAS**. Material de apoio em slides. Milene Serrano.

> FAKHROUTDINOV, Kirill. UML. UML 2.5 Diagrams Overview. [S. l.], 2023. Disponível em: https://www.uml-diagrams.org/uml-25-diagrams.html. Acesso em: 02 ago. 2024.
