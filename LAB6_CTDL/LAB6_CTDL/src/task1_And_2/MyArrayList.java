package task1_And_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;

	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	public void growSize() {
		E[] newElements = (E[]) new Object[elements.length * 2];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		return elements[i];
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		E old = elements[i];
		elements[i] = e;
		return old;
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size++] = e;
		return true;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		}
		if (size == elements.length) {
			growSize();
		}
		for (int j = size - 1; j >= i; j--) {
			elements[j + 1] = elements[j];
		}
		elements[i] = e;
		size++;
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		E removed = elements[i];
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}
		size--;
		return removed;
	}

	public void clear() {
		size = 0;
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public Object[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> clone = new MyArrayList<>(elements.length);
		for (E e : elements) {
			clone.add(e);
		}
		return clone;
	}

	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

}

class Node<E> {

	E data;
	Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

}

class MyLinkedList<E> implements Iterable<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (head == null)
			return null;
		return head.data;
	}

	public E last() {
		if (tail == null)
			return null;
		return tail.data;
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		if (tail == null) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (tail == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}

	public E removeFirst() {
		if (head == null)
			return null;
		E removed = head.data;
		head = head.next;
		size--;
		if (head == null) {
			tail = null;
		}
		return removed;
	}

	public E removeLast() {
		if (head == null)
			return null;
		if (head == tail) {
			E removed = head.data;
			head = tail = null;
			size--;
			return removed;
		}
		Node<E> current = head;
		while (current.next != tail) {
			current = current.next;
		}
		E removed = tail.data;
		tail = current;
		tail.next = null;
		size--;
		return removed;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node<E> current = head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				if (current == null)
					throw new NoSuchElementException();
				E data = current.data;
				current = current.next;
				return data;
			}
		};
	}

}
