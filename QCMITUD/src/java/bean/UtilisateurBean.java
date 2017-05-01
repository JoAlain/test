/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Utilisateur;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alain
 */
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.ClientDataSource",
        name = "java:app/jdbc/qcmitud",
        serverName = "localhost",
        portNumber = 1527,
        user = "qcmitud", // nom et
        password = "qcmitud", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "qcmitud"
)
@Stateless
@LocalBean
public class UtilisateurBean {

    @PersistenceContext(unitName = "QCMITUDPU")
    private EntityManager em;

    public UtilisateurBean() {
    }

    
    public void persist(Utilisateur object) {
        em.persist(object);
    }

    public void createUtilisateur(Utilisateur c) {
        em.persist(c);
    }

    public Utilisateur update(Utilisateur user) {
        return em.merge(user);
    }

    public List<Utilisateur> getAllUsers() {
        Query query = em.createNamedQuery("Utilisateur.findAll");
        return query.getResultList();
    }

    public List<Utilisateur> getEtudiants() {
        String requete = "SELECT c FROM Utilisateur c where c.typeuser = 'etudiant'";
        //System.out.println("requete = " + requete);
        TypedQuery<Utilisateur> query = em.createQuery(requete, Utilisateur.class);
        return query.getResultList();
    }
    
    public List<Utilisateur> findUserById(String id) {
        String requete = "SELECT c FROM Utilisateur c where c.id = "+id;
        //System.out.println("requete = " + requete);
        TypedQuery<Utilisateur> query = em.createQuery(requete, Utilisateur.class);
        return query.getResultList();
    }

    public List<Utilisateur> getEnseignants() {
        String requete = "SELECT c FROM Utilisateur c where c.typeuser = 'enseignant'";
        //System.out.println("requete = " + requete);
        TypedQuery<Utilisateur> query = em.createQuery(requete, Utilisateur.class);
        return query.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public boolean login(String pseudo, String password) {
        String requete = "select c from Utilisateur c where c.pseudo='" + pseudo + "' and c.password='" + password + "'";
        TypedQuery<Utilisateur> query = em.createQuery(requete, Utilisateur.class);
        return !query.getResultList().isEmpty();
    }
}
