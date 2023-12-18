package classes;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.*;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hospede
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "idHospede", referencedColumnName = "idPessoa")

public class Hospede extends Pessoa implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String rg;
	
	private String cpf;
	
	//FOI USADO A ESTRATÉGIA DATE, POIS SÓ PRECISAVA DA DATA DE NASCIMENTO, E NÃO HORA OU HORA E DATA.
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	
    @ElementCollection
    @CollectionTable(name="hospede_emails")
	private Set<String> emails;
    
    @OneToMany (mappedBy = "hospede"
    		, cascade =
    		{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    		@JoinColumn(name="idReserva")
    private List<Reserva> reservas = new LinkedList<>();

    

	public Hospede(String rg, String cpf, Date dataNascimento, Set<String> emails) {
		super();
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.emails = emails;
	}
	
	

	public List<Reserva> getReservas() {
		return reservas;
	}



	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}



	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Hospede() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNascimento, emails, rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospede other = (Hospede) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(emails, other.emails) && Objects.equals(rg, other.rg);
	}

	@Override
	public String toString() {
		String aux ="";
		if(emails != null) {
			for(String emailAUX : emails) {
				if(emailAUX != null) {
					aux += emailAUX.toString() + "\n";
				}
			}
		}
			
		return "Hospede ["+super.toString()+"rg=" + rg + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento+ ", emails=" + aux + "]";
	}


	


	
	
	
	
   
}
