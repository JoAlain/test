/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alain
 */
@Entity
@XmlRootElement
@NamedQueries({@NamedQuery(name = "QCM.findAll", query = "SELECT c from QCM c")
        ,@NamedQuery(name = "QCM.findByID", query = "SELECT c FROM QCM c where c.id = :id")})
public class QCM implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;

    public QCM(String libelle, String description, Utilisateur enseignant) {
        this.libelle = libelle;
        this.description = description;
        this.enseignant = enseignant;
    }

    public QCM() {
    }
    
    private String libelle;
    private String description;
    
    @OneToMany (mappedBy = "qcm")
    private List<EntityQuestions> questions;
    
    @OneToMany (mappedBy = "qcm")
    private List<ReponseEtudiant> qcm;
    
    @ManyToOne
    private Utilisateur enseignant;

    public List<EntityQuestions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<EntityQuestions> questions) {
        this.questions = questions;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Utilisateur enseignant) {
        this.enseignant = enseignant;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QCM)) {
            return false;
        }
        QCM other = (QCM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.QCM[ id=" + id + " ]";
    }
    
}
