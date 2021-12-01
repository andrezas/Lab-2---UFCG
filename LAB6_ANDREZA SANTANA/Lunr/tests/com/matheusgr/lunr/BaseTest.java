package com.matheusgr.lunr;

import org.junit.jupiter.api.BeforeEach;

import com.matheusgr.lunr.busca.BuscaController;
import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.similaridade.SimilaridadeController;

class BaseTest {

	public static final String TEXTO1_ID = "789";
	public static final String TEXTO2_ID = "ABC";
	public static final String TEXTO3_ID = "Teste1";
	public static final String TEXTO4_ID = "Teste2";
	public static final String TEXTO5_ID = "Teste3";
	public static final String TEXTO6_ID = "Teste3";
	public static final String JAVA_ID = "456";
	public static final String HTML_ID = "123";
	
	protected DocumentoController documentoController;
	protected BuscaController buscaController;
	protected SimilaridadeController similaridadeController;

	@BeforeEach
	void setUp() throws Exception {
		LunrApp lunrApp = new LunrApp();
		this.documentoController = lunrApp.getDocumentoController();
		this.buscaController = lunrApp.getBuscaController();
		this.similaridadeController = lunrApp.getSimilaridadeController();
		var exemplo = new DocumentoExemplos();
		this.documentoController.adicionaDocumentoHtml(HTML_ID, exemplo.sampleHTML());
		this.documentoController.adicionaDocumentoJava(JAVA_ID, exemplo.sampleJava());
		this.documentoController.adicionaDocumentoTxt(TEXTO1_ID, "um arquivo! texto simples.\r\nuse DUAS linhas apenas.");
		this.documentoController.adicionaDocumentoTxt(TEXTO2_ID, "um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r\nMAIS AVANÇO!");
		this.documentoController.adicionaDocumentoTxt(TEXTO3_ID, "Realizando o primeiro teste.");
		this.documentoController.adicionaDocumentoTxt(TEXTO4_ID, "Último laboratório de lp2.");
		this.documentoController.adicionaDocumentoTxt(TEXTO5_ID, "minha sanidade mental pede férias.");
		this.documentoController.adicionaDocumentoTxt(TEXTO6_ID, "minha sanidade mental pede férias.");
	}
	
}
