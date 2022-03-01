package repository;
import domain.Bier;
import javax.persistence.EntityNotFoundException;

public interface BierDao extends GenericDao<Bier>  {
        public Bier getBierByName(String name) throws EntityNotFoundException;   
}