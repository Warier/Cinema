import java.util.ArrayList;
import java.util.List;

// Felippe Machado Nunes de Oliveira    RA:2347946
public class Controle {
	
	private static Leitura ler = new Leitura();
	private static Gerente gerente;
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	public static List<Sala> salas = new ArrayList<Sala>();
	public static List<Filme> filmes = new ArrayList<Filme>();
	public static List<Sessao> sessoes = new ArrayList<Sessao>();
	private static boolean vai = true;
	

	public void criarGerente() {
		System.out.println("CADASTRAR GERENTE");
		while(vai) {
			try {
				gerente = new Gerente(ler.entDados("Digite o nome: "), ler.entDados("Digite o CPF: "), Integer.parseInt(ler.entDados("Digite a idade: ")),
						ler.entDados("Digite o codigo: "), ler.entDados("Digite a senha: "));
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Digite apenas numeros para a idade");
			}
		}
	}
	
	
	public void cadastrarFuncionario() {
		Funcionario func;
		System.out.println("CADASTRAR FUNCIONARIO");
		while(vai) {
			try {
				func = new Funcionario(ler.entDados("Digite o nome: "), ler.entDados("Digite o CPF: "), Integer.parseInt(ler.entDados("Digite a idade: ")),
						ler.entDados("Digite o codigo: "), ler.entDados("Digite a senha: "));
				funcionarios.add(func);
				gerente.adicionarFuncionario(func);
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Digite apenas numeros para a idade");
			}
		}
	}
	
	public void cadastrarCliente() {
		Cliente clien;
		System.out.println("CADASTRAR CLIENTE");
		while(vai) {
			try {
				clien = new Cliente(ler.entDados("Digite o nome: "), ler.entDados("Digite o CPF: "), Integer.parseInt(ler.entDados("Digite a idade: ")), ler.entDados("Digite a senha: "));
				clientes.add(clien);
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Digite apenas numeros para a idade");
			}
		}
	}
	
	public void listarFuncionarios() {
		System.out.println("Lista de funcionarios");
		for(int i = 0; i < funcionarios.size(); i++) {
			System.out.println("\nFUNCIONARIO " + (i + 1));
			System.out.println(funcionarios.get(i).toString());
		}
		System.out.println("\nNUMERO DE FUNCIONARIOS: "+ funcionarios.size() + "\n");
	}
	
	public Usuario entrar() {
		String entrada, senha;
		System.out.println("DIGITE O LOGIN E A SENHA PARA ENTRAR");
		while(vai) {
			entrada = ler.entDados("Digite o CPF ou o codigo: ");
			senha = ler.entDados("Digite a senha: ");
			if(gerente.getCodigo().equals(entrada) && gerente.getSenha().equals(senha)) {
				return gerente;
			}
			for(int i = 0; i < funcionarios.size(); i++) {
				if(funcionarios.get(i).getCodigo().equals(entrada) && funcionarios.get(i).getSenha().equals(senha)) {
					return funcionarios.get(i);
				}
			}
			for(int i = 0; i < clientes.size(); i++) {
				if(clientes.get(i).getCpf().equals(entrada) && clientes.get(i).getSenha().equals(senha)) {
					return clientes.get(i);
				}
			}
			System.out.println("LOGIN OU SENHA INCORRETOS\n");
			String continuar = ler.entDados("DESEJA CONTINUAR S - SIM  N - NAO");
			if(!continuar.equals("S")) {
				return null;
			}
		}
		return null;
	}
	
