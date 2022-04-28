public class TstSala {

	public static void main(String[] args) {
		Filme f1 = new Filme("Doctor Strange in the Multiverse of Madnes");
		f1.setCategoria("Aventura");
		f1.setClassificacaoEtaria(14);
		f1.setTrailer("https://www.youtube.com/watch?v=X23XCFgdh2M");
		f1.setDuracaoEmMinutos(90);
		f1.setDescricao("Dr Stephen Strange casts a forbidden spell that opens a portal"
				+ " to the multiverse. However, a threat emerges that may be too big for his team to handle.");
		
		Sala s1 = new SalaVip( 30, 1);
		f1.impDados();
		Sessao ss1 = new Sessao(s1, f1, "22:00 23/05", 20);
		System.out.println("\n\nValor da sessao: " + ss1.valor());
		ss1.ocuparAssento(30);
		System.out.println(ss1.getAssentosOcupados());
		Ingresso i1 = new Ingresso(ss1);
		System.out.println("\n\nValor do ingresso: " + i1.getValorIngresso());
	}

}
