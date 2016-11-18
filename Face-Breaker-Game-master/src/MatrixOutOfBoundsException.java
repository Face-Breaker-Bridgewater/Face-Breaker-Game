public class MatrixOutOfBoundsException extends Exception {

	String reason;
	
	public MatrixOutOfBoundsException(String reason){
		this.reason = reason;
	}
	
	public String toString(){
		String statement = "This was thrown because "+reason;
		return statement;
	}
}