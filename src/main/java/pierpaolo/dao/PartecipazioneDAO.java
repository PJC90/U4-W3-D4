package pierpaolo.dao;

import pierpaolo.entities.Location;
import pierpaolo.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em; // Tutti i metodi qua sotto avranno bisogno dell'EntityManager poichè dovranno interagire col DB

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione di " + partecipazione.getPersona().getNome() + " generato!");
    }

    public Partecipazione findById(long id){
        //public Evento perchè mi ritorna l'EVENTO!!!
        // SELECT * FROM students WHERE id = 1
        return em.find(Partecipazione.class, id);
        // Primo parametro è l'Entity, secondo l'id da ricercare
    }

    public void findByIdAndDelete(long id){
        // 1. Cerco l'evento in db
        Partecipazione found = this.findById(id);
        if(found != null){
            // 2.0 Ho bisogno di una transazione (mi viene fornita dall'EntityManager
            EntityTransaction transaction = em.getTransaction();
            // 2.1 Inizio la transazione
            transaction.begin();
            // 2.2 Rimuovo l'oggetto dal Persistence Context (in questo momento non sarà ancora rimosso da DB)
            em.remove(found);
            // 2.3. Concludo la transazione con la rimozione effettiva di una riga dalla tabella students
            transaction.commit();
            System.out.println("Partecipazione di " + found.getPersona() + " cancellato!");
        } else {
            System.out.println("Partecipazione con id " + id + " non è stato trovato");
        }
    }

}
