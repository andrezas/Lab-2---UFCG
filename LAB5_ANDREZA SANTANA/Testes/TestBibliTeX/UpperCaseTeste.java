package TestBibliTeX;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BibliTeX.UpperCase;

class UpperCaseTeste {

	@Test
	void testTransforma() {
		UpperCase u = new UpperCase();
		System.out.println(u.transforma("testE"));
	}

	@Test
	void testTransforma2() {
		UpperCase u = new UpperCase();
		assertEquals("OI, TUDO BEM?", u.transforma("oi, tudo bem?"));
	}
	
	@Test
	void testTransformaNull() {
		UpperCase u = new UpperCase();
		try {
			u.transforma(null);
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testTransformaVazio() {
		UpperCase u = new UpperCase();
		try {
			u.transforma("");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
