package pierpaolo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("Gara Di Atletica")
public class GaraDiAtletica extends Evento{
    @ManyToMany
    @JoinTable(name = "atletica_persone", joinColumns = @JoinColumn(name = "gara_id"),inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<Persona> atleti;
    @ManyToOne
    @JoinColumn(name = "vincitore")
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, EventoType tipoEvento, int numeroMassimoPartecipanti) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
