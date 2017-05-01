package entity;

import entity.EntityResponse;
import entity.QCM;
import entity.ReponseEtudiant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-30T22:41:29")
@StaticMetamodel(EntityQuestions.class)
public class EntityQuestions_ { 

    public static volatile ListAttribute<EntityQuestions, ReponseEtudiant> reponse;
    public static volatile SingularAttribute<EntityQuestions, String> questions;
    public static volatile SingularAttribute<EntityQuestions, QCM> qcm;
    public static volatile SingularAttribute<EntityQuestions, Long> id;
    public static volatile ListAttribute<EntityQuestions, EntityResponse> reponses;

}