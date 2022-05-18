// Felippe Machado Nunes de Oliveira    RA:2347946

public class Principal {

	public static void main(String[] args) {
		
		Leitura l = new Leitura();
		Controle cl = new Controle();
		boolean vai = true;
		int escolha = 4;
		


		
		cl.criarGerente();
		while(vai){
			System.out.println("1 - CRIAR CONTA");
			System.out.println("2 - ENTRAR NA CONTA");
			System.out.println("0 - SAIR");
			try {
				escolha = Integer.parseInt(l.entDados("DIGITE O NUMERO DA OPCAO DESEAJADA: "));
			} catch (NumberFormatException ex) {
				System.out.println("DIGITE APENAS UM NUMERO");
			}
			switch(escolha) {
			default:
				System.out.println("DIGITE APENAS UMA DAS OPCOES ACIMA");
				break;
			case 0:
				return;
			case 1:
				cl.cadastrarCliente();
				break;
			case 2:
				Usuario u1 = cl.entrar();
				if(u1 instanceof Cliente) {
					cl.menuVenda((Cliente)u1);
				} else if(u1 instanceof Funcionario || u1 instanceof Gerente) {
					cl.menuInterno(u1);
				} else if(u1 == null){
					break;
				}
			}
		}
	}

}
