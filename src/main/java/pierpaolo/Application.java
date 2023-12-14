package pierpaolo;

import com.github.javafaker.Faker;
import pierpaolo.dao.EventoDAO;
import pierpaolo.dao.LocationDAO;
import pierpaolo.dao.PartecipazioneDAO;
import pierpaolo.dao.PersonaDAO;
import pierpaolo.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2jpa");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO eventDao = new EventoDAO(em);
        LocationDAO locationDao = new LocationDAO(em);
        PartecipazioneDAO partecipazDao = new PartecipazioneDAO(em);
        PersonaDAO personaDao = new PersonaDAO(em);

        Faker fk = new Faker(Locale.ITALY);

        Evento ev1 = new Evento("Corso",LocalDate.now(),"Java",EventoType.PRIVATO,20);
//        eventDao.save(ev1);
        Location loc1 = new Location("ciao", "we");
        loc1.setEvento(ev1);
        locationDao.save(loc1);


        // ---------------A fine programma è sempre bene ricordarsi di chiudere entitymanager e entitymanagerfactory
        em.close();
        emf.close();
    }

}
