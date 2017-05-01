/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.EntityResponse;
import entity.Utilisateur;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alain
 */
@DataSourceDefinition (
    className="org.apache.derby.jdbc.ClientDataSource",
    name="java:app/jdbc/qcmitud",
    serverName="localhost",
    portNumber=1527,
    user="qcmitud", // nom et
    password="qcmitud", // mot de passe que vous avez donnés lors de la création de la base de données
    databaseName="qcmitud"
)
@Stateless
@LocalBean
@Startup
public class ReponseBean {

    @PersistenceContext(unitName = "QCMITUDPU")
    private EntityManager em;

    public void persist(EntityResponse object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void createResponse(EntityResponse c) {
        em.persist(c);
    }
    
    public EntityResponse update(EntityResponse response) {
        return em.merge(response);
    }
    
    public List<EntityResponse> getAllResponses() {
        Query query = em.createNamedQuery("EntityResponse.findAll");
        return query.getResultList();
    }
    
    public List<EntityResponse> getAllResponses(String id) {
        String requete = "SELECT c FROM EntityResponse c where c.QUESTION_ID = "+id;
        //System.out.println("requete = " + requete);
        TypedQuery<EntityResponse> query = em.createQuery(requete, EntityResponse.class);
        return query.getResultList();
    }
}
