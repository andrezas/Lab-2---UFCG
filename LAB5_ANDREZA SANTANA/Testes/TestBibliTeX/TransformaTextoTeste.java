package TestBibliTeX;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTeX.TransformaTexto;
import BibliTeX.UpperCase;

class TransformaTextoTeste {

	TransformaTexto transformacao;
	
	@BeforeEach
	void instanciaTransformaTxt() {
		this.transformacao = new TransformaTexto();
	}
	
	@Test
	void testListaTransformacoes() {
		System.out.println(transformacao.listaTransformacoes());
	}
	
	@Test
	void testTransformaUpperCase() {
		assertEquals("OI, TUDO BEM?", this.transformacao.transforma("UpperCase", "oi, tudo bem?"));
	}
	
	@Test
	void testTransformaCaMeLcAsEfy() {
		assertEquals("Oi, TuDo bEm?", this.transformacao.transforma("CaMeLcAsEfY", "oi, tudo bem?"));
	}
	
	@Test
	void testTransformaClean() {
		assertEquals("Oi Tudo bem pessoa", this.transformacao.transforma("Clean", "Oi! Tudo bem, pessoa?"));
	}
	
	@Test
	void testTransformaCleanSpace() {
		assertEquals("oi,tudobem?", this.transformacao.transforma("CleanSpace", "oi, tudo bem?"));
	}
	
	@Test
	void testTransformaExclamacaoParaAsterisco() {
		assertEquals("oi* tudo bem**", this.transformacao.transforma("ExclamacaoParaAsterisco", "oi! tudo bem!!"));
	}
	
	@Test
	void testTransformaInterrogaPraPontos() {
		assertEquals("oi. tudo bem.", this.transformacao.transforma("InterrogaPraPontos", "oi? tudo bem?"));
	}
	
	
	@Test
	void testTransformaVazio() {
		try {
			this.transformacao.transforma("Clean", " ");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testTransformaNaoExiste() {
		try {
			this.transformacao.transforma("InterrogaPraExclamacao", "oi, tudo bem?");
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testTransformaNull() {
		try {
			this.transformacao.transforma("InterrogaPraPontos", null);
			fail("Era esperado um erro");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testListarOriginais() {
		this.transformacao.transforma("InterrogaPraPontos", "oi, tudo bem?");
		String resultadoEsperado = "oi, tudo bem?" + "\n";
		assertEquals(resultadoEsperado, this.transformacao.listarOriginais());
	}

	@Test
	void testCadastraTransformacao() {
		this.transformacao.cadastraTransformacao("UpperCase", new UpperCase());
		this.transformacao.listaTransformacoes();
	}
	
	@Test
	void testContaTransformacao() {
		this.transformacao.transforma("CleanSpace", "oi, tudo bem?");
		this.transformacao.transforma("Clean", "oi, tudo bem?");
		assertEquals("2", this.transformacao.contaTransformacao());
	}
	
	
	
	@Test
	void testHistorico() {
		this.transformacao.transforma("CleanSpace", "oi, tudo bem?");
		this.transformacao.transforma("ExclamacaoParaAsterisco", "oi! tudo bem!!");
		assertEquals("oi, tudo bem? -> CleanSpace -> oi,tudobem?", this.transformacao.historico(0));
	}
	
	
	
}
