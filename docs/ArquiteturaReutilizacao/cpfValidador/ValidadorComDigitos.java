package cpfValidador;

public class ValidadorComDigitos implements ValidadorCPF {
    @Override
    public boolean validar(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "");

        if (cpf.length() != 11 || !cpf.matches("\\d+")) {
            return false;
        }

        int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int primeiroDigito = calcularDigitoVerificador(cpf.substring(0, 9), pesos);
        int segundoDigito = calcularDigitoVerificador(cpf.substring(0, 9) + primeiroDigito, new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2});

        return cpf.equals(cpf.substring(0, 9) + primeiroDigito + segundoDigito);
    }

    private int calcularDigitoVerificador(String cpf, int[] pesos) {
        int soma = 0;
        for (int i = 0; i < cpf.length(); i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * pesos[i];
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}

