// Felippe Machado Nunes de Oliveira    RA:2347946

public class SalaComum extends Sala{

	public SalaComum(int identificador) {
		super(identificador);
	}

	public int getNumeroDeAssentos() {
		return super.numDeAssentos;
	}
	
	public double getPreco() {
		return 0;
	}
}
