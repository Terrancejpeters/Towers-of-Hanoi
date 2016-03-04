package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T> {

	private int size = 0;
	private Node<T> first = null;
	private Node<T> last = null;

	public ListImplementation() {
	}

	public ListImplementation(T data) {
		first = new Node<T>(data, null);
	}

	public ListImplementation(Node<T> head) {
		first = head;
	}

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
		Iterator<T> it = new listIterator<T>(first);
		if (n > size - 1 || n < 0) {
			throw new NoSuchElementException("Greater than size");
		}
		T temp = it.next();
		int i = 0;
		while (i < n && it.hasNext()) {
			temp = it.next();
			i++;
		}
		return temp;
	}

	@Override
	public ListInterface<T> append(T elem) {
		// TODO Auto-generated method stub
		ListImplementation<T> rval = this;
		size++;
		if (elem == null) {
			throw new NullPointerException();
		}
		if (first == null) {
			first = new Node<T>(elem, null);
		} else if (last == null) {
			last = new Node<T>(elem, null);
			first.setNext(last);
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
		return new listIterator<T>(first);
		// Make a new list iterator
	}

}
