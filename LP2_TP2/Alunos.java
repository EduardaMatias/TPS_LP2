package LP2_TP2;

import java.util.UUID;

public class Alunos {
	private String nome;
	private String endereco;
	private int idade;
	private UUID uuid;
	
	Alunos(String nome, String endereco, int idade, UUID uuid) {
		this.nome = nome;
		this.endereco = endereco;
		this.idade = idade;
		this.uuid = uuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Aluno: nome: " + this.nome + ", uuid: " + this.uuid + "";
	}	
}
