package TestBibliTeX;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BibliTeX.CaMeLcAsEfY;

class CaMeLcAsEfYTeste {

	@Test
	void testTransforma() {
		CaMeLcAsEfY c = new CaMeLcAsEfY();
		System.out.println(c.transforma("oi, como vc vai?"));
	}
	
	@Test
	void testTransformaEquals() {
		CaMeLcAsEfY c = new CaMeLcAsEfY();
		assertEquals("Ol¡", c.transforma("oL·"));
	}
	
	@Test
	void testTransformaTxtNull() {
		CaMeLcAsEfY c = new CaMeLcAsEfY();
		try {
			c.transforma(null);
			fail("Era esperado um erro");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
		@Test
		void testTransformaTxtVazio() {
			CaMeLcAsEfY c = new CaMeLcAsEfY();
			String txt = "";
			try {
				c.transforma(txt);
				fail("Era esperado um erro");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}

}
