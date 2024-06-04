package model;

public class TipoProduto {

    private int codIdentificador;
    private String nome;
    private String descricao;

    public int getCodIdentificador() {
        return codIdentificador;
    }

    public void setCodIdentificador(int codIdentificador) {
        this.codIdentificador = codIdentificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getCodIdentificador() + ";" + getNome() + ";" + getDescricao();
    }
}
