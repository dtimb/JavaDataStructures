public class ArrayQueue<E> {
	private E[] data;
	private int front;
	private int rear;
	private int size;
	private int capacity;

	public ArrayQueue(int capacity) {
		super();
		this.data = (E[]) new Object[capacity];
		this.front = 0;
		this.rear = capacity - 1;
		this.size = 0;
		this.capacity = capacity;
	}

	/*
	 * enqueue at rear of queue
	 */
	public boolean enqueue(E item) {
		if (size == capacity) // queue is full
		{
			return false;
		} else {
			rear = (rear + 1) % capacity; // makes rear 0 in the circular array
			data[rear] = item;
			size++;
			return true;
		}
	}

	/*
	 * dequeue from front of queue
	 */
	public E dequeue() {
		if (size == 0) // queue is empty
		{
			return null;
		} else {
			E returnValue = data[front]; 
			front = (front + 1) % capacity; // makes front 0 in the circular array
			size--;
			return returnValue;
		}
	}

	public E peek() {
		return data[front];
	}

	public int size() {
		return size;
	}
}