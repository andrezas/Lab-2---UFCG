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
		Aluno a = new Aluno( "250", "Gabriel Reyes",  "Computa��o");
		Aluno b = new Aluno( "200", "Lili Camposh",  "Computa��o");
		Aluno c = new Aluno( "202", "Angela Ziegler",  "Medicina");
		Aluno d = new Aluno( "201", "Torbjorn Lindholm",  "Engenharia Mec�nica");
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
		this.c.cadastraGrupo("Programa��o OO", null);
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
		this.c.cadastraAluno("200", "Lili Camposh",  "Computa��o");
		this.c.cadastraAluno("202", "Angela Ziegler",  "Medicina");
		this.c.cadastraGrupo("Programa��o OO", null);
		this.c.alocaAlunoGrupo("200", "Programa��o OO");
		this.c.alocaAlunoGrupo("202", "Programa��o oo");
	}
	
	@Test
	void testAlocaAlunoJaAlocado() {
		this.c.cadastraAluno("200", "Lili Camposh",  "Computa��o");
		this.c.cadastraAluno("202", "Angela Ziegler",  "Medicina");
		this.c.cadastraGrupo("Programa��o OO", null);
		this.c.alocaAlunoGrupo("200", "Programa��o OO");
		this.c.alocaAlunoGrupo("202", "Programa��o oo");
		this.c.alocaAlunoGrupo("200", "programa��o oo");
	}
	
	@Test
	void testAlocaAlunoNaoExistente() {
		this.c.cadastraGrupo("Programa��o OO", null);
		try {
			this.c.alocaAlunoGrupo("100", "Programa��o OO");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testAlocaAlunoGrupoNaoExiste() {
		this.c.cadastraAluno("200", "Lili Camposh",  "Computa��o");
		try {
			this.c.alocaAlunoGrupo("200", "Anatomia");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testAlocaAlunoGrupoRestrito() {
		this.c.cadastraAluno("250", "Gabriel Reyes",  "Computa��o");
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
		this.c.cadastraAluno("250", "Gabriel Reyes",  "Computa��o");
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
		this.c.cadastraAluno("200", "Lili Camposh",  "Computa��o");
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
		this.c.cadastraAluno("250", "Gabriel Reyes",  "Computa��o");
		this.c.cadastraGrupo("Programa��o OO", null);
		this.c.cadastraGrupo("Listas", null);
		this.c.alocaAlunoGrupo("250", "programa��o oo");
		this.c.alocaAlunoGrupo("250", "listas");
		this.c.checaGruposDoAluno("250");
	}
	

}
