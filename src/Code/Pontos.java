package Code;

public class Pontos extends Conquista {

	private int valor = 0;

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void increment(int incremento) {
		this.valor += incremento;
	}
	
}
