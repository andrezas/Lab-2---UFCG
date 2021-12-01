package lab2;

/**
* Representação das finanças de um aluno, ou seja, os ganhos e as despesas que o
* aluno teve para o mesmo possa controlar suas finanças.
* 
* @author Andreza Santana
*/
public class RegistroFinancas {
	
	/**
	 * Armazena os ganhos do aluno, inclusive o ganho inicial.
	 */
	private int ganhos = 0;
	
	/**
	 * Representa a quantidade de ganhos que o aluno obteve. 
	 */
	private int quantGanhos = 0;
	
	/**
	 * Array criado para armazenar os ganhos do aluno.
	 */
	private int[] listaGanhos;
	
	/**
	 * Representa as despesas totoais do aluno.
	 */
	private int despesas = 0;
	
	/**
	 * Inicializa/Constrói um registro de finanças a partir de um ganho inicial 
	 * e a quantidade de ganhos do aluno.
	 * 
	 * @param ganhosIniciais o ganho inical do aluno, ou seja, o primeiro ganho.
	 * @param totalDeGanhos a quantidade de ganhos do aluno.
	 */
	public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
		this.ganhos = ganhosIniciais;
		this.quantGanhos = totalDeGanhos;
		listaGanhos = new int[totalDeGanhos];
	}
	
	/**
	 * Adiciona novos ganhos, em centavos, obtidos pelo aluno e armazena esses valores
	 * na lista de ganhos em um aposição específica, de modo que o valor possa ser
	 * substituído por um novo valor e o valor anteriormente armazenado nessa posição
	 * passe a ser desconsiderado.
	 * 
	 * @return sem retorno.
	 */
	public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
		if (listaGanhos[posicaoGanho-1] != 0) {
			this.ganhos -= listaGanhos[posicaoGanho-1];
			listaGanhos[posicaoGanho-1] = valorCentavos;
			this.ganhos += valorCentavos;
		}else {
			listaGanhos[posicaoGanho-1] = valorCentavos;
			this.ganhos += valorCentavos;
		}
	}
	
	/**
	 * Soma todas as despesas do aluno.
	 * 
	 * @return sem retorno.
	 */
	public void pagaDespesa(double valor) {
		this.despesas += valor;
	}

	/**
	 * Faz a exibição dos ganhos do aluno, ou seja, uma espécie de extrato bancário
	 * contendo apenas os ganhos.
	 * 
	 * @return uma String retorno os ganhos do aluno em uma posição específica. 
	 */
	public String exibeGanhos() {
		String resultado = "";
		for(int i=0; i< listaGanhos.length; i++) {
			if(i < listaGanhos.length - 1) {
				resultado += i+1 + " - " + listaGanhos[i] + "\n";
			}else {
				resultado += i+1 + " - " + listaGanhos[i];
			}
			
		}
		return resultado;
	}
	
	/**
	 * Retorna a String que representa uma espécie de extrato bancário das finanças
	 * do aluno.
	 * 
	 * @return a representação em String das finanças do aluno.
	 */
	public String toString() {
		int disponivel = this.ganhos - this.despesas;
		return "Total recebidos: " + this.ganhos + ", " + "Despesas totais: " + this.despesas + ", " + "Total disponível: " + disponivel;
	}
	
	
}

