package produto;

public class Produto {
    // Atributos 
    int codigo;
    double preco;
    int quantidadeEstoque;
    
    // Construtor 
    public Produto(int codigo, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    // Métodos getters 
    public int getCodigo() {
        return codigo;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    
    // Reduz a quantidade em estoque
    public void reduzirEstoque(int quantidade) {
        this.quantidadeEstoque -= quantidade;
    }
    
    // Calcula preço com desconto percentual
    public double obterValorComDesconto(double percentual) {
        return preco * (1 - percentual / 100);        
    }
}