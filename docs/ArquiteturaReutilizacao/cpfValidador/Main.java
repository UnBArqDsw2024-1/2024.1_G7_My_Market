package cpfValidador;

public class Main {
    public static void main(String[] args) {
        // Exemplos de CPFs para teste
        String cpfValido = "123.456.789-09";
        String cpfInvalido = "111.111.111-11";
        String cpfInvalidoFormato = "12345678900";

        // Instância do contexto usando o Validador Simples
        ValidadorCPFContext context = new ValidadorCPFContext(new ValidadorSimples());
        System.out.println("== Teste com Validador Simples ==");
        System.out.println("CPF valido (formato com pontos e hifen): " + context.validarCPF(cpfValido));
        System.out.println("CPF invalido (todos digitos iguais): " + context.validarCPF(cpfInvalido));
        System.out.println("CPF invalido (formato sem pontos e hifen): " + context.validarCPF(cpfInvalidoFormato));

        // Alterando a estratégia para o Validador Completo com dígitos
        context.setEstrategia(new ValidadorComDigitos());
        System.out.println("\n== Teste com Validador Completo ==");
        System.out.println("CPF valido (formato com pontos e hifen): " + context.validarCPF(cpfValido));
        System.out.println("CPF invalido (todos digitos iguais): " + context.validarCPF(cpfInvalido));
        System.out.println("CPF invalido (formato sem pontos e hifen): " + context.validarCPF(cpfInvalidoFormato));
    }
}

