package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T> {

	private int size = 0;
	private Node<T> first = null;
	private Node<T> last = null;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T get(int n) throws NoSuchElementException {
		Node<T> temp = first;
		if (n > size) {
			throw new NoSuchElementException("Greater than size");
		}
		int i = 0;
		while (i < n) {
			temp = temp.getNext();
			i++;
		}
		return temp.getData();
	}

	@Override
	public ListInterface<T> append(T elem) {
		// TODO Auto-generated method stub
		size++;
		if (first == null) {
			first = new Node<T>(elem, last);
		} else if (last == null) {
			last = new Node<T>(elem, null);
		} else {
			Node<T> temp = new Node<T>(elem, null);
			last.setNext(temp);
			last = temp;
		}
		return this;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
			return new Iterator<T>(first);
			//Make a new list iterator
	}

}
