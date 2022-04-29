// Felippe Machado Nunes de Oliveira    RA:2347946

public class TstSala {

	public static void main(String[] args) {
		Filme f1 = new Filme("Doctor Strange in the Multiverse of Madnes");
		f1.setCategoria("Aventura");
		f1.setClassificacaoEtaria(14);
		f1.setTrailer("https://www.youtube.com/watch?v=X23XCFgdh2M");
		f1.setDuracaoEmMinutos(90);
		f1.setDescricao("Dr Stephen Strange casts a forbidden spell that opens a portal"
				+ " to the multiverse. However, a threat emerges that may be too big for his team to handle.");
		f1.impDados();
		
		Sala s1 = new SalaVip(1);
		
		System.out.println("Numero de assentos da sala vip: " + s1.getNumDeAssentos());

		Sessao ss1 = new Sessao(s1, f1, "22:00 23/05", 20);
		
		System.out.println("\n\nValor da sessao: " + ss1.valor() + "\n\n");
		
		ss1.ocuparAssento(24);
		System.out.println("Assentos ocupados na sessao: " + ss1.getAssentosOcupados() + "\n\n");
		
		
		Cliente c1 = new Cliente("Joao", "0000", 25);
		c1.setSenha("abcde");
		
		System.out.println("\nTENTATIVA DE COMPRA 1\n");
		try {
			c1.compra(ss1);
			System.out.println("Valor do ingresso: " + c1.getIngresso().getValorIngresso() + "\n\n");
			System.out.println("Informaçoes do ingresso: " + c1.getIngresso().toString());
		} catch(RuntimeException ex) {}
		
		System.out.println("\nTENTATIVA DE COMPRA 2\n");
		try {
			c1.compra(ss1);
		} catch(RuntimeException ex) {}
		
		
		
		Funcionario f2 = new Funcionario("OutroJoao", "1111", 18, "20003");
		f2.setSenha("abcde");
		f2.setSalario(2000);
		
		System.out.println("Tentantiva login 1:");
		f2.login(f2, "20002", "abcde");
		System.out.println(f2.getOnline());
		
		f2.login(f2, "20003", "abcde");
		System.out.println("Tentantiva login 2:" +f2.getOnline());
	}

}
