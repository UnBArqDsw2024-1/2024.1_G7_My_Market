package ChainsOfResponsibility;

public class Request {
    private boolean estoqueDisponivel;
    private boolean pagamentoValidado;
    private boolean aprovadoPeloGerente;

    public boolean isEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public void setEstoqueDisponivel(boolean estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public boolean isPagamentoValidado() {
        return pagamentoValidado;
    }

    public void setPagamentoValidado(boolean pagamentoValidado) {
        this.pagamentoValidado = pagamentoValidado;
    }

    public boolean isAprovadoPeloGerente() {
        return aprovadoPeloGerente;
    }

    public void setAprovadoPeloGerente(boolean aprovadoPeloGerente) {
        this.aprovadoPeloGerente = aprovadoPeloGerente;
    }
}
