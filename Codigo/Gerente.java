// Felippe Machado Nunes de Oliveira    RA:2347946
import java.util.ArrayList;
import java.util.List;

public final class Gerente extends Usuario{
	
	private double salario = 20000.00;
	private String codigo;
	private List<Funcionario> func = new ArrayList<Funcionario>();
	

	public Gerente(String nome, String cpf, int idade, String codigo, String senha) {
		super(nome, cpf, idade);
		super.setSenha(senha);
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
	
	public void adicionarFuncionario(Funcionario f1) {
		func.add(f1);
	}
	
	//Sobrecarga
	public void login(String codigo, String senha) {
		if(this.codigo == codigo && getSenha() == senha) {
			setOnline(true);
		} else {
			System.out.println("\nCodigo ou senha incorretos\n");
		}
	}
		
	//Sobrescrita
	public String toString() {  
		return "\nNome: " + super.getNome() + "\tIdade: " + super.getIdade() + "\nCPF: " + super.getCpf() + "\nCodigo:" + this.getCodigo() ;
	}


}
