/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alain
 */

@Entity
@XmlRootElement
@NamedQueries({@NamedQuery(name = "EntityResponse.findAll", query = "SELECT c FROM EntityResponse c")
    ,@NamedQuery(name = "EntityResponse.findByID", query = "SELECT c FROM EntityResponse c where c.id = :id")})
public class EntityResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reponse;

    public EntityResponse(String reponse, boolean istrue, double note) {
        this.reponse = reponse;
        this.istrue = istrue;
        this.note = note;
    }

    public EntityResponse(String reponse, boolean istrue, double note, EntityQuestions question) {
        this.reponse = reponse;
        this.istrue = istrue;
        this.note = note;
        this.question = question;
    }
    
    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    private boolean istrue;
    private double note;
    
    @ManyToOne
    private EntityQuestions question;

    public boolean isIstrue() {
        return istrue;
    }

    public void setIstrue(boolean istrue) {
        this.istrue = istrue;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public EntityQuestions getQuestion() {
        return question;
    }

    public void setQuestion(EntityQuestions question) {
        this.question = question;
    }

    public EntityResponse() {
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
        if (!(object instanceof EntityResponse)) {
            return false;
        }
        EntityResponse other = (EntityResponse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EntityResponse[ id=" + id + " ]";
    }
    
}
