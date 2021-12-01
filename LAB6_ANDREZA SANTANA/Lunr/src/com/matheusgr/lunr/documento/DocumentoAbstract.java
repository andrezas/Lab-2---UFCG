package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.Map;

import biblitex.TransformaTexto;

/**
 * Representa uma classe abstrata de Documentos. Será utilizada para a criação de subtipos.
 * @author andre
 *
 */
public abstract class DocumentoAbstract implements Documento{
	
	protected String id;
	protected String original;
	protected String limpo;
	protected Map<String, String> metadados;
	protected String[] split;
	

	/**
	 * Constrói/ Inicializa o objeto.
	 * 
	 * @param id O id do documento
	 * @param original O texto original do documento
	 * @param limpo O texto do documento limpo
	 */
	public DocumentoAbstract(String id, String original) {
		this.id = id;
		this.original = original;
	}

	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public double metricaTextoUtil() {
		long extractedSize = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanSpaces, this.limpo)
				.length();
		return (1.0 * extractedSize) / this.original.length();
	}
	
	@Override
	public String[] getTexto() {
		if (this.split == null) {
			this.split = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanLines, this.limpo)
					.split(" ");
			Arrays.sort(this.split);
		}
		return this.split;
	}
	
	@Override
	public abstract Map<String, String> getMetadados();
	
	
}
