package cpfValidador;

public class ValidadorCPFContext {
    private ValidadorCPF estrategia;

    public ValidadorCPFContext(ValidadorCPF estrategia) {
        this.estrategia = estrategia;
    }

    public boolean validarCPF(String cpf) {
        return estrategia.validar(cpf);
    }

    public void setEstrategia(ValidadorCPF estrategia) {
        this.estrategia = estrategia;
    }
}

