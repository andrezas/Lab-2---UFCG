package BibliTeX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Representa a classe respons�vel por controlar as transforma��es de texto.
 * 
 * @author Andreza Santana
 *
 */
public class TransformaTexto {
	
	/**
	 * Representa um mapa de transforma��o, tendo como chave o nome da transforma��o.
	 */
	private Map<String, AlgoritmoTransformacao> transformacoes;
	
	/**
	 * Representa uma lista contendo o hist�rico de transforma��es.
	 */
	private List<String> historico;
	
	/**
	 * Representa um conjunto que armazena os textos originais, ou seja, aqueles que ser�o submetidos a uma transforma��o.
	 */
	private Set<String> txtOriginais;
	
	/**
	 * Atributo que realiza a contagem de transforma��es realizadas.
	 */
	private int contabilizaTransformacoes;
	
	/**
	 * Representa o tipo do logger.  
	 */
	private Logger logger;
	
	/**
	 * Constr�i/Inicializa o controller, neste caso denominado "TransformaTexto".
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
	 * Transforma textos de acordo com a transforma��o passada.
	 * 
	 * @param transformacao O nome da transforma��o que deve ser realizada.
	 * @param texto O texto que deve ser transformado.
	 */
	public String transforma(String transformacao, String texto) {
		if (transformacao == null || texto == null) {
			throw new NullPointerException("DADO NULO!");
		} else if (transformacao.isBlank() || texto.isBlank()) {
			throw new IllegalArgumentException("DADO VAZIO!");
		}else if(transformacaoExiste(transformacao) == false) {
			throw new IllegalArgumentException("TRANSFORMA��O N�O CADASTRADA");
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
	 * Retorna um hist�rico das transforma��es realizadas, exibindo o texto original, 
	 * a transforma��o aplicada e o resultado da transforma��o.
	 *
	 * @return A representa��o string do hist�rico de transforma��o. 
	 */
	public String historico(int index) {
		if (logger != null) {
			return logger.registroLogger(null, "historico") + index + "\n" + this.historico.get(index);
		}
		return this.historico.get(index);
	}
	
	/**
	 * Retorna o n�mero de transforma��es realizadas.
	 * 
	 * @return um n�mero inteiro representando a quantidade de transforma��es feitas.
	 */
	public String contaTransformacao() {
		if (logger != null) {
			return logger.registroLogger(null, "contaTransformacao") + this.contabilizaTransformacoes;
		}
		String numTransformacoes = String.valueOf(contabilizaTransformacoes);
		return numTransformacoes;
	}
	
	/**
	 * Retorna a listagem dos textos originais, ou seja, dos textos que foram submetidos a transforma��es.
	 * 
	 * @return A representa��o string dos textos originais, sem repeti��o.
	 */
	public String listarOriginais() {
		String resultado = "";
		for(String original : this.txtOriginais) {
			resultado += original + "\n";
		}
		return resultado;
	}
	
	/**
	 * Cadastra no mapa novas transforma��es.
	 * 
	 * @param nome O nome da transforma��o.
	 * @param transformacao A transforma��o que implementa a interface AlgoritmoTransforma��o.
	 */
	public void cadastraTransformacao(String nome, AlgoritmoTransformacao transformacao) {
		this.transformacoes.put(nome, transformacao);
	}
	
	/**
	 * Retorna a listagem das transforma��es textuais dispon�veis em ordem alfab�tica.
	 *
	 * @return A representa��o string das transforma��es dispon�veis de maneira ordenada. 
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
	 * M�todo auxiliar que adiciona as transforma��es padr�es + a transforma��o nova ao Mapa de transforma��es. 
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
	 * M�todo auxiliar que verifica a existencia de uma transforma��o no mapa de transforma��es.
	 * 
	 * @param transformacao O nome da transforma��o. 
	 * 
	 * @return true caso a transforma��o exista e caso contr�rio retorna false.
	 */
	private boolean transformacaoExiste(String transformacao) {
		if(this.transformacoes.containsKey(transformacao)) {
			return true;
		}
		return false;
	}
	
}
