
public class Ingresso {
	
	private Sessao ss1;
	private double valorIngresso;

	public Ingresso(Sessao ss1) {
		this.ss1 = ss1;
		valorIngresso = ss1.valor();
		ss1.ocuparAssento(1);
	}
	
	public double getValorIngresso() {
		return this.valorIngresso;
	}
	
	public void setValorIngresso(double valorIngresso) {
		this.valorIngresso = valorIngresso;
	}
}
