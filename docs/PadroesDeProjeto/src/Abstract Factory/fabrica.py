from abc import ABC, abstractmethod
from produto import Camiseta, Casaco, CamisetaCasual, CamisetaFormal, CasacoCasual, CasacoFormal

class RoupaFactory(ABC):
    @abstractmethod
    def criar_camiseta(self):
        pass

    @abstractmethod
    def criar_casaco(self):
        pass

class RoupaCasualFactory(RoupaFactory):
    def criar_camiseta(self):
        return CamisetaCasual()

    def criar_casaco(self):
        return CasacoCasual()

class RoupaFormalFactory(RoupaFactory):
    def criar_camiseta(self):
        return CamisetaFormal()

    def criar_casaco(self):
        return CasacoFormal()
