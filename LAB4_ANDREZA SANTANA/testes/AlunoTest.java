import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab4.Aluno;

class AlunoTest {

	private Aluno aluno;
	
	@Test
	void testAluno() {
		this.aluno = new Aluno("193", "Fulano", "CC");
	}
	
	@Test
	void testAlunoValorNulo() {
		try {
			this.aluno = new Aluno(null, "Fulano", "CC");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testAlunoValorVazio() {
		try {
			this.aluno = new Aluno("873", "Fulano", "");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
