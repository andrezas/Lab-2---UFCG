package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Representa a classe que realiza buscas avançadas a partir de um mapa de metadados.
 * 
 * @author Andreza Santana
 *
 */
public class BuscaAvancada implements Busca{
	
	/**
	 * Representa o mapa de metadados.
	 */
	private Map<String, String> metadados;
	
	/**
	 * Inicializa/ Constrói um objeto do tipo busca avançada.
	 * 
	 * @param metadados O mapa de metadados.
	 */
	public BuscaAvancada(Map<String, String> metadados) {
		(new ValidadorBusca()).valida(metadados);
		this.metadados = metadados; 
	}

	@Override
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for (Documento d : ds.busca(metadados)) {
			respostaDocumento.put(d, this.metadados.size());
		}
	
		return respostaDocumento;
	}

	@Override
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.metadados.size()][];
		int iterador = 0;
		for (String chave : metadados.keySet()) {
			String metadado = metadados.get(chave);
			resultado[iterador] = new String[] {"METADADO " + (iterador + 1), chave + ": " + metadado};
			iterador += 1;
		}
		return resultado;
	}

	
}
