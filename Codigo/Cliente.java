// Felippe Machado Nunes de Oliveira    RA:2347946
public class Cliente extends Usuario implements CompraIngresso{
	
	private Ingresso ingresso;

	
	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setI1(Ingresso i1) {
		this.ingresso = i1;
	}


	public Cliente(String nome, String cpf, int idade) {
		super(nome, cpf, idade);
	}
	
	public void compra(Sessao s1) {
		try {
			ingresso = new Ingresso(s1);
			System.out.println("\nCOMPRA REALIZADA COM SUCESSO\n");
		} catch(RuntimeException ex) {
			System.out.println("\nNAO FOI POSSIVEL REALIZAR A COMPRA\n");
		}
	}
	
	public String toString() {
		return "\nNome: " + super.getNome() + "\tIdade: " + super.getIdade() + "\nCPF: " + super.getCpf();
	}
	
	public void login(String entrada, String senha) {
		if(getCpf().equals(entrada) && getSenha().equals(senha)) {
			setOnline(true);
		} else {
			System.out.println("\nCPF OU SENHA INCORRETOS\n");
		}
	}

}
