package dao;

import util.JPAUtil;

import classes.Reserva;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class ReservaDAO {
	
	
	private EntityManager em;

	public ReservaDAO() {
	}
	
	public boolean salvar(Reserva entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE RESERVA! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	
	public boolean atualizar(Reserva entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE RESERVA! ");
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
			Reserva entity = em.find(Reserva.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE RESERVA! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}
	
	
	public List<Reserva> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Reserva> query = em.createQuery("SELECT obj FROM Reserva obj", Reserva.class);
			List<Reserva> reserva = query.getResultList();
			return reserva;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE RESERVA! ");
			//e.printStackTrace();
			return null;
		} 
	}
	
	
	public Reserva buscarID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Reserva reserva = em.find(Reserva.class, id);
			return reserva;
		} catch (RuntimeException e) {
			System.out.println("ERRO NA CLASSE RESERVA! ");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}
	
	
	

}
