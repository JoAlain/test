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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alain
 */
@Entity
@XmlRootElement
@NamedQueries({@NamedQuery(name = "EntityQuestions.findAll", query = "SELECT c FROM EntityQuestions c")
    ,@NamedQuery(name = "EntityQuestions.findByID", query = "SELECT c FROM EntityQuestions c where c.id = :id")})
public class EntityQuestions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private QCM qcm;
    
    @OneToMany (mappedBy = "question")
    private List<ReponseEtudiant> reponse;
    
    private String questions;

    public EntityQuestions(QCM qcm, String questions) {
        this.qcm = qcm;
        this.questions = questions;
    }

    public EntityQuestions(String questions) {
        this.questions = questions;
    }

    public EntityQuestions() {
    }

    public QCM getQcm() {
        return qcm;
    }

    public void setQcm(QCM qcm) {
        this.qcm = qcm;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public List<EntityResponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<EntityResponse> reponses) {
        this.reponses = reponses;
    }
    
    @OneToMany (mappedBy = "question")
    private List<EntityResponse> reponses;
    
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
        if (!(object instanceof EntityQuestions)) {
            return false;
        }
        EntityQuestions other = (EntityQuestions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EntityQuestions[ id=" + id + " ]";
    }
    
}
