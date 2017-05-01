/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import entity.QCM;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Alain
 */
@Named(value = "basicView")
@ViewScoped
public class BasicView implements Serializable{

    /**
     * Creates a new instance of BasicView
     */
    public BasicView() {
    }
 
    private TreeNode root;
     
    private QCM selectedDocument;
         
    @ManagedProperty("#{questionnaireMBean}")
    private QuestionnaireMBean service;
     
    @PostConstruct
    public void init() {
        root = service.createListeQuestionnaire();
    }
 
    public TreeNode getRoot() {
        return root;
    }
 
    public void setService(QuestionnaireMBean service) {
        this.service = service;
    }
 
    public QCM getSelectedDocument() {
        return selectedDocument;
    }
 
    public void setSelectedDocument(QCM selectedDocument) {
        this.selectedDocument = selectedDocument;
    }
    
}
