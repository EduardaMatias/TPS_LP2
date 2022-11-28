
public class Cargo {
	private int cod;
	private String cargo;
	
	public Cargo(int cod, String cargo) {
		this.cod = cod;
		this.cargo = cargo;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
