package Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import Code.*;

public class TesteAutomatizado {

	ServicoForumGamificacaoProxy forum = new ServicoForumGamificacaoProxy();
	
	@Test
	public void testeAdicionarTopico() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);
		
		forum.adicionarTopico("Teste", "Tópico de Teste");
		assertEquals("CRIACAO", testeArma.getConquista("Teste", "CRIACAO").getNome());
		assertEquals("EU FALO, SABIA?", testeArma.getConquista("Teste", "EU FALO, SABIA?").getNome());
	}
	
	@Test
	public void testeAdicionarComentario() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);
		
		forum.adicionarComentario("Teste2", "Tópico de teste", "Comentario");
		assertEquals("PARTICIPACAO", testeArma.getConquista("Teste2", "PARTICIPACAO").getNome());
		assertEquals("MEUS DOIS CENTS", testeArma.getConquista("Teste2", "MEUS DOIS CENTS").getNome());
	}
	
	@Test
	public void testeDarLikeTopico() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);
		
		forum.darLikeTopico("Teste3", "Tópico de teste", "Teste number 2");
		assertEquals("CRIACAO", testeArma.getConquista("Teste3", "CRIACAO").getNome());
	}
	
	@Test
	public void testeDarLikeComentario() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);
		
		forum.darLikeComentario("Teste4", "Tópico de teste", "Comentario testoso", "Comentario usuario");
		assertEquals("PARTICIPACAO", testeArma.getConquista("Teste4", "PARTICIPACAO").getNome());
	}
	
	@Test
	public void testeAdicionarTopicoTwoTimes() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);
		
		forum.adicionarTopico("Teste5", "Tópico de Teste");
		forum.adicionarTopico("Teste5", "Tópico de Teste2");
		assertEquals("CRIACAO", testeArma.getConquista("Teste5", "CRIACAO").getNome());
		assertEquals("EU FALO, SABIA?", testeArma.getConquista("Teste5", "EU FALO, SABIA?").getNome());
		// NA MAIN ELE RETORNA 10, AQUI ESTÁ RETORNANDO 7?????
		assertEquals(10, ((Pontos)testeArma.getConquista("Teste5", "CRIACAO")).getValor());
	}
	
	@Test
	public void testeVariosMuchosLoucos() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);
		
		forum.adicionarTopico("Teste6", "Tópico de Teste");
		forum.adicionarComentario("Teste6", "Tópico de teste", "Comentario");
		forum.darLikeComentario("Teste6", "Tópico de teste", "Comentario testoso", "Comentario usuario");
		forum.darLikeTopico("Teste6", "Tópico de teste", "Teste number 2");
		
		assertEquals("CRIACAO", testeArma.getConquista("Teste6", "CRIACAO").getNome());
		assertEquals("EU FALO, SABIA?", testeArma.getConquista("Teste6", "EU FALO, SABIA?").getNome());
		assertEquals("PARTICIPACAO", testeArma.getConquista("Teste6", "PARTICIPACAO").getNome());
		assertEquals("MEUS DOIS CENTS", testeArma.getConquista("Teste6", "MEUS DOIS CENTS").getNome());
		// NA MAIN ELE DA 4, AQUI RETORNA 5????
		assertEquals(4, ((Pontos)testeArma.getConquista("Teste6", "PARTICIPACAO")).getValor());
		// ESSE TESTE NA MAIN DA 6, MAS AQUI TA RETORNANDO 2, NAO SEI SE É POR CAUSA DA ORDEM QUE ELE EXECUTA OS TESTES
		assertEquals(6, ((Pontos)testeArma.getConquista("Teste6", "CRIACAO")).getValor());
	}
	
	@Test
	public void testeVerificar100PontosParticipacao() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);
		
		for(int i = 0; i < 20; i++) {
			forum.adicionarTopico("Teste7", "Teste numero 7");
		}
		
		assertEquals("INVENTOR",  testeArma.getConquista("Teste7", "INVENTOR").getNome());
	}
	
	@Test
	public void testeVerificar100PontosCriacao() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);
		
		for(int i = 0; i < 45; i++) {
			forum.adicionarComentario("Teste8", "Teste numero 8", "Aehp");
		}
		
		assertEquals("MEMBRO DA COMUNIDADE",  testeArma.getConquista("Teste8", "MEMBRO DA COMUNIDADE").getNome());
	}
	
	//FAZER ISSO AQUI LANÇAR UMA EXCEÇÃO E VERIFICAR SE A CONQUISTA NÃO FOI ADICIONADA - ELA NAO DEVE SER ADICIONADA
	@Test
	public void partiuLançarExcecao() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);
		
		try {
			forum.adicionarTopico("teste", "teste");
		}catch (Exception e) {
			assertNull(testeArma.getConquista("Teste9", "CRIACAO"));
		}
		
	}
	
}
