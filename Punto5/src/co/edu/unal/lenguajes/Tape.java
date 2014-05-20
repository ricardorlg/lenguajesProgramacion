package co.edu.unal.lenguajes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;

public class Tape {
	private char blankSimbol = ' ';
	private String input;
	private Hashtable<Integer, Character> tape;

	public Tape(String input2) {
		this.input = input2;
		tape = new Hashtable<>();
		for (int i = 0; i < input.length(); i++) {
			tape.put(i, input.charAt(i));
		}
	}

	public Tape(String input2, char blanckSymbol) {
		this.input = input2;
		this.blankSimbol = blanckSymbol;
		tape = new Hashtable<>();

		for (int i = 0; i < input.length(); i++) {
			tape.put(i, input.charAt(i));
		}
	}

	public char getSymbol(int position) {
		if (tape.containsKey(position)) {
			return tape.get(position);
		} else {
			return blankSimbol;
		}
	}

	public void setSymbol(int position, char symbol) {
		tape.put(position, symbol);
	}

	@Override
	public String toString() {
		String rep = "";
		Enumeration<Integer> keys = tape.keys();
		ArrayList<Integer> s = Collections.list(keys);
		int minIndex = Collections.min(s);
		int maxIndex = Collections.max(s);
		for (int i = minIndex; i <= maxIndex; i++) {
			rep += tape.get(i);
		}
		return rep;
	}
}
