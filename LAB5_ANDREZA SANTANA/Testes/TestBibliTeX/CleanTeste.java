package TestBibliTeX;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import BibliTeX.Clean;

class CleanTeste {

	@Test
	void testTransforma() {
		Clean c = new Clean();
		System.out.println(c.transforma("Olá, mundo!"));
	}
	
	@Test
	void testTransforma2() {
		Clean c = new Clean();
		System.out.println(c.transforma("O,,l á m.un!d *o!"));
	}
	
	@Test
	void testTransformaEquals() {
		Clean c = new Clean();
		assertEquals("Olá Tudo bem Eu estou bem", c.transforma("Olá! Tudo bem? Eu estou bem."));
	}
	
	@Test
	void testTransformaNulo() {
		Clean c = new Clean();
		try {
			c.transforma(null);
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testTransformaVazio() {
		Clean c = new Clean();
		String texto = "";
		try {
			c.transforma(texto);
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testTransformaSoPontuacao() {
		Clean c = new Clean();
		System.out.println(c.transforma("?!?,"));
	}
}
