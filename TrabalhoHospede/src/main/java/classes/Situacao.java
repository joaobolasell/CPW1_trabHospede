package classes;

public enum Situacao {
	
	VAGO("Vago", 1),
	OCUPADO("Ocupado", 2),
	MANUTENCAO("Em Manutencao", 3);
	

	private final String descricao;
		
	private final int id;

	Situacao(String descricao, int id){
		this.descricao = descricao;
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public int getId() {
		return id;
	}	
	

}
