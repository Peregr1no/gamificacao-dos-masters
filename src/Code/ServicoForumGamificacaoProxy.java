package Code;

public class ServicoForumGamificacaoProxy implements ServicoForum{
	
	@Override
	public void adicionarComentario(String usuario, String topico, String comentario) {
		
		if(FabricaArmazenamentoConquista.getArmazenamentoConquista().getConquista(usuario, "PARTICIPACAO") == null) {
			Pontos pontos = new Pontos();
			pontos.nome = "PARTICIPACAO";
			pontos.increment(3);
			FabricaArmazenamentoConquista.getArmazenamentoConquista().addConquista(usuario, pontos);
		}else {
			Conquista pontos = FabricaArmazenamentoConquista.getArmazenamentoConquista().getConquista(usuario, "PARTICIPACAO");
			((Pontos) pontos).increment(3);
			FabricaArmazenamentoConquista.getArmazenamentoConquista().addConquista(usuario, pontos);
		}
		
		if(FabricaArmazenamentoConquista.getArmazenamentoConquista().getConquista(usuario, "MEUS DOIS CENTS") == null) {
			Insignia addInsignia = new Insignia();
			addInsignia.nome = "MEUS DOIS CENTS";
			FabricaArmazenamentoConquista.getArmazenamentoConquista().addConquista(usuario, addInsignia);
		}
		
	}
	
	@Override
	public void darLikeComentario(String usuario, String topico, String comentario, String comentarioUsuario) {
		// TODO Auto-generated method stub
		
	}
	
	public void adicionarTopico(String usuario, String topico) {
		// TODO Auto-generated method stub
		
	}
	
	public void darLikeTopico(String usuario, String topico, String topicoUsuario) {
		// TODO Auto-generated method stub
		
	}
	
}
