package pierpaolo;

import pierpaolo.dao.EventoDAO;
import pierpaolo.dao.LocationDAO;
import pierpaolo.dao.PartecipazioneDAO;
import pierpaolo.dao.PersonaDAO;
import pierpaolo.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2jpa");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PartecipazioneDAO pd = new PartecipazioneDAO(em);
        PersonaDAO ps = new PersonaDAO(em);

        Evento battesimo = new Evento("Pippo", LocalDate.of(2023, 5,25),"Battesimo", EventoType.PUBBLICO,200);
        Evento cresima = new Evento("Aldo",LocalDate.of(2023,12,31),"Ci credo", EventoType.PRIVATO,3);
//--------------------------------------------------------------------------------------------------------------------SAVE
//        ed.save(battesimo);
//        ed.save(cresima);
// ----------------------------------------------------------------------------------------------FIND BY ID
        long id = 3;
        Evento battesimoFindById = ed.findById(id);
        if(battesimoFindById != null){
            System.out.println(battesimoFindById);
        } else {
            System.out.println("Evento di ID " + id + " non trovato");
        }
// ---------------------------------------------------------------------------------DELETE
        ed.findByIdAndDelete(14);

        //---------------------------------------------------------------------    1 to 1
//        Evento vm = new Evento("Svelti",LocalDate.of(2023,2,3),"Esaltiamoci",EventoType.PRIVATO,200);
//        ed.save(vm);

        Evento battesimoFromDb = ed.findById(18);
        System.out.println(battesimoFromDb);
        Location villaMaiella = new Location("Lions", "Guardiagrele", battesimoFromDb);
//        ld.save(villaMaiella);
        Evento cresimaID = ed.findById(12);
        Location vignale = new Location("Il Vignale", "Rapino", cresimaID);
//        ld.save(vignale);
        //---------------------------------------------------------------------    1 to Many
        Persona aldo = new Persona("Aldo", "Baglio","aldobaglio@gmail.com", LocalDate.of(1961,6,3),Sessotype.M);
//        ps.save(aldo);
        Persona aldoDB = ps.findById(25);
        Partecipazione part = new Partecipazione(aldoDB,battesimoFromDb);
//        pd.save(part);



        // ---------------A fine programma è sempre bene ricordarsi di chiudere entitymanager e entitymanagerfactory
        em.close();
        emf.close();
    }

}
