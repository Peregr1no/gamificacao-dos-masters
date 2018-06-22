package Code;

public abstract class Conquista {

		protected String nome;
		
		public boolean verificaTipoConquista(Conquista conquista) {
				return conquista instanceof Pontos;
		}
		
		public String getNome() {
			return this.nome;
		}
}
