public class SalaXD extends Sala{

	public SalaXD(int identificador, int numDeAssentos) {
		super(identificador, numDeAssentos);
	}

	public int getNumeroDeAssentos() {
		return super.numDeAssentos - 10;
	}

	public double getPreco() {
		return super.preco + 10;
	}

}
