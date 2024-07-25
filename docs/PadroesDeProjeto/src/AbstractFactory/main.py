from fabrica import RoupaCasualFactory, RoupaFormalFactory

def main():
    # Fábrica de Roupas Casuais
    roupa_casual_factory = RoupaCasualFactory()
    camiseta_casual = roupa_casual_factory.criar_camiseta()
    casaco_casual = roupa_casual_factory.criar_casaco()
    camiseta_casual.exibir_info()  # Print: Camiseta Casual
    casaco_casual.exibir_info()     # Print: Casaco Casual

    # Fábrica de Roupas Formais
    roupa_formal_factory = RoupaFormalFactory()
    camiseta_formal = roupa_formal_factory.criar_camiseta()
    casaco_formal = roupa_formal_factory.criar_casaco()
    camiseta_formal.exibir_info()  # Print: Camiseta Formal
    casaco_formal.exibir_info()     # Print: Casaco Formal

if __name__ == "__main__":
    main()
