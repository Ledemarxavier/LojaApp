package loja;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import cliente.Cliente;
import produto.Produto;
import carrinhoDeCompras.CarrinhoDeCompras;

public class Loja {
	// Listas para armazenar dados da loja
    List<Cliente> clientes = new ArrayList<>();
    List<Produto> estoque = new ArrayList<>();
    List<CarrinhoDeCompras> vendasFinalizadas = new ArrayList<>();
    public CarrinhoDeCompras vendaEmAndamento;
    Scanner scanner = new Scanner(System.in);
    
 // Cadastra novo cliente
    public void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente novo = new Cliente(nome, cpf);
        clientes.add(novo);

        System.out.println("Cliente cadastrado com sucesso!");
    }
    
    // Busca cliente por nome
    public Cliente pesquisarCliente(String nome) {
        for(Cliente c : clientes) {
            if(c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
     
 // Cadastra novo produto no estoque
    public void cadastrarProduto() {
        System.out.print("Código do produto: ");
        int codigo = scanner.nextInt();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        
        Produto novo = new Produto(codigo, preco, quantidade);
        estoque.add(novo);
        System.out.println("Produto cadastrado com sucesso!");
    }
      
 // Busca produto por código
    public Produto pesquisarProduto(int codigo) {
        for(Produto p : estoque) {
            if(p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    // Inicia nova venda para um cliente
    public void iniciarVenda() {
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = pesquisarCliente(nomeCliente);
        if (cliente == null) {
            System.out.println("Erro ao iniciar venda. Cliente não encontrado.");
            return;
        }

        if (vendaEmAndamento != null) {
            System.out.println("Erro: Já existe uma venda em andamento.");
            return;
        }

        vendaEmAndamento = new CarrinhoDeCompras();
        vendaEmAndamento.setCliente(cliente);

        System.out.println("Venda iniciada para " + cliente.getNome());
    }

 // Adiciona produto ao carrinho atual
    public void adicionarProdutoAoCarrinho() {
        if (vendaEmAndamento == null) {
            System.out.println("Erro: Nenhuma venda em andamento.");
            return;
        }

        System.out.print("Código do produto: ");
        int codigo = scanner.nextInt();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Desconto (%): ");
        double desconto = scanner.nextDouble();

        Produto produto = pesquisarProduto(codigo);
        if (produto == null) {
            System.out.println("Erro: Produto não encontrado.");
            return;
        }

        // Verifica se há estoque suficiente
        if (produto.getQuantidadeEstoque() < quantidade) {
            System.out.println("Erro: Quantidade insuficiente em estoque. Disponível: " + produto.getQuantidadeEstoque());
            return;
        }

        // Adiciona ao carrinho e reduz o estoque
        vendaEmAndamento.adicionarProdutoAoCarrinho(produto, quantidade, desconto);
        produto.reduzirEstoque(quantidade);
        
        System.out.println("Produto adicionado ao carrinho com sucesso!");
        System.out.println("Estoque atual: " + produto.getQuantidadeEstoque());
    }

 // Exibe conteúdo do carrinho atual
    public void exibirConteudoDoCarrinho(){
        if (vendaEmAndamento != null) {
            System.out.println("\n=== Carrinho de Compras ===");
            System.out.println(vendaEmAndamento);
        } else {
            System.out.println("Nenhuma venda em andamento.");
        }
    }

 // Finaliza a venda atual
    public void fecharVenda() {
        if (vendaEmAndamento == null) {
            System.out.println("Nenhuma venda em andamento para fechar.");
            return;
        }
        double total = vendaEmAndamento.obterValorTotal();
        vendasFinalizadas.add(vendaEmAndamento);
        vendaEmAndamento = null;
        System.out.println("Venda finalizada! Total: R$" + String.format("%.2f", total));
    }
 // Exibe venda atual
    public void exibirVendaEmAndamento() {
        if (vendaEmAndamento == null) {
            System.out.println("Nenhuma venda em andamento.");
            return;
        }
        
        System.out.println("\nVenda em andamento:");
        System.out.println("Cliente: " +
             vendaEmAndamento.getCliente());
        System.out.println(vendaEmAndamento);
    }
    
 // Exibe vendas finalizadas
    public void exibirVendasFinalizadas() {
        if (vendasFinalizadas == null || vendasFinalizadas.isEmpty()) {
            System.out.println("Nenhuma venda finalizada encontrada.");
            return;
        }
        
        System.out.println("\nVendas finalizadas");
        for (CarrinhoDeCompras venda : vendasFinalizadas) {
            System.out.println("\nCliente: " + 
                (venda.getCliente().getNome() != null ? venda.getCliente().getNome() : "Não informado"));
            System.out.println(venda.toString());
        }
    }
}