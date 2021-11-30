package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa a classe respons�vel por controlar as a��es de grupo e aluno.
 * 
 * @author Andreza Santana
 *
 */
public class ControleAluno {

	/**
	 * Representa um mapa de aluno, tendo como chave a matr�cula.
	 */
	private Map<String, Aluno> alunos;
	
	/**
	 * Representa um mapa de grupos que tem o nome/tema do grupo como chave.
	 */
	private Map<String, Grupo> grupos;
	
	/**
	 * Representa os alunos que responderam quest�es no quadro.
	 */
	private List<Aluno> responderamQuadro;
	
	
	/**
	 * Constr�i/Inicializa um controle de alunos.
	 */
	public ControleAluno() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.responderamQuadro = new ArrayList<>();
	}
	
	/**
	 * Cadastra alunos a partir de sua matr�cula, nome e curso. Antes de cada cadastro
	 * verifica se a matr�cula passada como par�metro j� foi cadastrada.
	 * 
	 * @param matricula
	 * @param nomeAluno
	 * @param curso
	 */
	public void cadastraAluno(String matricula, String nomeAluno, String curso) {
		if (alunoExiste(matricula) == true) {
			throw new IllegalArgumentException("MATR�CULA J� CADASTRADA!");
		}else {
			this.alunos.put(matricula, new Aluno(matricula, nomeAluno, curso));
		}
	}
	
	/**
	 * Exibe um aluno cadastrado no mapa de alunos. Para tanto, verifica se o aluno 
	 * existe, ou seja, se ela est� cadastrado ou n�o.
	 * 
	 * @param matricula
	 * 
	 * @return a representa��o String de aluno, ou seja, o toString de aluno.
	 */
	public String exibeAluno(String matricula) {
		if (alunoExiste(matricula) == true) {
			Aluno aluno = (Aluno) this.alunos.get(matricula);
			return aluno.toString();
		}else {
			return "ALUNO N�O CADASTRADO!";
		}
	}
	
	/**
	 * Cadastra um novo grupo verificando se este j� existe.
	 * 
	 * @param nomeGrupo
	 * @param tamanho
	 */
	public void cadastraGrupo(String nomeGrupo, Integer tamanho) {
		if(grupoExiste(nomeGrupo) == true) {
			throw new IllegalArgumentException("GRUPO J� CADASTRADO!");
		}else {
			this.grupos.put(nomeGrupo.toUpperCase(), new Grupo(nomeGrupo, tamanho));
		}
	}
	
	/**
	 * Aloca um aluno em um grupo a partir de sua matricula e o nome do grupo em 
	 * que deve ser cadastrado. Verifica se o aluno passado como par�metro existe, bem
	 * como o grupo passado.
	 * 
	 * @param matricula
	 * @param nomeG
	 */
	public void alocaAlunoGrupo(String matricula, String nomeG) {
		if(alunoExiste(matricula) == false) {
			throw new IllegalArgumentException("ALUNO N�O CADASTRADO!");
		}
		if(grupoExiste(nomeG) == false) {
			throw new IllegalArgumentException("GRUPO N�O CADASTRADO!");
		}
		Grupo grupo = (Grupo) this.grupos.get(nomeG.toUpperCase());
		Aluno aluno = (Aluno) this.alunos.get(matricula);
		grupo.alocaAluno(aluno);
	}
	
	/**
	 * Verifica se o aluno com matricula passada existe no grupo especificado. Realiza
	 * a verifica��o de exist�ncia do grupo passado.
	 * 
	 * @param nomeG
	 * @param matricula
	 * 
	 * @return true em caso de pertencimento e false em caso de n�o pertencimento.
	 */
	public boolean verificaPertinenciaGrupo(String nomeG, String matricula) {
		if(grupoExiste(nomeG) == false) {
			throw new IllegalArgumentException("GRUPO N�O CADASTRADO!");
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
	 * Cadastra aluno que respondeu quest�o no quadro na lista "responderamQuadro".
	 * 
	 * @param matricula
	 */
	public void cadastraAlunoRespondeQuestao(String matricula) {
		if(alunoExiste(matricula) == true) {
			Aluno aluno = (Aluno) this.alunos.get(matricula);
			this.responderamQuadro.add(aluno);
		}else {
			throw new IllegalArgumentException("ALUNO N�O CADASTRADO!");
		}
		
	}
	

	/**
	 * Imprime a segunda representa��o string (presente na classe Aluno) dos alunos
	 * que responderam quest�es no quadro.
	 *  
	 * @return representa��o String dos alunos que responderam no quadro.
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
	 * Checa os grupos que o aluno passado como par�metro est� cadastrado.
	 * 
	 * @param matricula
	 * 
	 * @return representa��o String dos grupos do aluno.
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
	 * M�todo auxiliar para verificar a exist�ncia de um aluno
	 * 
	 * @param matricula
	 * @return true caso exista e false caso n�o exista.
	 */
	private boolean alunoExiste(String matricula) {
		if(this.alunos.containsKey(matricula)) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo auxiliar para verificar a exist�ncia de um grupo
	 * 
	 * @param matricula
	 * @return true caso exista e false caso n�o exista.
	 */
	private boolean grupoExiste(String nomeG) {
		if(this.grupos.containsKey(nomeG.toUpperCase())) {
			return true;
		}else {
			return false;
		}
	}

}
