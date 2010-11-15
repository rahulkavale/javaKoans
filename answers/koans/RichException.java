package koans;

public class RichException extends Exception {

	int number;
	
	public RichException(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}
