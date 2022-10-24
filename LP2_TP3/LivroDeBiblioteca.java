package LP2_TP3;

public class LivroDeBiblioteca extends Livro implements ItemDeBiblioteca{
	protected boolean emprestado;
    protected String localizacao;
    protected String status;

	LivroDeBiblioteca(String titulo, String autor, String editora, short anoEdicao, String localizacao, String status) {
		super(titulo, autor, editora, anoEdicao);
        this.localizacao = localizacao;
        this.status = status;
	}
	
	public String getStatus() {
		if(this.emprestado == true) {
    		return "Emprestado";
    	} else {
    		return "Dispon�vel";
    	} 
	}

	@Override
    public void Empresta() {
    	if(this.emprestado == true) {
    		System.out.println("Este livro n�o est� dispon�vel.");
    	} else {
    		this.emprestado = true;
    		System.out.println("Dever� ser devolvido em " + diasemprestimo + " dias!\n");
    	}       
    }

    @Override
    public void Devolve() {
    	if(this.emprestado == true) {
    		this.emprestado = false;
    		System.out.println("Devolvido com sucesso.");
    	} else {
    		System.out.println("O livro j� foi devolvido");
    	} 
    }

    @Override
    public boolean getEmprestado() {
        return emprestado;
    }

    @Override
    public String getLocalizacao() {
        return localizacao;
    }

    @Override
    public String toString() {
        String dados = super.getDados();
        dados = dados + "Localiza��o: " + localizacao;
        return dados;
    }
}
