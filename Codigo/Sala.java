// Felippe Machado Nunes de Oliveira    RA:2347946

public abstract class Sala {

	protected int numDeAssentos = 50;
	private int identificador;
	
	public Sala(int identificador) {
		this.identificador = identificador;

		
	}
	
	public abstract int getNumDeAssentos();
	
	public final int getIdentificador() {
		return identificador;
	}

	public final void setNumDeAssentos(int numDeAssentos) {
		this.numDeAssentos = numDeAssentos;
	}

	public final void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public abstract double getPreco();
	
	//Sobrescrita
	public String toString() {
		return "SALA " + this.identificador + "\nNumero de assentos: " + getNumDeAssentos() + "\n";
		
	}
	
}
