import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.Aluno;
import lab4.ControleAluno;
import lab4.Grupo;

class ControleTest {
	
	ControleAluno c = new ControleAluno();
	
	@BeforeEach
	void preparaAlunos() {
		Aluno a = new Aluno( "250", "Gabriel Reyes",  "Computação");
		Aluno b = new Aluno( "200", "Lili Camposh",  "Computação");
		Aluno c = new Aluno( "202", "Angela Ziegler",  "Medicina");
		Aluno d = new Aluno( "201", "Torbjorn Lindholm",  "Engenharia Mecânica");
	}
	
	
	@Test
	void testCadastraAluno() {
		this.c.cadastraAluno("123", "Ana", "CC");
	}

	@Test
	void testExibeAluno() {
		this.c.cadastraAluno("134", "Bia", "CC");
		assertEquals("Aluno: 134 - Bia - CC", this.c.exibeAluno("134"));
	}

	@Test
	void testCadastraGrupoSemRestricao() {
		this.c.cadastraGrupo("Programação OO", null);
	}

	@Test
	void testCadastraGrupoComRestricao() {
		this.c.cadastraGrupo("Listas", 2);
	}
	
	@Test
	void testCadastraGrupoJaExistente() {
		this.c.cadastraGrupo("Listas", 2);
		try {
			this.c.cadastraGrupo("Listas", null);
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testAlocaAlunoGrupo() {
		this.c.cadastraAluno("200", "Lili Camposh",  "Computação");
		this.c.cadastraAluno("202", "Angela Ziegler",  "Medicina");
		this.c.cadastraGrupo("Programação OO", null);
		this.c.alocaAlunoGrupo("200", "Programação OO");
		this.c.alocaAlunoGrupo("202", "Programação oo");
	}
	
	@Test
	void testAlocaAlunoJaAlocado() {
		this.c.cadastraAluno("200", "Lili Camposh",  "Computação");
		this.c.cadastraAluno("202", "Angela Ziegler",  "Medicina");
		this.c.cadastraGrupo("Programação OO", null);
		this.c.alocaAlunoGrupo("200", "Programação OO");
		this.c.alocaAlunoGrupo("202", "Programação oo");
		this.c.alocaAlunoGrupo("200", "programação oo");
	}
	
	@Test
	void testAlocaAlunoNaoExistente() {
		this.c.cadastraGrupo("Programação OO", null);
		try {
			this.c.alocaAlunoGrupo("100", "Programação OO");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testAlocaAlunoGrupoNaoExiste() {
		this.c.cadastraAluno("200", "Lili Camposh",  "Computação");
		try {
			this.c.alocaAlunoGrupo("200", "Anatomia");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testAlocaAlunoGrupoRestrito() {
		this.c.cadastraAluno("250", "Gabriel Reyes",  "Computação");
		this.c.cadastraAluno("202", "Angela Ziegler",  "Medicina");
		this.c.cadastraGrupo("listas", 1);
		this.c.alocaAlunoGrupo("250", "Listas");
		try {
			this.c.alocaAlunoGrupo("202", "listas");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	void testVerificaPertinenciaGrupo() {
		this.c.cadastraAluno("250", "Gabriel Reyes",  "Computação");
		this.c.cadastraAluno("202", "Angela Ziegler",  "Medicina");
		this.c.cadastraGrupo("listas", null);
		this.c.alocaAlunoGrupo("250", "Listas");
		assertEquals(true, this.c.verificaPertinenciaGrupo("LISTAS", "250"));
		assertEquals(false,this.c.verificaPertinenciaGrupo("listas", "202"));
		assertTrue(this.c.verificaPertinenciaGrupo("LISTAS", "250"));
		assertFalse(this.c.verificaPertinenciaGrupo("listas", "202"));
	}

	@Test
	void testVerificaPertinenciaGrupoNaoCadsatrado() {
		this.c.cadastraAluno("200", "Lili Camposh",  "Computação");
		try {
			this.c.verificaPertinenciaGrupo("Anatomia", "200");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testExibeGruposAlunoSemGrupo() {
		this.c.cadastraAluno("202", "Angela Ziegler",  "Medicina");
		assertEquals("GRUPOS:\n", this.c.checaGruposDoAluno("202"));
	}
	
	@Test
	void testExibeGruposAlunoComGrupo() {
		this.c.cadastraAluno("250", "Gabriel Reyes",  "Computação");
		this.c.cadastraGrupo("Programação OO", null);
		this.c.cadastraGrupo("Listas", null);
		this.c.alocaAlunoGrupo("250", "programação oo");
		this.c.alocaAlunoGrupo("250", "listas");
		this.c.checaGruposDoAluno("250");
	}
	

}
