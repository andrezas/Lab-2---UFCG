package TestBibliTeX;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import BibliTeX.CleanSpace;

class CleanSpaceTeste {

	@Test
	void testTransforma() {
		CleanSpace c = new CleanSpace();
		System.out.println(c.transforma("olá mundo"));
	}
	
	@Test
	void testTransformaNull() {
		CleanSpace c = new CleanSpace();
		try {
			c.transforma(null);
			fail("Era esperado um erro");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testTransformaEquals() {
		CleanSpace c = new CleanSpace();
		assertEquals("oi,comovcvai?", c.transforma("oi, como vc vai?"));
	}
	
	@Test
	void testTransformaVazio() {
		CleanSpace c = new CleanSpace();
		String texto = " ";
		try {
			c.transforma(texto);
			fail("Era esperado um erro");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
