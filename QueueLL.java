public class QueueLL<E> {
	private Node<E> front;
	private Node<E> rear;
	private int size;

	public QueueLL() {
		super();
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	public void enqueue(E item) {
		if (front == null) // empty
		{
			rear = new Node(item, null);
			front = rear;
			size++;
		} else {
			rear.next = new Node<E>(item, null);
			rear = rear.next;
			size++;
		}
	}

	public E dequeue() {
		if (front == null) // empty
		{
			return null;
		} else {
			E returnValue = front.data;
			front = front.next;
			size--;
			return returnValue;
		}
	}

	public boolean isEmpty() {
		return front == null;
	}

	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data, Node<E> next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
}