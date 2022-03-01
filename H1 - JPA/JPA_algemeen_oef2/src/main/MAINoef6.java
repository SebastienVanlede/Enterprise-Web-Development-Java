package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domein.Campus;
import domein.Docent;
import domein.Werkruimte;
import util.JPAUtil;

public class MAINoef6 {

	public static void main(String[] args) {
		List<Campus> campusList;
		List<Docent> docentList;
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Campus campusAalst = entityManager.createNamedQuery("Campus.findByName",Campus.class).setParameter("naam", "Aalst").getSingleResult();
		Campus campusGent = entityManager.createNamedQuery("Campus.findByName",Campus.class).setParameter("naam", "Gent").getSingleResult();
		Werkruimte kelder = entityManager.find(Werkruimte.class , "SCH555");
		
		if(campusAalst!=null && campusGent!=null && kelder !=null) {	
			System.out.println(campusAalst);
			System.out.println(campusGent);
			System.out.println(kelder);
			TypedQuery<Docent> queryD = entityManager.createNamedQuery("Docent.docentenInTweeCampussen", Docent.class);
			queryD.setParameter("campusA", campusAalst);
			queryD.setParameter("campusB", campusGent);
			
			List<Docent> docenten = queryD.getResultList();
			
			docenten.forEach(d -> d.setWerkruimte(kelder));
			
			
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		JPAUtil.getEntityManagerFactory().close();

		
	}
}
