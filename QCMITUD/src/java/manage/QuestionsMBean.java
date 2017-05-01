/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import bean.QuestionBean;
import bean.QuestionnaireBean;
import entity.EntityQuestions;
import entity.QCM;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Alain
 */
@Named(value = "questionsMBean")
@ViewScoped
public class QuestionsMBean implements Serializable{

    /**
     * Creates a new instance of QuestionsMBean
     */
    @EJB
    private QuestionBean bean;
    private List<EntityQuestions> listQuestions;
    private String idqcm;

    public String getIdqcm() {
        return idqcm;
    }

    public void setIdqcm(String idqcm) {
        this.idqcm = idqcm;
    }
    
    public QuestionsMBean() {
    }
    
    public List<EntityQuestions> getAllQuestionnaire(int idQCM) {
        if (listQuestions == null) {
            listQuestions = bean.getAllQuestions(idQCM);
        }
        return listQuestions;
    }
    
    
    public List<EntityQuestions> getAllQuestionnaire() {
        if (listQuestions == null) {
            listQuestions = bean.getAllQuestions();
        }
        return listQuestions;
    }
    
}
