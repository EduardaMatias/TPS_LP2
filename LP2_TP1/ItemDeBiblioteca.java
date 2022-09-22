package LP2_TP1;

public interface ItemDeBiblioteca {

    static final int diasemprestimo = 7;

    public boolean getEmprestado();

    public String getLocalizacao();

    public void Empresta();

    public void Devolve();
}
