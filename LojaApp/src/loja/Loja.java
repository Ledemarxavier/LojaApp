package loja;

import java.util.ArrayList;
import java.util.List;

import cliente.Cliente;
import produto.Produto;
import carrinhoDeCompras.CarrinhoDeCompras;

public class Loja {
	List<Cliente> clientes = new ArrayList<>();
	List<Produto> estoque = new ArrayList<>();
	List<CarrinhoDeCompras> vendasFinalizadas = new ArrayList<>();
}
