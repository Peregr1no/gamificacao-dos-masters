package Code;

public interface ServicoForum {
	void adicionarTopico(String usuario, String topico);
	void adicionarComentario(String usuario, String topico, String comentario);
	void darLikeTopico(String usuario, String topico, String topicoUsuario);
	void darLikeComentario(String usuario, String topico, String comentario, String comentarioUsuario);
}
