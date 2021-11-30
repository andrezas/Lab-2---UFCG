import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab3.Contato;

class ContatoTest {

	private Contato contatoBase;
	 
	@BeforeEach
	void preparaContatos() {
		this.contatoBase = new Contato("Matheus", "Gaudencio", "555-5551");
	}


	@Test
	void testContato() {
		new Contato("Matheus", "Gaudencio", "555-5551").equals(contatoBase);
	}

	@Test
	void testCadastraTagLimiteInferior() {
		this.contatoBase.cadastraTag("ccc", 1);
	}
		
	
	@Test
	void testCadastraTagLimiteSuperior() {
		this.contatoBase.cadastraTag("ccc", 5);
	}
	
	@Test
	void testCadastraTagAbaixoLimiteInferior() {
		try {
			this.contatoBase.cadastraTag("ccc", 0);
			fail("Era esperado um erro, pois a posição da tag está abaixo do limite superior");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testCadastraTagAcimaLimiteSuperior() {
		try {
			this.contatoBase.cadastraTag("ccc", 6);
			fail("Era esperado um erro, pois a posição da tag está acima do limite superior");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testEqualsObject() {
		Contato contato = new Contato("Andreza", "Santana", "276524534");
			assertFalse(this.contatoBase.equals(contato) && contato.equals(this.contatoBase));
			assertTrue(this.contatoBase.hashCode() != contato.hashCode());
//			
		
	}

	@Test
	void testhashCode() {
		Contato c1 = new Contato("Deza", "Santos", "0239783");
		Contato c2 = new Contato("Deza", "Santana", "0239783");
		assertFalse(c1.hashCode() == c2.hashCode());
	}
	

}
