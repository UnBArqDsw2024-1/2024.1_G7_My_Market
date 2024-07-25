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

def main():

    camisa_pequena = Camisa(TamanhoPequeno())
    camisa_grande = Camisa(TamanhoGrande())
    camisa_pequena.aplicar_tamanho()  # Aplicando tamanho pequeno
    camisa_grande.aplicar_tamanho()   # Aplicando tamanho grande


    casaco_pequeno = Casaco(TamanhoPequeno())
    casaco_grande = Casaco(TamanhoGrande())
    casaco_pequeno.aplicar_tamanho()  # Aplicando tamanho pequeno
    casaco_grande.aplicar_tamanho()   # Aplicando tamanho grande

if __name__ == "__main__":
    main()
