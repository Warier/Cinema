public abstract class Sala {

	protected int numDeAssentos = 50;
	protected int identificador; 
	protected double preco = 0;
	
	public Sala(int identificador,int numDeAssentos) {
		this.identificador = identificador;
		this.numDeAssentos = numDeAssentos;
		
	}
	
	public abstract int getNumeroDeAssentos();
	
	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public abstract double getPreco();
	
}
