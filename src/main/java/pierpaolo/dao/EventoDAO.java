package pierpaolo.dao;

import pierpaolo.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em; // Tutti i metodi qua sotto avranno bisogno dell'EntityManager poichè dovranno interagire col DB

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " generato!");
    }

    public Evento findById(long id){
        //public Evento perchè mi ritorna l'EVENTO!!!
        // SELECT * FROM students WHERE id = 1
        return em.find(Evento.class, id);
        // Primo parametro è l'Entity, secondo l'id da ricercare
    }

    public void findByIdAndDelete(long id){
        // 1. Cerco l'evento in db
        Evento found = this.findById(id);
        if(found != null){
            // 2.0 Ho bisogno di una transazione (mi viene fornita dall'EntityManager
            EntityTransaction transaction = em.getTransaction();
            // 2.1 Inizio la transazione
            transaction.begin();
            // 2.2 Rimuovo l'oggetto dal Persistence Context (in questo momento non sarà ancora rimosso da DB)
            em.remove(found);
            // 2.3. Concludo la transazione con la rimozione effettiva di una riga dalla tabella students
            transaction.commit();
            System.out.println("Evento " + found.getTitolo() + " cancellato!");
        } else {
            System.out.println("L'Evento con id " + id + " non è stato trovato");
        }
    }

}
