package Code;

public abstract class Conquista {

		protected String tipo;
	
		public void verificaTipoConquista(Conquista conquista) {
		if(conquista.tipo.equalsIgnoreCase("PARTICIPACAO")) {
			this.tipo = "PARTICIPACAO";
		}else { 
			this.tipo = "CRIACAO";
		}
	}
	
}
