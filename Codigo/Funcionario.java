// Felippe Machado Nunes de Oliveira    RA:2347946
public class Funcionario extends Usuario{
	
	private double salario;
	private String codigo;
	
	public Funcionario(String nome, String cpf, int idade, String codigo) {
		super(nome, cpf, idade);
		this.codigo = codigo;
	}


	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void login(String codigo, String senha) {
		if(this.codigo == codigo && getSenha() == senha) {
			setOnline(true);
		} else {
			System.out.println("\nCodigo ou senha incorretos\n");
		}
	}

}
