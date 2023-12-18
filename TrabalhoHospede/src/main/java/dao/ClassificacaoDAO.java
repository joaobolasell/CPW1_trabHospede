package dao;

import util.JPAUtil;

import classes.Classificacao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClassificacaoDAO {
	
	private EntityManager em;

	public ClassificacaoDAO() {
	}
	
	public boolean salvar(Classificacao entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE CLASSIFICACAO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public boolean atualizar(Classificacao entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE CLASSIFICACAO! ");
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
			Classificacao entity = em.find(Classificacao.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE CLASSIFICACAO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}
	
	
	public List<Classificacao> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Classificacao> query = em.createQuery("SELECT obj FROM Classificacao obj", Classificacao.class);
			List<Classificacao> classificacao = query.getResultList();
			return classificacao;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE CLASSIFICACAO! ");
			//e.printStackTrace();
			return null;
		} 
	}
	
	
	public Classificacao buscarID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Classificacao classificacao = em.find(Classificacao.class, id);
			return classificacao;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE CLASSIFICACAO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}
	

}
