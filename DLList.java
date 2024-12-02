/*
 * DLList.java
 * Dylan Timbrook
 * 3/3/23
 * Contains methods: 
 * 	add (at tail),
 * 	add (at index),
 * 	get,
 * 	indexOf,
 * 	size,
 * 	iterator,
 * 	reverseiterator,
 * 	remove
 */

import java.util.*; // import java.util

@SuppressWarnings("rawtypes")
public class DLList<E extends Comparable>
{
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    public void add( E item ) // add at tail of list
    {
        if( head == null )
        {
            head = new Node<E>( item, null, null );
            tail = head;
            size++;
        }
        else
        {
            tail.next = new Node<E>( item, null, tail );
            tail = tail.next;
            size++;
        }
    }
    
    public void add( int index, E item ) // add at index
    {
        if( index < 0 || index >= size )
        {
            throw new IndexOutOfBoundsException( index );// error catch if index is out of list bounds
        }
        
        Node<E> p = head;
        int position = 0;
        while( position < index - 1 )
        {
            p = p.next;
            position++;
        }
        p.next = new Node<E>( item, p.next, p );
        p.next.next.prev = p.next;
        size++;
    }
    
    public E get( int index )
    {
        if( index < 0 || index >= size )
        {
            throw new IndexOutOfBoundsException( index ); // error catch if index is out of list bounds
        }
        
        Node<E> p = head;
        int position = 0;
        while( position < index )
        {
            p = p.next;
            position++;
        }
        return p.data;
    }
    
	@SuppressWarnings("unchecked")
	public int indexOf( E target )
    {
        Node<E> p = head;
        int index = 0;
        while( p != null )
        {
            if( p.data.compareTo( target ) == 0 )
            {
                return index;
            }
            else
            {
                p = p.next;
                index++;
            }
        }
        return -1;
    }
    
    public int size()
    {
        return size;
    }
    
    /*
     * iterator() and reverseIterator() methods instantiates and return ListIter and ReverseIter objects
     */
    public Iterator<E> iterator()
    {
        return new ListIter();
    }
    public Iterator<E> reverseiterator()
    {
    	return new ReverseIter();
    }

    private static class Node<E>
    {
        private E data;
        private Node<E> next;
        private Node<E> prev;
        
        public Node(E data, Node<E> next, Node<E> prev)
        {
            super();
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    
    /*
     * ListIter and reverseIter inner classes
     */
    
    // Forward Iterator; iterates forwards
    class ListIter implements Iterator<E>
    {
        private Node<E> nextItem = head;
        private Node<E> lastItemReturned = null;
        
        public boolean hasNext()
        {
            return nextItem != null;
        }
        
        public E next()
        {
            if( !hasNext() )        // if no items left in list
            {
                throw new NoSuchElementException();
            }
            
            lastItemReturned = nextItem;
            nextItem = nextItem.next;

            return lastItemReturned.data;
        }
 
    }
    
    // Reverse Iterator; iterates backwards
    class ReverseIter implements Iterator<E>
    {
        private Node<E> prevItem = tail;
        private Node<E> lastItemReturned = null;
        
        public boolean hasNext()
        {
        	return prevItem != null;
        }
 
        public E next()
        {
            if( !hasNext() ) // if no items left in list
            {
                throw new NoSuchElementException();
            }
            
            lastItemReturned = prevItem;
            prevItem = prevItem.prev;

            return lastItemReturned.data;
        }
    }
    
    // remove method
    public void remove(int index) // remove at index
    {
    	if( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException( index ); // error catch if index is out of list bounds
		}
    	Node<E> p = head;
		int position = 0;
		
		while( position < index -1 ) {
			p = p.next;
			position++;
		}		
		if( p == head ) {
			head = p.next;
			p.prev = p;
		}
		if(p == tail) {
			tail = p.prev;
			p.next = p;
		}
		p.next = p.next.next; // move p.next pointer to after the desired node to remove
		p.prev = p.prev.prev; // p.prev pointer to before the desired node to remove
		size--;
    }
}