package no.hvl.dat102.oppg2;

import java.util.*;

public interface BSTreADT<T extends Comparable<T>> extends Iterable<T> {

	/**
	 * Sjekk antall noder i binærtre.
	 * @return antall noder i binærtre.
	 */
	public int antall();

	/**
	 * Sjekk om binærtre er tomt.
	 * @return sann hvis dette binære treet er tom og usann ellers.
	 */
	public boolean erTom();

	/**
	 * Legger det spesifiserte elementet på passende plass i BS-treet. 
	 * Like elementer blir lagt til høyre. Bruk av rekursiv hjelpemetode.
	 * @param element å legge til
	 */
	public void leggTil(T element);

	/**
	 * Finn et element i treet.
	 * @param element å finne
	 * @return referanse til element, eller null ved ikke-funn.
	 */
	public T finn(T element);

	/**
	 * Fjern et element fra treet.
	 * @param element å fjerne
	 * @return elementet hvis det finnes, null hvis ikke.
	 */
	public T fjern(T element);

	/**
	 * @return en inordeniterator
	 */
	public Iterator<T> iterator();
}
