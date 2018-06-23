package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import Code.*;

public class TesteAutomatizado {

	ServicoForum forum = new ServicoForumGamificacaoProxy();

	@Test
	public void testeAdicionarTopico() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		forum.adicionarTopico("Teste", "T�pico de Teste");
		assertEquals("CRIACAO", testeArma.getConquista("Teste", "CRIACAO").getNome());
		assertEquals("EU FALO, SABIA?", testeArma.getConquista("Teste", "EU FALO, SABIA?").getNome());
	}

	@Test
	public void testeAdicionarComentario() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		forum.adicionarComentario("Teste2", "T�pico de teste2", "Comentario2");
		assertEquals("PARTICIPACAO", testeArma.getConquista("Teste2", "PARTICIPACAO").getNome());
		assertEquals("MEUS DOIS CENTS", testeArma.getConquista("Teste2", "MEUS DOIS CENTS").getNome());
	}

	@Test
	public void testeDarLikeTopico() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		forum.darLikeTopico("Teste3", "T�pico de teste3", "Teste number 3");
		assertEquals("CRIACAO", testeArma.getConquista("Teste3", "CRIACAO").getNome());
	}

	@Test
	public void testeDarLikeComentario() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		forum.darLikeComentario("Teste4", "T�pico de teste4", "Comentario testoso4", "Comentario usuario4");
		assertEquals("PARTICIPACAO", testeArma.getConquista("Teste4", "PARTICIPACAO").getNome());
	}

	@Test
	public void testeAdicionarTopicoTwoTimes() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		forum.adicionarTopico("Teste5", "T�pico de Teste5");
		forum.adicionarTopico("Teste5", "T�pico de Teste5");
		assertEquals("CRIACAO", testeArma.getConquista("Teste5", "CRIACAO").getNome());
		assertEquals("EU FALO, SABIA?", testeArma.getConquista("Teste5", "EU FALO, SABIA?").getNome());
		// NA MAIN ELE RETORNA 10, AQUI EST� RETORNANDO 7?????
		assertEquals(10, ((Pontos) testeArma.getConquista("Teste5", "CRIACAO")).getValor());
	}

	@Test
	public void testeTopicos() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		forum.adicionarTopico("Teste6", "T�pico de Teste6");
		forum.darLikeTopico("Teste6", "T�pico de teste6", "Teste number 6");

		assertEquals("CRIACAO", testeArma.getConquista("Teste6", "CRIACAO").getNome());
		assertEquals("EU FALO, SABIA?", testeArma.getConquista("Teste6", "EU FALO, SABIA?").getNome());
		assertEquals(6, ((Pontos) testeArma.getConquista("Teste6", "CRIACAO")).getValor());
	}

	@Test
	public void testeComentario() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		forum.adicionarComentario("Teste7", "T�pico de teste7", "Comentario7");
		forum.darLikeComentario("Teste7", "T�pico de teste7", "Comentario testoso7", "Comentario usuario7");

		assertEquals("PARTICIPACAO", testeArma.getConquista("Teste7", "PARTICIPACAO").getNome());
		assertEquals("MEUS DOIS CENTS", testeArma.getConquista("Teste7", "MEUS DOIS CENTS").getNome());
		assertEquals(4, ((Pontos) testeArma.getConquista("Teste7", "PARTICIPACAO")).getValor());

	}

	@Test
	public void testeVerificar100PontosParticipacao() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		for (int i = 0; i < 20; i++) {
			forum.adicionarTopico("Teste8", "Teste numero 8");
		}

		assertEquals("INVENTOR", testeArma.getConquista("Teste8", "INVENTOR").getNome());
	}

	@Test
	public void testeVerificar100PontosCriacao() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		for (int i = 0; i < 45; i++) {
			forum.adicionarComentario("Teste9", "Teste numero 9", "Aehp");
		}

		assertEquals("MEMBRO DA COMUNIDADE", testeArma.getConquista("Teste9", "MEMBRO DA COMUNIDADE").getNome());
	}

	@Test
	public void partiuLancarExcecao() {
		FabricaArmazenamentoConquista fabric = new FabricaArmazenamentoConquista();
		ArmazenamentoConquista testeArma = ArmazenamentoMemoriaConquista.getInstance();
		fabric.setArmazenamentoConquista(testeArma);

		try {
			forum.adicionarTopico("teste", "teste");
		} catch (Exception e) {
			assertNull(testeArma.getConquista("Teste9", "CRIACAO"));
		}

	}

}
