from abc import ABC, abstractmethod

class Camiseta(ABC):
    @abstractmethod
    def exibir_info(self):
        pass

class Casaco(ABC):
    @abstractmethod
    def exibir_info(self):
        pass

class CamisetaCasual(Camiseta):
    def exibir_info(self):
        print("Camiseta Casual")

class CamisetaFormal(Camiseta):
    def exibir_info(self):
        print("Camiseta Formal")


class CasacoCasual(Casaco):
    def exibir_info(self):
        print("Casaco Casual")

class CasacoFormal(Casaco):
    def exibir_info(self):
        print("Casaco Formal")

