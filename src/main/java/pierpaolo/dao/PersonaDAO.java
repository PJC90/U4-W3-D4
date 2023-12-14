package pierpaolo.dao;

import pierpaolo.entities.Location;
import pierpaolo.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em; // Tutti i metodi qua sotto avranno bisogno dell'EntityManager poichè dovranno interagire col DB

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("persona " + persona.getNome() + " generato!");
    }

    public Persona findById(long id){
        //public Evento perchè mi ritorna l'EVENTO!!!
        // SELECT * FROM students WHERE id = 1
        return em.find(Persona.class, id);
        // Primo parametro è l'Entity, secondo l'id da ricercare
    }

    public void findByIdAndDelete(long id){
        // 1. Cerco l'evento in db
        Persona found = this.findById(id);
        if(found != null){
            // 2.0 Ho bisogno di una transazione (mi viene fornita dall'EntityManager
            EntityTransaction transaction = em.getTransaction();
            // 2.1 Inizio la transazione
            transaction.begin();
            // 2.2 Rimuovo l'oggetto dal Persistence Context (in questo momento non sarà ancora rimosso da DB)
            em.remove(found);
            // 2.3. Concludo la transazione con la rimozione effettiva di una riga dalla tabella students
            transaction.commit();
            System.out.println("persona " + found + " cancellato!");
        } else {
            System.out.println("persona con id " + id + " non è stato trovato");
        }
    }
}
