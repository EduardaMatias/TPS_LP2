package LP2_TP1;

public class LivroDeBiblioteca extends Livro implements ItemDeBiblioteca {
	   protected boolean emprestado;
	    protected String localizacao;

		public LivroDeBiblioteca(String titulo, String autor, String editora, short anoEdicao, String localizacao) {
			super(titulo, autor, editora, anoEdicao);
	        this.localizacao = localizacao;
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
	        this.emprestado = false;
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
	    public String getDados() {
	        String dados = super.getDados();
	        dados = dados + " Localiza��o: " + localizacao + "\n";
	        return dados;
	    }
}
