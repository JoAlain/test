/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import bean.UtilisateurBean;
import entity.Util;
import entity.Utilisateur;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alain
 */
@Named(value = "userManager")
@ViewScoped
public class UserManager implements Serializable{

    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
    }

    @EJB
    private UtilisateurBean userManager;
    private List<Utilisateur> listUser;
    private List<Utilisateur> listEtudiant;
    private List<Utilisateur> listProfesseur;

    private String pseudo;
    private String password;

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

    public List<Utilisateur> getUsers() {
        if (listUser == null) {
            listUser = userManager.getAllUsers();
        }
        return listUser;
    }

    public List<Utilisateur> getEtudiants() {
        if (listEtudiant == null) {
            listEtudiant = userManager.getEtudiants();
        }
        //System.out.println("this.listEtudiant.size() = " + this.listEtudiant.size());
        return listEtudiant;
    }

    public List<Utilisateur> getEnseignants() {
        if (listProfesseur == null) {
            listProfesseur = userManager.getEnseignants();
        }
        //System.out.println("this.listProfesseur.size() = " + this.listProfesseur.size());
        return listProfesseur;
    }

    public String seConnecter() {
        boolean result = userManager.login(pseudo, password);
        if (result) {
            return "EtudiantList";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login ou mot de passe incorrect!", "Veuillez essayé à nouveau!"));
            return "index";
        }
    }
    
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "index";
   }
}
