
import java.io.IOException;
import java.util.NoSuchElementException;
public class ArrayList<T> implements List<T> {
	
	private static final int DEFAULT_MAX_SIZE = 10;
	private int maxsize;
	private int currentsize;
	private T data[];
	
	
	//constructor
	public ArrayList(){
		
		maxsize = DEFAULT_MAX_SIZE;
		currentsize = 0;

		 data = (T[])new Object[ DEFAULT_MAX_SIZE ];

	}
	

	//add item at end of arrayList
	@SuppressWarnings("unchecked")
	public void add(T item){
		

		if(currentsize == data.length-1){
			grow();
		}

		
		data[currentsize] = item;
		currentsize++;


	}

		//add an item into the array
	@SuppressWarnings("unchecked")
	public void add(int pos, T item){

		if(pos > data.length){
			currentsize = currentsize*2;
		}

	
		for(int i = currentsize; i > pos; i--){
			data[i] = data[i-1];
		}
		data[pos]= item;
		currentsize++;
	}

	//grows array into twice the size
	@SuppressWarnings("unchecked")
	protected void grow(){
		// makes new arraylist
		T[] temp = (T[]) new Object[data.length *2];
		for(int i = 0; i < data.length; i++ ){
			temp[i] = data[i];
		}
		data = temp;
	}

	//returns T value at position passed in
	@SuppressWarnings("unchecked")
	public T get(int pos){
		if(pos >= 0 && pos < currentsize ){
			throw new NoSuchElementException();
		}

		return (T) data[pos];
	}

	//returns current size of arraylist
	public int size(){
		return currentsize;

	}

	//removes and returns T value at position passed as a parameter
	@SuppressWarnings("unchecked")
	public T remove(int pos){
	
		if(pos >= 0 && pos< currentsize){
			throw new NoSuchElementException();
		}
		
		for(int x = pos; x < data.length -1; x++){
			data[x] = data[x+1];
		}

		return  (T)data[pos];
	}
}