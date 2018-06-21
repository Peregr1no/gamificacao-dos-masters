package Code;

import java.util.List;

public class MainProvisoria {

	public static void main(String[] args) {
		
		ArmazenamentoConquista arm = ArmazenamentoMemoriaConquista.getInstance();
		
		FabricaArmazenamentoConquista fabrica = new FabricaArmazenamentoConquista();
		
		fabrica.setArmazenamentoConquista(arm);
		
		ServicoForumGamificacaoProxy game = new ServicoForumGamificacaoProxy();
		
		game.adicionarComentario("Erik", "New Topic", "Aehue");

		game.adicionarComentario("Erik", "New Topic", "Aehue");
		
		game.adicionarComentario("Erik", "New Topic", "Aehue");
		
		game.adicionarComentario("Erik", "New Topic", "Aehue");
		
		game.adicionarTopico("Erik", "Meu topico");
		
		game.darLikeComentario("Erik", "Nao sei", "Aehoo", "Leo");
		
		game.darLikeTopico("Erik", "Agora vai", "Nao sei");
		
		List<Conquista> listas = FabricaArmazenamentoConquista.getArmazenamentoConquista().getConquistas("Erik");
		
		for(int i = 0; i < listas.size(); i++) {
			if(listas.get(i) instanceof Pontos) {
				System.out.print(listas.get(i).nome + " - Pontos:");
				System.out.println(((Pontos )listas.get(i)).getValor());
			}else {
				System.out.println("Insignia: " + listas.get(i).nome);
			}
		}
		
	}

}
