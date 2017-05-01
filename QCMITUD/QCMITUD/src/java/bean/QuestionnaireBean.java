/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.QCM;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
public class QuestionnaireBean {

    @PersistenceContext(unitName = "QCMITUDPU")
    private EntityManager em;

    public void persist(QCM object) {
        em.persist(object);
    }

    public void createQCM(QCM c) {
        em.persist(c);
    }
    
    public QCM update(QCM qcm) {
        return em.merge(qcm);
    }
    
    public List<QCM> getAllQuestionnaire() {
        Query query = em.createNamedQuery("QCM.findAll");
        return query.getResultList();
    }
    
    public QCM getQuestionnaire(int idQcm){
        return em.find(QCM.class, idQcm);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
