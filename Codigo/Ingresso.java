// Felippe Machado Nunes de Oliveira    RA:2347946
public class Ingresso {
	
	private Sessao ss1;
	private double valorIngresso;

	public Ingresso(Sessao ss1) throws SessaoIndisponivelException {
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
	
	public String toString() {
		return ss1.getF1().getNome() + "\nHora e data: " + ss1.getDataHora() + "\t Sala " + ss1.getS1().getIdentificador();
	}
}
