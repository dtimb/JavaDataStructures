public class SLList<E extends Comparable>{

	private Node<E> head = null;
	private int size = 0;
	
	
	public SLList() {
		head = null;
		size = 0;
	}
	
	public void add( E item ) {
		/**
		 * @param item is the object that will be added to the tail of the list
		 */
		if( head == null ) { // if the head is null the list is empty
			head = new Node<E>( item, null );
		}
		else {
			Node<E> p = head;
			while( p.next != null ) { // while not at end of list
				p = p.next;
			}
			p.next = new Node<E>( item, null );
			
		}
		size++; // increment size after adding a tail
	}
	public E get( int index ) {
		/**
		 * @param index representing the index of the object in the list
		 * @return returns the data (the object) of the node
		 */
		if( index<0 || index >= size ) {
			return null;
		}
		Node<E> p = head;
		int position = 0;
		
		while( position < index ) {
			p = p.next;
			position++;
		}
		return p.data;
	}
	public int indexOf( E target ) {
		/**
		 * @param target is the node that user needs to find the index of
		 * @return returns int representing index in the list of target
		 */
		Node<E> p = head;
		int index = 0;
		// look for target index E object
		while( p != null ) {
			// if found return value of index
			// since working with object use compareTo method
			if( target.compareTo( p.data ) == 0 ){
				// returns 0 if they are equal, 1 if not
				return index;
			}
			p = p.next;
			index++;
		}
		return -1; // meaning that it is not found
	}
	public int size() {
		/**
		 * size is logged when a new node is added to the list
		 * @return size of the List
		 */
		return size;
	}
	public E remove( int index ) {
		/**
		 * @param receives index of the node user wants to remove
		 * @return returns object that is found at the index and removed
		 */
		if( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException( index );
		}
		Node<E> p = head;
		int position = 0;
		
		while( position < index -1 ) {
			p = p.next;
			position++;
		}		
		if( p == head ) {
			head = p.next;
		}
		p.next = p.next.next;
		size--;
		return p.data;
	}
	
	private class Node<E> {
		private E data;
		private Node next;
		
		public Node( E data, Node next ) {
			this.data = data;
			this.next = next;
		}	
	}
}
