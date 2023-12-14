package pierpaolo.entities;



import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String città;

    @OneToOne
    @JoinColumn(name = "evento_id", nullable = false, unique = true)
    private Evento evento;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Location() {

    }
    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +

                '}';
    }
}
