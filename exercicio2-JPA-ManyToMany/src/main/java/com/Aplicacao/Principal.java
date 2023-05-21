package com.Aplicacao;

import java.util.Arrays;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Models.Aluno;
import com.Models.Disciplina;

public class Principal {

	public static void main(String[] args) {


		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Programação I");

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("Programação II");
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("João");
	
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Maria");

		aluno1.setDisciplinas(Arrays.asList(disciplina1, disciplina2));

		aluno2.setDisciplinas(Collections.singletonList(disciplina2));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio2-jpa-manytomany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();


		em.persist(aluno1);
		em.persist(aluno2);
		em.persist(disciplina1);
		em.persist(disciplina2);

		tx.commit();

		em.close();
		emf.close();


	}

}
