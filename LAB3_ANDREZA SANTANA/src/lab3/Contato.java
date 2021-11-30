package lab3;

import java.util.Arrays;
import java.util.Objects;

import org.junit.jupiter.params.aggregator.ArgumentAccessException;

/**
 * Rrepresentação do contato que será armazenado na agenda.
 * 
 * @author Andreza Santana
 *
 */
public class Contato {

	/**
	 * Representação da quantidade de tags que um contato pode conter.
	 */
    private static final int QUANT_TAGS = 5;

    /**
     * Representação do nome de um contato.
     */
    private String nome;
    
    /**
     * Representação do sobrenome de um contato.
     */
    private String sobrenome;
    
    /**
     * Representação do telefone de um contato.
     */
    private String telefone;
    
    /**
     * Representação da lista de tags que um contato pode conter.
     */
    private String[] tag;

    /**
     * Constrói  um contato a partir de seu nome, sobrenome e telefone. Além de instanciar
     * a lista de tags de um contato a partir de uma variável final pré-definida que representa
     * a quantidade de tags que um contato pode ter. 
     * 
     * @param nome O nome do contato.
     * @param sobrenome O sobrenome do contato.
     * @param telefone O telefone do contato.
     */
    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.tag = new String[QUANT_TAGS];
        
    }
    
    /**
     * Cadastra uma tag em um contato solicitando a tag a ser inserida e a posição 
     * que ela deve ocupar.
     * 
     * @param tag A tag que deve ser inserida na lista de tags.
     * @param posicao A posição que a tag deve ocupar na lista.
     */
    public void cadastraTag(String tag, int posicao) {
    	if( posicao < 1 || posicao > 5) {
    		throw new ArgumentAccessException("POSICAO DA TAG INVÁLIDA");
    	}
    	this.tag[posicao - 1] = tag;
    }
    
    /**
     * Retorna uma representação String, ou seja, textual das tags contidas na lista
     * de um contato específico.
     * 
     * @return a representação em string das tags de um contato.
     */
    public String toStringTags() {
    	String tags = "";
    	for (int i = 0; i < this.tag.length; i++) {
    		if(this.tag[i] != null) {
    			if (this.tag[i+1] == null) {
    				tags += tag[i];
    			}else {
    				tags += tag[i] + " ";
    			}
    		}
    	}
    	return tags;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(tag);
        result = prime * result + Objects.hash(nome, sobrenome, telefone);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) &&
                Objects.equals(sobrenome, contato.sobrenome) &&
                Objects.equals(telefone, contato.telefone) &&
                Arrays.equals(tag, contato.tag);
    }

    
}