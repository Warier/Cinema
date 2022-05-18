// Felippe Machado Nunes de Oliveira    RA:2347946
import java.util.ArrayList;
import java.util.List;

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
	
	public void cadastrarFilme() {
		Filme f1;
		System.out.println("\nCADASTRAR FILME\n");
		while(vai) {
			f1 = new Filme();
			f1.setNome(ler.entDados("Digite o nome do filme: "));
			f1.setCategoria(ler.entDados("Digite a categoria do filme: "));
			f1.setDescricao(ler.entDados("Digite uma descricao para o filme: "));
			try {
				f1.setCodigo(Integer.parseInt(ler.entDados("Digite um codigo de identificacao para o filme: ")));
				f1.setClassificacaoEtaria(Integer.parseInt(ler.entDados("Digite a classificacao etaria do filme: ")));
				f1.setDuracaoEmMinutos(Integer.parseInt(ler.entDados("Digite a duracao do filme em minutos: ")));
				filmes.add(f1);
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Digite apenas numeros");
			}
		}
	}
	
	public void cadastrarSessao() {
		Sessao s1;
		System.out.println("\nCADASTRAR SESSAO\n");
		while(vai) {
			s1 = new Sessao();
			try {
				while(s1.getF1() == null) {
					int cod = Integer.parseInt(ler.entDados("Digite o codigo do Filme que deseja atribuir a sessao: "));
					for(int i = 0; i < filmes.size(); i++) {
						if(filmes.get(i).getCodigo() == cod) {
							s1.setF1(filmes.get(i));
							break;
						}
					}
					if(s1.getF1() == null) {
						System.out.println("Codigo de filme nao encontrado");
						return;
					} else {
						break;
					}
				}
			} catch (NumberFormatException ex) {
				System.out.println("Digite apenas numeros para o codigo");
			}
			try {
				while(s1.getS1() == null) {
					int cod = Integer.parseInt(ler.entDados("Digite o identificador da sala que deseja atribuir a sessao: "));
					for(int i = 0; i < salas.size(); i++) {
						if(salas.get(i).getIdentificador() == cod) {
							s1.setS1(salas.get(i));
							break;
						}
					}
					if(s1.getS1() == null) {
						System.out.println("identificador de sala nao encontrado");
						return;
					} else {
						break;
					}
				}
			} catch (NumberFormatException ex) {
				System.out.println("Digite apenas numeros para o codigo");
			}
			s1.setDataHora(ler.entDados("Digite a data e a hora da sessao:"));
			while(vai) {
				try {
					s1.setPrecoBase(Double.parseDouble(ler.entDados("Digite o preco base para essa sessao: ")));
					s1.setCodigo(Integer.parseInt(ler.entDados("Digite um codigo para a sessao: ")));
					sessoes.add(s1);
					break;
				} catch (NumberFormatException ex) {
					System.out.println("Digite apenas numeros");
				}
			}
			break;
		}
	}
	
	public void cadastrarSala() {
		Sala s1;
		System.out.println("\nCADASTRAR SALA\n");
		while(vai) {			
			try {
				s1 = new SalaComum(Integer.parseInt(ler.entDados("Digite um identificador para sala: ")));
				salas.add(s1);
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Digite apenas numeros");
			}
		}
	}
	
	public void editarSalario() {
		String cod = ler.entDados("Digite o codigo do funcionario: ");
		boolean encontrado = false;		
		for(int i = 0; i< funcionarios.size(); i++) {
			if(funcionarios.get(i).getCodigo().equals(cod)) {
				while(vai) {			
					try {
						funcionarios.get(i).setSalario(Double.parseDouble(ler.entDados("Digite o novo salario: ")));
						encontrado = true;
						break;
					} catch (NumberFormatException ex) {
						System.out.println("Digite apenas numeros");
					}
				}
				break;
			}
		}
		if(encontrado) {
			return;
		} else {
			System.out.println("\nFUNCIONARIO NAO ENCONTRADO NO SISTEMA\n");
		}
		
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
				cadastrarFilme();
				break;
			case 2:
				cadastrarSessao();
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
				cadastrarSala();
				break;
			case 6:
				if(u1 instanceof Gerente) {
					cadastrarFuncionario();
				}
				break;
			case 7:
				if(u1 instanceof Gerente) {
					editarSalario();
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
					filmes.get(i).impDados();
					System.out.println("Lista de sessoes do filme");
					for(int j = 0; j < sessoes.size(); j++) {
						if(sessoes.get(j).getF1().equals(filmes.get(i))) {
							System.out.println("\nSESSAO " + (j + 1));
							System.out.println(sessoes.get(j).toString());
						}
					}
				}
				System.out.println("\nNUMERO DE FILMES EM CARTAZA: "+ filmes.size() + "\n");
				break;
			case 2:
				int cod = -1;
				boolean encontrado = false;	
				while(vai) {			
					try {
						cod = Integer.parseInt(ler.entDados("Digite o codigo da sessao: "));
						break;
					} catch (NumberFormatException ex) {
						System.out.println("Digite apenas numeros");
					}
				}
				for(int i = 0; i< sessoes.size(); i++) {
					if(sessoes.get(i).getCodigo() == cod) {
						u1.compra(sessoes.get(i));
						System.out.println("ULTIMO INGRESSO COMPRADO");
						encontrado = true;
					}
				}
				if(encontrado) {
					System.out.println(u1.getIngresso().toString());
				} else {
					System.out.println("\nSESSAO NAO ENCONTRADO NO SISTEMA\n");
				}
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
					System.out.println(u1.getIngresso().toString());
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
