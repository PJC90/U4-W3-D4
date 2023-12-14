package pierpaolo.entities;

public class Concerto extends Evento{
    private Generetype genereTipo;
    private InStreamingType inStreamingTipo;

    public Concerto() {
    }
    public Concerto(Generetype genereTipo, InStreamingType inStreamingTipo) {
        this.genereTipo = genereTipo;
        this.inStreamingTipo = inStreamingTipo;
    }

    public Generetype getGenereTipo() {
        return genereTipo;
    }

    public void setGenereTipo(Generetype genereTipo) {
        this.genereTipo = genereTipo;
    }

    public InStreamingType getInStreamingTipo() {
        return inStreamingTipo;
    }

    public void setInStreamingTipo(InStreamingType inStreamingTipo) {
        this.inStreamingTipo = inStreamingTipo;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genereTipo=" + genereTipo +
                ", inStreamingTipo=" + inStreamingTipo +
                '}';
    }
}
