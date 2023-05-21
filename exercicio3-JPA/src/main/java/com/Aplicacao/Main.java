package com.Aplicacao;

import java.util.Arrays;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Models.Classe;
import com.Models.Professor;

public class Main {

	public static void main(String[] args) {
	
		
		Classe classe1 = new Classe();
		classe1.setCnome("Historia");
		
		Classe classe2 = new Classe();
		classe2.setCnome("Matematica");
		
		Classe classe3 = new Classe();
		classe3.setCnome("Fisica");
	
		Professor prof1 = new Professor();
		prof1.setTnome("Marcelo");
		prof1.setAssunto("Exatas");
		prof1.setClasse(Arrays.asList(classe2, classe3));
		
		Professor prof2 = new Professor();
		prof2.setTnome("Gilberto");
		prof2.setAssunto("Humanas");
		prof2.setClasse(Collections.singletonList(classe1));
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio3-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();


		em.persist(prof1);
		em.persist(prof2);
		em.persist(classe1);
		em.persist(classe2);
		em.persist(classe3);

		tx.commit();

		em.close();
		emf.close();


	}

}
