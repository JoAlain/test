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
@NamedQueries({@NamedQuery(name = "Utilisateur.findAll", query = "SELECT c FROM Utilisateur c")
    ,@NamedQuery(name = "Utilisateur.findByID", query = "SELECT c FROM Utilisateur c where c.id = :id")
    ,@NamedQuery(name = "Utilisateur.findUserByLoginPass", query = "SELECT c FROM Utilisateur c where c.pseudo = :pseudo and c.password = :password")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pseudo;
    private String password;
    private String typeuser;
    private String nom;
    private String prenom;
    private String adresse;
    private String datenaissance;
    private String telephone;
    
    @OneToMany (mappedBy = "enseignant")
    private List<QCM> qcm;

    
    @OneToMany (mappedBy = "etudiant")
    private List<ReponseEtudiant> reponse;
    
    public List<QCM> getQcm() {
        return qcm;
    }

    public void setQcm(List<QCM> qcm) {
        this.qcm = qcm;
    }
    
    public Utilisateur() {
    }

    public Utilisateur(String pseudo, String password, String typeuser, String nom) {
        this.pseudo = pseudo;
        this.password = password;
        this.typeuser = typeuser;
        this.nom = nom;
    }

    public Utilisateur(String pseudo, String password, String typeuser, String nom, String prenom, String adresse, String datenaissance, String telephone) {
        this.pseudo = pseudo;
        this.password = password;
        this.typeuser = typeuser;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.datenaissance = datenaissance;
        this.telephone = telephone;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Utilisateur[ id=" + id + " ]";
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeuser() {
        return typeuser;
    }

    public void setTypeuser(String typeuser) {
        this.typeuser = typeuser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
}
