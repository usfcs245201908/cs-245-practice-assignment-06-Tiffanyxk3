import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> 
{
	public T[] arr;
	public T[] growArr;
	public int position;
	
	public ArrayQueue() {
		arr = (T[]) new Object[10];
		position = -1;
	}

	public void enqueue(T item) {
		if (position == arr.length-1) {
			grow();
		}
		position++;
		arr[position] = item;
	}

	public T dequeue() throws Exception {
		if (empty()) {
			throw new Exception();
		}

		T temp = arr[0];
		for (int i=1; i<=arr.length-1; i++) {
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = null;
		position--;
		return temp;
	}

	public boolean empty() {
		if (position == -1) {
			return true;
		}
		return false;
	}

	public void grow() {
		growArr = (T[]) new Object[(arr.length)*2];
		for (int i=0; i<arr.length; i++) {
			growArr[i] = arr[i];
		}
		arr = growArr;
	}


}