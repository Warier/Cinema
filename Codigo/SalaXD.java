// Felippe Machado Nunes de Oliveira    RA:2347946

public final class SalaXD extends Sala{
	

	public SalaXD(int identificador) {
		super(identificador);
	}

	public final int getNumDeAssentos() {
		return super.numDeAssentos - 10;
	}

	public final double getPreco() {
		return 10;
	}

}
