package main;

import domein.Campus;
import domein.Docent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class MAINoef5 {
	public static void main(String args[]) {
		List<Campus> campusList;
		List<Docent> docentList;

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		TypedQuery<Campus> queryC = entityManager.createNamedQuery("Campus.findAll", Campus.class);
		campusList = queryC.getResultList();

		TypedQuery<Docent> queryD = entityManager.createNamedQuery("Docent.findAll", Docent.class);
		docentList = queryD.getResultList();
		System.out.println(campusList);
		System.out.println(docentList);

		Docent d1 = docentList.get(0);
		//Campus dummy1 = d1.getCampussen().iterator().next();
		System.out.printf("%s %s\n", d1, d1.getCampussen());
		Docent d2 = docentList.get(1);
		System.out.printf("%s %s\n", d2, d2.getCampussen());
		Docent d3 = docentList.get(2);
		System.out.printf("%s %s\n", d3, d3.getCampussen());

		Campus c1 = campusList.get(0);
		System.out.printf("%s %s\n", c1, c1.getDocenten());
		Campus c2 = campusList.get(1);
		//Docent dummy2 = c2.getDocenten().iterator().next();
		System.out.printf("%s %s\n", c2, c2.getDocenten());

		entityManager.getTransaction().commit();
		entityManager.close();
		JPAUtil.getEntityManagerFactory().close();
	}
}