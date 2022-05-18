// Felippe Machado Nunes de Oliveira    RA:2347946
public class Sessao{

	private double precoBase;
	private int assentosOcupados = 0;
	private String dataHora;
	private Sala s1;
	private Filme f1;
	private int codigo;
	
	public Sessao() {
		
	}
	
	public Sessao(Sala s1, Filme f1, String dataHora, double precoBase) {
		this.s1 = s1;
		this.f1 = f1;
		this.dataHora = dataHora;
		this.precoBase = precoBase;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int cod) {
		this.codigo = cod;
	}
	
	public double getPrecoBase() {
		return precoBase;
	}
	
	public int getAssentosOcupados() {
		return assentosOcupados;
	}
	
	public String getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
	public Sala getS1() {
		return s1;
	}
	
	public void setS1(Sala s1) {
		this.s1 = s1;
	}
	
	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}

	public Filme getF1() {
		return f1;
	}
	
	public void setF1(Filme f1) {
		this.f1 = f1;
	}
	
	public double valor() {
		return (precoBase + s1.getPreco()) * 2;	
	}
	
	public void ocuparAssento(int vendido) throws SessaoIndisponivelException  {
		if(this.assentosOcupados + vendido <= this.s1.getNumDeAssentos()) {
			this.assentosOcupados += vendido;
		} else {
			System.out.printf("%n Os ingressos dessa sessao se esgotaram%n");
			throw new SessaoIndisponivelException();
		}
	}
	
	//Sobrescrita
	public String toString() {
		return "\nData e hora: "+ this.dataHora + "\nSala " + this.s1.getIdentificador() + "\tpreco: " + this.valor() + "\n" + "CODIGO DE SESSAO: " + this.codigo + "\n";
			
	}
}
