public class SalaComum extends Sala{

	public SalaComum(int identificador, int numDeAssentos) {
		super(identificador, numDeAssentos);
	}

	public int getNumeroDeAssentos() {
		return super.numDeAssentos;
	}
	
	public double getPreco() {
		return super.preco;
	}
}
