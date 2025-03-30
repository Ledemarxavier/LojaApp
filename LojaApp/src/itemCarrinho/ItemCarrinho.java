package itemCarrinho;

import produto.Produto;

public class ItemCarrinho {
    // Dados do item: produto, quantidade e desconto aplicado
    Produto produto;
    int quantidade;
    double desconto;
    
    // Cria novo item para o carrinho
    public ItemCarrinho(Produto produto, int quantidade, double desconto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }
    
    // Calcula valor total do item com desconto
    public double obterCusto() {
        return produto.obterValorComDesconto(desconto) * quantidade;
    }
    
    // Formata os dados
    public String toString() {
        return produto.getCodigo() + " - Qtd: " + quantidade + " - Desconto: " + desconto + "%";
    }
}