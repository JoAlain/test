/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import bean.QuestionnaireBean;
import bean.UtilisateurBean;
import entity.QCM;
import entity.Utilisateur;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Alain
 */
@Named(value = "questionnaireDetailsMBean")
@Dependent
public class QuestionnaireDetailsMBean implements Serializable{

    /**
     * Creates a new instance of QuestionnaireDetailsMBean
     */
    public QuestionnaireDetailsMBean() {
    }
    
    @EJB
    private QuestionnaireBean bean;
    
    @EJB
    private UtilisateurBean beanUser;
    
    private int idQcm;
    private QCM questionnaire;
    private Utilisateur users;

    public QuestionnaireBean getBean() {
        return bean;
    }

    public void setBean(QuestionnaireBean bean) {
        this.bean = bean;
    }

    public int getIdQcm() {
        return idQcm;
    }

    public void setIdQcm(int idQcm) {
        this.idQcm = idQcm;
    }

    public QCM getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(QCM questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Utilisateur getUsers() {
        return users;
    }

    public void setUsers(Utilisateur users) {
        this.users = users;
    }

    
    public QCM getDetails() {
        return questionnaire;
    }
    
    public Utilisateur getDetailsUsers() {
        return users;
    }
    
    public String update() {
        questionnaire = bean.update(questionnaire);
        return "QuestionnaireList";
    }

    public void loadCustomer() {
        this.questionnaire = bean.getQuestionnaire(idQcm);
    }
    
    public Converter getenseignantCodeConverter() {
        return new Converter() {
            
            @Override
            public Object getAsObject(FacesContext context, UIComponent component, String value) {
                return beanUser.findUserById(value);
            }

            @Override
            public String getAsString(FacesContext context, UIComponent component, Object value) {
                Utilisateur dc = (Utilisateur) value;
                return dc.getNom() + " " + dc.getPrenom();
            }
        };
    }
    
}
