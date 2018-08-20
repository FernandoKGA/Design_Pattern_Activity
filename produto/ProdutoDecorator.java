package produto;

public abstract class ProdutoDecorator implements Produto {

    protected final Produto produto;

    public ProdutoDecorator(Produto produto) {
        this.produto = produto;
    }
    
    @Override
    public void setQtdEstoque(int qtdEstoque) {
        this.produto.setQtdEstoque(qtdEstoque);
    }

    @Override
    public void setPreco(double preco) {
        this.produto.setPreco(preco);
    }

    @Override
    public int getId() {
        return this.produto.getId();
    }

    @Override
    public String getDescricao() {
        return this.produto.getDescricao();
    }

    @Override
    public String getCategoria() {
        return this.produto.getCategoria();
    }

    @Override
    public int getQtdEstoque() {
        return this.produto.getQtdEstoque();
    }

    @Override
    public double getPreco() {
        return this.produto.getPreco();
    }

    @Override
    public abstract String formataParaImpressao();
}
