package LP2_TP1;

public class Main {

	public static void main(String[] args) {
		LivroDeBiblioteca L1 = new LivroDeBiblioteca("Introdução à POO usando Java", "Prof. Rafael Santos", "Campus/SBC",
				(short)2003, "g11p17");
		L1.Empresta();
		L1.Empresta();
		L1.Devolve();
	}

}
