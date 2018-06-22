package Code;

public class Main {

	public static void main(String[] args) {
		
		ArmazenamentoConquista arm = ArmazenamentoMemoriaConquista.getInstance();
		
		FabricaArmazenamentoConquista fabrica = new FabricaArmazenamentoConquista();
		
		fabrica.setArmazenamentoConquista(arm);
		
		ServicoForumGamificacaoProxy game = new ServicoForumGamificacaoProxy();
		
		game.adicionarTopico("Erik", "Meu topico");
		game.adicionarTopico("Erik", "Meu topico2");

	}

}
