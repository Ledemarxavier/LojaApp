package carrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;
import itemCarrinho.ItemCarrinho;
import cliente.Cliente;
import produto.Produto;

public class CarrinhoDeCompras {
    public List<ItemCarrinho> itens = new ArrayList<>();
    
    // Cliente associado à compra
    public Cliente cliente;
    
    // Retorna o cliente da compra
    public Cliente getCliente() {
        return this.cliente;
    }
    
    // Define o cliente da compra
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Adiciona produto ao carrinho
    public void adicionarProdutoAoCarrinho(Produto produto, int quantidade, double desconto) {
        if (produto == null || quantidade <= 0) return;
        itens.add(new ItemCarrinho(produto, quantidade, desconto));
    }

    // Calcula o valor total do carrinho
    public double obterValorTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.obterCusto(); 
        }
        return total;
    }

    // Formata os dados
    public String toString() {
        String result = "Cliente: " + (cliente != null ? cliente.getNome() : "Nenhum") + "\n";
        result += "Itens:\n";
        for (ItemCarrinho item : itens) {
            result += item.toString() + "\n"; // Lista cada item
        }
        result += "Total: R$" + String.format("%.2f", obterValorTotal());
        return result;
    }
}