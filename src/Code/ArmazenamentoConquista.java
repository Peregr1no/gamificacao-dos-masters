package Code;

import java.util.List;

public interface ArmazenamentoConquista {
	void addConquista(String usuario, Conquista conquista);
	List<Conquista> getConquistas(String usuario);
	Conquista getConquista(String usuario, String nomeConquista);
}
