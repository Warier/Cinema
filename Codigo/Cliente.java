// Felippe Machado Nunes de Oliveira    RA:2347946
public class Cliente extends Usuario implements CompraIngresso{
	
	private Ingresso ingresso = null;
	private boolean maiorDeIdade = false;

	
	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setI1(Ingresso i1) {
		this.ingresso = i1;
	}


	public Cliente(String nome, String cpf, int idade, String senha) {
		super(nome, cpf, idade);
		super.setSenha(senha);
		if(idade >=  18) {
			maiorDeIdade = true;
		}
	}
	
	public void compra(Sessao s1) {
		if(s1.getF1().getClassificacaoEtaria() >= 18 && !maiorDeIdade) {
			System.out.println("\nNAO FOI POSSIVEL REALIZAR A COMPRA\nSEM IDADE MINIMA PARA ENTRAR NA SESSAO ");
			return;
		}
		try {
			ingresso = new Ingresso(s1);
			System.out.println("\nCOMPRA REALIZADA COM SUCESSO\n");
		} catch(SessaoIndisponivelException ex) {
			System.out.println("\nNAO FOI POSSIVEL REALIZAR A COMPRA\n");
		}
	}
	
	//Sobrescrita
	public String toString() { 
		if(ingresso == null) {
			return  "\nNome: " + super.getNome() + "\tIdade: " + super.getIdade() + "\nCPF: " + super.getCpf();
		} else {
			return "\nNome: " + super.getNome() + "\tIdade: " + super.getIdade() + "\nCPF: " + super.getCpf() + "\nIngresso: " + ingresso.toString();
		}
	}
	
	//Sobrecarga
	public void login(String entrada, String senha) { 
		if(getCpf().equals(entrada) && getSenha().equals(senha)) {
			setOnline(true);
		} else {
			System.out.println("\nCPF OU SENHA INCORRETOS\n");
		}
	}

}
