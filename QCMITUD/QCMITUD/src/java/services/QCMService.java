/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Alain
 */
@Named(value = "documentService")
@ApplicationScoped
public class QCMService implements Serializable, Comparable<QCMService>{
    
    private int idqcm;
    private String titre;
    private int idquestion;
    private String questions;
    private int idreponse;
    private String reponse;

    public QCMService(int idqcm, String titre, int idquestion, String questions, int idreponse, String reponse) {
        this.idqcm = idqcm;
        this.titre = titre;
        this.idquestion = idquestion;
        this.questions = questions;
        this.idreponse = idreponse;
        this.reponse = reponse;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titre == null) ? 0 : titre.hashCode());
        result = prime * result + ((questions == null) ? 0 : questions.hashCode());
        result = prime * result + ((reponse == null) ? 0 : reponse.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QCMService other = (QCMService) obj;
        if (titre == null) {
            if (other.titre != null)
                return false;
        } else if (!titre.equals(other.titre))
            return false;
        if (questions == null) {
            if (other.questions != null)
                return false;
        } else if (!questions.equals(other.questions))
            return false;
        if (reponse == null) {
            if (other.reponse != null)
                return false;
        } else if (!reponse.equals(other.reponse))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return titre;
    }
 
    public int compareTo(QCMService document) {
        return this.getTitre().compareTo(document.getTitre());
    }
    
    public int getIdqcm() {
        return idqcm;
    }

    public void setIdqcm(int idqcm) {
        this.idqcm = idqcm;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getIdquestion() {
        return idquestion;
    }

    public void setIdquestion(int idquestion) {
        this.idquestion = idquestion;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public int getIdreponse() {
        return idreponse;
    }

    public void setIdreponse(int idreponse) {
        this.idreponse = idreponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    
    
}
