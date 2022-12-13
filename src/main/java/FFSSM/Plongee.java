/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	public LocalDate date;

	public int profondeur;

	public int duree;

	private final List<Plongeur> listePlongeurs;

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
		this.listePlongeurs=new ArrayList<>();
	}

	public void ajouteParticipant(Plongeur participant) {
		listePlongeurs.add(participant);
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {

		boolean estConforme = listePlongeurs.size() != 0;


		for (Plongeur plongeur : listePlongeurs){


				if (!plongeur.derniereLicence().estValide(this.date)){
					estConforme=false;

				}

		}

		return estConforme;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Plongee plongee = (Plongee) o;
		return profondeur == plongee.profondeur && duree == plongee.duree && lieu.equals(plongee.lieu) && chefDePalanquee.equals(plongee.chefDePalanquee) && date.equals(plongee.date) && listePlongeurs.equals(plongee.listePlongeurs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lieu, chefDePalanquee, date, profondeur, duree, listePlongeurs);
	}
}
