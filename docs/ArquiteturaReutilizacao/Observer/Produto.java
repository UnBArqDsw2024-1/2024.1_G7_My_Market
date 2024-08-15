import java.util.ArrayList;
import java.util.List;

public class Produto implements Sujeito {
    private String nome;
    private double preco;
    private boolean emPromocao;
    private List<Observador> observadores;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.emPromocao = false;
        this.observadores = new ArrayList<>();
    }

    public void setEmPromocao(boolean emPromocao) {
        if (this.emPromocao != emPromocao) {  // Verifica se há mudança de estado
            this.emPromocao = emPromocao;
            if (emPromocao) {
                notificarObservadores();
            }
        }
    }

    @Override
    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.atualizar("O produto " + nome + " está em promoção por " + preco + "!");
        }
    }
}

