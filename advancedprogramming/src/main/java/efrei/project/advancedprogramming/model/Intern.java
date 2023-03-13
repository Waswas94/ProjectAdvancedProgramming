package efrei.project.advancedprogramming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "interns")
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "company" )
    private String company;

    @Column(name = "CdC" )
    private String cdc;

    @Column(name = "ficheVisite")
    private String ficheVisite;

    @Column(name = "ficheEvalEntr")
    private String ficheEvalEntr;

    @Column(name = "rapportRendu")
    private String rapportRendu;

    /*
    @Column(name = "debut")
    private Date debut;

    @Column(name = "fin")
    private Date fin;
*/
    @Column(name = "adresse")
    private String adresse;



    @Column(name = "promo")
    private String promo;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    public Intern() {

    }


    public Intern(Long id, String name, String email, String phone, String company, String cdc, String ficheVisite, String ficheEvalEntr, String rapportRendu, Date debut, Date fin, String adresse, String promo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.cdc = cdc;
        this.ficheVisite = ficheVisite;
        this.ficheEvalEntr = ficheEvalEntr;
        this.rapportRendu = rapportRendu;
        /*this.debut = debut;
        this.fin = fin;*/
        this.adresse = adresse;
        this.promo = promo;
    }

    public Intern(Long id, String name, String email, String phone, String company, String cdc, String ficheVisite, String ficheEvalEntr, String rapportRendu, Date debut, Date fin, String adresse, String promo, Tutor tutor) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.cdc = cdc;
        this.ficheVisite = ficheVisite;
        this.ficheEvalEntr = ficheEvalEntr;
        this.rapportRendu = rapportRendu;
        /*this.debut = debut;
        this.fin = fin;*/
        this.adresse = adresse;
        this.promo = promo;
        this.tutor = tutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public String getCdc() {
        return cdc;
    }

    public void setCdc(String cdc) {
        this.cdc = cdc;
    }

    public String getFicheVisite() {
        return ficheVisite;
    }

    public void setFicheVisite(String ficheVisite) {
        this.ficheVisite = ficheVisite;
    }

    public String getFicheEvalEntr() {
        return ficheEvalEntr;
    }

    public void setFicheEvalEntr(String ficheEvalEntr) {
        this.ficheEvalEntr = ficheEvalEntr;
    }

    public String getRapportRendu() {
        return rapportRendu;
    }

    public void setRapportRendu(String rapportRendu) {
        this.rapportRendu = rapportRendu;
    }
/*
    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
*/
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }
}