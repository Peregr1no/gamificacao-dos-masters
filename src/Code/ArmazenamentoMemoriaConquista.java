package Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArmazenamentoMemoriaConquista implements ArmazenamentoConquista, ObservadorConquista {

	private static ArmazenamentoConquista uniqueInstance;

	private static HashMap<String, List<Conquista>> armConquistaUsuario = new HashMap<>();

	private List<Conquista> manipulaConquistas = new ArrayList<>();

	private static int naoPossuiConquista = -1;

	private ArmazenamentoMemoriaConquista() {
	}

	public static synchronized ArmazenamentoConquista getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ArmazenamentoMemoriaConquista();
		}
		return uniqueInstance;
	}

	private boolean checkExist(String usuario) {
		return armConquistaUsuario.containsKey(usuario);
	}

	public int getIndice(List<Conquista> listaConquista, String nomeConquista) {
		for (int i = 0; i < listaConquista.size(); i++) {
			if (listaConquista.get(i).nome.equalsIgnoreCase(nomeConquista)) {
				return i;
			}
		}
		return naoPossuiConquista;
	}

	@Override
	public void addConquista(String usuario, Conquista conquista) {
		if (checkExist(usuario)) {
			manipulaConquistas = getConquistas(usuario);
			int indice = getIndice(manipulaConquistas, conquista.nome);
			if (indice == naoPossuiConquista) {
				manipulaConquistas.add(conquista);
			} else {
				manipulaConquistas.set(indice, conquista);
			}
			armConquistaUsuario.put(usuario, manipulaConquistas);
		} else {
			manipulaConquistas.add(conquista);
			armConquistaUsuario.put(usuario, manipulaConquistas);
		}
		atualizarConquista(usuario, conquista);
	}

	@Override
	public List<Conquista> getConquistas(String usuario) {
		if (checkExist(usuario)) {
			return armConquistaUsuario.get(usuario);
		}

		List<Conquista> novaLista = new ArrayList<>();
		return novaLista;
	}

	@Override
	public Conquista getConquista(String usuario, String nomeConquista) {

		List<Conquista> listaGet = getConquistas(usuario);
		for (int i = 0; i < listaGet.size(); i++) {
			if (listaGet.get(i).nome.equals(nomeConquista)) {
				return listaGet.get(i);
			}
		}
		return null;
	}

	@Override
	public void atualizarConquista(String usuario, Conquista a) {
		if (a.verificaTipoConquista(a)) {
			if (((Pontos) a).getValor() >= 100) {
				if (getConquista(usuario, TipoConquista.INVENTOR.getNome()) == null
						&& (a.nome.equals(TipoConquista.CRIACAO.getNome()))) {
					addInsignia(usuario, TipoConquista.INVENTOR);

				} else if (getConquista(usuario, TipoConquista.MEMBRO_DA_COMUNIDADE.getNome()) == null
						&& a.nome.equals(TipoConquista.PARTICIPACAO.getNome())) {
					addInsignia(usuario, TipoConquista.MEMBRO_DA_COMUNIDADE);

				}
			}
			System.out.println("Você esta com: " + ((Pontos) a).getValor() + " pontos / " + a.nome);
		} else {
			System.out.println("Você ganhou a insignia: " + a.nome);
		}
	}

	private void addInsignia(String usuario, TipoConquista tipoConquista) {
		manipulaConquistas = getConquistas(usuario);
		manipulaConquistas.add(new Insignia(tipoConquista.getNome()));
		armConquistaUsuario.put(usuario, manipulaConquistas);
		System.out.println("Parabéns você se tornou " + tipoConquista.getNome());
	}

}
