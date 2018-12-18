
public class TemaLocado {
	
	private Tema tema;
	private String data;
	
	
	public TemaLocado(Tema tema, String data) {
		setTema(tema);
		setData(data);
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

}
