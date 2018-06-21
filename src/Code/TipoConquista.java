package Code;

public enum TipoConquista {
	PARTICIPACAO("PARTICIPACAO"), MEUS_DOIS_CENTS("MEUS DOIS CENTS"), CRIACAO("CRIACAO"), EU_FALO_SABIA(
			"EU FALO SABIA?"), INVENTOR("INVETOR"), MEMBRO_DA_COMUNIDADE("MEMBRO DA COMUNIDADE");

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private TipoConquista(String nome) {
		this.nome = nome;
	}

}
