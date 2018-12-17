import java.util.ArrayList;

public class Fornecedor extends Pessoa {

	private ArrayList<String> produto;

	public ArrayList<String> getProduto() {
		return produto;
	}

	private void setProduto(ArrayList<String> produto) {
		this.produto = produto;
	}
	
	public Fornecedor(String n, String t, String e, ArrayList<String> p) {
		setNome(n);
		setTelefone(t);
		setEndereco(e);
		setProduto(p);
	}
	
}
