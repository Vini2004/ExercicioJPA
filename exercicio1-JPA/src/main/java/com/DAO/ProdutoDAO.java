package com.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Models.Produto;

public class ProdutoDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio-jpa");

	public void cadastrar(Produto produto) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(produto);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	

	
	public Produto atualizar(Produto produto) {
	    EntityManager em = emf.createEntityManager();

	    try {
	        em.getTransaction().begin();
	        em.merge(produto);
	        em.getTransaction().commit();
	        return produto;
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        e.printStackTrace();
	        return null;
	    } finally {
	        em.close();
	    }
	}
	

	public void excluir(Produto produto) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			produto = em.merge(produto); // unifica o objeto com o contexto de persistência
			em.remove(produto); // remove o objeto da base de dados
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}


	public Produto buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Produto.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}



}
