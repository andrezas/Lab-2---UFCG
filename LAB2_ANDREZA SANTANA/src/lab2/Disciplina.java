package lab2;

import java.util.Arrays;

/**
* Representação da disciplina que terá seu progresso avaliado. 
* 
* @author Andreza Santana
*/
public class Disciplina {

	/**
	* Nome da disciplina que está sendo cursada pelo aluno.
	*/
	private String nameDisciplina;
	
	/**
	* Representação das horas de estudo dedicadas à disciplina.
	*/
	private int horasEstudo;
	
	/**
	* Array encarregado de armazenar as 4 notas do aluno.
	*/
	private double[] notas =  new double[4];
	
	/**
	* Média do aluno na disciplina calculada a partir das 4 notas armazenadas
	* na lista notas.
	*/
	private double media;
	
	/**
	* Constrói uma disciplina a partir do seu nome.
	* 
	* @param nome o nome da disciplina.
	*/
	public Disciplina(String nomeDisciplina) {
		this.nameDisciplina = nomeDisciplina;
	}

	/**
	* Cadastra/Adiciona as horas que o aluno dedica ao estudo da disciplina.
	*
	* @return não tem retorno.
	*/
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}
	
	/**
	* Cadastra/Adiciona uma nota em uma posição determinada na lista de notas 
	* da disciplina.
	*
	* @return não tem retorno.
	*/
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	* Verifica se o aluno deve ser considerado aprovado ou não na disciplina. 
	* O aluno deverá ser considerado aprovado quando sua média seja igual ou 
	* acima de 7.0
	*
	* @return a confirmação ou negação, através das palavras-chave "true" ou "false" 
	* da aprovação do aluno na disciplina
	*/
	public boolean aprovado() {
		double soma = 0;
		for (int i = 0; i < notas.length; i++) {
			soma += notas[i];
		}
		media = soma / 4;
		if (media >= 7) {
			return true;
		}else {
			return false;
		}
	}

	/**
	* A a String que representa o progresso do aluno na disciplina
	*
	* @return a representação em String do nome da disciplina e o desdobramento 
	* do aluno na disciplina.
	*/
	public String toString() {
		return this.nameDisciplina + " " + this.horasEstudo + " " + this.media + " " + Arrays.toString(notas);
	}
}
	


