package co.edu.unal.lenguajes;

import java.util.ArrayList;
import java.util.List;

public class ProbabilisticTuringMachine {
	private Tape tape;
	private char blanckSymbol;
	private List<Character> alphabet;
	private String initialState;
	private List<String> finalStates;
	private List<TranscictionFunction> functions;
	private String input;
	private String currentState;
	private int tapeHead = 0;

	public ProbabilisticTuringMachine(char blanckSymbol,
			List<Character> alphabet, String initialState,
			List<String> finalStates, List<TranscictionFunction> functions,
			String input) {
		super();
		this.blanckSymbol = blanckSymbol;
		this.alphabet = alphabet;
		this.initialState = initialState;
		this.finalStates = finalStates;
		this.functions = functions;
		this.input = input;
		this.currentState = this.initialState;
		tape = new Tape(input, blanckSymbol);
	}

	public void step() throws Exception {
		char underHead = tape.getSymbol(tapeHead);
		List<TranscictionFunction> lf = getCFunctions(underHead);
		if (!lf.isEmpty()) {
			TranscictionFunction theFunction = getFunctionProb(lf);
			tape.setSymbol(tapeHead, theFunction.getSymbolToWrite());
			tapeHead += theFunction.getMoveDirection();
			currentState = theFunction.getNextState();
		} else {
			throw new Exception("error ");
		}
	}

	private TranscictionFunction getFunctionProb(List<TranscictionFunction> lf)
			throws Exception {
		double p = Math.random();
		double cumulativeProbability = 0.0;
		for (TranscictionFunction item : lf) {
			cumulativeProbability += item.getProbability();
			if (p <= cumulativeProbability) {
				return item;
			}
		}
		throw new Exception("No se encontro funcion");
	}

	public boolean isFinal() {
		return finalStates.contains(currentState);
	}

	private List<TranscictionFunction> getCFunctions(char currentSymbol) {
		List<TranscictionFunction> functionst = new ArrayList<TranscictionFunction>();
		for (TranscictionFunction function : functions) {
			String fState = function.getCurrentState();
			char symbol = function.getCurrentSymbol();
			if (currentState.equalsIgnoreCase(fState)
					&& currentSymbol == symbol) {
				functionst.add(function);
			}
		}
		return functionst;
	}

	public void imprimir() {
		System.out.println(tape.toString());
	}

	public Tape getTape() {
		return tape;
	}

	public void setTape(Tape tape) {
		this.tape = tape;
	}

	public char getBlanckSymbol() {
		return blanckSymbol;
	}

	public void setBlanckSymbol(char blanckSymbol) {
		this.blanckSymbol = blanckSymbol;
	}

	public List<Character> getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(List<Character> alphabet) {
		this.alphabet = alphabet;
	}

	public String getInitialState() {
		return initialState;
	}

	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}

	public List<String> getFinalStates() {
		return finalStates;
	}

	public void setFinalStates(List<String> finalStates) {
		this.finalStates = finalStates;
	}

	public List<TranscictionFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(List<TranscictionFunction> functions) {
		this.functions = functions;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
}
