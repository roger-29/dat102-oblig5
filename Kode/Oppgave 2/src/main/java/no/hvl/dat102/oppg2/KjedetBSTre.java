package no.hvl.dat102.oppg2;

import no.hvl.dat102.oppg2.BSTreADT;
import java.util.*;

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

	private int antall;
	private BinaerTreNode<T> rot;

	/**
	 * Oppretter et tomt binært søketre.
	 */
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/**
	 * Oppretter et binært søketre med en node
	 * @param element Element som skal være i noden.
	 */
	public KjedetBSTre(T element) {
		antall = 1;
		rot = new BinaerTreNode<T>(element);
	}

	public int antall() {
		return antall;
	}

	public boolean erTom() {
		return (antall == 0);
	}

	public void leggTilAlle(T ... a) {
		for (T i : a) {
			leggTil(i);
		}
	}

	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		if (p == null) {
			return new BinaerTreNode<T>(element);
		}

		int n = element.compareTo(p.getElement());

		if (n < 0) {
			p.setVenstre(leggTilRek(p.getVenstre(), element));
		} else {
			p.setHoyre(leggTilRek(p.getHoyre(), element));
		}

		return p;
	}

	/**
	 * Legger det spesifiserte elementet på passende plass i dette binære 
	 * søketreet. Like elementer blir lagt til høyre.
	 */
	public void leggTilIterativ(T element) {
		BinaerTreNode<T> temp = new BinaerTreNode<T>(element);

		if (erTom()) {
			rot = temp;
			antall++;
			return;
		}

		BinaerTreNode<T> aktuell = rot;
		boolean lagtTil = false;

		while (!lagtTil) {
			if (element.compareTo(aktuell.getElement()) < 0) {
				if (aktuell.getVenstre() == null) {
					aktuell.setVenstre(temp);
					lagtTil = true;
				} else {
					aktuell = aktuell.getVenstre();
				}
			}

			if (element.compareTo(aktuell.getElement()) >= 0) {
				if (aktuell.getHoyre() == null) {
					aktuell.setHoyre(temp);
					lagtTil = true;
				} else {
					aktuell = aktuell.getHoyre();
				}
			}
		}

		antall++;
	}

	public T fjern(T element) {
		return element;
	}

	// Fjerner noden med minste verdi fra dette binære søketreet.
	public T fjernMin() {
		T resultat = null;

		if (!erTom()) {
			if (rot.getVenstre() == null) {
				resultat = rot.getElement();
				rot = rot.getHoyre();
			} else {
				BinaerTreNode<T> foreldre = rot;
				BinaerTreNode<T> aktuell = rot.getVenstre();

				while (aktuell.getVenstre() != null) {
					foreldre = aktuell;
					aktuell = aktuell.getVenstre();
				}

				resultat = aktuell.getElement();
				foreldre.setVenstre(aktuell.getHoyre());
			}

			antall--;
		}

		return resultat;
	}

	// Fjerner noden med største verdi fra dette binære søketreet.
	public T fjernMaks() {
		T resultat = null;

		if (!erTom()) {

			if (rot.getHoyre() == null) {
				resultat = rot.getElement();
				rot = rot.getVenstre();
			} else {
				BinaerTreNode<T> foreldre = rot;
				BinaerTreNode<T> aktuell = rot.getHoyre();
				while (aktuell.getHoyre() != null) {
					foreldre = aktuell;
					aktuell = aktuell.getHoyre();
				}

				resultat = aktuell.getElement();
				foreldre.setHoyre(aktuell.getVenstre());
			}

			antall--;
		}

		return resultat;
	}

	// Returnerer det minste elementet i dette binære søketreet.
	public T finnMin() {

		T resultat = null;

		if (!erTom()) {
			BinaerTreNode<T> aktuell = rot;

			while (aktuell.getVenstre() != null)
				aktuell = aktuell.getVenstre();

			resultat = aktuell.getElement();
		}

		return resultat;
	}

	/******************************************************************
	 Returnerer det største elementet i dette binære søketreet. 
	******************************************************************/
	public T finnMaks() {
		T resultat = null;

		if (!erTom()) {

			BinaerTreNode<T> aktuell = rot;

			while (aktuell.getHoyre() != null)
				aktuell = aktuell.getHoyre();

			resultat = aktuell.getElement();
		}

		return resultat;
	}//

	/*******************************************************************************
	 Returnerer en referanse til det spesifiserte elementet hvis det finst
	 i dette BS-treet, null elles. Bruk av rekursjon
	/ ******************************************************************************/
	public T finn(T element) {
		// Søk med rekursiv hjelpemetode 

		return finnRek(element, rot);
	}

	// Den rekursive hjelpemetoden for søking
	private T finnRek(T element, BinaerTreNode<T> p) {
		T svar = null;
		if (p != null) {
			if (element.compareTo(p.getElement()) == 0) { // I rot
				svar = p.getElement();
			} else if (element.compareTo(p.getElement()) < 0) {
				svar = finnRek(element, p.getVenstre()); // I venstre u.t.
			} else {
				svar = finnRek(element, p.getHoyre()); // I h�gre u.t.
			}
		}
		return svar;
	}

	/************************************************************************
	 Returnerer en referanse til det spesifiserte elementet hvis det fins
	 i dette BS-treet, null ellers. Uten bruk av rekursjon.
	/ ************************************************************************/
	public T finnIterativ(T element) {
		// S�k med while-setning

		BinaerTreNode<T> p = rot;
		T svar = null;
		while (p != null && svar == null) {
			if (element.compareTo(p.getElement()) < 0)
				p = p.getVenstre();
			else if (element.compareTo(p.getElement()) > 0)
				p = p.getHoyre();
			else
				svar = p.getElement();
		}
		return svar;
	}

	public int hoyde() {
		return hoyde(rot);
	}

	private int hoyde(BinaerTreNode<T> n) {
		return n == null 
			? -1 
			: 1 + Math.max(hoyde(n.getVenstre()), hoyde(n.getHoyre()));
	}

	public Iterator<T> iterator() {
		return new InordenIterator(rot);
	}

	//*****************************************************************
	// Gjennomgår treet i preorden
	//*****************************************************************

	public void visPreorden() {
		visRekPreorden(rot);
		System.out.println();
	}

	private void visRekPreorden(BinaerTreNode<T> p) {
		if (p != null) {
			System.out.print(p.getElement() + " ");
			visRekPreorden(p.getVenstre());
			visRekPreorden(p.getHoyre());
		}
	}

	//*****************************************************************
	// Gjennomgår treet i inorden
	//*****************************************************************

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p == null) {
			return;
		}
		
		visInorden(p.getVenstre());
		System.out.print(p.getElement() + " ");
		visInorden(p.getHoyre());
	}

	public void skrivVerdier(T nedre, T ovre) {
		skrivVerdierRek(rot, nedre, ovre);
	}

	private void skrivVerdierRek(BinaerTreNode<T> t, T min, T maks) {
		if (t == null) {
			return;
		}

		if (t.getElement().compareTo(min) > 0) {
			skrivVerdierRek(t.getVenstre(), min, maks);
		}

		if ((t.getElement().compareTo(min) >= 0) && (t.getElement().compareTo(maks) <= 0)) {
			System.out.print(t.getElement() + " ");
		}

		if (t.getElement().compareTo(maks) < 0) {
			skrivVerdierRek(t.getHoyre(), min, maks);
		}
	}
}
