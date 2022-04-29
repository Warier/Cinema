// Felippe Machado Nunes de Oliveira    RA:2347946

public final class SalaVip extends Sala{

	public SalaVip(int identificador) {
		super(identificador);
	}

	public final int getNumeroDeAssentos() {
		return super.numDeAssentos - 25;
	}

	public double getPreco() {
		return 25;
	}

}
