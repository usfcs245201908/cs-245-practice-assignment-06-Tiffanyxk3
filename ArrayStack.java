import java.util.Arrays;

public class ArrayStack<T> implements Stack<T>
{
	public T[] arr;
	public int size;
	public T[] growArr;
	public int position;

	public ArrayStack() {
		arr = (T[]) new Object[10];
		position = -1;
		size = arr.length;
	}

	public void push(T item) {
		if (position == size-1) {
			grow();
		}
		position++;
		arr[position] = item;
	}

	public T pop() throws Exception {
		if (empty()) {
			throw new Exception();
		}

		return arr[position--];
	}

	public T peek() throws Exception {
		if (empty()) {
			throw new Exception();
		}
		return arr[position];
	}

	public boolean empty() {
		if (position == -1) {
			return true;
		}
		return false;
	}

	public void grow() {
		growArr = (T[]) new Object[size*2];
		for (int i=0; i<size; i++) {
			growArr[i] = arr[i];
		}
		arr = growArr;
		size = size*2;
	}

}