package entity;

import entity.EntityQuestions;
import entity.ReponseEtudiant;
import entity.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-30T22:41:29")
@StaticMetamodel(QCM.class)
public class QCM_ { 

    public static volatile SingularAttribute<QCM, String> libelle;
    public static volatile ListAttribute<QCM, EntityQuestions> questions;
    public static volatile SingularAttribute<QCM, String> description;
    public static volatile ListAttribute<QCM, ReponseEtudiant> qcm;
    public static volatile SingularAttribute<QCM, Long> id;
    public static volatile SingularAttribute<QCM, Utilisateur> enseignant;

}