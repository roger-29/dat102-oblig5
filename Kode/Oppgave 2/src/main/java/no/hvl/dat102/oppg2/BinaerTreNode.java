package no.hvl.dat102.oppg2;

public class BinaerTreNode<T> {
	private T element;
	private BinaerTreNode<T> venstre, høyre;

	public BinaerTreNode(T el) {
		element = el;
		venstre = null;
		høyre = null;
	}

	public BinaerTreNode<T> getVenstre() {
		return venstre;
	}

	public BinaerTreNode<T> getHoyre() {
		return høyre;
	}

	public void setVenstre(BinaerTreNode<T> ny) {
		venstre = ny;
	}

	public void setHoyre(BinaerTreNode<T> ny) {
		høyre = ny;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T el) {
		element = el;
	}

	public int antallBarn() {
		int barn = 0;

		if (venstre != null)
			barn = 1 + venstre.antallBarn();

		if (høyre != null)
			barn = barn + 1 + høyre.antallBarn();

		return barn;
	}
}
