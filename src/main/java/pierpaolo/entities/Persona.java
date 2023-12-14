package pierpaolo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private Sessotype tipoSesso;
    @OneToMany(mappedBy = "persona") // nella classe Persona  --->private Persona persona;
    private List<Partecipazione> listaPartecipazioni;

    public Persona() {}
    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sessotype tipoSesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.tipoSesso = tipoSesso;
//        this.listaPartecipazioni = listaPartecipazioni; NON HA SENSO creare una listaPartecipazioni in Persona!!!
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Sessotype getTipoSesso() {
        return tipoSesso;
    }

    public void setTipoSesso(Sessotype tipoSesso) {
        this.tipoSesso = tipoSesso;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", tipoSesso=" + tipoSesso +

                '}';
    }
}
