package testes;

import classes.*;
import dao.*;

import java.util.*;

public class TestesMapeamentos {

	public static void main(String[] args) {
System.out.println("OI\n");
		
		

		
		//----------TESTES enderecoDAO---------\
		System.out.println("----------TESTES enderecoDAO---------");
		
		Endereco e1 = new Endereco();
		e1.setLogradouro("Rua dois");
		e1.setComplemento("333");
		e1.setCEP("90999-000");
		
		EnderecoDAO objDAO = new EnderecoDAO();
		
		if(objDAO.cadastrar(e1)) {
			System.out.println("ENDERECO CADASTRADO COM SUCESSO! ");
		} 
		
		 System.out.println("\nLISTAR TODOS ENDERECOS");
		 for(Endereco endAux : objDAO.buscarTodos()) {
			 System.out.println(endAux.toString());
		 }
		 
		 System.out.println("\nATUALIZAR ENDERECO");
		 e1.setComplemento("casa2");
		 if(objDAO.atualizar(e1)) {
			System.out.println("ENDERECO ATUALIZADO COM SUCESSO! ");
		 }
		 
		 System.out.println("\nLISTAR TODOS ENDERECOS");
		 for(Endereco endAux : objDAO.buscarTodos()) {
			 System.out.println(endAux.toString());
		 }
		 
		 System.out.println("\nBUSCAR PELO ID ");
		 if(objDAO.buscarID(e1.getIdEndereco()) != null) {
			 System.out.println(objDAO.buscarID(e1.getIdEndereco()).toString());
		 }
		
			
		 System.out.println("\nBUSCAR PELO COMPLEMENTO");
		 if(objDAO.buscarComplemento(e1.getComplemento()) != null) {
			 System.out.println(objDAO.buscarComplemento(e1.getComplemento()).toString());
		 }
		
		 
		/*
			
		if(objDAO.excluir(e1.getIdEndereco())) {
			System.out.println("ENDERECO EXCLUIDO COM SUCESSO! ");
		}
		*/
		
		//----------TESTES pessoaDAO---------
		 System.out.println("----------TESTES pessoaDAO---------");
		
		//ENDERECO JÁ CRIADO ACIMA		
		
		List<Endereco> enderecos = new LinkedList<>();
		enderecos.add(e1);		
		
		PessoaDAO pessDAO = new PessoaDAO();
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Pedro");
		p1.setTelefone("5555555");
		p1.setEnderecos(enderecos);		
		
		
		if(new PessoaDAO().cadastrar(p1)) {
			System.out.println("PESSOA SALVA COM SUCESSO! ");
		}
		
		 System.out.println("\nLISTAR TODAS PESSOAS");
		 for(Pessoa pessAux : pessDAO.buscarTodos()) {
			 System.out.println(pessAux.toString());
		 }
		 
		 System.out.println("\nATUALIZAR PESSOA");
		 p1.setNome("Joao");
		 if(pessDAO.atualizar(p1)) {
			System.out.println("PESSOA ATUALIZADO COM SUCESSO! ");
		 }
		 
		 System.out.println("\nLISTAR TODAS PESSOAS");
		 for(Pessoa pessAux : pessDAO.buscarTodos()) {
			 System.out.println(pessAux.toString());
		 }
		 
		 
		  /*
		if(pessDAO.excluir(p1.getIdPessoa())) {
			System.out.println("PESSOA EXCLUIDA COM SUCESSO! ");
		}
		 */

		
		//----------TESTES hospedeDAO---------
		 System.out.println("----------TESTES hospedeDAO---------");

		
		
		
		Hospede h1 = new Hospede();
		h1.setNome("João");
		h1.setTelefone("999999");
		h1.setRg("RG123");
		h1.setCpf("cpf321");
		Date d1 = new Date(95, 3, 4);
		h1.setDataNascimento(d1);
		Set<String> emails = new HashSet<String>();
    	emails.add("fulano1@mail.com");
    	emails.add("fulano2@mail.com");
    	h1.setEmails(emails);
    	
    	h1.setEnderecos(enderecos);
    	
    	
    	
    	HospedeDAO hospDAO = new HospedeDAO();
    	
    	if(new HospedeDAO().salvar(h1)) {
    		System.out.println("HOSPEDE SALVO COM SUCESSO! ");
    	}
    	
		 System.out.println("\nLISTAR TODOS HOSPEDES");
		 for(Hospede HospAUX : hospDAO.buscarTodos()) {
			 System.out.println(HospAUX.toString());
		 }
		 
		 System.out.println("\nATUALIZAR HOSPEDE");
		 h1.setNome("Paulo");
		 if(hospDAO.atualizar(h1)) {
			System.out.println("HOSPEDE ATUALIZADO COM SUCESSO! ");
		 }
		 
		 System.out.println("\nLISTAR TODOS HOSPEDES");
		 for(Hospede HospAUX : hospDAO.buscarTodos()) {
			 System.out.println(HospAUX.toString());
		 }
		 
		
		 
		 /*
		if(hospDAO.excluir(h1.getIdPessoa())) {
			System.out.println("HOSPEDE EXCLUIDO COM SUCESSO! ");
		}
		 */
		 
		//----------TESTES classificacaoDAO---------
		 System.out.println("----------TESTES classificacaoDAO---------");
		Classificacao c1 = new Classificacao();
		c1.setCama("CASAL");
		c1.setFrigobar(true);
		c1.setArCondicionado(true);
		
		ClassificacaoDAO cDAO = new ClassificacaoDAO();
		
		if(cDAO.salvar(c1)) {
			System.out.println("CLASSIFICACAO SALVA COM SUCESSO! ");
		}
		
		System.out.println("\nLISTAR TODAS CLASSIFICACOES");
		for(Classificacao cAUX : cDAO.buscarTodos()) {
			System.out.println(cAUX.toString());
		}
		
		 System.out.println("\nATUALIZAR CLASSIFICACAO");
		 c1.setCama("KING");
		 if(cDAO.atualizar(c1)) {
			System.out.println("CLASSIFICACAO ATUALIZADA COM SUCESSO! ");
		 }
		 
		 System.out.println("\nLISTAR TODAS CLASSIFICACOES");
		 for(Classificacao cAUX : cDAO.buscarTodos()) {
			System.out.println(cAUX.toString());
		 }
		 
		 System.out.println("\nBUSCAR PELO ID ");
		 if(cDAO.buscarID(c1.getIdClassificacao()) != null) {
			 System.out.println(cDAO.buscarID(c1.getIdClassificacao()).toString());
		 }
		 
		/*	
		 if(cDAO.excluir(c1.getIdClassificacao())) {
			System.out.println("CLASSIFICACAO EXCLUIDA COM SUCESSO! ");
		}
		*/ 

		//----------TESTES quartoDAO---------
		 System.out.println("----------TESTES quartoDAO---------");

		  Quarto q1 = new Quarto();
		  q1.setOcupado(false);
		  q1.setNumero(10);
		  q1.setCapacidadeMaxima(4);
		  q1.setSituacao(Situacao.VAGO);
		  q1.setClassificacao(c1);
		  
				
		  QuartoDAO qDAO = new QuartoDAO();
				
		  if(qDAO.salvar(q1)) {
			System.out.println("QUARTO SALVO COM SUCESSO! ");
		  }
		  
		  System.out.println("\nLISTAR TODOS QUARTOS ");
		  for(Quarto qAUX : qDAO.buscarTodos()) {
			System.out.println(qAUX.toString());
		  }
		  
		  System.out.println("\nATUALIZAR QUARTO");
		  q1.setCapacidadeMaxima(5);
		  if(qDAO.atualizar(q1)) {
			  System.out.println("QUARTO ATUALIZADO COM SUCESSO! ");
		  }
		  
		  System.out.println("\nLISTAR TODOS QUARTOS ");
		  for(Quarto qAUX : qDAO.buscarTodos()) {
			System.out.println(qAUX.toString());
		  }
		  
		  System.out.println("\nBUSCAR PELO ID ");
		  if(qDAO.buscarID(q1.getIdQuarto()) != null) {
			  System.out.println(qDAO.buscarID(q1.getIdQuarto()).toString());
		  }
		  
			/*	
			 if(qDAO.excluir(q1.getIdQuarto())) {
				System.out.println("QUARTO EXCLUIDO COM SUCESSO! ");
			}
			*/
		  
		//----------TESTES reservaDAO---------
		  System.out.println("----------TESTES reservaDAO---------");
		  
		  ReservaDAO rDAO = new ReservaDAO();
		  
		  
		  
		  List<Quarto> quartos = new LinkedList<>();
		  quartos.add(q1);
		  
		  Reserva r1 = new Reserva();
		  r1.setDataEntrada(new Date());
		  r1.setDataSaida(new Date());		  
		  r1.setQuartos(quartos);
		  
		  List<Reserva> reservas = new LinkedList<>();
		  q1.setReservas(reservas);
		  
		  r1.setHospede(h1);
		  h1.setReservas(reservas);
		  
		  if(rDAO.salvar(r1)) {
			  System.out.println("RESERVA SALVA COM SUCESSO! ");
		  }
		 
		  System.out.println("\nLISTAR TODAS RESERVAS ");
		  for(Reserva rAUX : rDAO.buscarTodos()) {
			System.out.println(rAUX.toString());
		  }
		  
		  System.out.println("\nATUALIZAR RESERVA");
		  r1.setDataEntrada(new Date());
		  if(rDAO.atualizar(r1)) {
			  System.out.println("RESERVA ATUALIZADA COM SUCESSO! ");
		  }
		  
		  System.out.println("\nLISTAR TODAS RESERVAS ");
		  for(Reserva rAUX : rDAO.buscarTodos()) {
			System.out.println(rAUX.toString());
		  }
		  
		  System.out.println("\nBUSCAR PELO ID ");
		  if(rDAO.buscarID(r1.getIdReserva()) != null) {
			  System.out.println(rDAO.buscarID(r1.getIdReserva()).toString());
		  }
		  
			/*
			 if(rDAO.excluir(r1.getIdReserva())) {
				System.out.println("RESERVA EXCLUIDA COM SUCESSO! ");
			}
			*/

	}

}
