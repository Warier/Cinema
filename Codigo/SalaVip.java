public class SalaVip extends Sala{

	public SalaVip(int identificador, int numDeAssentos) {
		super(identificador, numDeAssentos);
	}

	public int getNumeroDeAssentos() {
		return super.numDeAssentos - 25;
	}

	public double getPreco() {
		return super.preco + 25;
	}

}
