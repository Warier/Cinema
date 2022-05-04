// Felippe Machado Nunes de Oliveira    RA:2347946

public final class SalaVip extends Sala{

	public SalaVip(int identificador) {
		super(identificador);
	}

	public final int getNumDeAssentos() {
		return super.numDeAssentos - 25;
	}

	public final double getPreco() {
		return 25;
	}

}
