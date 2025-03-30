package cliente;

public class Cliente{
	String nome;
	String cpf;
	
	//Construtor
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	// Métodos getters
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
}