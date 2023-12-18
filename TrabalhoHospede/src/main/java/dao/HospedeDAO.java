package dao;



import util.JPAUtil;

import classes.Hospede;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class HospedeDAO {
	
	private EntityManager em;

	public HospedeDAO() {
	}
	
	public boolean salvar(Hospede entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE HOSPEDE! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public boolean atualizar(Hospede entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE HOSPEDE! ");
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
			Hospede entity = em.find(Hospede.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE HOSPEDE! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}
	
	
	public List<Hospede> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Hospede> query = em.createQuery("SELECT obj FROM Hospede obj", Hospede.class);
			List<Hospede> hospedes = query.getResultList();
			return hospedes;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE HOSPEDE! ");
			//e.printStackTrace();
			return null;
		} 
	}
	
	
	public Hospede buscarID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Hospede hospede = em.find(Hospede.class, id);
			return hospede;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE HOSPEDE! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}
	

	
	
	
	
	



}
