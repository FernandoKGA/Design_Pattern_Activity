package produto;

import static enumeradores.Enum_Formatos.*;

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
    public abstract String formataParaImpressao(); /*{
        String impressao = "";
        if ((format_flags & FORMATO_ITALICO.getBit()) > 0) {
            impressao += "<i>";
        }
        if ((format_flags & FORMATO_NEGRITO.getBit()) > 0) {
            impressao += "<b>";
        }
        
        impressao += this.produto.formataParaImpressao();
        
        if ((format_flags & FORMATO_NEGRITO.getBit()) > 0) {
            impressao += "</b>";
        }

        if ((format_flags & FORMATO_ITALICO.getBit()) > 0) {
            impressao += ("</i>");
        }
        return impressao;
    }*/
}