	public void menuInterno(Usuario u1) {
		int escolha = 0;
		while(vai) {
			System.out.println("\n\nMENU DE FUNCIONARIOS\n");
			System.out.println("1 - CADASTRAR FILME");
			System.out.println("2 - CRIAR NOVA SESSAO");
			System.out.println("3 - LISTAR SESSOES");
			System.out.println("4 - LISTAR CLIENTES");
			System.out.println("5 - CADASTRAR SALA");
			if(u1 instanceof Gerente) {
				System.out.println("6 - CADASTRAR FUNCIONARIO");
				System.out.println("7 - EDITAR SALARIO DE FUNCIONARIO");
				System.out.println("8 - LISTAR FUNCIONARIO");
			}
			System.out.println("0 - SAIR");
			try {
				escolha = Integer.parseInt(ler.entDados("DIGITE O NUMERO DA OPCAO DESEAJADA: "));
			} catch (NumberFormatException ex) {
				System.out.println("DIGITE APENAS UM NUMERO");
			}
			
			switch(escolha) {
			case 0:
				return;
			case 1:
				break;
			case 2:
				break;
			case 3:
				System.out.println("Lista de sessoes");
				for(int i = 0; i < sessoes.size(); i++) {
					System.out.println("\nSESSAO " + (i + 1));
					System.out.println(sessoes.get(i).toString());
				}
				System.out.println("\nNUMERO DE SESSOES: "+ sessoes.size() + "\n");
				break;
			case 4:
				System.out.println("Lista de clientes");
				for(int i = 0; i < clientes.size(); i++) {
					System.out.println("\nCLIENTE " + (i + 1));
					System.out.println(clientes.get(i).toString());
				}
				System.out.println("\nNUMERO DE CLIENTES: "+ clientes.size() + "\n");
				break;
			case 5:
				break;
			case 6:
				if(u1 instanceof Gerente) {
					cadastrarFuncionario();
				}
				break;
			case 7:
				if(u1 instanceof Gerente) {
					
				}
				break;
			case 8:
				if(u1 instanceof Gerente) {
					listarFuncionarios();
				}
				break;
			default:
				System.out.println("ESCOLHA APENAS UMA DAS OPCOES ACIMA");
			}
		}
		
	}
	
	public void menuVenda(Cliente u1) {
		int escolha = 0;
		while(vai) {
			System.out.println("\n\nMENU DE USUARIO\n");
			System.out.println("1 - MOSTRAR FILMES EM EXIBICAO");
			System.out.println("2 - COMPRAR INGRESSO");
			System.out.println("3 - LISTAR SESSOES");
			System.out.println("4 - EXIBIR INGRESSO");
			System.out.println("5 - INFORMACOES DE USUARIO");
			System.out.println("0 - SAIR");
			try {
				escolha = Integer.parseInt(ler.entDados("DIGITE O NUMERO DA OPCAO DESEAJADA: "));
			} catch (NumberFormatException ex) {			
				System.out.println("DIGITE APENAS UM NUMERO");
			}
			
			switch(escolha) {
			case 0:
				return;
			case 1:
				System.out.println("Lista de filmes");
				for(int i = 0; i < filmes.size(); i++) {
					System.out.println(filmes.get(i).toString());
					System.out.println("Lista de sessoes do filme");
					for(int j = 0; j < sessoes.size(); j++) {
						if(sessoes.get(j).getF1().equals(filmes.get(i))) {
							System.out.println("\nSESSAO " + (j + 1));
							System.out.println(sessoes.get(j).toString());
						}
					}
					System.out.println("\nNUMERO DE SESSOES: "+ sessoes.size() + "\n");
				}
				System.out.println("\nNUMERO DE FILMES EM CARTAZA: "+ filmes.size() + "\n");
				break;
			case 2:
				break;
			case 3:
				System.out.println("Lista de sessoes");
				for(int i = 0; i < sessoes.size(); i++) {
					System.out.println("\nSESSAO " + (i + 1));
					System.out.println(sessoes.get(i).toString());
				}
				System.out.println("\nNUMERO DE SESSOES: "+ sessoes.size() + "\n");
				break;
			case 4:
				if(u1.getIngresso() != null) {
					u1.getIngresso().toString();
				} else {
					System.out.println("\nNENHUM INGRESSO COMPRADO\n");
				}
				break;
			case 5:
				System.out.println("\nNome: " + u1.getNome() + "\tIdade: " + u1.getIdade() + "\nCPF: " + u1.getCpf());
				break;
			default:
				System.out.println("ESCOLHA APENAS UMA DAS OPCOES ACIMA");
			}
		}
		
	}
	
	
}
