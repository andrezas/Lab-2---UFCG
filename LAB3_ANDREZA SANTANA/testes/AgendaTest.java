import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab3.Agenda;

class AgendaTest {
	
	
	@Test
	void testCadastraContato() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(3, "deza", "santana", "123");
	}
	
	@Test
	void testCadastraContatoLimiteInferior() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(1, "deza", "santos", "123");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	void testCadastraContatoLimiteSuperior() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(100, "deza", "ss", "123");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	void testCadastraContatoAbaixoLimiteInferior() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(0, "andreza", "deza", "123");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testCadastraContatoAcimaLimiteInferior() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(100, "dreza", "deza", "123");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testAdicionaFavorito() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "maria", "luiza", "1234");
		agenda.adicionaFavorito(1, 1);
	}

	@Test
	void testAdicionaFavoritoPosicaoAbaixoLimite() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(1, "maria", "helena", "1234");
			agenda.adicionaFavorito(0, 2);
			fail("Era esperado um erro aqui");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	void testAdicionaFavoritoPosicaoAcimaLimite() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(1, "maria", "das gracas", "1234");
			agenda.adicionaFavorito(1, 1);
			fail("Era esperado um erro aqui");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	void testAdicionaTagPosicaoAcimaLimite() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(1, "maria", "clara", "12345");
			agenda.adicionaTag("1", "ccc", 6);
			fail("Era esperado um erro aqui");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	void testAdicionaTagPosicaoAbaixoLimite() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(1, "maria", "cecilia", "12345");
			agenda.adicionaTag("1", "ccc", 0);
			fail("Era esperado um erro aqui");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
