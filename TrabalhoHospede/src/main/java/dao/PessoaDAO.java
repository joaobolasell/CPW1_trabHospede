
package dao;

import util.JPAUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import classes.Pessoa;

public class PessoaDAO {
	
	private EntityManager em;

	public PessoaDAO() {
	}
	
	public boolean cadastrar(Pessoa entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE PESSOA! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}		
	}
	
	public boolean atualizar(Pessoa entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE PESSOA! ");
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
			Pessoa entity = em.find(Pessoa.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE PESSOA! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}
	
	
	public List<Pessoa> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Pessoa> query = em.createQuery("SELECT obj FROM Pessoa obj", Pessoa.class);
			List<Pessoa> pessoas = query.getResultList();
			return pessoas;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE PESSOA! ");
			//e.printStackTrace();
			return null;
		} 
	}
	
	
	public Pessoa buscarID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Pessoa pessoa = em.find(Pessoa.class, id);
			return pessoa;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE PESSOA! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}
	
	
	

}
