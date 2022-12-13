/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;

    private List<Embauche> listeEmbauche;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.numeroDiplome = numeroDiplome;
        listeEmbauche=new ArrayList<>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {

        int dernierIndex =listeEmbauche.size() - 1;
    return  Optional.ofNullable(listeEmbauche.get(dernierIndex).getEmployeur());


    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        listeEmbauche.add(new Embauche(debutNouvelle, this, employeur))   ;
    }

    public List<Embauche> emplois() {
        return listeEmbauche ;
    }

    public void terminerEmbauche (LocalDate fin){
        listeEmbauche.get(listeEmbauche.size()-1).terminer(fin);
    }

}
