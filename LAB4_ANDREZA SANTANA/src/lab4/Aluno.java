package lab4;

import java.util.Objects;

/**
 * Representação do aluno
 * 
 * @author Andreza Santana
 *
 */
public class Aluno {

	/**
	 * Representação do nome do aluno.
	 */
	private String nome;
	
	/**
	 * Representação da matricula do aluno.
	 */
	private String matricula;
	
	/**
	 * Representação do curso do aluno.
	 */
	private String curso;
	
	/**
	 * Constrói/Inicializa um aluno a partir de sua matricula, nome e curso. Para tanto, 
	 * realiza a verificação de campos vazios ou nulos.
	 * 
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula.isBlank() || nome.isBlank() || curso.isBlank()) {
			throw new IllegalArgumentException("Dado vazio!");
		}
		if (matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Dado nulo!");
		}
		
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCurso() {
		return curso;
	}

	/**
	 * Retorna uma representação String, ou seja, textual do aluno.
	 * 
	 * @return a representação em string do aluno.
	 */
	@Override
	public String toString() {
		return "Aluno: " + this.matricula + " - " +  this.nome + " - " + this.curso; 
	}
	
	/**
	 * Retorna uma representação String, ou seja, textual do aluno.
	 * 
	 * @return uma segunda representação em string do aluno sem a palavra "Aluno: ".
	 */
	public String segundoToString() {
		return this.matricula + " - " +  this.nome + " - " + this.curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	
}
