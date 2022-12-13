package FFSSMM;

import FFSSM.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MoniteurTest {


    Moniteur untel, president;
    Club c1 ;
    LocalDate d1 , d2 , d3 , d4 ;

    Licence l1;

    Personne TroisTel;

    Plongeur QuatreTel;

    Site site;

    @BeforeEach
public void SetUp(){

        president = new Moniteur("100", "Deuxtel", "Jean","8 rue Firmin ","0608953004",
                LocalDate.of(1985,8,20),777,10 );

        untel = new Moniteur("123", "Untel", "Georges","3 rue Firmin Oulès","060000000004",
                LocalDate.of(1990,12,15),456,9);

        TroisTel = new Personne("99", "Troistel", "Jeanne","9 rue Firmin ","0608953774",
                LocalDate.of(1984,6,21));

        QuatreTel = new Plongeur("98", "Quatretel", "Luc","2 rue Firmin ","060894004",
                LocalDate.of(1983,3,2),10 );



        c1 = new Club(president,"ISIS","060604040502");
        site = new Site("Les gorges","gorge");
        d1 = LocalDate.of(2022,12,15);
        d2 = LocalDate.of(2023,1,15);
        d3 = LocalDate.of(2023,2,13);
        d4 = LocalDate.of(2023,3,12);








    }

    @Test
    void TestMoniteur() {

        untel.nouvelleEmbauche(c1,d1);


        assertEquals(1,untel.emplois().size(),
                "une embauche crée une historique d'emploi");

        assertEquals(LocalDate.of(2022,12,15), untel.emplois().get(0).getDebut(),
                "Les dates de début doivent correspondre'");

        untel.terminerEmbauche( d2);


        assertEquals(Optional.empty(), untel.employeurActuel(),
                "Il n'a plus d'employeur");

        




    }


    @Test
    void TestLicence() {

        l1=new Licence(TroisTel,"123456789", d1,c1 );

        assertTrue(l1.estValide(d2), "licence valide 1 mois après");
        assertFalse(l1.estValide(LocalDate.of(2023,12,16)), "licence non valide 1 an après");



    }

    @Test
    void TestPlongee() {

        Plongee p = new Plongee(site,untel,d2,5,3);
        assertFalse(p.estConforme(), "une plongée sans participant n'est pas conforme");



        QuatreTel.ajouteLicence("123456789", d1,c1);
        p.ajouteParticipant(QuatreTel);
        assertTrue(p.estConforme(), "une plongée avec participant avec licence est  conforme");

        Plongee p2 = new Plongee(site,untel,d2.plusYears(2),5,3);
        p2.ajouteParticipant(QuatreTel);
        assertFalse(p.estConforme(), "une plongée avec participant ayant une licence expirée n'est pas conforme");








    }
}
