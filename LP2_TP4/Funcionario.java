public class Funcionario {
	public int cod;
	private String nome;
	private double sal;
	private String cargo;
	
	public Funcionario(int cod, String nome, double sal, String cargo) {
		this.cod = cod;
		this.nome = nome;
		this.sal = sal;
		this.cargo = cargo;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
