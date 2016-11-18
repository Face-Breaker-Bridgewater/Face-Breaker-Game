
public class Matrix_Brick {

	Brick [] elements;
	private int capacity;
	private int numElms;
	public int offSet;
	
	public Matrix_Brick(int capacity, int offSet) {
		this.capacity = capacity;
		this.offSet = offSet;
		elements = new Brick [capacity];
		this.numElms = 0;
	}
	public void ensureCapacity(int minCapacity){
		if (minCapacity > capacity){
			capacity = minCapacity;
			Brick[] newArray = new Brick[capacity];
			for (int i=0; i<numElms; i++){
				newArray[i] = elements[i];
			}
			elements = newArray;
		}
	}
	public boolean  add(Brick elm, int k )throws NullPointerException,MatrixOutOfBoundsException {
		if(elm ==null)
			throw new NullPointerException();
		if (k<0)
			throw new MatrixOutOfBoundsException("the matrix element is out of bounds");
		if (k>=capacity){
			ensureCapacity(k*2);
		}
		elements [k] = elm;
		numElms++;
		return false;
		
	}
	public Brick elementAt(int k)throws MatrixOutOfBoundsException{
		if (k>=numElms||k<0)
			throw new MatrixOutOfBoundsException("the matrix element is out of bounds");
		Brick elm=  elements[k];
		return elm;
	}
	public Brick removeAt(int k) throws MatrixOutOfBoundsException{
		if (k>=numElms||k<0)
			throw new MatrixOutOfBoundsException("the matrix element is out of bounds");
		Brick elm=  elements[k];
		elements[k]=null;
		return elm;
	}
}
