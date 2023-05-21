package br.com.aplicacao;

import java.io.IOException;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.entidades.Department;
import br.com.entidades.Employee;
import br.com.entidades.Log;

public class OneToOne {

	public static void main(String[] args) throws IOException {
		// LOGGER
		Log meuLogger = new Log("Log.txt");
		try {
			// Log meuLogger = new Log("Log.txt");
			meuLogger.logger.setLevel(Level.FINE);
			meuLogger.logger.info("Log de informação");
			meuLogger.logger.warning("Log de Aviso");
			meuLogger.logger.severe("Log Severo");

		} catch (Exception e) {
			meuLogger.logger.info("Exception:" + e.getMessage()); 
			e.printStackTrace();

		}

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("exercicio2-jpa"); 
		EntityManager entitymanager = emfactory.createEntityManager(); 
		meuLogger.logger.info("\nA entidade manager factory ManyToOne foi criada!!");

		entitymanager.getTransaction().begin(); 

		
		Department department = new Department();
		
		department.setName("Development"); 
		
		entitymanager.persist(department); 

		
		Employee employee1 = new Employee();
		employee1.setEname("Vinicius Almeida");
		employee1.setSalary(45000.0);
		employee1.setDeg("Technical Writer");
		employee1.setDepartment(department);

		
		Employee employee2 = new Employee();
		employee2.setEname("Victor Chaves");
		employee2.setSalary(45000.0);
		employee2.setDeg("Technical Writer");
		employee2.setDepartment(department);

		
		entitymanager.persist(employee1);
		entitymanager.persist(employee2);

		entitymanager.getTransaction().commit();
		entitymanager.close(); 
		emfactory.close(); 
	}

}
