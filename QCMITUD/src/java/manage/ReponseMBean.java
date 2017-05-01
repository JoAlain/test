/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import bean.ReponseBean;
import entity.EntityResponse;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Alain
 */
@Named(value = "reponseMBean")
@Dependent
public class ReponseMBean {

    private String idquestion;
    /**
     * Creates a new instance of ReponseMBean
     */
    public ReponseMBean() {
    }
    
    private List<EntityResponse> listReponse;
    @EJB
    private ReponseBean beanReponse;
    
    public List<EntityResponse> getAllReponse() {
        if (listReponse == null) {
            listReponse = beanReponse.getAllResponses();
        }
        return listReponse;
    }
    
    public List<EntityResponse> getAllReponse(String idquestion) {
        if (listReponse == null) {
            listReponse = beanReponse.getAllResponses(idquestion);
        }
        return listReponse;
    }
}
