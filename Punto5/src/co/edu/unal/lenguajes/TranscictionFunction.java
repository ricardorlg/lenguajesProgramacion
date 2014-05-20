package co.edu.unal.lenguajes;

public class TranscictionFunction {
	private String currentState;
	private char currentSymbol;
	private String nextState;
	private char symbolToWrite;
	private int moveDirection;
	private double probability;

	public TranscictionFunction(String currentState, char currentSymbol,
			String nextState, char symbolToWrite, int moveDirection,
			double probability) {
		super();
		this.currentState = currentState;
		this.currentSymbol = currentSymbol;
		this.nextState = nextState;
		this.symbolToWrite = symbolToWrite;
		this.moveDirection = moveDirection;
		this.probability = probability;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[current state =  " + currentState + " currentsymbol = "
				+ currentSymbol + " next = " + nextState + " ]";
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public char getCurrentSymbol() {
		return currentSymbol;
	}

	public void setCurrentSymbol(char currentSymbol) {
		this.currentSymbol = currentSymbol;
	}

	public String getNextState() {
		return nextState;
	}

	public void setNextState(String nextState) {
		this.nextState = nextState;
	}

	public char getSymbolToWrite() {
		return symbolToWrite;
	}

	public void setSymbolToWrite(char symbolToWrite) {
		this.symbolToWrite = symbolToWrite;
	}

	public int getMoveDirection() {
		return moveDirection;
	}

	public void setMoveDirection(int moveDirection) {
		this.moveDirection = moveDirection;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

}
