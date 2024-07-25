# Bridge - GoF estrutural

## 1. Introdução

O padrão de projeto estrutural Bridge consiste em separar a abstração do problema de sua real implementação. Isso é feito separando as classes mais generalistas (abstratas) das classes implementadoras. Essas classes implementadoras são as classes que realmente farão a implementação do método com base nas especificidades exigidas pelo cliente. Consequentemente, as classes mais abstratas e as classes implementadoras podem variar de forma independente uma da outra, esse relacionamento é chamado de Bridge.

> Desacoplar uma abstração da sua implementação, de modo que as duas possam variar independentemente (Livro: Padrões de Projeto, pg. 146)

## 2. Objetivo

Demonstrar a implementação do padrão de projeto estrutural Bridge, criando uma classe abstrata com duas variações, e uma classe implementadora que também tem duas variações. Depois, conectar ambas, mostrando que elas podem trabalhar de forma independente.

## 3. Implementação
### 3.1 Diagrama UML

A classe mais abstrata Roupa possui duas filhas (Camisa e Casaco), e a classe implementadora Tamanho pode atribuir a classes do tipo Roupa o tamanho específico Grande ou Pequeno, dependendo do que for exigido pelo cliente.

![diagramaBridge](./src/Bridge/Bridge.png)
<h6 align = "center">Figura 1: Diagrama de classes Bridge</h6>

### 3.2 Código
Aqui está um exemplo simples de implementação do padrão Adapter em Python no contexto do diagrama UML:

Primeiro é definido uma interface para a implementação (Tamanho) e duas classes concretas que a implementam (TamanhoPequeno e TamanhoGrande):

```Python
from abc import ABC, abstractmethod

class Tamanho(ABC):
    @abstractmethod
    def aplicar_tamanho(self):
        pass

class TamanhoPequeno(Tamanho):
    def aplicar_tamanho(self):
        print("Aplicando tamanho pequeno")

class TamanhoGrande(Tamanho):
    def aplicar_tamanho(self):
        print("Aplicando tamanho grande")
```

Depois é implementado uma interface para a abstração (Roupa) e classes concretas que a implementam (Camisa e Casaco):

```Python
class Roupa(ABC):
    def __init__(self, tamanho):
        self._tamanho = tamanho

    @abstractmethod
    def aplicar_tamanho(self):
        pass

class Camisa(Roupa):
    def __init__(self, tamanho):
        super().__init__(tamanho)

    def aplicar_tamanho(self):
        print("Camisa:")
        self._tamanho.aplicar_tamanho()

class Casaco(Roupa):
    def __init__(self, tamanho):
        super().__init__(tamanho)

    def aplicar_tamanho(self):
        print("Casaco:")
        self._tamanho.aplicar_tamanho()
```
Após isso é feita uma função que permita que o cliente acione as instâncias de Camisa e Casaco, cada uma usando diferentes implementações de Tamanho:

```Python
def main():

    camisa_pequena = Camisa(TamanhoPequeno())
    camisa_grande = Camisa(TamanhoGrande())
    camisa_pequena.aplicar_tamanho()  
    camisa_grande.aplicar_tamanho()   


    casaco_pequeno = Casaco(TamanhoPequeno())
    casaco_grande = Casaco(TamanhoGrande())
    casaco_pequeno.aplicar_tamanho()  
    casaco_grande.aplicar_tamanho()   

if __name__ == "__main__":
    main()

```

## Resultado
Após rodar o código acima vai imprimir o seguinte reultado:
```Python
Camisa:
Aplicando tamanho pequeno
Camisa:
Aplicando tamanho grande
Casaco:
Aplicando tamanho pequeno
Casaco:
Aplicando tamanho grande
```
Isso demostra que o código está funcionando no padrão do Bridge, permitindo que a abstração (**Camisa**, **Casaco**) e a implementação (**TamanhoPequeno**, **TamanhoGrande**) possam variar independentemente.
## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Criacionais**. Material de apoio em slides. Milene Serrano.

> Gamma, Erich, et al. **Padrões de projetos: soluções reutilizáveis de software orientados a objetos.** Disponível em: Minha Biblioteca, Grupo A, 2000.

>REFATORING GURU. Singleton Design Pattern. Disponível em: https://refactoring.guru/pt-br/design-patterns/singleton. Acesso em: 25 jul. 2024.

## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0    | Inicio da estrutura do documento | [RodrigoWright](https://github.com/RodrigoWright) | [Guilherme Oliveira](https://github.com/GG555-13) | 24/07/2023 | 24/07/2023 |
| 1.1 | Código e Resultado | [Guilherme Oliveira](https://github.com/GG555-13)| [RodrigoWright](https://github.com/RodrigoWright) | 25/07/2023 | 25/07/2023 |
| 1.3 | Texto Introdutório e UML | [RodrigoWright](https://github.com/RodrigoWright) | [Guilherme Oliveira](https://github.com/GG555-13) | 25/07/2023 | 25/07/2023 |



