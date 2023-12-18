package dao;

import util.JPAUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.Endereco;

public class EnderecoDAO {
	
	
	private EntityManager em;

	public EnderecoDAO() {
	}

	public boolean cadastrar(Endereco entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE ENDERECO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}		
	}
	
	public boolean atualizar(Endereco entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE ENDERECO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}
	
	public boolean excluir(long id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Endereco entity = em.find(Endereco.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE ENDERECO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}
	
	
	public List<Endereco> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Endereco> query = em.createQuery("SELECT obj FROM Endereco obj", Endereco.class);
			List<Endereco> enderecos = query.getResultList();
			return enderecos;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE ENDERECO! ");
			//e.printStackTrace();
			return null;
		} 
	}
	
	
	public Endereco buscarID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Endereco endereco = em.find(Endereco.class, id);
			return endereco;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE ENDERECO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}
	
	public Endereco buscarComplemento(String complemento) {
		try {
			em = JPAUtil.getEntityManager();
			Endereco endereco = em.find(Endereco.class, complemento);
			return endereco;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE ENDERECO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}
	
	
	
	
	
	
	
	

}
