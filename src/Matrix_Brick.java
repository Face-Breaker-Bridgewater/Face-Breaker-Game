
public class Matrix_Brick <T> {
	
	Object [] elements;
	private int capacity;
	private int numElms;
	public int offSet;
	
	public Matrix_Brick(int capacity, int offSet) {
		this.capacity = capacity;
		this.offSet = offSet;
		elements = new Object [capacity];
		this.numElms = 0;
		
	}
	public void ensureCapacity(int minCapacity){
		if (minCapacity > capacity){
			capacity = minCapacity;
			Object[] newArray = new Object[capacity];
			for (int i=0; i<numElms; i++){
				newArray[i] = elements[i];
			}
			elements = newArray;
		}
		
	}
	public boolean  add(T elm, int k )throws NullPointerException,MatrixOutOfBoundsException {
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
}
