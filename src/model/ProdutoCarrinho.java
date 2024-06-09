package model;

public class ProdutoCarrinho {
    private int id;
    private String nome;
    private double valor;
    private String descricao;
    private int quantidade;

    public ProdutoCarrinho(int id, String nome, double valor, String descricao, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Id: " + id + "; Produto: " + nome + "; Valor: R$" + valor + "; Descrição: " + descricao + "; Quantidade: " + quantidade;
    }
}
