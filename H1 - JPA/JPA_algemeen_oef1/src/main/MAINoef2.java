package main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import domein.Docent;
import util.JPAUtil;

public class MAINoef2 {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Docent docent = entityManager.find(Docent.class, 2L);
		
		if(docent != null) {
			docent.opslag(new BigDecimal(200));
		} else {
			System.out.println("docent 2 niet gevonden");
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		JPAUtil.getEntityManagerFactory().close();

	}

}
