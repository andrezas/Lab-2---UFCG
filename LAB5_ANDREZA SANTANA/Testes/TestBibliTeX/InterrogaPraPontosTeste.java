package TestBibliTeX;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BibliTeX.InterrogaPraPontos;

class InterrogaPraPontosTeste {

	@Test
	void testTransforma() {
		InterrogaPraPontos i = new InterrogaPraPontos(); 
		System.out.println(i.transforma("Tudo bem?"));
	}
	
	@Test
	void testTransformaEquals() {
		InterrogaPraPontos i = new InterrogaPraPontos(); 
		assertEquals(".##!...", i.transforma("?##!..?"));
	}
	
	@Test
	void testTransformaNull() {
		InterrogaPraPontos i = new InterrogaPraPontos(); 
		try {
			i.transforma(null);
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testTransformaVazio() {
		InterrogaPraPontos i = new InterrogaPraPontos(); 
		try {
			i.transforma(" ");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
