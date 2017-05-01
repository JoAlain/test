package entity;

import entity.EntityQuestions;
import entity.QCM;
import entity.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-30T22:41:29")
@StaticMetamodel(ReponseEtudiant.class)
public class ReponseEtudiant_ { 

    public static volatile SingularAttribute<ReponseEtudiant, Double> notes;
    public static volatile SingularAttribute<ReponseEtudiant, EntityQuestions> question;
    public static volatile SingularAttribute<ReponseEtudiant, QCM> qcm;
    public static volatile SingularAttribute<ReponseEtudiant, Long> id;
    public static volatile SingularAttribute<ReponseEtudiant, Utilisateur> etudiant;

}