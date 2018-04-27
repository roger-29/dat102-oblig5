package no.hvl.dat102.oppg2;

import java.util.*;
import static no.hvl.dat102.oppg2.Utils.*;

public class Main {

	public static void main(String[] args) {
		clear();

		System.out.println("DAT102 | Obligatorisk innlevering 5 | Oppgave 2\n");

		mangeTre();

		System.out.println();
	}

	public static void liteTre() {

	}

	public static KjedetBSTre<Integer> genTree(int size, int max) {
		KjedetBSTre<Integer> bs = new KjedetBSTre<Integer>();
		Random r = new Random();

		for (int i = 0; i < size; i++) {
			Integer n = new Integer(r.nextInt(max));
			bs.leggTil(n);
		}
		
		return bs;
	}

	public static void mangeTre() {
		final int ANTALL_TRAER = 100;
		final int ANTALL_NODER = 1024;
		final int MAKS_VERDI = 512;

		ArrayList<Integer> hoyder = new ArrayList<Integer>();

		for (int i = 0; i < ANTALL_TRAER; i++) {
			KjedetBSTre<Integer> bs = genTree(ANTALL_NODER, MAKS_VERDI);

			hoyder.add(bs.hoyde());
		}

		System.out.println("Generert " + ANTALL_TRAER + " trær med " + ANTALL_NODER + " noder hver.\n");

		System.out.println("Minste teoretiske høyde: " + minTeoretiskHoyde(ANTALL_NODER));
		System.out.println("Største teoretiske høyde: " + (ANTALL_NODER - 1) + "\n");

		System.out.println("Minste høyde i kjøring: " + minVal(hoyder));
		System.out.println("Største høyde i kjøring: " + maxVal(hoyder));
		System.out.println("Gjennomsnittlig høyde i kjøring: " + avgVal(hoyder));

		genTree(100, 512).skrivVerdier(200, 300);
	}

	

	public static void klient() {

		//Lager BS-tre med 8 noder
		//Skriv ut i in-orden, dvs sortert
		//Sjekker om verdien 10 er i treet
		//

		final int ANTALL_NODER = 64;
		Random tilfeldig = new Random();

		KjedetBSTre<Integer> bs = new KjedetBSTre<Integer>();
		Integer resultat = null;

		for (int i = 0; i < ANTALL_NODER; i++) {
			Integer element = new Integer(tilfeldig.nextInt(512));
			bs.leggTil(element);
		}

		System.out.println("Treet med " + ANTALL_NODER + " noder.");

		bs.visInorden();

		Integer el = new Integer(10);

		System.out.println("Dybde: " + bs.hoyde());

		//************************************************************************

		resultat = bs.finn(el);
		if (resultat != null)
			System.out.println("\nSoekte etter " + el + " og fant " + resultat);
		else
			System.out.println("\nSoekte etter " + el + " som ikke var i treet ");

		//****************************************************************************

		resultat = bs.fjernMaks();
		if (resultat != null)
			System.out.println("\nFjernet stoerste " + resultat);
		else
			System.out.println("Treet er tomt");
		System.out.println("Treet er nå: ");
		bs.visInorden();

		//****************************************************************************
		resultat = bs.fjernMin();
		if (resultat != null)
			System.out.println("\nFjernet minste " + resultat);
		else
			System.out.println("Tree er tomt ");
		System.out.println("Treet er nå: ");
		bs.visInorden();
		//****************************************************************************

		resultat = bs.finnMin();
		if (resultat != null)
			System.out.println("\nMinste element " + resultat);
		else
			System.out.println("Treet er tomt");

		//******************************************************************************

		resultat = bs.finnMaks();
		if (resultat != null)
			System.out.println("\nStoerste element " + resultat);
		else
			System.out.println("Treet er tomt");

		//****************************************************************************

	}

	private static void clear() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}  
}
