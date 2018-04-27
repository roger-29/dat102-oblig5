package no.hvl.dat102.oppg2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class KjedetBSTreADTTest {

	private KjedetBSTre<Integer> bs;

	// Testdata som legges inn i treet
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;

	// Testdata som ikke legges inn i treet
	private Integer e7 = 8;

	/**
	 * Opprett en tomt tre for hver test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public final void setup() throws Exception {
		bs = new KjedetBSTre<Integer>();
	}

	/**
	 * Tester finn
	 */
	@Test
	public final void erElementIBSTre() {
		bs.leggTilAlle(e1, e4, e0, e5, e2, e6, e3);

		assertEquals(e0, bs.finn(e0));
		assertEquals(e1, bs.finn(e1));
		assertEquals(e2, bs.finn(e2));
		assertEquals(e3, bs.finn(e3));
		assertEquals(e4, bs.finn(e4));
		assertEquals(e5, bs.finn(e5));
		assertEquals(e6, bs.finn(e6));

		assertEquals(null, bs.finn(e7));
	}

	/**
	 * Tester ordning ved å legge til elementer og fjerne minste
	 */
@Test
public final void erBSTreOrdnet() {
	bs.leggTilAlle(e3, e2, e4, e1, e5, e0, e6);

	assertEquals(e0, bs.fjernMin());
	assertEquals(e1, bs.fjernMin());
	assertEquals(e2, bs.fjernMin());
	assertEquals(e3, bs.fjernMin());
	assertEquals(e4, bs.fjernMin());
	assertEquals(e5, bs.fjernMin());
	assertEquals(e6, bs.fjernMin());
}

	/**
	* Tester ordning ved å bruke en inordeniterator
	* Her studerer du alt om bruk av inordeniterator.
	*/
	@Test
	public final void erBSTreOrdnet2() {
		bs.leggTilAlle(e3, e2, e4, e1, e5, e0, e6);

		Integer el[] = { e0, e1, e2, e3, e4, e5, e6 };
		int i = 0;
		for (Integer e : bs) {
			assertEquals(el[i], e);
			i++;
		}
	}
}
