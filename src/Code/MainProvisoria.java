package Code;


public class MainProvisoria {

	public static void main(String[] args) {
		
		ArmazenamentoConquista arm = ArmazenamentoMemoriaConquista.getInstance();
		
		FabricaArmazenamentoConquista fabrica = new FabricaArmazenamentoConquista();
		
		fabrica.setArmazenamentoConquista(arm);
		
		ServicoForumGamificacaoProxy game = new ServicoForumGamificacaoProxy();
		
		game.adicionarComentario("Erik", "New Topic", "Aehue");
	
		game.adicionarTopico("Erik", "Meu topico");
		
		game.darLikeTopico("Erik", "Agora vai", "Nao sei");
		
	}

}
