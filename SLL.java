package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable {
	private static final long serialVersionUID = 1L;

	private Node head;
	private Node tail;
	private int size;

	public SLL() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	private void checkIndexForInsert(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	private Node nodeAt(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	public void append(Object data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}

		size++;
	}

	public void prepend(Object data) {
		Node newNode = new Node(data);

		newNode.setNext(head);
		head = newNode;

		if (tail == null) {
			tail = newNode;
		}

		size++;
	}

	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		checkIndexForInsert(index);

		if (index == 0) {
			prepend(data);
			return;
		}

		if (index == size) {
			append(data);
			return;
		}

		Node prev = nodeAt(index - 1);
		Node newNode = new Node(data);

		newNode.setNext(prev.getNext());
		prev.setNext(newNode);

		size++;
	}

	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		Node target = nodeAt(index);
		target.setData(data);
	}

	public int size() {
		return size;
	}

	public void delete(int index) throws IndexOutOfBoundsException {
		checkIndex(index);

		if (index == 0) {
			head = head.getNext();
			if (head == null) {
				tail = null;
			}
			size--;
			return;
		}

		Node prev = nodeAt(index - 1);
		Node toRemove = prev.getNext();
		prev.setNext(toRemove.getNext());

		if (toRemove == tail) {
			tail = prev;
		}

		size--;
	}

	public Object retrieve(int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		return nodeAt(index).getData();
	}

	public int indexOf(Object data) {
		Node current = head;
		int index = 0;

		while (current != null) {
			Object currentData = current.getData();

			if (data == null) {
				if (currentData == null) {
					return index;
				}
			} else if (data.equals(currentData)) {
				return index;
			}

			current = current.getNext();
			index++;
		}

		return -1;
	}

	public boolean contains(Object data) {
		return indexOf(data) != -1;
	}
}
