import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab3.Termometro;

class TermometroTest {

	private Termometro termometro;
	
	
	@Test
	void testMedicao() {
		this.termometro = new Termometro(31);
		assertTrue(this.termometro.medicao().equals("QUENTE"));
	}

}
