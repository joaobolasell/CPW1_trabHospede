package classes;



/* Foi escolhido a estratégia JOINED para criar uma tabela para cada Classe por ser a mais próxima do modelo de classes. 
 * Não concordo em criar uma tabela para tudo, caso eu queira criar outra subclasse de pessoa no futuro,
 *  usando outra estratégia ficaria muitas colunas de informação na mesma tabela, inclusive algumas obrigatoriamente null.*/

import classes.Endereco;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;
	
	private String nome;
	private String telefone;
	
	@OneToMany (cascade=CascadeType.PERSIST)
	@JoinColumn(name="idPessoa")
	private List<Endereco> enderecos;
	
	

	
	public Pessoa() {
		super();
	}

	public Pessoa(Long idPessoa, String nome, String telefone, List<Endereco> enderecos) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.telefone = telefone;
		this.enderecos = enderecos;
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	public Long getIdPessoa() {
		return idPessoa;
	}
	

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		String aux = "";
		if(enderecos != null) {
			for(Endereco e : enderecos) {
				if(e != null) {
					aux += e.toString() + "\n";
				}
			}
		}		
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", telefone=" + telefone + ", enderecos=" + aux
				+ "]";
	}

	


   
}
