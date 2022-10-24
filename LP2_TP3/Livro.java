package LP2_TP3;

public class Livro {
	private String titulo, autor, editora;
	private short anoedicao;

	public Livro(String titulo, String autor, String editora, short anoedicao) {
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.anoedicao = anoedicao;
	}

	public Livro() {
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setAnoEdicao(short anoedicao) {
		this.anoedicao = anoedicao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditora() {
		return editora;
	}

	public short getAnoEdicao() {
		return anoedicao;
	}

	public String getDados() {
		String dados = "Título: " + this.getTitulo() + "\n" + "Autor: " + this.getAutor() + "\n" + "Editora: "
				+ this.getEditora() + "\n" + "Ano: " + this.getAnoEdicao() + "\n";
		return dados;
	}
}
