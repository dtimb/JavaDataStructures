import java.util.EmptyStackException;

public class MyStack<E> {
	private Node<E> top;

	public MyStack() {
		super();
		this.top = null;
	}

	/*
	 * Push item onto top of stack
	 *
	 * @param item to be pushed onto stack
	 */
	public void push( E item ) {
		top = new Node<E>( item, top );
	}

	/*
	 * Pop item off top of stack and remove it
	 *
	 * @return item on top of stack
	 */
	public E pop() {
		if ( top == null ) // Stack is empty
		{
			throw new EmptyStackException();
		} else {
			E returnValue = top.data;
			top = top.next;
			return returnValue;
		}
	}

	/*
	 * Return item off top of stack but do not remove it
	 *
	 * @return item on top of stack
	 */
	public E peek() {
		if ( top == null ) // stack is empty
		{
			throw new EmptyStackException();
		} else {
			return top.data;
		}
	}

	/*
	 * Check whether stack is empty
	 *
	 * @return true if stack is empty false otherwise
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/*
	 * Node inner class
	 */
	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node( E data, Node<E> next ) {
			super();
			this.data = data;
			this.next = next;
		}
	}

	public String size() {
		return null;
	}
	
	// readHTML for main Prog4 program
	public String readHTML( String record ) {
        int start = record.indexOf( "<" ); // find index of < start of
        if ( start < 0 ) {
            return null;
        }
        
        int end = record.indexOf( ">" ); // find index of > end of item
        String item = record.substring(start + 1, end);
        
        return item;
    }
}