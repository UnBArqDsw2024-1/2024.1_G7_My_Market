class ConfigManager:
    _instance = None

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super(ConfigManager, cls).__new__(cls, *args, **kwargs)
        return cls._instance

    def __init__(self):
        if not hasattr(self, 'initialized'):
            self.configuration = "Configuração padrão"
            self.initialized = True

    def get_configuration(self):
        return self.configuration

    def set_configuration(self, configuration):
        self.configuration = configuration


def main():
    # Pega a instancia do ConfigManager
    config_manager1 = ConfigManager()
    print(config_manager1.get_configuration())  # Output: Configuração padrão

    # Muda a configuração
    config_manager1.set_configuration("Nova configuração")

    # Pega a instancia e verifica a configuração
    config_manager2 = ConfigManager()
    print(config_manager2.get_configuration())  # Output: Nova configuração

    # Verificação
    print(config_manager1 == config_manager2)  # Output: True

if __name__ == "__main__":
    main()
