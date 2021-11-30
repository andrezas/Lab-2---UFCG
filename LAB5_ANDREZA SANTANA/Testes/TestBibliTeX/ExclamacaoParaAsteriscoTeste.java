package TestBibliTeX;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BibliTeX.ExclamacaoParaAsterisco;

class ExclamacaoParaAsteriscoTeste {

	@Test
	void testTransforma() {
		ExclamacaoParaAsterisco e = new ExclamacaoParaAsterisco(); 
		System.out.println(e.transforma("Exclamação ! para ! asterisco!"));
	}
	
	@Test
	void testTransforma2() {
		ExclamacaoParaAsterisco e = new ExclamacaoParaAsterisco(); 
		System.out.println(e.transforma("!    ! *"));
	}
	
	@Test
	void testTransformaEquals() {
		ExclamacaoParaAsterisco e = new ExclamacaoParaAsterisco(); 
		assertEquals("(*) -> (*)", e.transforma("(!) -> (!)"));
	}
	
	@Test
	void testTransformaNull() {
		ExclamacaoParaAsterisco ea = new ExclamacaoParaAsterisco(); 
		System.out.println(ea.transforma("t!e!s!t!e"));
		try {
			ea.transforma(null);
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	@Test
	void testTransformaVazio() {
		ExclamacaoParaAsterisco ea = new ExclamacaoParaAsterisco(); 
		String t2 = "    ";
		try {
			ea.transforma(t2);
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
