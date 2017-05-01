/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.EntityQuestions;
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
public class QuestionBean {

    @PersistenceContext(unitName = "QCMITUDPU")
    private EntityManager em;

    
    
    
    public void persist(EntityQuestions object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void createQuestions(EntityQuestions c) {
        em.persist(c);
    }
    
    public EntityQuestions update(EntityQuestions question) {
        return em.merge(question);
    }
    
    public List<EntityQuestions> getAllQuestions() {
        Query query = em.createNamedQuery("EntityQuestions.findAll");
        return query.getResultList();
    }
    
    public List<EntityQuestions> getAllQuestions(int idQCM){
        String requete = "SELECT c FROM EntityQuestions c where c.QCM_ID = "+idQCM;
        TypedQuery<EntityQuestions> query = em.createQuery(requete, EntityQuestions.class);
        return query.getResultList();
    }
    
}
