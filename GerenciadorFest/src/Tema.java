import java.util.ArrayList;

public class Tema {
	
	private String nome;
	private ArrayList<String> itens;
	private String corToalha;
	private ArrayList<Fornecedor> fornecedor;
	private int preco;
	
	public Tema(String n, ArrayList<String> i, String cT, ArrayList<Fornecedor> f, int p) {
		setNome(n);
		setItens(i);
		setCorToalha(cT);
		setFornecedor(f);
		setPreco(p);
	}
	public ArrayList<String> getItens() {
		return itens;
	}
	public void setItens(ArrayList<String> itens) {
		this.itens = itens;
	}
	public String getCorToalha() {
		return corToalha;
	}
	public void setCorToalha(String corToalha) {
		this.corToalha = corToalha;
	}
	public ArrayList<Fornecedor> getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(ArrayList<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
