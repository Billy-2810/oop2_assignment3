package sait.sll.utility;

/**
 * Abstract data type for a linked list.
 * 
 * @version 2025
 *
 */
public interface LinkedListADT 
{
	/**
	 * Returns true if this list is empty, otherwise false.
	 * @return true if list is empty, false otherwise.
	 */
	boolean isEmpty();

	/**
	 * Clears all elements from this list.
	 */
	void clear();
	
	/**
	 * Appends element to the end of this list.
	 * @param data data to append.
	 */
	void append(Object data);

	/**
	 * Prepends element to the beginning of this list.
	 * @param data data to prepend.
	 */
	void prepend(Object data);
	
	/**
	 * Inserts element at a specific index of this list.
	 * @param data data to insert.
	 * @param index index to insert data at.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size of the list.
	 */
	void insert(Object data, int index) throws IndexOutOfBoundsException;

	/**
	 * Replaces the element at a specific index of this list.
	 * @param data data to replace.
	 * @param index index of element to replace.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	void replace(Object data, int index) throws IndexOutOfBoundsException;

	/**
	 * Gets the number of elements in this list.
	 * @return size of list (0 meaning empty).
	 */
	int size();

	/**
	 * Removes an element at the specific index from this list.
	 * @param index index of the element to remove.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	void delete(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Returns the data of the element at the specific index of this list.
	 * @param index index of element to get.
	 * @return data in element with matching index.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	Object retrieve(int index) throws IndexOutOfBoundsException;

	/**
	 * Returns the index of the first occurrence of the element with the specific data in this list.
	 * @param data data of the element to find the first index of.
	 * @return index of the first element with matching data, -1 if not found.
	 */
	int indexOf(Object data);

	/**
	 * Returns true if this list contains an element with specified data, otherwise false.
	 * @param data data to search for.
	 * @return true if element containing data exists, false otherwise.
	 */
	boolean contains(Object data);
}