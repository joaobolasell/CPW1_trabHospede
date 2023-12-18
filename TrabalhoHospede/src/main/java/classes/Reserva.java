package classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import classes.Quarto;
import classes.Hospede;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity

public class Reserva implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idReserva;
	
	//FOI USADO TIMESTAMP PRA SALVAR DATA E HORA, IMPORTANTE SABER A DATA E A HORA QUE O HOSPEDE ENTRA E SAI, PARA CONTAR AS DIARIAS, SABENDO QUE HOTEIS TEM HORARIO DE CHEKIN E CHEKOUT
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Date dataEntrada;
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Date dataSaida;
	

	 @ManyToMany (cascade= CascadeType.PERSIST)
	 @JoinTable( name="reserva_quarto", 
	               joinColumns={ @JoinColumn(name="idReserva")}, 
	               inverseJoinColumns={@JoinColumn(name="idQuarto")})
	private List<Quarto> quartos;

	 
	 @ManyToOne
	 @JoinColumn(name="idPessoa")
	private Hospede hospede;
	
	 
	 
	 
	
	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Reserva() {
		super();
	}

	@Override
	public String toString() {
		
		String auxQ = "";
		if(quartos != null) {
			for(Quarto quarto : quartos) {
				if(quarto != null) {
					auxQ += quarto.toString() + "\n";
				}
			}
		}
				
		return "Reserva [idReserva=" + idReserva + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida
				+ ", quartos=" + auxQ + ", hospede=" + hospede + "]";
	}
	
	
	
   
}
