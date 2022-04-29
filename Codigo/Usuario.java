// Felippe Machado Nunes de Oliveira    RA:2347946

public abstract class Usuario {
	private String nome;
	private String cpf;
	private int idade;
	private String senha;
	private boolean online = false;
	

	public Usuario(String nome, String cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	
	
	public int getIdade() {
		return idade;
	}
	
	public boolean getOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	
	public void login(Usuario u1,String entrada, String senha) {
		if(u1 instanceof Cliente) {
			if(u1.getCpf() == entrada && u1.getSenha() == senha) {
				this.online = true;
			} else {
				System.out.println("\nCPF ou senha incorretos\n");
			}
		} else {
			Funcionario f1 = (Funcionario) u1;
			if(f1.getCodigo() == entrada && getSenha() == senha) {
				setOnline(true);
			} else {
				System.out.println("\nCodigo ou senha incorretos\n");
			}
		}
	}
	
	
}
