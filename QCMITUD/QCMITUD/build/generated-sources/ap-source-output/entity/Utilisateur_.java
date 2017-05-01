package entity;

import entity.QCM;
import entity.ReponseEtudiant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-30T22:41:29")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile ListAttribute<Utilisateur, ReponseEtudiant> reponse;
    public static volatile SingularAttribute<Utilisateur, String> password;
    public static volatile SingularAttribute<Utilisateur, String> datenaissance;
    public static volatile SingularAttribute<Utilisateur, String> adresse;
    public static volatile SingularAttribute<Utilisateur, String> typeuser;
    public static volatile SingularAttribute<Utilisateur, String> telephone;
    public static volatile ListAttribute<Utilisateur, QCM> qcm;
    public static volatile SingularAttribute<Utilisateur, Long> id;
    public static volatile SingularAttribute<Utilisateur, String> pseudo;
    public static volatile SingularAttribute<Utilisateur, String> nom;
    public static volatile SingularAttribute<Utilisateur, String> prenom;

}