/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Licence implements Comparable{

    private Personne possesseur;

    private String numero;

    private LocalDate delivrance;

    private Club club;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
         LocalDate fin = delivrance.plus(1, ChronoUnit.YEARS);

         return d.isBefore(fin) && d.isAfter(delivrance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Licence licence = (Licence) o;
        return possesseur.equals(licence.possesseur) && numero.equals(licence.numero) && delivrance.equals(licence.delivrance) && club.equals(licence.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(possesseur, numero, delivrance, club);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
