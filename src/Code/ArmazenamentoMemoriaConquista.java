package Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArmazenamentoMemoriaConquista implements ArmazenamentoConquista{

	private static ArmazenamentoConquista uniqueInstance;
	
	private static HashMap<String, List<Conquista>> armConquistaUsuario = new HashMap<>();
	
	private List<Conquista> manipulaConquistas = new ArrayList<>();
	
	public static synchronized ArmazenamentoConquista getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new ArmazenamentoMemoriaConquista();
		}
		return uniqueInstance;
	}
	
	private boolean checkExist(String usuario) {
		return armConquistaUsuario.containsKey(usuario);
	}
	
	public int getIndice(List<Conquista> listaConquista, String nomeConquista) {
		for(int i = 0; i < listaConquista.size(); i++) {
			if(listaConquista.get(i).tipo.equalsIgnoreCase(nomeConquista)) {
				return i;
			}
		}
		return 0;
	}
	
	@Override
	public void addConquista(String usuario, Conquista conquista) {
		if(checkExist(usuario)){
			manipulaConquistas = getConquistas(usuario);
			int indice = getIndice(manipulaConquistas, conquista.tipo);
			manipulaConquistas.add(indice, conquista);
			armConquistaUsuario.put(usuario, manipulaConquistas);
			System.out.println("Atualizei um usuario existente e sua conquista");
		}else {
			List<Conquista> novasConquistas = new ArrayList<>();
			novasConquistas.add(conquista);
			armConquistaUsuario.put(usuario, novasConquistas);
			System.out.println("Adicionei um novo usuario e sua conquista");
		}
	}
	
	@Override
	public List<Conquista> getConquistas(String usuario) {
		if(checkExist(usuario)) {
			return armConquistaUsuario.get(usuario);
		}
		
		List<Conquista> novaLista = new ArrayList<>();
		return novaLista;
	}
	
	@Override
	public Conquista getConquista(String usuario, String nomeConquista) {
		
		List<Conquista> listaGet = getConquistas(usuario);
		for(int i = 0; i < listaGet.size(); i++) {
			if(listaGet.get(i).tipo.equals(nomeConquista)) {
				return listaGet.get(i);
			}
		}
		return new Pontos();
	}
	
}