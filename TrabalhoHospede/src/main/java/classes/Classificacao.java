package classes;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Classificacao
 *
 */
@Entity

public class Classificacao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClassificacao;

	private String cama;
	private boolean frigobar;
	private boolean arCondicionado;

	
	
	
	
	
	public Classificacao() {
		super();
	}
	
	
	
	
	public Long getIdClassificacao() {
		return idClassificacao;
	}

	public void setIdClassificacao(Long idClassificacao) {
		this.idClassificacao = idClassificacao;
	}

	public String getCama() {
		return cama;
	}

	public void setCama(String cama) {
		this.cama = cama;
	}

	public boolean isFrigobar() {
		return frigobar;
	}

	public void setFrigobar(boolean frigobar) {
		this.frigobar = frigobar;
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}


	@Override
	public String toString() {
		return "Classificacao [idClassificacao=" + idClassificacao + ", cama=" + cama + ", frigobar=" + frigobar
				+ ", arCondicionado=" + arCondicionado + "]";
	}


	
	
	
	
   
}
