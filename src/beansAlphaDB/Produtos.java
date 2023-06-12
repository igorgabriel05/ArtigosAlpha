package beansAlphaDB;

public class Produtos {
    private int id;
    private String produto;
    private double preco;
    private int quantidade;
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String toString() {
        return this.produto;
    }
    
    public boolean equals(Object objeto) {
        Produtos p = (Produtos) objeto;
        if(this.id == p.getId()) {
            return true;
        } else {
            return false;
        }
    }
    
}
