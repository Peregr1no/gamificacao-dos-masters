package Code;

public class ServicoForumGamificacaoProxy implements ServicoForum {

	@Override
	public void adicionarComentario(String usuario, String topico, String comentario) {
		incrementPontos(usuario, 3, TipoConquista.PARTICIPACAO);
		incrementInsignia(usuario, TipoConquista.MEUS_DOIS_CENTS);
	}

	@Override
	public void darLikeComentario(String usuario, String topico, String comentario, String comentarioUsuario) {
		incrementPontos(usuario, 1, TipoConquista.PARTICIPACAO);
	}

	public void adicionarTopico(String usuario, String topico) {
		incrementPontos(usuario, 5, TipoConquista.CRIACAO);
		incrementInsignia(usuario, TipoConquista.EU_FALO_SABIA);
	}

	public void darLikeTopico(String usuario, String topico, String topicoUsuario) {
		incrementPontos(usuario, 1, TipoConquista.CRIACAO);
	}

	private void incrementPontos(String usuario, int increment, TipoConquista tipoConquista) {
		if (FabricaArmazenamentoConquista.getArmazenamentoConquista().getConquista(usuario,
				tipoConquista.getNome()) == null) {
			Pontos pontos = new Pontos();
			pontos.nome = tipoConquista.getNome();
			pontos.increment(increment);
			FabricaArmazenamentoConquista.getArmazenamentoConquista().addConquista(usuario, pontos);
		} else {
			Conquista pontos = FabricaArmazenamentoConquista.getArmazenamentoConquista().getConquista(usuario,
					tipoConquista.getNome());
			((Pontos) pontos).increment(increment);
			FabricaArmazenamentoConquista.getArmazenamentoConquista().addConquista(usuario, pontos);
		}
	}

	private void incrementInsignia(String usuario, TipoConquista tipoConquista) {
		if (FabricaArmazenamentoConquista.getArmazenamentoConquista().getConquista(usuario,
				tipoConquista.getNome()) == null) {
			FabricaArmazenamentoConquista.getArmazenamentoConquista().addConquista(usuario,
					new Insignia(tipoConquista.getNome()));
		}
	}

}
