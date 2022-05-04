// Felippe Machado Nunes de Oliveira    RA:2347946

public class TstSala {

	public static void main(String[] args) {
		
		Leitura l = new Leitura();
		System.out.println("CADASTAR FILME\n\n");
		Filme f1 = new Filme(l.entDados("Digite o titulo do filme: "));
		f1.setCategoria(l.entDados("Digite a categoria do filme: "));
		f1.setClassificacaoEtaria(Integer.parseInt(l.entDados("Digite a classsificacao do filme: ")));
		f1.setDuracaoEmMinutos(Integer.parseInt(l.entDados("Digite a duraçao em minutos do filme: ")));
		f1.setDescricao(l.entDados("Digite a descricao do filme: "));
		f1.setTrailer("");
		
		System.out.println("\n\tFilme cadastrado\n");
		f1.impDados();
		
		
		System.out.println("\n\tCADASTRAR SALA DE CINEMA\n");
		
		
		SalaVip s1 = new SalaVip(Integer.parseInt(l.entDados("Digite o numero de identificacao da sala: ")));

		System.out.println("Numero de assentos dessa sala: " + s1.getNumDeAssentos());
		
		
		System.out.println("\n\tCADASTAR SESSAO\n\n");

		
		Sessao ss1 = new Sessao(s1, f1, l.entDados("Digite a data e a hora da sessao: "), Integer.parseInt(l.entDados("Digite o preco base da sessao: ")));		
		System.out.println("\n\nValor do ingresso inteiro sessao: " + ss1.valor() + "\n\n");		
		ss1.ocuparAssento(24);
		System.out.println("Assentos ocupados na sessao: " + ss1.getAssentosOcupados() + "\n\n");
		
		
		System.out.println("\n\tCADASTAR CLIENTE\n");
		
		
		Cliente c1 = new Cliente(l.entDados("Digite o nome: "), l.entDados("Digite o CPF: "), Integer.parseInt(l.entDados("Digite a idade: ")));
		c1.setSenha(l.entDados("Digite a senha: "));
		
		System.out.println(c1.toString());
		
		
		System.out.println("\n\tTENTATIVA DE LOGIN\n");

		while(c1.getOnline() != true) {
			c1.login(l.entDados("Digite o CPF: "), l.entDados("Digite a senha: "));
		}
		
		System.out.println("\nTENTATIVA DE COMPRA 1\n");
		try {
			
			c1.compra(ss1);
			
		} catch(RuntimeException ex) {
			
		}finally {
			
			System.out.println("Valor do ingresso inteiro: " + c1.getIngresso().getValorIngresso() + "\n\n");
			System.out.println("Informaçoes do ingresso: " + c1.getIngresso().toString());
			System.out.println("Assentos ocupados na sessao: " + ss1.getAssentosOcupados() + "\n\n");
			
		}
		
		System.out.println("\nTENTATIVA DE COMPRA 2\n");
		try {
			c1.compra(ss1);
		} catch(RuntimeException ex) {
			
		}finally {
			
			System.out.println("Valor do ingresso inteiro: " + c1.getIngresso().getValorIngresso() + "\n\n");
			System.out.println("Informaçoes do ingresso: " + c1.getIngresso().toString());
			System.out.println("Assentos ocupados na sessao: " + ss1.getAssentosOcupados() + "\n\n");
			
		}
		
	}

}
