package classes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import classes.Situacao;
import classes.Classificacao;
import classes.Reserva;


/**
 * Entity implementation class for Entity: Quarto
 *
 */
@Entity

public class Quarto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idQuarto;
	
	private boolean isOcupado;
	private int numero;
	private int capacidadeMaxima;
	
	//foi usado a estrategia STRING para salvar o valor da constante da enum no banco de dados
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	@OneToOne (cascade= {CascadeType.REMOVE, CascadeType.PERSIST})
	private Classificacao classificacao;
	
	

	
	@ManyToMany(mappedBy="quartos")
	private List<Reserva> reservas;
	
	

	public Quarto() {
		super();
	}


	
	


	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Long getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(Long idQuarto) {
		this.idQuarto = idQuarto;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public Situacao getSituacao() {
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}


	public boolean isOcupado() {
		return isOcupado;
	}

	public void setOcupado(boolean isOcupado) {
		this.isOcupado = isOcupado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}






	@Override
	public String toString() {
		
		String aux = "";
		if(reservas != null) {
			for(Reserva r : reservas) {
				if(r != null) {
					aux += r.toString() + "\n";
				}
			}
		}
		
		return "Quarto [idQuarto=" + idQuarto + ", isOcupado=" + isOcupado + ", numero=" + numero
				+ ", capacidadeMaxima=" + capacidadeMaxima + ", situacao=" + situacao + ", classificacao="
				+ classificacao + ", reservas=" + aux + "]";
	}
	
	
	
	
   
}
