// Felippe Machado Nunes de Oliveira    RA:2347946
public final class Filme {
	private String nome;
	private String descricao;
	private String categoria;
	private String trailer; // link para o trailer no Youtube
	private int duracaoEmMinutos;
	private int classificacaoEtaria;
	private int codigo;
	
	public Filme() {
		
	}

	public Filme(String nome) {
		this.nome = nome;
	}
	
	public Filme(int cod) {
		this.codigo = cod;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int cod) {
		this.codigo = cod;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getTrailer() {
		return trailer;
	}
	
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}
	
	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}
	
	public int getClassificacaoEtaria() {
		return classificacaoEtaria;
	}
	
	public void setClassificacaoEtaria(int classificacaoEtaria) {
		this.classificacaoEtaria = classificacaoEtaria;
	}
	
	public void impDados() {
		System.out.printf("%n%n \t%s %n%n", nome);
		System.out.printf("Categoria: %-5s  Duracao: %d Minutos  Classificacao etaria: %d Anos%n", categoria, duracaoEmMinutos, classificacaoEtaria);
		System.out.printf("Trailer: %s%n%n", trailer);
		System.out.printf("%s%n%n", descricao);
		
	}
	
}
