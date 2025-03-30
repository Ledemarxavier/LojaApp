package main;

import java.util.Scanner;

import cliente.Cliente;
import loja.Loja;
import produto.Produto;
import carrinhoDeCompras.CarrinhoDeCompras;

public class Main {

	public static void main(String[] args) {
		Loja loja = new Loja();
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
        
        System.out.println("\n=== Menu ===");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Cadastrar produto");
        System.out.println("3. Iniciar venda");
        System.out.println("4. Adicionar produto ao carrinho");
        System.out.println("5. Exibir conteúdo do carrinho");
        System.out.println("6. Fechar venda");
        System.out.println("7. Exibir venda em andamento");
        System.out.println("8. Exibir vendas finalizadas");
        System.out.println("9. Sair");
        System.out.print("Escolha uma opção: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch(opcao) {
        case 1:
            loja.cadastrarCliente();
            break;
        case 2:
            loja.cadastrarProduto();
            break;
        case 3:
        	 loja.iniciarVenda();
        	break;
        case 4:
        	loja.adicionarProdutoAoCarrinho();
            break;
        case 5:
        	loja.exibirConteudoDoCarrinho();
        	break;
        case 6:
        	loja.fecharVenda();
        	break;
        case 7:
        	loja.exibirVendaEmAndamento();
        	break;
        case 8:
        	loja.exibirVendasFinalizadas();
        	break;
        case 9:
        	System.out.println("Saindo do sistema...");
            scanner.close();
            System.exit(0);
            break;
            
        default:
            System.out.println("Opção inválida!");
        	}
        }
	}
}
