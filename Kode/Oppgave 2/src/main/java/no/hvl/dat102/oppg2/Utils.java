package no.hvl.dat102.oppg2;

import java.util.ArrayList;

public class Utils {

	public static int minTeoretiskHoyde(int n) {
		return (int) Math.floor(Math.log10(n) / Math.log(2));
	}

	public static int maxVal(ArrayList<Integer> arr) {
		int r = 0;

		for (Integer n : arr) {
			r = n > r ? n : r;
		}

		return r;
	}

	public static int minVal(ArrayList<Integer> arr) {
		int r = arr.get(0);

		for (Integer n : arr) {
			r = n < r ? n : r;
		}

		return r;
	}

	public static int avgVal(ArrayList<Integer> arr) {
		int sum = 0;

		for (Integer n : arr) {
			sum += n;
		}

		return sum / arr.size();
	}
}
