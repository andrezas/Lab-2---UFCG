package BibliTeX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Representa a classe responsável por controlar as transformações de texto.
 * 
 * @author Andreza Santana
 *
 */
public class TransformaTexto {
	
	/**
	 * Representa um mapa de transformação, tendo como chave o nome da transformação.
	 */
	private Map<String, AlgoritmoTransformacao> transformacoes;
	
	/**
	 * Representa uma lista contendo o histórico de transformações.
	 */
	private List<String> historico;
	
	/**
	 * Representa um conjunto que armazena os textos originais, ou seja, aqueles que serão submetidos a uma transformação.
	 */
	private Set<String> txtOriginais;
	
	/**
	 * Atributo que realiza a contagem de transformações realizadas.
	 */
	private int contabilizaTransformacoes;
	
	/**
	 * Representa o tipo do logger.  
	 */
	private Logger logger;
	
	/**
	 * Constrói/Inicializa o controller, neste caso denominado "TransformaTexto".
	 */
	public TransformaTexto() {
		this.transformacoes = new HashMap<>();
		this.historico = new ArrayList<>();
		this.txtOriginais = new HashSet<>();
		this.contabilizaTransformacoes = 0;
		inicializaPadroes();
	}
	
	public TransformaTexto(Logger logger) {
		this.transformacoes = new HashMap<>();
		this.historico = new ArrayList<>();
		this.txtOriginais = new HashSet<>();
		this.contabilizaTransformacoes = 0;
		this.logger = logger;
		inicializaPadroes();
	}
	
	/**
	 * Transforma textos de acordo com a transformação passada.
	 * 
	 * @param transformacao O nome da transformação que deve ser realizada.
	 * @param texto O texto que deve ser transformado.
	 */
	public String transforma(String transformacao, String texto) {
		if (transformacao == null || texto == null) {
			throw new NullPointerException("DADO NULO!");
		} else if (transformacao.isBlank() || texto.isBlank()) {
			throw new IllegalArgumentException("DADO VAZIO!");
		}else if(transformacaoExiste(transformacao) == false) {
			throw new IllegalArgumentException("TRANSFORMAÇÃO NÃO CADASTRADA");
		}
		
		AlgoritmoTransformacao t = this.transformacoes.get(transformacao);
		
		this.contabilizaTransformacoes += 1;
		
		this.txtOriginais.add(texto);
		
		String novoHistorico = texto + " -> " + transformacao + " -> " + t.transforma(texto);
		this.historico.add(novoHistorico);
		
		if(logger != null) {
			return this.logger.registroLogger(transformacao, "transforma") + t.transforma(texto);
		}
		return t.transforma(texto);	
	}
	
	/**
	 * Retorna um histórico das transformações realizadas, exibindo o texto original, 
	 * a transformação aplicada e o resultado da transformação.
	 *
	 * @return A representação string do histórico de transformação. 
	 */
	public String historico(int index) {
		if (logger != null) {
			return logger.registroLogger(null, "historico") + index + "\n" + this.historico.get(index);
		}
		return this.historico.get(index);
	}
	
	/**
	 * Retorna o número de transformações realizadas.
	 * 
	 * @return um número inteiro representando a quantidade de transformações feitas.
	 */
	public String contaTransformacao() {
		if (logger != null) {
			return logger.registroLogger(null, "contaTransformacao") + this.contabilizaTransformacoes;
		}
		String numTransformacoes = String.valueOf(contabilizaTransformacoes);
		return numTransformacoes;
	}
	
	/**
	 * Retorna a listagem dos textos originais, ou seja, dos textos que foram submetidos a transformações.
	 * 
	 * @return A representação string dos textos originais, sem repetição.
	 */
	public String listarOriginais() {
		String resultado = "";
		for(String original : this.txtOriginais) {
			resultado += original + "\n";
		}
		return resultado;
	}
	
	/**
	 * Cadastra no mapa novas transformações.
	 * 
	 * @param nome O nome da transformação.
	 * @param transformacao A transformação que implementa a interface AlgoritmoTransformação.
	 */
	public void cadastraTransformacao(String nome, AlgoritmoTransformacao transformacao) {
		this.transformacoes.put(nome, transformacao);
	}
	
	/**
	 * Retorna a listagem das transformações textuais disponíveis em ordem alfabética.
	 *
	 * @return A representação string das transformações disponíveis de maneira ordenada. 
	 */
	public String listaTransformacoes() {
		List<String> listaAuxiliar = new ArrayList<>();
		
		for(AlgoritmoTransformacao transformacao : this.transformacoes.values()) {
			listaAuxiliar.add(transformacao.getNome());
		}
		
		Collections.sort(listaAuxiliar);
		String listagem = "";
		for (String nome : listaAuxiliar) {
			listagem += nome + "\n";
		}
		return listagem;
	}
	
	/**
	 * Método auxiliar que adiciona as transformações padrões + a transformação nova ao Mapa de transformações. 
	 */
	private void inicializaPadroes() {
		this.transformacoes.put("CaMeLcAsEfY",new CaMeLcAsEfY());
		this.transformacoes.put("Clean", new Clean());
		this.transformacoes.put("InterrogaPraPontos", new InterrogaPraPontos());
		this.transformacoes.put("UpperCase", new UpperCase());
		this.transformacoes.put("CleanSpace", new CleanSpace());
		this.transformacoes.put("ExclamacaoParaAsterisco", new ExclamacaoParaAsterisco());		
	}
	
	/**
	 * Método auxiliar que verifica a existencia de uma transformação no mapa de transformações.
	 * 
	 * @param transformacao O nome da transformação. 
	 * 
	 * @return true caso a transformação exista e caso contrário retorna false.
	 */
	private boolean transformacaoExiste(String transformacao) {
		if(this.transformacoes.containsKey(transformacao)) {
			return true;
		}
		return false;
	}
	
}
