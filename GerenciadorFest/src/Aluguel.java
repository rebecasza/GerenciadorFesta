
public class Aluguel {
	
	private Cliente cliente;
	private Tema tema;
	private Double precoFinal;
	private String data;
	private String horaInicio;
	private String horaFim;
	private String endereco;
	private int qtdPessoas;
	private boolean locacaoFinalizada;
	
	
	public Aluguel(Cliente c, Tema t, Double pF, String d, String hI, String hF, String e, int qP, boolean lF) {
		setCliente(c);
		setTema(t);
		setPrecoFinal(pF);
		setData(d);
		setHoraInicio(hI);
		setHoraFim(hF);
		setEndereco(e);
		setQtdPessoas(qP);
		setLocacaoFinalizada(lF);
	}
	
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Double getPrecoFinal() {
		return precoFinal;
	}
	public void setPrecoFinal(Double precoFinal) {
		this.precoFinal = precoFinal;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public int getQtdPessoas() {
		return qtdPessoas;
	}



	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}



	public boolean isLocacaoFinalizada() {
		return locacaoFinalizada;
	}



	public void setLocacaoFinalizada(boolean locacaoFinalizada) {
		this.locacaoFinalizada = locacaoFinalizada;
	}

}
