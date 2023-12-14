package pierpaolo.entities;

import java.util.List;

public class GaraDiAtletica extends Evento{
    private List<Persona> setAtleti;
    private Persona vincitore;

    public GaraDiAtletica() {
    }
    public GaraDiAtletica(List<Persona> setAtleti, Persona vincitore) {
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    public List<Persona> getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(List<Persona> setAtleti) {
        this.setAtleti = setAtleti;
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
