import java.util.ArrayList;

public class ArrayBrick extends ArrayList<Brick>{

	public ArrayBrick(){
		super();
	}
	public Brick removeNull(int i) throws IndexOutOfBoundsException{
		if (i<0||i>=super.size())
			throw new IndexOutOfBoundsException();
		Brick brick = super.get(i);
		super.set(i,null);
		return brick;
	}
}
