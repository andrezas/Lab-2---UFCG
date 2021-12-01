package com.matheusgr.lunr.busca;

import java.util.Map;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Representa a interface que realiza as busca de documentos e a descrição de 
 * consultas realizadas.
 * 
 * @author Andreza Santana
 *
 */
public interface Busca {
	
	Map<Documento, Integer> busca(DocumentoService ds);
	
	 String[][] descreveConsulta();

}
