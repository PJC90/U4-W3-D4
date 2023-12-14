package pierpaolo.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@DiscriminatorValue("Gara Di Atletica")
public class GaraDiAtletica extends Evento{
    @ManyToMany
    @JoinTable(name = "atletica_persone", joinColumns = @JoinColumn(name = "gara_id"),inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private List<Persona> setAtleti;
    @ManyToOne
    private Persona vincitore;

    public GaraDiAtletica() {
    }
    public GaraDiAtletica( Persona vincitore) {

        this.vincitore = vincitore;
    }

    public List<Persona> getSetAtleti() {
        return setAtleti;
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
                "setAtleti=" + setAtleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
