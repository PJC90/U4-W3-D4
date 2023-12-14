package pierpaolo.entities;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne//  una persona può avere più partecipazioni
    @JoinColumn(name = "partecipante_id")// Join Column identifica dove posizioniamo la chiave esterna
    private Persona persona;
    @ManyToOne//  un evento può avere più partecipazioni
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private StatoType tipoStato;

    public Partecipazione() {
    }
    public Partecipazione(Persona persona, Evento evento) {
        this.persona = persona;
        this.evento = evento;
        this.tipoStato = StatoType.DA_CONFERMARE;
    }

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoType getTipoStato() {
        return tipoStato;
    }

    public void setTipoStato(StatoType tipoStato) {
        this.tipoStato = tipoStato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", tipoStato=" + tipoStato +
                '}';
    }
}
