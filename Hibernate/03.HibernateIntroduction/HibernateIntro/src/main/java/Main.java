import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by vladix on 5/24/17.
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Town town = new Town();
        town.setTownId(123);
        town.setName("asd");

        em.persist(town);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
