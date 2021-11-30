package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa a classe responsável por controlar as ações de grupo e aluno.
 * 
 * @author Andreza Santana
 *
 */
public class ControleAluno {

	/**
	 * Representa um mapa de aluno, tendo como chave a matrícula.
	 */
	private Map<String, Aluno> alunos;
	
	/**
	 * Representa um mapa de grupos que tem o nome/tema do grupo como chave.
	 */
	private Map<String, Grupo> grupos;
	
	/**
	 * Representa os alunos que responderam questões no quadro.
	 */
	private List<Aluno> responderamQuadro;
	
	
	/**
	 * Constrói/Inicializa um controle de alunos.
	 */
	public ControleAluno() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.responderamQuadro = new ArrayList<>();
	}
	
	/**
	 * Cadastra alunos a partir de sua matrícula, nome e curso. Antes de cada cadastro
	 * verifica se a matrícula passada como parâmetro já foi cadastrada.
	 * 
	 * @param matricula
	 * @param nomeAluno
	 * @param curso
	 */
	public void cadastraAluno(String matricula, String nomeAluno, String curso) {
		if (alunoExiste(matricula) == true) {
			throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA!");
		}else {
			this.alunos.put(matricula, new Aluno(matricula, nomeAluno, curso));
		}
	}
	
	/**
	 * Exibe um aluno cadastrado no mapa de alunos. Para tanto, verifica se o aluno 
	 * existe, ou seja, se ela está cadastrado ou não.
	 * 
	 * @param matricula
	 * 
	 * @return a representação String de aluno, ou seja, o toString de aluno.
	 */
	public String exibeAluno(String matricula) {
		if (alunoExiste(matricula) == true) {
			Aluno aluno = (Aluno) this.alunos.get(matricula);
			return aluno.toString();
		}else {
			return "ALUNO NÃO CADASTRADO!";
		}
	}
	
	/**
	 * Cadastra um novo grupo verificando se este já existe.
	 * 
	 * @param nomeGrupo
	 * @param tamanho
	 */
	public void cadastraGrupo(String nomeGrupo, Integer tamanho) {
		if(grupoExiste(nomeGrupo) == true) {
			throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
		}else {
			this.grupos.put(nomeGrupo.toUpperCase(), new Grupo(nomeGrupo, tamanho));
		}
	}
	
	/**
	 * Aloca um aluno em um grupo a partir de sua matricula e o nome do grupo em 
	 * que deve ser cadastrado. Verifica se o aluno passado como parâmetro existe, bem
	 * como o grupo passado.
	 * 
	 * @param matricula
	 * @param nomeG
	 */
	public void alocaAlunoGrupo(String matricula, String nomeG) {
		if(alunoExiste(matricula) == false) {
			throw new IllegalArgumentException("ALUNO NÃO CADASTRADO!");
		}
		if(grupoExiste(nomeG) == false) {
			throw new IllegalArgumentException("GRUPO NÃO CADASTRADO!");
		}
		Grupo grupo = (Grupo) this.grupos.get(nomeG.toUpperCase());
		Aluno aluno = (Aluno) this.alunos.get(matricula);
		grupo.alocaAluno(aluno);
	}
	
	/**
	 * Verifica se o aluno com matricula passada existe no grupo especificado. Realiza
	 * a verificação de existência do grupo passado.
	 * 
	 * @param nomeG
	 * @param matricula
	 * 
	 * @return true em caso de pertencimento e false em caso de não pertencimento.
	 */
	public boolean verificaPertinenciaGrupo(String nomeG, String matricula) {
		if(grupoExiste(nomeG) == false) {
			throw new IllegalArgumentException("GRUPO NÃO CADASTRADO!");
		}
		Grupo grupo = (Grupo) this.grupos.get(nomeG.toUpperCase());
		boolean pertence = false;
		for(Aluno aluno : grupo.getAlunos()) {
			if (aluno.getMatricula().equals(matricula)) {
				pertence = true;
				break;
			}
		}
		return pertence;
	}
	
	/**
	 * Cadastra aluno que respondeu questão no quadro na lista "responderamQuadro".
	 * 
	 * @param matricula
	 */
	public void cadastraAlunoRespondeQuestao(String matricula) {
		if(alunoExiste(matricula) == true) {
			Aluno aluno = (Aluno) this.alunos.get(matricula);
			this.responderamQuadro.add(aluno);
		}else {
			throw new IllegalArgumentException("ALUNO NÃO CADASTRADO!");
		}
		
	}
	

	/**
	 * Imprime a segunda representação string (presente na classe Aluno) dos alunos
	 * que responderam questões no quadro.
	 *  
	 * @return representação String dos alunos que responderam no quadro.
	 */
	public String imprimeAlunosQuadro() {
		String saida = "\nALUNOS:\n";
		int index = 1;
		for (Aluno aluno : this.responderamQuadro) {
			saida += index + ". " + aluno.segundoToString() + "\n";
			index ++;
		}
		return saida;
	}
	
	/**
	 * Checa os grupos que o aluno passado como parâmetro está cadastrado.
	 * 
	 * @param matricula
	 * 
	 * @return representação String dos grupos do aluno.
	 */
	public String checaGruposDoAluno(String matricula) {
		String saida = "GRUPOS:\n";
		Aluno aluno = (Aluno) alunos.get(matricula);
		for(Grupo grupo : this.grupos.values()) {
			if (grupo.alunoPertenceGrupo(aluno)) {
				saida += grupo.toString() + "\n";
			}
		}
		return saida;
	}
	
	/**
	 * Método auxiliar para verificar a existência de um aluno
	 * 
	 * @param matricula
	 * @return true caso exista e false caso não exista.
	 */
	private boolean alunoExiste(String matricula) {
		if(this.alunos.containsKey(matricula)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método auxiliar para verificar a existência de um grupo
	 * 
	 * @param matricula
	 * @return true caso exista e false caso não exista.
	 */
	private boolean grupoExiste(String nomeG) {
		if(this.grupos.containsKey(nomeG.toUpperCase())) {
			return true;
		}else {
			return false;
		}
	}

}
