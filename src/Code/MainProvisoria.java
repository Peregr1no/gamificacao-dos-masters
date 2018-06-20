package Code;

public class MainProvisoria {

	public static void main(String[] args) {
		
		ArmazenamentoConquista testeProvi = ArmazenamentoMemoriaConquista.getInstance();
		
		Pontos teste = new Pontos();
		teste.tipo = "Ola";
		
		testeProvi.addConquista("Teste", teste);
		testeProvi.addConquista("Teste", teste);
		
		ArmazenamentoConquista testeProvi2 = new ArmazenamentoMemoriaConquista();

		testeProvi2.addConquista("Teste", teste);
		testeProvi2.addConquista("Ola", teste);
		
	}

}
