package entity;

import entity.EntityQuestions;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-30T22:41:29")
@StaticMetamodel(EntityResponse.class)
public class EntityResponse_ { 

    public static volatile SingularAttribute<EntityResponse, String> reponse;
    public static volatile SingularAttribute<EntityResponse, Double> note;
    public static volatile SingularAttribute<EntityResponse, EntityQuestions> question;
    public static volatile SingularAttribute<EntityResponse, Long> id;
    public static volatile SingularAttribute<EntityResponse, Boolean> istrue;

}