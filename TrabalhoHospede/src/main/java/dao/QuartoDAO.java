package dao;





import util.JPAUtil;

import classes.Quarto;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class QuartoDAO {
	
	private EntityManager em;

	public QuartoDAO() {
	}
	
	public boolean salvar(Quarto entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE QUARTO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public boolean atualizar(Quarto entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE QUARTO! ");
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
			Quarto entity = em.find(Quarto.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE QUARTO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}
	
	
	public List<Quarto> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Quarto> query = em.createQuery("SELECT obj FROM Quarto obj", Quarto.class);
			List<Quarto> quarto = query.getResultList();
			return quarto;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE QUARTO! ");
			//e.printStackTrace();
			return null;
		} 
	}
	
	
	public Quarto buscarID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Quarto quarto = em.find(Quarto.class, id);
			return quarto;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE QUARTO! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}
	
	

}
