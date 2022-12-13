package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Plongeur extends Personne {

    private int niveau;
    private TreeSet<Licence> listeLicence;




    private GroupeSanguin groupeSanguin;


    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.listeLicence = new TreeSet<>();
    }

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupeSanguin) {
        this(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.groupeSanguin = groupeSanguin;
    }

    public Set<Licence> getLicences() {
        return listeLicence;
    }

    public GroupeSanguin getGroupeSanguin() {
        return groupeSanguin;
    }

    public int getNiveau() {
        return niveau;
    }

    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {
        this.listeLicence.add(new Licence(this, numero, delivrance, club));
    }
    public Licence derniereLicence() {

        return listeLicence.last();
    }


}
