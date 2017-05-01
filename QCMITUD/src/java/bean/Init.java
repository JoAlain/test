/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.EntityQuestions;
import entity.EntityResponse;
import entity.QCM;
import entity.Utilisateur;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Alain
 */
@Singleton
@LocalBean
@Startup
public class Init {

    @EJB
    private QuestionnaireBean bean;

    @EJB
    private UtilisateurBean beanUser;

    @EJB
    private QuestionnaireBean qcmBean;
    
    @EJB
    private QuestionBean questionBean;
    
    @EJB
    private ReponseBean reponseBean;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    public void initData() {

        System.out.println(" ****************** initialisation des données *************************** ");

        Utilisateur utilisateur1 = new Utilisateur("alain", "alain", "etudiant", "TIARILALA", "Joë Alain", "lot IB 365 bis Andoharanofotsy", "01/01/1995", "+261 3 45 03 17 63");
        Utilisateur utilisateur2 = new Utilisateur("doudou", "doudou", "etudiant", "TIARILALA", "Doudou", "lot MB 143 bis Mahabo", "02/02/1993", "+261 3 45 03 17 62");
        Utilisateur utilisateur3 = new Utilisateur("narindra", "narindra", "etudiant", "RANDRIAMIARINTSOA", "Narindra", "Soamanandrariny", "03/03/1994", "+261 3 44 50 09 03");
        Utilisateur utilisateur4 = new Utilisateur("richard", "richard", "enseignant", "RICHARD", "GRIN", "Parc Valrose 06108 Nice Cedex 2", "05/05/1970", "(33) 4 92 07 66 53 (04 92 07 66 53)");

        beanUser.createUtilisateur(utilisateur1);
        beanUser.createUtilisateur(utilisateur2);
        beanUser.createUtilisateur(utilisateur3);
        beanUser.createUtilisateur(utilisateur4);

        QCM qcm = new QCM("Java EE", "Question pour EJB", utilisateur4);
        qcmBean.createQCM(qcm);
        
        EntityQuestions question1 = new EntityQuestions(qcm, "Si on change de serveur d’application Java EE il faut récrire une petite partie des EJB");
        EntityQuestions question5 = new EntityQuestions(qcm, "Les EJB servent à effectuer les traitements dont les pages JSF ont besoin");
        EntityQuestions question4 = new EntityQuestions(qcm, "L’annotation pour les EJB qui peuvent être utilisables à distance est");
        EntityQuestions question3 = new EntityQuestions(qcm, "Si on veut qu’une méthode soit exécutée à la création d’un EJB il faut l’annoter par");
        EntityQuestions question2 = new EntityQuestions(qcm, "Vous voulez récupérer les informations qu’une base de données possède sur un étudiant. Quel type d’EJB allezvous utiliser ?");
        
        questionBean.createQuestions(question1);
        questionBean.createQuestions(question2);
        questionBean.createQuestions(question3);
        questionBean.createQuestions(question4);
        questionBean.createQuestions(question5);
        
        EntityResponse reponse1 = new EntityResponse("EJB session sans état", true, 1, question2);
        EntityResponse reponse2 = new EntityResponse("EJB session avec état", true, 1, question2);
        EntityResponse reponse3 = new EntityResponse("Singleton", false, 0, question2);
        EntityResponse reponse4 = new EntityResponse("Mbd", false, 0, question2);
        
        reponseBean.createResponse(reponse1);
        reponseBean.createResponse(reponse2);
        reponseBean.createResponse(reponse3);
        reponseBean.createResponse(reponse4);
        
        EntityResponse reponse5 = new EntityResponse("@Init", false, 0, question3);
        EntityResponse reponse6 = new EntityResponse("@PostCreate", false, 0, question3);
        EntityResponse reponse7 = new EntityResponse("@PostConstruct", true, 1, question3);
        
        reponseBean.createResponse(reponse5);
        reponseBean.createResponse(reponse6);
        reponseBean.createResponse(reponse7);
        
        EntityResponse reponse8 = new EntityResponse("@Network", false, 0, question4);
        EntityResponse reponse9 = new EntityResponse("@Remote", true, 1, question4);
        EntityResponse reponse10 = new EntityResponse("@Distant", false, 0, question4);
        
        reponseBean.createResponse(reponse8);
        reponseBean.createResponse(reponse9);
        reponseBean.createResponse(reponse10);
        
        //question5
        
        EntityResponse reponse11 = new EntityResponse("Vrai", false, 0, question5);
        EntityResponse reponse12 = new EntityResponse("Faux", true, 1, question5);
        
        reponseBean.createResponse(reponse11);
        reponseBean.createResponse(reponse12);
        
        // question1
        EntityResponse reponse13 = new EntityResponse("Vrai", false, 0, question3);
        EntityResponse reponse14 = new EntityResponse("Faux", true, 1, question3);
        
        
        reponseBean.createResponse(reponse13);
        reponseBean.createResponse(reponse14);
        
        System.out.println("******************* initialisation des données terminé ************************* ");

    }
}
