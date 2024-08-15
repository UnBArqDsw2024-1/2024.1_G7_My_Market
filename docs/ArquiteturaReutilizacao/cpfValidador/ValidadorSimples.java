package cpfValidador;

public class ValidadorSimples implements ValidadorCPF {
    @Override
    public boolean validar(String cpf) {
        // Remove pontos e hífens para validar apenas os dígitos
        cpf = cpf.replace(".", "").replace("-", "");

        // Verifica se o CPF tem 11 dígitos
        return cpf.length() == 11 && cpf.matches("\\d+");
    }
}

