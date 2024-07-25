from abc import ABC, abstractmethod

class Subject(ABC):
    @abstractmethod
    def registrar_observador(self, observador):
        pass

    @abstractmethod
    def remover_observador(self, observador):
        pass

    @abstractmethod
    def notificar_observadores(self):
        pass

class Loja(Subject):
    def __init__(self):
        self._observadores = []
        self._novos_produtos = []
        self._descontos = {}

    def registrar_observador(self, observador):
        self._observadores.append(observador)

    def remover_observador(self, observador):
        self._observadores.remove(observador)

    def notificar_observadores(self):
        for observador in self._observadores:
            observador.atualizar(self._novos_produtos, self._descontos)
        self._novos_produtos = []

    def adicionar_produto(self, produto):
        self._novos_produtos.append(produto)
        self.notificar_observadores()

    def adicionar_desconto(self, produto, desconto):
        self._descontos[produto] = desconto
        self.notificar_observadores()

class Observer(ABC):
    @abstractmethod
    def atualizar(self, novos_produtos, descontos):
        pass

class Cliente(Observer):
    def __init__(self, nome, tipo_notificacao):
        self._nome = nome
        self._tipo_notificacao = tipo_notificacao
        self._ultimos_produtos = []
        self._ultimos_descontos = {}

    def atualizar(self, novos_produtos, descontos):
        novos_produtos = [produto for produto in novos_produtos if produto not in self._ultimos_produtos]
        novos_descontos = {produto: desconto for produto, desconto in descontos.items() if produto not in self._ultimos_descontos}

        if novos_produtos or novos_descontos:
            print(f"Notificação para {self._nome}:")
            if self._tipo_notificacao == "produtos" and novos_produtos:
                print("Novos produtos adicionados: ", novos_produtos)
            elif self._tipo_notificacao == "tudo":
                if novos_produtos:
                    print("Novos produtos adicionados: ", novos_produtos)
                if novos_descontos:
                    print("Descontos disponíveis: ", novos_descontos)
            print()
            self._ultimos_produtos.extend(novos_produtos)
            self._ultimos_descontos.update(novos_descontos)

def main():
    loja = Loja()

    cliente1 = Cliente("João", "produtos")
    cliente2 = Cliente("Pedro", "tudo")

    loja.registrar_observador(cliente1)
    loja.registrar_observador(cliente2)

    loja.adicionar_produto("Tênis Adidas Breaknet Masculino - Branco+Preto")
    loja.adicionar_produto("Tênis Nike Air Max SC Masculino - Preto+Branco")
    loja.remover_observador(cliente1)
    loja.adicionar_desconto("Tênis Adidas", "10% de desconto")
    loja.adicionar_desconto("Tênis Nike", "20% de desconto")

if __name__ == "__main__":
    main()
