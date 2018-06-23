package Code;

public class Main {

	public static void main(String[] args) {
		
		ArmazenamentoConquista arm = ArmazenamentoMemoriaConquista.getInstance();
		
		FabricaArmazenamentoConquista fabrica = new FabricaArmazenamentoConquista();
		
		fabrica.setArmazenamentoConquista(arm);
		
		ServicoForumGamificacaoProxy game = new ServicoForumGamificacaoProxy();
		
		game.adicionarComentario("Teste6", "T�pico de teste", "Comentario");
		game.darLikeComentario("Teste6", "T�pico de teste", "Comentario testoso", "Comentario usuario");

	}

}
