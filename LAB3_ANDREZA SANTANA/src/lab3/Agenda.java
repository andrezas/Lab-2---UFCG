package lab3;

/**
 * Representação da agenda que contém os conatos.
 * 
 * @author Andreza Santana
 *
 */
public class Agenda {

	/**
	 * Quantidade de contatos da agenda.
	 */
    private static final int QUANT_CONTATOS = 100;
    
    /**
     * Quantidade de contatos favoritos da agenda.
     */
    private static final int QUANT_FAVORITOS = 10;

    /**
     * Array com os contatos da agenda.
     */
    private Contato[] contatos;
    
    /**
     * Array com os contatos definidos como favoritos na agenda.
     */
    private Contato[] favoritos;

    /**
     * Constrói uma agenda e definindo o tamanho das listas de contatos a partir 
     * de valores finais pré-definidos;
     */
    public Agenda() {
        this.contatos = new Contato[QUANT_CONTATOS];
        this.favoritos = new Contato[QUANT_FAVORITOS];
    }

    /**
     * Checa se um contato em uma determinada posicao da lista de contatos também
     * é favorito.
     * 
     * @param posicao A posição do contato na lista de contatos.
     * @return a confirmação se o contato é ou não favorito a partir das plavras-chave 
     * true ou false. 
     */
    private boolean checkContatoFavorito(int posicao) {
        for (Contato favorito : this.favoritos) {
            if (favorito != null) {
                if (favorito.equals(this.contatos[posicao - 1])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Pega um contato em uma posição determindada.
     * 
     * @param posicao A posicao do contato na lista de contatos.
     * @return a representação em String do contato correspondente à posição passada
     * como parâmetro contendo o ícone de favorito (caso o contato seja um favorito),
     * nome, sobrenome, telefone e tags (caso existam)
     */
    public String getContato(int posicao) {
        if (this.checkContatoFavorito(posicao)) {
            return "❤️ " + this.contatos[posicao - 1].getNome() + " " + this.contatos[posicao - 1].getSobrenome() + "\n" + this.contatos[posicao - 1].getTelefone() + "\n" + this.contatos[posicao -1].toStringTags();
        } else {
            return this.contatos[posicao - 1].getNome() + " " + this.contatos[posicao - 1].getSobrenome() + "\n" + this.contatos[posicao - 1].getTelefone() + "\n" + this.contatos[posicao -1].toStringTags();
        }
    }

    /**
     * Retorna uma cópia da lista de contatos.
     * 
     * @return sem parâmetros.
     */
    public Object[] getContatos() {
        return this.contatos.clone();
    }

    /**
     * Retorna uma cópia da lista de contatos favoritos.
     * 
     * @return sem parâmetros.
     */
    public Object[] getFavoritos() {
        return this.favoritos.clone();
    }

    /**
     * Cadastra um novo contato na lista de contatos da agenda. 
     * 
     * @param posicao A posição que o contato deve ocupar na lista de contatos;
     * @param nome O nome do contato;
     * @param sobrenome O sobrenome do Contato;
     * @param numero O número/telefone do contato.
     */
    public void cadastraContato(int posicao, String nome, String sobrenome, String numero) {
        permiteCadastroContato(posicao, nome, sobrenome, numero);
        Contato contato = new Contato(nome, sobrenome, numero);
        this.contatos[posicao - 1] = contato;
    }

    /**
     * Verifica se um contato pode ou não ser cadastrado a partir da sua posição (negado quando
     * 1 < posicao ou posicao > 100), caso nome e sobrenome dos contatos sejam iguais ou nulos.
     * 
     * @param posicao A posição desejada para o cadastro do contato na lista de contatos;
     * @param nome O nome do contato.
     * @param sobrenome O sobrenome do contato.
     * @param telefone O telefone do contato.
     */
    private void permiteCadastroContato(int posicao, String nome, String sobrenome, String telefone) {
        if (posicao < 1 || posicao > 100) {
            throw new IllegalArgumentException("POSICAO INVALIDA! \n");
        }

        if (nome.isBlank() || nome.isEmpty() || telefone.isEmpty() || telefone.isBlank()) {
            throw new NullPointerException("CONTATO INVALIDO \n");
        } else {
            for (int i = 0; i < contatos.length; i++) {
                if (contatos[i] != null) {
                    if (contatos[i].getNome().toUpperCase().contains(nome.toUpperCase()) && contatos[i].getSobrenome().toUpperCase().contains(sobrenome.toUpperCase())) {
                        throw new IllegalArgumentException("CONTATO JA CADASTRADO! \n");
                    }
                }
            }
        }
    }

    /**
     * Adicona contatos já existentes na lista de contatos em uma nova lista de contatos que 
     * representa os contatos favoritos.
     * 
     * @param posicao A posição que o contato deve ocupar na lista de favoritos.
     * @param posicaoContato A posição do contato que deve ser adicionado como favorito.
     */
    public void adicionaFavorito(int posicao, int posicaoContato) {
        for (int i = 0; i < favoritos.length; i++) {
            if (favoritos[i] != null) {
                if (favoritos[i].getNome().contains(contatos[posicaoContato].getNome()) && favoritos[i].getSobrenome().contains(contatos[posicaoContato].getSobrenome())) {
                    throw new IllegalArgumentException("CONTATO JA FAVORITADO! \n");
                }
            }
        }
        this.favoritos[posicao - 1] = this.contatos[posicaoContato - 1];

    }

    /**
     * Adiciona tags à um contato ou mais contatos, ou seja, um texto. 
     * Ao todo 5 tags podem ser adicionadas de cada vez.
     * 
     * @param posicaoContato A posicao do contato que deve receber a tag;
     * @param tag A tag a ser adicionada, ou seja, o texto;
     * @param posicaoTag A posicao que a tag deve ocupar na lista de tags.
     */
    public void adicionaTag(String posicaoContato, String tag, int posicaoTag) {
    	String[] p = posicaoContato.split(" ");
    	for(String posicao : p) {
    		int posContato = Integer.parseInt(posicao);
    		if ( posContato < 1  || posContato > 100) {
    			throw new IllegalArgumentException("CONTATO INVÁLIDO! \n");
    		}
    		contatos[posContato - 1].cadastraTag(tag, posicaoTag);
    
    	}
    }


    
   
}