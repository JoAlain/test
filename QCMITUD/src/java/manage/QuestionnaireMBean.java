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
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import services.QCMService;

/**
 *
 * @author Alain
 */
@Named(value = "questionnaireMBean")
@ViewScoped
public class QuestionnaireMBean implements Serializable {

    /**
     * Creates a new instance of QuestionnaireMBean
     */
    public QuestionnaireMBean() {
    }
    
    @EJB
    private QuestionnaireBean bean;
    
    @EJB
    private UtilisateurBean beanUser;
    
    private List<QCM> listQuestionnaire;

    public List<QCM> getAllQuestionnaire() {
        if (listQuestionnaire == null) {
            listQuestionnaire = bean.getAllQuestionnaire();
        }
        return listQuestionnaire;
    }
    
    public TreeNode createListeQuestionnaire() {
        
        List<QCM> qcmList = getAllQuestionnaire();
        TreeNode root = new DefaultTreeNode(new QCMService(0, "Files", 0, "-", 0, "Folder"), null);
        for(int i = 0; i < qcmList.size(); i++){
            TreeNode documents = new DefaultTreeNode(new QCMService(qcmList.get(i).getId().intValue(), qcmList.get(i).getLibelle(), 0, "-", 0, "-"), root);
        }
        return root;
    }

    public List<QCM> getListQuestionnaire() {
        return listQuestionnaire;
    }

    public void setListQuestionnaire(List<QCM> listQuestionnaire) {
        this.listQuestionnaire = listQuestionnaire;
    }
    
    /*
    public void setSelectedItems(List<QCM> selectedCars) {
        this.listQuestionnaire = selectedCars;
    }
     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Item Selected", ((QCM) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Item Unselected", ((QCM) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/
    
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
