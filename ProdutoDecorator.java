
public class ProdutoDecorator implements Produto {

    private final Produto produto;

    private final int format_flags;

    public static final int FORMATO_PADRAO = 0b0000;
    public static final int FORMATO_NEGRITO = 0b0001;
    public static final int FORMATO_ITALICO = 0b0010;

    public ProdutoDecorator(Produto produto, int format_flags) {
        this.produto = produto;
        this.format_flags = format_flags;
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
    public String formataParaImpressao() {
        String impressao = "";
        if ((format_flags & FORMATO_ITALICO) > 0) {
            impressao += "<i>";
        }
        if ((format_flags & FORMATO_NEGRITO) > 0) {
            impressao += "<b>";
        }
        
        impressao += this.produto.formataParaImpressao();
        
        if ((format_flags & FORMATO_NEGRITO) > 0) {
            impressao += "</b>";
        }

        if ((format_flags & FORMATO_ITALICO) > 0) {
            impressao += ("</i>");
        }
        return impressao;
    }
}
