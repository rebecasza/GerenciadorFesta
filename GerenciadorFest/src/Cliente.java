
public class Cliente extends Pessoa {
	
	private String dataCadastro;

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Cliente(String n, String t, String end, String d) {
		
		setNome(n);
		setTelefone(t);
		setEndereco(end);
		setDataCadastro(d);
		
	}

}
